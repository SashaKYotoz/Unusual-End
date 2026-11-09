package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.entity.EndstoneGolemEntity;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndSounds;

public class EndstoneGolemEntityDiesProcedure {
    public static void execute(EndstoneGolemEntity entity) {
        if (!(entity.level() instanceof ServerLevel level))
            return;
        Vec3 pos = entity.position();
        level.sendParticles(ParticleTypes.EXPLOSION, pos.x, pos.y, pos.z, 10, 1, 1, 1, 0);
        level.playSound(null, pos.x, pos.y, pos.z, SoundEvents.GENERIC_EXPLODE.value(), SoundSource.HOSTILE, 1f, 1f);
        strikeVisualLightning(level, pos);
        for (int i = 0; i < 5; i++) {
            UnusualEnd.queueServerWork(5 + level.random.nextInt(6), () -> {
                strikeVisualLightning(level, pos);
                level.playSound(null, pos.x, pos.y, pos.z, SoundEvents.GENERIC_EXPLODE.value(), SoundSource.HOSTILE, 1f, 1f);
            });
        }
        UnusualEnd.queueServerWork(15, () -> level.playSound(null, pos.x, pos.y, pos.z, UnusualEndSounds.ENDSTONE_GOLEM_DEATH.get(), SoundSource.HOSTILE, 2f, 1f));

        ItemEntity orb = dropProtected(level, pos, UnusualEndItems.GOLEM_ORB.get());
        orb.setGlowingTag(true);
        int shards = 2 + level.random.nextInt(3);
        for (int i = 0; i < shards; i++)
            dropProtected(level, pos, UnusualEndItems.ANCIENT_SHARD.get());
        if (level.random.nextFloat() < 0.3f)
            dropProtected(level, pos, UnusualEndItems.MUSIC_DISC_ENDSTONE_GOLEM_THEME.get());
        ExperienceOrb.award(level, pos, 5000);
    }

    private static void strikeVisualLightning(ServerLevel level, Vec3 pos) {
        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
        if (bolt == null)
            return;
        bolt.moveTo(pos.x, pos.y, pos.z);
        bolt.setVisualOnly(true);
        level.addFreshEntity(bolt);
    }

    private static ItemEntity dropProtected(ServerLevel level, Vec3 pos, ItemLike item) {
        ItemEntity drop = new ItemEntity(level, pos.x, pos.y, pos.z, new ItemStack(item));
        drop.setInvulnerable(true);
        drop.setUnlimitedLifetime();
        level.addFreshEntity(drop);
        return drop;
    }
}
