package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.sweety.unusualend.entity.FlampyrEntity;
import net.sweety.unusualend.init.UnusualEndEntities;
import net.sweety.unusualend.util.ProcedureHelper;

public class UnbucketFireflyProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack stack) {
        if (direction == null || entity == null)
            return;
        if (!entity.isShiftKeyDown()) {
            if (world.getBiome(BlockPos.containing(x, y, z)).is(Biomes.MANGROVE_SWAMP) || world.getBiome(BlockPos.containing(x, y, z)).is(Biomes.SWAMP)) {
                ProcedureHelper.awardAdvancement(entity, "firefly_in_swamp");
            }
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == stack.getItem()) {
                if (!(ProcedureHelper.isCreative(entity))) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                }
                if (entity instanceof LivingEntity _entity)
                    _entity.swing(InteractionHand.MAIN_HAND, true);
            } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == stack.getItem()) {
                if (!(ProcedureHelper.isCreative(entity))) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                }
                if (entity instanceof LivingEntity _entity)
                    _entity.swing(InteractionHand.OFF_HAND, true);
            }
            if (world instanceof ServerLevel _level) {
                FlampyrEntity entityToSpawn = UnusualEndEntities.FLAMPYR.get().spawn(_level, BlockPos.containing(x + direction.getStepX(), y + direction.getStepY(), z + direction.getStepZ()), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null)
                    NBTProcessor.writeTagsIntoEntity(stack.getOrDefault(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY).copyTag(), entityToSpawn);
            }
        }
        ProcedureHelper.playSound(world, x, y, z, SoundEvents.ENDERMITE_AMBIENT, SoundSource.NEUTRAL, 1, 1);
    }
}
