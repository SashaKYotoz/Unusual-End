package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

@EventBusSubscriber
public class StipPlanksProcedure {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }

    private static void execute(LevelAccessor world, double x, double y, double z, LivingEntity entity) {
        if (entity == null)
            return;
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
                && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
            if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(UnusualEnd.makeUEID("strippable")))) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
                    if (!(ProcedureHelper.isCreative(entity))) {
                        entity.getMainHandItem().hurtAndBreak(1, entity, entity.getEquipmentSlotForItem(entity.getMainHandItem()));
                    }
                } else {
                    if (entity instanceof LivingEntity _entity)
                        _entity.swing(InteractionHand.OFF_HAND, true);
                    if (!(ProcedureHelper.isCreative(entity))) {
                        entity.getOffhandItem().hurtAndBreak(1, entity, entity.getEquipmentSlotForItem(entity.getOffhandItem()));
                    }
                }
                if (entity instanceof LivingEntity _entity)
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                if (world.isClientSide()) {
                    ProcedureHelper.playSound(world, x, y, z, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1, 1);
                }
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualEndBlocks.CHORUS_NEST_PLANKS.get()) {
                    ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualEndBlocks.STRIPPED_CHORUS_NEST_PLANKS.get().defaultBlockState(), 3);
                }
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualEndBlocks.CHORUS_NEST_STAIRS.get()) {
                    ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualEndBlocks.STRIPPED_CHORUS_NEST_STAIRS.get().defaultBlockState(), 3);
                }
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualEndBlocks.CHORUS_NEST_SLAB.get()) {
                    ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualEndBlocks.STRIPPED_CHORUS_NEST_SLAB.get().defaultBlockState(), 3);
                }
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualEndBlocks.CHORUS_CANE_BLOCK.get()) {
                    ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualEndBlocks.STRIPPED_CHORUS_CANE_BLOCK.get().defaultBlockState(), 3);
                }
                if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualEndBlocks.BLOOMING_CHORUS_CANE.get()) {
                    ProcedureHelper.replaceBlockKeepingState(world, BlockPos.containing(x, y, z), UnusualEndBlocks.CHORUS_CANE.get().defaultBlockState(), 3);
                }
            }
        }
    }
}
