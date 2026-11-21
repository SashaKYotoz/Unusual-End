package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemHandlerHelper;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedPotionRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double yaw = 0;
		if (blockstate.getBlock() == UnusualendModBlocks.SQUASH_O_LANTERN.get() || blockstate.getBlock() == UnusualendModBlocks.CARVED_WARPED_SQUASH.get()) {
			itemstack.shrink(1);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if ((ProcedureHelper.getDirection(blockstate)) == Direction.EAST) {
				yaw = -90;
			} else if ((ProcedureHelper.getDirection(blockstate)) == Direction.SOUTH) {
				yaw = 0;
			} else if ((ProcedureHelper.getDirection(blockstate)) == Direction.WEST) {
				yaw = 90;
			} else {
				yaw = 180;
			}
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = UnusualendModEntities.GLUB.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot((float) yaw);
					entityToSpawn.setYBodyRot((float) yaw);
					entityToSpawn.setYHeadRot((float) yaw);
				}
			}
			ParticleHelper.spawn(world, ParticleHelper.dustTransition(0.129f, 0.792f, 0.596f, 1.3f, 1.0f, 0.396f, 0.0f), (x + 0.5), y, (z + 0.5), 30, 0.4, 0.4, 0.4, 0);
		}
	}
}