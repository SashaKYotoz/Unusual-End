package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.Comparator;
import java.util.List;

public class BuildingInhibitorOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean nearby = false;
		if ((ProcedureHelper.getItemStack(world, BlockPos.containing(x, y, z), 0)).getItem() == Items.DRAGON_BREATH) {
			if (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Fuel") <= 16) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Fuel", (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Fuel") + 16));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.DRAGON_BREATH, (x + 0.5), (y + 1), (z + 0.5), 10, 0.3, 0.3, 0.3, 0);
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.BLOCKS, 1, (float) 1.5);
			}
		}
		if (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "isActive") >= 1) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("isActive", ((ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "isActive")) - 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "isActive") >= 1 || ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Fuel") >= 1) {
			nearby = false;
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (!(ProcedureHelper.isSpectator(entityiterator) || ProcedureHelper.isCreative(entityiterator))) {
								if (!(ProcedureHelper.getBlockEntityString(world, BlockPos.containing(x, y, z), "Owner")).equals(entityiterator.getStringUUID())) {
									nearby = true;
									ProcedureHelper.addEffect(entityiterator, new MobEffectInstance(UnusualendModMobEffects.DISRUPTION.get(), 140, 0, true, true));
								}
							}
						}
					}
				}
				if (nearby == true) {
					if (!(ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "isActive") >= 1)) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("Fuel", ((ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Fuel")) - 1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("isActive", 6000);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.DRAGON_BREATH, (x + 0.5), (y + 1), (z + 0.5), 10, 0.3, 0.3, 0.3, 0);
						ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.BLOCKS, 1, (float) 1.5);
					}
				}
			}
		}
	}
}
