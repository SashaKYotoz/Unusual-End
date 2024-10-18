package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModBlocks;

public class FlowerPotChorusFungusOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.POTTED_CHORUS_FUNGUS.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(UnusualendModBlocks.CHORUS_FUNGUS.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.FLOWER_POT.defaultBlockState(), 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.FLOWER_POT_CHORUS_ROOTS.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(UnusualendModBlocks.CHORUS_ROOTS.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.FLOWER_POT.defaultBlockState(), 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.FLOWER_POT_SHINY_SPIREA.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(UnusualendModBlocks.SHINY_SPIREA.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.FLOWER_POT.defaultBlockState(), 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.FLOWER_POT_WARPED_BUSH.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(UnusualendModBlocks.WARPED_BUSH.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.FLOWER_POT.defaultBlockState(), 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.FLOWER_POT_CANE.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(UnusualendModBlocks.BLOOMING_CHORUS_CANE.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.FLOWER_POT.defaultBlockState(), 3);
			}
		}
	}
}
