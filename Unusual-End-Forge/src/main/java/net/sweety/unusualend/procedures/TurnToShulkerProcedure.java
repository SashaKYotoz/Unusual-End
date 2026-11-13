package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.items.ItemHandlerHelper;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

public class TurnToShulkerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.END_STONE.asItem()) {
			if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))).getBlock() == UnusualendModBlocks.INFESTED_END_STONE.get()) {
				world.setBlock(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()), Blocks.END_STONE.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY()), (entity.getZ()), 30, 1, 1, 1, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY()), (entity.getZ()), 15, 1, 1, 1, 0);
				ProcedureHelper.playSound(world, x, y, z, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.HOSTILE, 1, 1);
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (!entity.level().isClientSide())
					entity.discard();
				if (sourceentity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Blocks.END_STONE);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (sourceentity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(UnusualendModBlocks.INFESTED_END_STONE.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				ProcedureHelper.awardAdvancement(sourceentity, "gotta_catch_em_all");
			}
		}
	}
}
