package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndEntities;

@EventBusSubscriber
public class PearlescentRingTriggerProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event != null && event.getEntity() != null)
            execute(event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
    }

    @SuppressWarnings({"removal", "deprecation"})
    private static void execute(LevelAccessor world, double x, double y, double z, Entity sourceEntity) {
        if (sourceEntity == null)
            return;
        if (ModList.get().isLoaded("curios")) {
//            if (sourceEntity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(UnusualEndItems.PEARLESCENT_RING.get(), lv).isPresent() : false) {
//                sourceEntity.getPersistentData().putBoolean("wasRingUsed", false);
//                if (sourceEntity instanceof LivingEntity lv) {
//                    CuriosApi.getCuriosHelper().findCurios(lv, UnusualEndItems.PEARLESCENT_RING.get()).forEach(item -> {
//                        ItemStack stackIterator = item.stack();
//                        if (!((sourceEntity instanceof Player _plrCldRem3 ? _plrCldRem3.getCooldowns().getCooldownPercent(UnusualEndItems.PEARLESCENT_RING.get(), 0f) * 100 : 0) > 0)) {
//                            if (NBTProcessor.getNBTDouble(stackIterator, "ringCooldown") >= 400) {
//                                sourceEntity.getPersistentData().putBoolean("wasRingUsed", true);
//                                if (world instanceof ServerLevel _serverLevel) {
//                                    Entity entitytospawn = UnusualendModEntities.SUMMONED_DRAGLING.get().spawn(_serverLevel,
//                                            BlockPos.containing(
//                                                    (sourceEntity.level()
//                                                            .clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
//                                                                    sourceEntity))
//                                                            .getBlockPos().getX()),
//                                                    (sourceEntity.level()
//                                                            .clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
//                                                                    sourceEntity))
//                                                            .getBlockPos().getY()),
//                                                    (sourceEntity.level().clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER,
//                                                            ClipContext.Fluid.NONE, sourceEntity)).getBlockPos().getZ())),
//                                            MobSpawnType.MOB_SUMMONED);
//                                    if (entitytospawn != null) {
//                                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
//                                    }
//                                    if ((entitytospawn) instanceof TamableAnimal _toTame && sourceEntity instanceof Player _owner)
//                                        _toTame.tame(_owner);
//                                    if (world instanceof ServerLevel _level)
//                                        _level.sendParticles(ParticleTypes.SQUID_INK, ((entitytospawn).getX()), ((entitytospawn).getY()), ((entitytospawn).getZ()), 10, 0.2, 0.2, 0.2, 0);
//                                    if (world instanceof ServerLevel _level)
//                                        _level.sendParticles(ParticleTypes.REVERSE_PORTAL, ((entitytospawn).getX()), ((entitytospawn).getY()), ((entitytospawn).getZ()), 10, 0.2, 0.2, 0.2, 0);
//                                    if (world instanceof Level _level) {
//                                        if (!_level.isClientSide()) {
//                                            _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1, 1);
//                                        } else {
//                                            _level.playLocalSound(x, y, z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1, 1, false);
//                                        }
//                                    }
//                                }
//                                if ((sourceEntity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(UnusualEnd.makeUEID("enderling_mask")))) {
//                                    if (world instanceof ServerLevel _serverLevel) {
//                                        Entity entitytospawn = UnusualendModEntities.SUMMONED_DRAGLING.get().spawn(_serverLevel,
//                                                BlockPos.containing(
//                                                        (sourceEntity.level()
//                                                                .clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
//                                                                        sourceEntity))
//                                                                .getBlockPos().getX()),
//                                                        (sourceEntity.level()
//                                                                .clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
//                                                                        sourceEntity))
//                                                                .getBlockPos().getY()),
//                                                        (sourceEntity.level().clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER,
//                                                                ClipContext.Fluid.NONE, sourceEntity)).getBlockPos().getZ())),
//                                                MobSpawnType.MOB_SUMMONED);
//                                        if (entitytospawn != null) {
//                                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
//                                        }
//                                        if ((entitytospawn) instanceof TamableAnimal _toTame && sourceEntity instanceof Player _owner)
//                                            _toTame.tame(_owner);
//                                    }
//                                }
//                                NBTProcessor.setNBTDouble(stackIterator, "ringCooldown", 0);
//                                if (sourceEntity instanceof Player _player)
//                                    _player.getCooldowns().addCooldown(UnusualEndItems.PEARLESCENT_RING.get(), 10);
//                            }
//                        }
//                    });
//                }
//            }
        }
        if ((sourceEntity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == UnusualEndItems.PEARLESCENT_RING.get()) {
            if (!((sourceEntity instanceof Player _plrCldRem42 ? _plrCldRem42.getCooldowns().getCooldownPercent(UnusualEndItems.PEARLESCENT_RING.get(), 0f) * 100 : 0) > 0)) {
                if (sourceEntity instanceof LivingEntity _livEnt && NBTProcessor.getNBTDouble(_livEnt.getOffhandItem(),"ringCooldown") >= 400) {
                    if (world instanceof ServerLevel _serverLevel) {
                        Entity entitytospawn = UnusualEndEntities.SUMMONED_DRAGLING.get()
                                .spawn(_serverLevel,
                                        BlockPos.containing(
                                                (sourceEntity.level()
                                                        .clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
                                                                sourceEntity))
                                                        .getBlockPos().getX()),
                                                (sourceEntity
                                                        .level()
                                                        .clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
                                                                sourceEntity))
                                                        .getBlockPos().getY()),
                                                (sourceEntity.level().clip(
                                                                new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceEntity))
                                                        .getBlockPos().getZ())),
                                        MobSpawnType.MOB_SUMMONED);
                        if (entitytospawn != null) {
                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                        if ((entitytospawn) instanceof TamableAnimal _toTame && sourceEntity instanceof Player _owner)
                            _toTame.tame(_owner);
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.SQUID_INK, ((entitytospawn).getX()), ((entitytospawn).getY()), ((entitytospawn).getZ()), 10, 0.2, 0.2, 0.2, 0);
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.REVERSE_PORTAL, ((entitytospawn).getX()), ((entitytospawn).getY()), ((entitytospawn).getZ()), 10, 0.2, 0.2, 0.2, 0);
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1, 1);
                            } else {
                                _level.playLocalSound(x, y, z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1, 1, false);
                            }
                        }
                    }
                    if ((sourceEntity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(UnusualEnd.makeUEID("enderling_mask")))) {
                        if (world instanceof ServerLevel _serverLevel) {
                            Entity entitytospawn = UnusualEndEntities.SUMMONED_DRAGLING.get()
                                    .spawn(_serverLevel,
                                            BlockPos.containing(
                                                    (sourceEntity.level()
                                                            .clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
                                                                    sourceEntity))
                                                            .getBlockPos().getX()),
                                                    (sourceEntity.level()
                                                            .clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
                                                                    sourceEntity))
                                                            .getBlockPos().getY()),
                                                    (sourceEntity.level().clip(new ClipContext(sourceEntity.getEyePosition(1f), sourceEntity.getEyePosition(1f).add(sourceEntity.getViewVector(1f).scale(1)), ClipContext.Block.COLLIDER,
                                                            ClipContext.Fluid.NONE, sourceEntity)).getBlockPos().getZ())),
                                            MobSpawnType.MOB_SUMMONED);
                            if (entitytospawn != null) {
                                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                            }
                            if ((entitytospawn) instanceof TamableAnimal _toTame && sourceEntity instanceof Player _owner)
                                _toTame.tame(_owner);
                        }
                    }
                    NBTProcessor.setNBTDouble(_livEnt.getOffhandItem(), "ringCooldown", 0);
                    if (sourceEntity instanceof Player player)
                        player.getCooldowns().addCooldown(UnusualEndItems.PEARLESCENT_RING.get(), 10);
                }
            }
        }
    }
}
