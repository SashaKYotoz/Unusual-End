
package net.sweety.unusualend.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.procedures.NBTProcessor;

public class TeleportationAnchorBlock extends Block {
	public TeleportationAnchorBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(4f, 300f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if (level.getBlockState(BlockPos.containing(x, y, z)).is(UnusualEndBlocks.TELEPORTATION_ANCHOR.get())) {
			ItemStack handItem = player.getMainHandItem();
			if (handItem.is(UnusualEndItems.PRISMATIC_MIRROR.get())) {
				if (UEConfig.CAN_USE_TELEPORTATION_ANCHOR.get()) {
					if (NBTProcessor.getNBTBoolean(handItem, "LinkedMirror")) {
						NBTProcessor.setNBTBoolean(handItem, "LinkedMirror", false);
						NBTProcessor.setNBTDouble(handItem, "TpX", 0);
						NBTProcessor.setNBTDouble(handItem, "TpY", 0);
						NBTProcessor.setNBTDouble(handItem, "TpZ", 0);
						ProcedureHelper.playSound(level, x, y, z, SoundEvents.GRINDSTONE_USE, SoundSource.NEUTRAL, 1, 1);
						handItem.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7e" + Component.translatable("item.unusualend.prismatic_mirror").getString())));
					} else {
						if ((player.level().dimension()) == Level.OVERWORLD || (player.level().dimension()) == Level.NETHER || (player.level().dimension()) == Level.END) {
							NBTProcessor.setNBTDouble(handItem, "TpX", x + 0.5);
							NBTProcessor.setNBTDouble(handItem, "TpY", y + 1);
							NBTProcessor.setNBTDouble(handItem, "TpZ", z + 0.5);
							NBTProcessor.setNBTBoolean(handItem, "LinkedMirror", true);
							NBTProcessor.setNBTString(handItem, "TpW", ("" + (level instanceof Level _lvl ? _lvl.dimension() : (level instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))));
							handItem.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7e" + Component.translatable("item.unusualend.linked_prismatic_mirror").getString())));
							player.swing(InteractionHand.MAIN_HAND, true);
							ProcedureHelper.playSound(level, x, y, z, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1, 1);
							if (level instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 20, 1.5, 1.5, 1.5, 0);
							ProcedureHelper.awardAdvancement(player, "hyperspace_jump");
						} else {
							if (player instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.translatable("text.unusualend.cant_host_anchor"), true);
						}
					}
				} else {
					if (!player.level().isClientSide())
						player.displayClientMessage(Component.translatable("text.unusualend.no_anchor"), true);
				}
			} else if (handItem.is(UnusualEndItems.VOID_TOTEM.get())) {
				if (UEConfig.CAN_LINK_VOID_TOTEM.get()) {
					if (NBTProcessor.getNBTBoolean(handItem, "LinkedTotem")) {
						NBTProcessor.setNBTBoolean(handItem, "LinkedTotem", false);
						NBTProcessor.setNBTDouble(handItem, "TpX", 0);
						NBTProcessor.setNBTDouble(handItem, "TpY", 0);
						NBTProcessor.setNBTDouble(handItem, "TpZ", 0);
						ProcedureHelper.playSound(level, x, y, z, SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1, 1);
						handItem.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7e" + Component.translatable("item.unusualend.void_totem").getString())));
					} else {
						if ((player.level().dimension()) == Level.OVERWORLD || (player.level().dimension()) == Level.NETHER || (player.level().dimension()) == Level.END) {
							NBTProcessor.setNBTDouble(handItem, "TpX", x + 0.5);
							NBTProcessor.setNBTDouble(handItem, "TpY", y + 1);
							NBTProcessor.setNBTDouble(handItem, "TpZ", z + 0.5);
							NBTProcessor.setNBTBoolean(handItem, "LinkedTotem", true);
							NBTProcessor.setNBTString(handItem, "TpW", ("" + (level instanceof Level _lvl ? _lvl.dimension() : (level instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))));
							handItem.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7e" + Component.translatable("item.unusualend.linked_void_totem").getString())));
							player.swing(InteractionHand.MAIN_HAND, true);
							ProcedureHelper.playSound(level, x, y, z, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1, 1);
							if (level instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 20, 1.5, 1.5, 1.5, 0);
							ProcedureHelper.awardAdvancement(player, "hyperspace_jump");
						} else {
							if (!player.level().isClientSide())
								player.displayClientMessage(Component.translatable("text.unusualend.cant_host_anchor"), true);
						}
					}
				} else {
					if (!player.level().isClientSide())
						player.displayClientMessage(Component.translatable("text.unusualend.no_anchor"), true);
				}
			} else if (handItem.is(Items.TOTEM_OF_UNDYING)) {
				if (UEConfig.CAN_LINK_TOTEM.get()) {
					if (NBTProcessor.getNBTBoolean(handItem, "LinkedTotem")) {
						NBTProcessor.setNBTBoolean(handItem, "LinkedTotem", false);
						NBTProcessor.setNBTDouble(handItem, "TpX", 0);
						NBTProcessor.setNBTDouble(handItem, "TpY", 0);
						NBTProcessor.setNBTDouble(handItem, "TpZ", 0);
						ProcedureHelper.playSound(level, x, y, z, SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1, 1);
						handItem.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7e" + Component.translatable("item.minecraft.totem_of_undying").getString())));
					} else {
						if ((player.level().dimension()) == Level.OVERWORLD || (player.level().dimension()) == Level.NETHER || (player.level().dimension()) == Level.END) {
							NBTProcessor.setNBTDouble(handItem, "TpX", x + 0.5);
							NBTProcessor.setNBTDouble(handItem, "TpY", y + 1);
							NBTProcessor.setNBTDouble(handItem, "TpZ", z + 0.5);
							NBTProcessor.setNBTBoolean(handItem, "LinkedTotem", true);
							NBTProcessor.setNBTString(handItem, "TpW", ("" + (level instanceof Level _lvl ? _lvl.dimension() : (level instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))));
							handItem.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7e" + Component.translatable("item.unusualend.linked_totem_undying").getString())));
							player.swing(InteractionHand.MAIN_HAND, true);
							ProcedureHelper.playSound(level, x, y, z, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1, 1);
							if (level instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 20, 1.5, 1.5, 1.5, 0);
						} else {
							if (!player.level().isClientSide())
								player.displayClientMessage(Component.translatable("text.unusualend.cant_host_anchor"), true);
						}
					}
				} else {
					if (!player.level().isClientSide())
						player.displayClientMessage(Component.translatable("text.unusualend.no_anchor"), true);
				}
			} else {
				if (!player.level().isClientSide())
					player.displayClientMessage(Component.translatable("text.unusualend.need_anchor_item"), true);
			}
		}
		return ItemInteractionResult.SUCCESS;
	}
}