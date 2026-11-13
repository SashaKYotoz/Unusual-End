package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModTags;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StipPlanksProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(UnusualendModTags.Blocks.STRIPPABLE)) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
					if (!(ProcedureHelper.isCreative(entity))) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							if (_ist.hurt(1, world.getRandom(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.OFF_HAND, true);
					if (!(ProcedureHelper.isCreative(entity))) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
							if (_ist.hurt(1, world.getRandom(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (world.isClientSide()) {
					ProcedureHelper.playSound(world, x, y, z, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1, 1);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.CHORUS_NEST_PLANKS.get()) {
					ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualendModBlocks.STRIPPED_CHORUS_NEST_PLANKS.get().defaultBlockState(), 3);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.CHORUS_NEST_STAIRS.get()) {
					ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualendModBlocks.STRIPPED_CHORUS_NEST_STAIRS.get().defaultBlockState(), 3);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.CHORUS_NEST_SLAB.get()) {
					ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualendModBlocks.STRIPPED_CHORUS_NEST_SLAB.get().defaultBlockState(), 3);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.CHORUS_CANE_BLOCK.get()) {
					ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualendModBlocks.STRIPPED_CHORUS_CANE_BLOCK.get().defaultBlockState(), 3);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.BLOOMING_CHORUS_CANE.get()) {
					ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualendModBlocks.CHORUS_CANE.get().defaultBlockState(), 3);
				}
			}
		}
	}
}
