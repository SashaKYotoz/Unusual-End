package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import net.sweety.unusualend.util.ProcedureHelper;

public class WarpedChestOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity) {
		if (direction == null || entity == null)
			return;
		if (!(ProcedureHelper.getBlockEntityString(world, BlockPos.containing(x, y, z), "UUID")).contains(entity.getStringUUID())) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) == 0) {
				{
					int _value = 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (world.isClientSide()) {
					ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.open")), SoundSource.BLOCKS, 1, (float) Mth.nextDouble(world.getRandom(), 1.2, 1.4));
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putString("UUID", ((ProcedureHelper.getBlockEntityString(world, BlockPos.containing(x, y, z), "UUID")) + "." + entity.getStringUUID()));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CLOUD, (x + 0.5), (y + 0.8), (z + 0.5), 5, 0.4, 0.1, 0.4, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(UnusualendModParticleTypes.WARPED_BUBBLES.get(), (x + 0.5), (y + Mth.nextDouble(world.getRandom(), 0.6, 0.9)), (z + 0.5), 20, 0.3, 0.1, 0.3, 0.05);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FISHING, (x + 0.5), (y + 0.8), (z + 0.5), 15, 0.4, 0.1, 0.4, 0);
				for (int index0 = 0; index0 < (int) Mth.nextDouble(world.getRandom(), 4, 5); index0++) {
					if (!world.isClientSide() && world.getServer() != null) {
						for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("unusualend:chests/warped_ship"))
								.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
							ProcedureHelper.dropItem(world, (x + 0.5 + direction.getStepX() * Mth.nextDouble(world.getRandom(), 0.6, 0.6)), (y + 0.5 + direction.getStepY() * Mth.nextDouble(world.getRandom(), 0.6, 0.6)), (z + 0.5 + direction.getStepZ() * Mth.nextDouble(world.getRandom(), 0.6, 0.6)), itemstackiterator, 10);
						}
					}
				}
				UnusualEnd.queueServerWork(5, () -> {
					{
						int _value = 0;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (world.isClientSide()) {
						ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")), SoundSource.BLOCKS, 1, (float) Mth.nextDouble(world.getRandom(), 1.1, 1.2));
					}
				});
				ProcedureHelper.awardAdvancement(entity, "open_warped_chest");
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 0.8), (z + 0.5), 5, 0.4, 0.1, 0.4, 0);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.translatable("text.unusualend.alreay_opened"), true);
			if (world.isClientSide()) {
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")), SoundSource.BLOCKS, 1, (float) 0.95);
			}
		}
	}
}
