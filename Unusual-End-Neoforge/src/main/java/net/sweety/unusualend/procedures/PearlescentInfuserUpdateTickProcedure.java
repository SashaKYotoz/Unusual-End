package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndMiscRegister;

public class PearlescentInfuserUpdateTickProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockPos pos = BlockPos.containing(x, y, z);

        processInfusion(world, pos, x, y, z, 0, UnusualEndItems.CITRINE_CHUNK.get(), "Citrine",
                ParticleTypes.FLAME, SoundEvents.CONDUIT_AMBIENT);

        processInfusion(world, pos, x, y, z, 1, UnusualEndItems.SHINY_CRYSTAL.get(), "Shiny",
                UnusualEndMiscRegister.PINK_FLAME.get(), SoundEvents.CONDUIT_AMBIENT_SHORT);

        processInfusion(world, pos, x, y, z, 2, UnusualEndItems.PRISMALITE_GEM.get(), "Prismatic",
                ParticleTypes.SOUL_FIRE_FLAME, SoundEvents.CONDUIT_AMBIENT_SHORT);
    }

    private static void processInfusion(LevelAccessor accessor, BlockPos pos, double x, double y, double z,
                                        int slotId, Item expectedItem, String nbtTag,
                                        ParticleOptions flameParticle, SoundEvent clientSound) {

        BlockEntity blockEntity = accessor.getBlockEntity(pos);
        if (blockEntity instanceof BaseContainerBlockEntity containerEntity) {
            InvWrapper wrapper = new InvWrapper(containerEntity);
            ItemStack stack = wrapper.getStackInSlot(slotId);

            if (stack.getItem() == expectedItem) {
                double currentValue = containerEntity.getPersistentData().getDouble(nbtTag);

                if (currentValue <= 7) {
                    stack.shrink(1);

                    if (!accessor.isClientSide()) {
                        containerEntity.getPersistentData().putDouble(nbtTag, currentValue + 1);
                        if (accessor instanceof Level level) {
                            BlockState state = accessor.getBlockState(pos);
                            level.sendBlockUpdated(pos, state, state, 3);
                        }
                    }
                    if (accessor instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(flameParticle, x + 0.5, y + 1.2, z + 0.5, 6, 0.1, 0.1, 0.1, 0);
                        serverLevel.sendParticles(ParticleTypes.SMOKE, x + 0.5, y + 1.2, z + 0.5, 8, 0.1, 0.1, 0.1, 0);
                    }
                    if (accessor instanceof Level level) {
                        if (!level.isClientSide())
                            level.playSound(null, pos, SoundEvents.CONDUIT_AMBIENT_SHORT, SoundSource.NEUTRAL, 2, 1.8F);
                         else
                            level.playLocalSound(x, y, z, clientSound, SoundSource.NEUTRAL, 2, 1.8F, false);
                    }
                }
            }
        }
    }
}