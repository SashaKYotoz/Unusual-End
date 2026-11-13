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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class AncientPodiumOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack item = ItemStack.EMPTY;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) && ProcedureHelper.getItemCount(world, BlockPos.containing(x, y, z), 0) == 0) {
			item = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent != null) {
					final int _slotid = 0;
					final ItemStack _setstack = item.copy();
					_setstack.setCount(1);
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANT, (x + 0.5), (y + 0.9), (z + 0.5), 15, 0.2, 0.2, 0.2, 0);
			ParticleHelper.spawn(world, ParticleHelper.dust(0.8f, 0.8f, 3.1f, 0.7f), (x + 0.5), (y + 0.9), (z + 0.5), 15, 0.15, 0.2, 0.15, 0);
			if (world.isClientSide()) {
				ProcedureHelper.playSound(world, x, y, z, SoundEvents.CHISELED_BOOKSHELF_INSERT_ENCHANTED, SoundSource.BLOCKS, 1, (float) 1.8);
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && ProcedureHelper.getItemCount(world, BlockPos.containing(x, y, z), 0) != 0) {
			item = (ProcedureHelper.getItemStack(world, BlockPos.containing(x, y, z), 0));
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = item.copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent != null) {
					final int _slotid = 0;
					final int _amount = 1;
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_slotid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
						}
					});
				}
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			if (world.isClientSide()) {
				ProcedureHelper.playSound(world, x, y, z, SoundEvents.CHISELED_BOOKSHELF_PICKUP_ENCHANTED, SoundSource.BLOCKS, 1, (float) 1.8);
			}
		}
	}
}
