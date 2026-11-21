package net.sweety.unusualend.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.entity.DraglingEntity;
import net.sweety.unusualend.entity.EnderblobEntity;
import net.sweety.unusualend.entity.EnderbulbEntity;
import net.sweety.unusualend.entity.EnderlingEntity;
import net.sweety.unusualend.entity.EndstoneGolemEntity;
import net.sweety.unusualend.entity.FlampyrEntity;
import net.sweety.unusualend.entity.SmallEnderbulbEntity;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import net.sweety.unusualend.item.PearlescentRingItem;
import net.sweety.unusualend.procedures.DivideSerenityProcedure;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;
import net.sweety.unusualend.util.TeleportHelper;

@Mod.EventBusSubscriber
public class LivingHurtEvents {
    private static final int ORB_RING_PARTICLES = 20;
    private static final double ORB_RING_RADIUS = 3;

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity target = event.getEntity();
        if (target == null)
            return;
        DamageSource source = event.getSource();
        Entity attacker = source.getEntity();
        boloksFury(event, target, source, attacker);
        if (golemProtectsDraglings(event, target, attacker)
                || crystallization(event, target)
                || bouncyGloopslateFall(event, target, source)
                || serenityFall(event, target, source)
                || endstoneGolemPush(event, target, source, attacker)
                || chorusHelmetDodge(event, target))
            return;
        enderlingVanish(target);
        if (target instanceof Player player)
            golemOrbs(player);
        if (attacker == null)
            return;
        endermiteInfection(target, attacker);
        flampyrInstakill(target, attacker);
        PearlescentRingItem.onHolderAttack(event);
    }

    private static boolean cancel(LivingHurtEvent event) {
        event.setCanceled(true);
        return true;
    }

    private static DamageSource damage(Level level, ResourceKey<DamageType> type) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type));
    }

    private static void boloksFury(LivingHurtEvent event, LivingEntity target, DamageSource source, Entity attacker) {
        if (!(attacker instanceof LivingEntity living) || source.isIndirect())
            return;
        int fury = living.getMainHandItem().getEnchantmentLevel(UnusualendModEnchantments.BOLOKS_FURY.get());
        if (fury == 0 || target.getHealth() < target.getMaxHealth())
            return;
        event.setAmount(event.getAmount() + 0.5f + 2 * fury);
        Level level = target.level();
        if (level instanceof ServerLevel serverLevel)
            serverLevel.sendParticles(UnusualendModParticleTypes.BOLOK_PARTICLE.get(), target.getX(), target.getY() + 0.7 * target.getBbHeight(), target.getZ(), 30, 0.3, 0.5, 0.3, 0.5);
        ProcedureHelper.playSound(level, target.getX(), target.getY(), target.getZ(), SoundEvents.PLAYER_HURT_DROWN, SoundSource.HOSTILE, 0.3f, (float) Mth.nextDouble(level.getRandom(), 0.6, 1.2));
    }

    private static boolean golemProtectsDraglings(LivingHurtEvent event, LivingEntity target, Entity attacker) {
        if (!(target instanceof DraglingEntity dragling) || !(attacker instanceof EndstoneGolemEntity golem))
            return false;
        if (golem.getTarget() != null)
            dragling.setTarget(golem.getTarget());
        return cancel(event);
    }

    private static boolean crystallization(LivingHurtEvent event, LivingEntity target) {
        if (!target.hasEffect(UnusualendModMobEffects.CRYSTALLIZATION.get()))
            return false;
        target.getPersistentData().putDouble("CrystalDamages", target.getPersistentData().getDouble("CrystalDamages") + event.getAmount());
        return cancel(event);
    }

    private static boolean bouncyGloopslateFall(LivingHurtEvent event, LivingEntity target, DamageSource source) {
        if (!(target instanceof Player) || !source.is(DamageTypes.FALL) || event.getAmount() >= 3)
            return false;
        if (!target.level().getBlockState(BlockPos.containing(target.getX(), target.getY() - 1, target.getZ())).is(UnusualendModBlocks.BOUNCY_GLOOPSLATE.get()))
            return false;
        target.resetFallDistance();
        return cancel(event);
    }

    private static boolean serenityFall(LivingHurtEvent event, LivingEntity target, DamageSource source) {
        if (!source.is(DamageTypes.FALL) || !target.hasEffect(UnusualendModMobEffects.SERENITY.get()))
            return false;
        cancel(event);
        target.resetFallDistance();
        if (target.level() instanceof ServerLevel serverLevel)
            serverLevel.sendParticles(ParticleTypes.POOF, target.getX(), target.getY() + 1, target.getZ(), 30, 1, 0.5, 1, 0);
        DivideSerenityProcedure.execute(target);
        return true;
    }

    private static boolean endstoneGolemPush(LivingHurtEvent event, LivingEntity target, DamageSource source, Entity attacker) {
        if (!(attacker instanceof EndstoneGolemEntity golem))
            return false;
        if (source.is(DamageTypes.CRAMMING))
            crammedByGolem(target);
        if (!source.is(DamageTypes.MOB_ATTACK) || golem.getEntityData().get(EndstoneGolemEntity.DATA_push) != 0)
            return false;
        cancel(event);
        golem.getEntityData().set(EndstoneGolemEntity.DATA_push, 1);
        Level level = target.level();
        float amount = event.getAmount();
        UnusualEnd.queueServerWork(4, () -> {
            target.invulnerableTime = 0;
            target.hurt(damage(level, DamageTypes.EXPLOSION), amount);
            if (level instanceof ServerLevel serverLevel)
                serverLevel.sendParticles(ParticleTypes.WITCH, target.getX(), target.getY(), target.getZ(), 10, 1, 1, 1, 0.1);
            int stone = Block.getId(UnusualendModBlocks.PURPUR_EMBEDDED_END_STONE.get().defaultBlockState());
            for (int i = 0; i < 5; i++)
                level.levelEvent(2001, BlockPos.containing(target.getX(), target.getY() + 1, target.getZ()), stone);
        });
        for (DraglingEntity dragling : level.getEntitiesOfClass(DraglingEntity.class, new AABB(target.position(), target.position()).inflate(8)))
            dragling.setTarget(target);
        return true;
    }

    private static void crammedByGolem(LivingEntity target) {
        ProcedureHelper.addEffect(target, new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 40, 2, false, true));
        if (!(target instanceof Player player))
            return;
        for (Item item : new Item[]{player.getMainHandItem().getItem(), player.getOffhandItem().getItem()}) {
            if (!player.getCooldowns().isOnCooldown(item))
                player.getCooldowns().addCooldown(item, 60);
        }
    }

    private static boolean chorusHelmetDodge(LivingHurtEvent event, LivingEntity target) {
        if (!target.getItemBySlot(EquipmentSlot.HEAD).is(UnusualendModItems.CHORUS_HELMET.get()) || target.isShiftKeyDown())
            return false;
        Level level = target.level();
        if (Math.random() >= Config.CHORUS_HELMET_PROBABILITY_TO_TELEPORT.get() / 100)
            return false;
        double x = target.getX();
        double y = target.getY();
        double z = target.getZ();
        for (int attempt = 0; attempt < 1000; attempt++) {
            double tx = x + Mth.nextInt(level.getRandom(), -5, 5);
            double ty = y + Mth.nextInt(level.getRandom(), -2, 2);
            double tz = z + Mth.nextInt(level.getRandom(), -5, 5);
            BlockPos spot = BlockPos.containing(tx, ty, tz);
            if (!level.getBlockState(spot).isAir() || !level.getBlockState(spot.below()).canOcclude())
                continue;
            TeleportHelper.teleport(target, tx, ty, tz);
            if (level instanceof ServerLevel serverLevel)
                serverLevel.sendParticles(ParticleTypes.PORTAL, tx, ty, tz, 30, 0.5, 1.5, 0.5, 0);
            ProcedureHelper.playSound(level, x, y, z, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1, 1);
            if (event.getAmount() > Config.MAX_DAMAGE_CHORUS_HELMET_CAN_DODGE_WITH_TP_.get())
                return false;
            ProcedureHelper.awardAdvancement(target, "use_chorus_helmet");
            return cancel(event);
        }
        return false;
    }

    private static void enderlingVanish(LivingEntity target) {
        if (!(target instanceof EnderlingEntity))
            return;
        ProcedureHelper.addEffect(target, new MobEffectInstance(MobEffects.INVISIBILITY, 60, 0, false, false));
        target.setDeltaMovement(new Vec3(0, -0.1, 0));
        ParticleHelper.spawn(target.level(), ParticleHelper.enderClothDust(), target.position().add(0, 1, 0), 20, 0.2, 0.3, 0.2, 0);
    }

    private static void endermiteInfection(LivingEntity target, Entity attacker) {
        if (!(attacker instanceof Endermite) && !(attacker instanceof EnderblobEntity))
            return;
        if (target instanceof EnderMan) {
            if (Math.random() < 0.5)
                ProcedureHelper.addEffect(target, new MobEffectInstance(UnusualendModMobEffects.ENDER_INFECTION.get(), 36000, 0));
        } else if (Math.random() < Config.ENDERMITES_PROBABILITY_TO_INFECT.get() / 100) {
            ProcedureHelper.addEffect(target, new MobEffectInstance(UnusualendModMobEffects.ENDER_INFECTION.get(), 600, 0));
        }
    }

    private static void flampyrInstakill(LivingEntity target, Entity attacker) {
        if (target instanceof SmallEnderbulbEntity && attacker instanceof Frog)
            target.hurt(damage(target.level(), DamageTypes.GENERIC), 20);
        if (attacker instanceof FlampyrEntity && (target instanceof Endermite || target instanceof EnderblobEntity || target instanceof EnderbulbEntity || target instanceof SmallEnderbulbEntity))
            target.hurt(damage(target.level(), DamageTypes.GENERIC), 15);
    }

    private static void golemOrbs(Player player) {
        Inventory inventory = player.getInventory();
        boolean blazing = inventory.contains(new ItemStack(UnusualendModItems.BLAZING_ORB.get()));
        boolean shulker = inventory.contains(new ItemStack(UnusualendModItems.SHULKER_ORB.get()));
        boolean withering = inventory.contains(new ItemStack(UnusualendModItems.WITHERING_ORB.get()));
        if (!blazing && !shulker && !withering && !inventory.contains(new ItemStack(UnusualendModItems.GOLEM_ORB.get())))
            return;
        if (Math.random() >= Config.ORB_TRIGGER.get() / 100)
            return;
        Level level = player.level();
        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();
        ProcedureHelper.playSound(level, x, y, z, SoundEvents.ZOMBIE_ATTACK_WOODEN_DOOR, SoundSource.PLAYERS, 1, 0.1f);
        level.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId(level.getBlockState(BlockPos.containing(x, y - 1, z))));
        ServerLevel serverLevel = level instanceof ServerLevel server ? server : null;
        for (Monster monster : level.getEntitiesOfClass(Monster.class, new AABB(player.position(), player.position()).inflate(3))) {
            monster.hurt(damage(level, DamageTypes.GENERIC), 8);
            ProcedureHelper.addEffect(monster, new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
            ProcedureHelper.addEffect(monster, new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 60, 1, false, false));
            if (serverLevel != null) {
                serverLevel.sendParticles(ParticleTypes.POOF, x, y, z, 10, 3, 3, 3, 0);
                serverLevel.sendParticles(ParticleTypes.END_ROD, x, y, z, 10, 3, 3, 3, 0);
            }
            if (blazing) {
                monster.setSecondsOnFire(10);
                ProcedureHelper.addEffect(player, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0, false, false));
                if (serverLevel != null)
                    serverLevel.sendParticles(ParticleTypes.FLAME, x, y, z, 15, 3, 3, 3, 0);
            }
            if (shulker)
                ProcedureHelper.addEffect(monster, new MobEffectInstance(MobEffects.LEVITATION, 60, 1, false, false));
            if (withering) {
                ProcedureHelper.addEffect(monster, new MobEffectInstance(MobEffects.WITHER, 60, 1, false, false));
                if (serverLevel != null)
                    serverLevel.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 20, 3, 3, 3, 0);
            }
        }
        for (int i = 0; i < ORB_RING_PARTICLES; i++) {
            double angle = Math.PI * 2 / ORB_RING_PARTICLES * i;
            double px = x + 0.5 + Math.cos(angle) * ORB_RING_RADIUS;
            double pz = z + 0.5 + Math.sin(angle) * ORB_RING_RADIUS;
            level.levelEvent(2001, BlockPos.containing(px, y, pz), Block.getId(level.getBlockState(BlockPos.containing(px, y - 1, pz))));
        }
    }
}