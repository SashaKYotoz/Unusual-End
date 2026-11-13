package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import net.sweety.unusualend.util.ProcedureHelper;

public class PearlescentInfuserUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == UnusualendModItems.CITRINE_CHUNK.get()) {
			if (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Citrine") <= 7) {
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
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Citrine", (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Citrine") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, (x + 0.5), (y + 1.2), (z + 0.5), 6, 0.1, 0.1, 0.1, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1.2), (z + 0.5), 8, 0.1, 0.1, 0.1, 0);
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient.short")), SoundSource.NEUTRAL, 2, (float) 1.8);
			}
		}
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x, y, z), 1)).getItem() == UnusualendModItems.SHINY_CRYSTAL.get()) {
			if (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Shiny") <= 7) {
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent != null) {
						final int _slotid = 1;
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
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Shiny", (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Shiny") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (UnusualendModParticleTypes.PINK_FLAME.get()), (x + 0.5), (y + 1.2), (z + 0.5), 6, 0.1, 0.1, 0.1, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1.2), (z + 0.5), 8, 0.1, 0.1, 0.1, 0);
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient.short")), SoundSource.NEUTRAL, 2, (float) 1.8);
			}
		}
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x, y, z), 2)).getItem() == UnusualendModItems.PRISMALITE_GEM.get()) {
			if (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Prismatic") <= 7) {
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					if (_ent != null) {
						final int _slotid = 2;
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
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Prismatic", (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Prismatic") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5), (y + 1.2), (z + 0.5), 6, 0.1, 0.1, 0.1, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1.2), (z + 0.5), 8, 0.1, 0.1, 0.1, 0);
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient.short")), SoundSource.NEUTRAL, 2, (float) 1.8);
			}
		}
	}
}
