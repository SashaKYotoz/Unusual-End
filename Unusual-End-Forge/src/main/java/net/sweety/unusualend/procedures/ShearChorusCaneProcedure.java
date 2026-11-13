package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ShearChorusCaneProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShearsItem
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof ShearsItem) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.CHORUS_CANE_FLOWER.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.FLOWERING_PURPUR_GRASS.get()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShearsItem) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.OFF_HAND, true);
				}
				ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.growing_plant.crop")), SoundSource.BLOCKS, 1, 1);
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.CHORUS_CANE_FLOWER.get()) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					for (int index0 = 0; index0 < Mth.nextInt(world.getRandom(), 1, 2); index0++) {
						ProcedureHelper.dropItem(world, (x + 0.5), (y + 1), (z + 0.5), new ItemStack(UnusualendModItems.CHORUS_PETAL.get()), 10);
					}
				} else {
					ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualendModBlocks.PURPUR_GRASS.get().defaultBlockState(), 3);
					ProcedureHelper.dropItem(world, (x + 0.5), (y + 1), (z + 0.5), new ItemStack(UnusualendModItems.CHORUS_PETAL.get()), 10);
				}
			}
		}
	}
}
