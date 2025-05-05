package net.mcreator.unusualend.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;
import net.mcreator.unusualend.init.UnusualendModEnchantments;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EnchantsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
        if (EnchantmentHelper.getTagEnchantmentLevel(UnusualendModEnchantments.BOLOKS_FURY.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
				if (entity instanceof LivingEntity && !damagesource.isIndirect()) {
					if (event instanceof LivingHurtEvent _hurt) {
						_hurt.setAmount((float) (amount + 0.5 + 2 * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(UnusualendModEnchantments.BOLOKS_FURY.get())));
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(UnusualendModParticleTypes.BOLOK_PARTICLE.get(), x, (y + 0.7 * entity.getBbHeight()), z, 30, 0.3, 0.5, 0.3, 0.5);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.PLAYER_HURT_DROWN, SoundSource.HOSTILE, (float) 0.3,
									(float) Mth.nextDouble(RandomSource.create(), 0.6, 1.2));
						} else {
							_level.playLocalSound(x, y, z, SoundEvents.PLAYER_HURT_DROWN, SoundSource.HOSTILE, (float) 0.3, (float) Mth.nextDouble(RandomSource.create(), 0.6, 1.2), false);
						}
					}
				}
			}
		}
	}
}
