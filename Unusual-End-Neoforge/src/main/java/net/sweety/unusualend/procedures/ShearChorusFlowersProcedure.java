package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.sweety.unusualend.util.ProcedureHelper;

@EventBusSubscriber
public class ShearChorusFlowersProcedure {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
    }

    private static void execute(Level level, double x, double y, double z, BlockState blockstate, Player player) {
        if (player == null)
            return;
        if (blockstate.getBlock() == Blocks.CHORUS_FLOWER && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) < 5) {
            if (player.getMainHandItem().getItem() instanceof HoeItem) {
                player.swing(InteractionHand.MAIN_HAND, true);
                if (!player.isCreative()) {
                    player.getMainHandItem().hurtAndBreak(1, player, player.getEquipmentSlotForItem(player.getMainHandItem()));
                }
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = level.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(5))
                    level.setBlock(_pos, _bs.setValue(_integerProp, 5), 3);
                ProcedureHelper.playSound(level, x, y, z, SoundEvents.CHORUS_FLOWER_DEATH, SoundSource.NEUTRAL, 1, 1);
            }
        }
    }
}
