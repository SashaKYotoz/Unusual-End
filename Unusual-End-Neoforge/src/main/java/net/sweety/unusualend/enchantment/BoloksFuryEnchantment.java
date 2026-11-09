package net.sweety.unusualend.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.init.UnusualEndMiscRegister;

public record BoloksFuryEnchantment() implements EnchantmentEntityEffect {
    public static final MapCodec<BoloksFuryEnchantment> CODEC = MapCodec.unit(BoloksFuryEnchantment::new);

    @Override
    public void apply(ServerLevel serverLevel, int level, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        if (level > 0)
            playFuryEffects(serverLevel, entity);
    }

    public static void playFuryEffects(ServerLevel level, Entity entity) {
        level.sendParticles(UnusualEndMiscRegister.BOLOK_PARTICLE.get(), entity.getX(), entity.getY() + 0.7f * entity.getBbHeight(), entity.getZ(), 30, 0.3, 0.5, 0.3, 0.5);
        level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.PLAYER_HURT_DROWN, SoundSource.HOSTILE, 0.3f, 0.6f + level.random.nextFloat() * 0.6f);
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
