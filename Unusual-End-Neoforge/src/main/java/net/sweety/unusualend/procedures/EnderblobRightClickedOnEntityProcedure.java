package net.sweety.unusualend.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.entity.EnderblobEntity;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class EnderblobRightClickedOnEntityProcedure {
    public static void execute(LevelAccessor level, Entity entity, Player player) {
        if (entity == null || player == null)
            return;
        if (player.getMainHandItem().is(Items.BRUSH)) {
            if ((entity instanceof EnderblobEntity _datEntI ? _datEntI.getEntityData().get(EnderblobEntity.DATA_BrushTimer) : 0) == 0) {
                if (!player.isCreative())
                    player.getMainHandItem().hurtAndBreak(1,player,player.getEquipmentSlotForItem(player.getMainHandItem()));
                player.swing(InteractionHand.MAIN_HAND, true);
                ProcedureHelper.dropItem(level, (entity.getX()), (entity.getY() + 0.3), (entity.getZ()), new ItemStack(UnusualEndItems.ENDERBLOB_MOULT.get()), 10);
                entity.hurt(new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.1);
                ParticleHelper.spawn(level, ParticleHelper.block(UnusualEndBlocks.ENDERBLOB_BLOCK.get()), (entity.getX()), (entity.getY() + 0.2), (entity.getZ()), 15, 0.3, 0.3, 0.3, 0);
                if (level.isClientSide()) {
                    ProcedureHelper.playSound(level, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BRUSH_GENERIC, SoundSource.NEUTRAL, 1, (float) 1.3);
                    ProcedureHelper.playSound(level, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.NEUTRAL, 1, (float) 0.85);
                }
                if (entity instanceof EnderblobEntity _datEntSetI)
                    _datEntSetI.getEntityData().set(EnderblobEntity.DATA_BrushTimer, 120);
            }
        }
    }
}