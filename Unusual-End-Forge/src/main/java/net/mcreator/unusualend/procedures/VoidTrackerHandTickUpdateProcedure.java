package net.mcreator.unusualend.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class VoidTrackerHandTickUpdateProcedure {
	public static void execute(Level level, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == Level.END) {
			itemstack.getOrCreateTag().putDouble("SonarWait", (itemstack.getOrCreateTag().getDouble("SonarWait") + 1));
			if (itemstack.getOrCreateTag().getDouble("SonarWait") >= 47 && itemstack.getOrCreateTag().getDouble("SonarWait") < 50) {
				itemstack.getOrCreateTag().putDouble("VoidState", 9);
			}
			if (itemstack.getOrCreateTag().getDouble("SonarWait") == 47) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 4);
			}
			if (itemstack.getOrCreateTag().getDouble("SonarWait") >= 50) {
				itemstack.getOrCreateTag().putDouble("SonarWait", 0);
				if (level instanceof ServerLevel) {
					ServerLevel serverLevel = (ServerLevel) level;
					BlockPos nearestStructure = serverLevel.findNearestMapStructure((TagKey.create(Registries.STRUCTURE, new ResourceLocation("unusualend:void_tracker_located"))), entity.blockPosition(), 100, false);
					if (nearestStructure != null) {
						if (!(itemstack.getOrCreateTag().getDouble("Distance") >= 0)) {
							itemstack.getOrCreateTag().putDouble("Distance", 999999);
							itemstack.getOrCreateTag().putDouble("VoidState", 10);
						} else {
							if (Math.round(new Vec3(x, y, z).distanceTo(new Vec3(nearestStructure.getX(), y, nearestStructure.getZ()))) < Math.round(itemstack.getOrCreateTag().getDouble("Distance"))) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7b\u25B2 + \u25B2"), true);
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"playsound minecraft:block.amethyst_block.resonate player @a ~ ~ ~ 2 1.7");
							} else if (Math.round(new Vec3(x, y, z).distanceTo(new Vec3(nearestStructure.getX(), y, nearestStructure.getZ()))) == Math.round(itemstack.getOrCreateTag().getDouble("Distance"))) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7d\u25C6 = \u25C6"), true);
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"playsound minecraft:block.amethyst_block.resonate player @a ~ ~ ~ 2 1.1");
							} else if (Math.round(new Vec3(x, y, z).distanceTo(new Vec3(nearestStructure.getX(), y, nearestStructure.getZ()))) > Math.round(itemstack.getOrCreateTag().getDouble("Distance"))) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7c\u25BC - \u25BC"), true);
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"playsound minecraft:block.amethyst_block.resonate player @a ~ ~ ~ 2 0.6");
							} else {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"playsound minecraft:block.amethyst_block.chime player @a ~ ~ ~ 2 0.7");
								if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A77\u25CF ? \u25CF"), true);
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A7k\u00A77\u25CF ? \u25CF"), true);
								}
							}
							itemstack.getOrCreateTag().putDouble("Distance", Math.round(new Vec3(x, y, z).distanceTo(new Vec3(nearestStructure.getX(), y, nearestStructure.getZ()))));
							if (itemstack.getOrCreateTag().getDouble("Distance") >= 1500) {
								itemstack.getOrCreateTag().putDouble("VoidState", 1);
							} else if (itemstack.getOrCreateTag().getDouble("Distance") >= 1200) {
								itemstack.getOrCreateTag().putDouble("VoidState", 2);
							} else if (itemstack.getOrCreateTag().getDouble("Distance") >= 900) {
								itemstack.getOrCreateTag().putDouble("VoidState", 3);
							} else if (itemstack.getOrCreateTag().getDouble("Distance") >= 600) {
								itemstack.getOrCreateTag().putDouble("VoidState", 4);
							} else if (itemstack.getOrCreateTag().getDouble("Distance") >= 300) {
								itemstack.getOrCreateTag().putDouble("VoidState", 5);
							} else if (itemstack.getOrCreateTag().getDouble("Distance") >= 150) {
								itemstack.getOrCreateTag().putDouble("VoidState", 6);
							} else if (itemstack.getOrCreateTag().getDouble("Distance") >= 750) {
								itemstack.getOrCreateTag().putDouble("VoidState", 7);
							} else if (itemstack.getOrCreateTag().getDouble("Distance") >= 20) {
								itemstack.getOrCreateTag().putDouble("VoidState", 8);
							} else if (itemstack.getOrCreateTag().getDouble("Distance") <= 20 && itemstack.getOrCreateTag().getDouble("Distance") > 0) {
								itemstack.getOrCreateTag().putDouble("VoidState", 9);
							} else {
								itemstack.getOrCreateTag().putDouble("VoidState", 10);
							}
						}
					}
				}
			}
		} else {
			itemstack.getOrCreateTag().putDouble("VoidState", 1);
			if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A77\u25CF ? \u25CF"), true);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7k\u00A77\u25CF ? \u25CF"), true);
			}
		}
	}
}
