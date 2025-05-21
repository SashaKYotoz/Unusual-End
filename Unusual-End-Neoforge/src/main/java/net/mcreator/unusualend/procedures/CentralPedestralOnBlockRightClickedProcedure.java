package net.mcreator.unusualend.procedures;

import net.minecraft.world.entity.*;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

import java.util.List;

public class CentralPedestralOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) return;
        double altars = 0;
        BlockPos[] altarPositions = {
                BlockPos.containing(x + 8, y, z),
                BlockPos.containing(x - 8, y, z),
                BlockPos.containing(x, y, z + 8),
                BlockPos.containing(x, y, z - 8),
                BlockPos.containing(x - 5, y, z + 5),
                BlockPos.containing(x + 5, y, z - 5),
                BlockPos.containing(x - 5, y, z - 5),
                BlockPos.containing(x + 5, y, z + 5)
        };
        for (BlockPos pos : altarPositions) {
            if (getItemStackInSlot(world, pos, 0).getItem() == UnusualendModBlocks.PRISMATIC_PEARL_DISPLAY.get().asItem()) {
                altars++;
            }
        }
        if (entity instanceof Player player && !player.level().isClientSide()) {
            displayAltarMessage(player, altars);
        }
        if (altars == 8) {
            triggerLightningSequence(world, x, y, z, altarPositions);
            displayMessageToAllPlayers(world, x, y, z, "text.unusualend.queen_theme");
        }
    }
    private static ItemStack getItemStackInSlot(LevelAccessor world, BlockPos pos, int slotId) {
        BlockEntity entity = world.getBlockEntity(pos);
        if (entity instanceof BaseContainerBlockEntity blockEntity) {
            InvWrapper wrapper = new InvWrapper(blockEntity);
            return wrapper.getStackInSlot(slotId);
        }
        return ItemStack.EMPTY;
    }

    private static void displayAltarMessage(Player player, double altars) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            message.append(i < altars ? "\u00A7d\u25CE" : "\u00A77\u25CE");
        }
        player.displayClientMessage(Component.literal(message.toString()), true);
    }

    private static void triggerLightningSequence(LevelAccessor world, double x, double y, double z, BlockPos[] positions) {
        for (BlockPos pos : positions) {
            world.destroyBlock(pos, false);
            if (world instanceof ServerLevel serverLevel) {
                LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
                if (lightningBolt != null) {
                    lightningBolt.moveTo(Vec3.atBottomCenterOf(pos));
                    lightningBolt.setVisualOnly(true);
                    serverLevel.addFreshEntity(lightningBolt);
                }
            }
        }
    }

    private static void displayMessageToAllPlayers(LevelAccessor world, double x, double y, double z, String messageKey) {
        final Vec3 center = new Vec3(x, y, z);
        List<LivingEntity> playersInRange = world.getEntitiesOfClass(LivingEntity.class, new AABB(center, center).inflate(32), e -> e instanceof Player);
        for (LivingEntity entity : playersInRange) {
            if (entity instanceof Player player && !player.level().isClientSide()) {
                player.displayClientMessage(Component.translatable(messageKey), true);
            }
        }
    }
}