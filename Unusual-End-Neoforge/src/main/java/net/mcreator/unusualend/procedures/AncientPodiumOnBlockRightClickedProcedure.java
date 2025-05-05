package net.mcreator.unusualend.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

public class AncientPodiumOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) return;

        BlockPos blockPos = BlockPos.containing(x, y, z);
        ItemStack mainHandItem = entity instanceof LivingEntity livingEntity ? livingEntity.getMainHandItem() : ItemStack.EMPTY;

        boolean isMainHandEmpty = mainHandItem.getItem() == Blocks.AIR.asItem();
        boolean isSlotEmpty = getSlotAmount(world, blockPos, 0) == 0;

        if (!isMainHandEmpty && isSlotEmpty) {
            handleInsert(world, blockPos, mainHandItem, entity);
        } else if (isMainHandEmpty && !isSlotEmpty) {
            ItemStack slotItem = getSlotItem(world, blockPos, 0);
            handlePickup(world, blockPos, slotItem, entity);
        }
    }

    private static int getSlotAmount(LevelAccessor world, BlockPos pos, int slotId) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof BaseContainerBlockEntity entity) {
            InvWrapper wrapper = new InvWrapper(entity);
            return wrapper.getStackInSlot(slotId).getCount();
        }
        return 0;
    }

    private static ItemStack getSlotItem(LevelAccessor world, BlockPos pos, int slotId) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof BaseContainerBlockEntity entity) {
            InvWrapper wrapper = new InvWrapper(entity);
            return wrapper.getStackInSlot(slotId).copy();
        }
        return ItemStack.EMPTY;
    }

    private static void handleInsert(LevelAccessor world, BlockPos pos, ItemStack itemStack, Entity entity) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof BaseContainerBlockEntity entity1) {
            InvWrapper wrapper = new InvWrapper(entity1);
            ItemStack stackToInsert = itemStack.copy();
            stackToInsert.setCount(1);
            wrapper.setStackInSlot(0, stackToInsert);
        }

        if (world instanceof Level level) {
            level.updateNeighborsAt(pos, level.getBlockState(pos).getBlock());
        }

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.getMainHandItem().shrink(1);
        }

        if (world instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.ENCHANT, pos.getX() + 0.5, pos.getY() + 0.9, pos.getZ() + 0.5, 15, 0.2, 0.2, 0.2, 0);
            serverLevel.getServer().getCommands().performPrefixedCommand(
                    new CommandSourceStack(CommandSource.NULL, new Vec3(pos.getX() + 0.5, pos.getY() + 0.9, pos.getZ() + 0.5), Vec2.ZERO, serverLevel, 4, "", Component.literal(""), serverLevel.getServer(), null).withSuppressedOutput(),
                    "particle dust 0.8 0.8 3.1 0.7 ~ ~ ~ 0.15 0.2 0.15 0 15"
            );
        }

        playSound(world, pos, "block.chiseled_bookshelf.insert.enchanted");
    }

    private static void handlePickup(LevelAccessor world, BlockPos pos, ItemStack itemStack, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.setItemInHand(InteractionHand.MAIN_HAND, itemStack);
            if (livingEntity instanceof Player player) {
                player.getInventory().setChanged();
            }
        }

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof BaseContainerBlockEntity entity1) {
            InvWrapper wrapper = new InvWrapper(entity1);
            ItemStack stackInSlot = wrapper.getStackInSlot(0).copy();
            stackInSlot.shrink(1);
            wrapper.setStackInSlot(0, stackInSlot);
        }

        if (world instanceof Level level) {
            level.updateNeighborsAt(pos, level.getBlockState(pos).getBlock());
        }

        playSound(world, pos, "block.chiseled_bookshelf.pickup.enchanted");
    }

    private static void playSound(LevelAccessor world, BlockPos pos, String soundEvent) {
        if (world instanceof Level level) {
            ResourceLocation soundLocation = new ResourceLocation(soundEvent);
            if (!level.isClientSide()) {
                level.playSound(null, pos, BuiltInRegistries.SOUND_EVENT.get(soundLocation), SoundSource.BLOCKS, 1, 1.8f);
            } else {
                level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), BuiltInRegistries.SOUND_EVENT.get(soundLocation), SoundSource.BLOCKS, 1, 1.8f, false);
            }
        }
    }
}
