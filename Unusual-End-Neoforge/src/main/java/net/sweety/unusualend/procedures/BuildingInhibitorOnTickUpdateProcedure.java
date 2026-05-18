package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndMiscRegister;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BuildingInhibitorOnTickUpdateProcedure {
    public static void execute(Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity == null) return;
        CompoundTag nbt = blockEntity.getPersistentData();
        double fuel = nbt.getDouble("Fuel");
        double isActive = nbt.getDouble("isActive");
        String ownerUuid = nbt.getString("Owner");

        boolean stateChanged = false;
        if (blockEntity instanceof BaseContainerBlockEntity container) {
            IItemHandler handler = new InvWrapper(container);
            ItemStack stackInSlot = handler.getStackInSlot(0);

            if (stackInSlot.is(Items.DRAGON_BREATH) && fuel <= 16) {
                fuel += 16;
                nbt.putDouble("Fuel", fuel);
                stackInSlot.shrink(1);
                stateChanged = true;

                spawnEffects(level, pos);
            }
        }

        if (isActive >= 1) {
            isActive -= 1;
            nbt.putDouble("isActive", isActive);
            stateChanged = true;
        }
        if (isActive >= 1 || fuel >= 1) {
            Vec3 center = pos.getCenter();
            AABB area = new AABB(center, center).inflate(32);
            List<Player> nearbyPlayers = level.getEntitiesOfClass(Player.class, area,
                    player -> !player.isSpectator() && !player.isCreative());

            boolean targetFound = false;
            for (Player player : nearbyPlayers) {
                if (ownerUuid.equals(player.getStringUUID())) {
                    targetFound = true;
                    if (!level.isClientSide())
                        player.addEffect(new MobEffectInstance(UnusualEndMiscRegister.DISRUPTION, 140, 0, true, true));
                }
            }
            if (targetFound && isActive < 1) {
                fuel -= 1;
                isActive = 6000;

                nbt.putDouble("Fuel", fuel);
                nbt.putDouble("isActive", isActive);
                stateChanged = true;

                spawnEffects(level, pos);
            }
        }
        if (stateChanged && !level.isClientSide()) {
            BlockState state = level.getBlockState(pos);
            level.sendBlockUpdated(pos, state, state, 3);
        }
    }

    private static void spawnEffects(Level level, BlockPos pos) {
        if (level instanceof ServerLevel serverLevel)
            serverLevel.sendParticles(ParticleTypes.DRAGON_BREATH, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 10, 0.3, 0.3, 0.3, 0);
        if (!level.isClientSide())
            level.playSound(null, pos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.0F, 1.5F);
        else
            level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.0F, 1.5F, false);
    }
}