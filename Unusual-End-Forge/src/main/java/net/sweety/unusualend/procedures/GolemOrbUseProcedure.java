package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;

@Mod.EventBusSubscriber
public class GolemOrbUseProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	private static void execute(@Nullable Event event, LevelAccessor level, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
        if (entity instanceof Player player) {
            if (player.getInventory().contains(new ItemStack(UnusualendModItems.GOLEM_ORB.get()))
                    || player.getInventory().contains(new ItemStack(UnusualendModItems.BLAZING_ORB.get()))
                    || player.getInventory().contains(new ItemStack(UnusualendModItems.SHULKER_ORB.get()))
                    || player.getInventory().contains(new ItemStack(UnusualendModItems.WITHERING_ORB.get()))) {
				if (Math.random() < Config.ORB_TRIGGER.get() / 100) {
					ProcedureHelper.playSound(level, x, y, z, SoundEvents.ZOMBIE_ATTACK_WOODEN_DOOR, SoundSource.PLAYERS, 1, (float) 0.1);
					level.levelEvent(2001, new BlockPos(x, y - 1, z), Block.getId((level.getBlockState(new BlockPos(x, y - 1, z)))));
					{
                        final Vec3 center = new Vec3(x, y, z);
                        List<Entity> entityList = level.getEntitiesOfClass(Entity.class, new AABB(center, center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(center))).toList();
                        for (Entity iterator : entityList) {
							if (iterator instanceof Monster) {
								iterator.hurt(DamageSource.GENERIC, 8);
								ProcedureHelper.addEffect(iterator, new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
								ProcedureHelper.addEffect(iterator, new MobEffectInstance(UnusualendModMobEffects.HEAVINESS.get(), 60, 1, false, false));
								if (level instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.POOF, x, y, z, 10, 3, 3, 3, 0);
								if (level instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 10, 3, 3, 3, 0);
                                if (player.getInventory().contains(new ItemStack(UnusualendModItems.BLAZING_ORB.get()))) {
                                    iterator.setSecondsOnFire(10);
                                    ProcedureHelper.addEffect(player, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0, false, false));
                                    if (level instanceof ServerLevel _level)
                                        _level.sendParticles(ParticleTypes.FLAME, x, y, z, 15, 3, 3, 3, 0);
                                }
                                if (player.getInventory().contains(new ItemStack(UnusualendModItems.SHULKER_ORB.get()))) {
                                    ProcedureHelper.addEffect(iterator, new MobEffectInstance(MobEffects.LEVITATION, 60, 1, false, false));
                                }
                                if (player.getInventory().contains(new ItemStack(UnusualendModItems.WITHERING_ORB.get()))) {
                                    ProcedureHelper.addEffect(iterator, new MobEffectInstance(MobEffects.WITHER, 60, 1, false, false));
                                    if (level instanceof ServerLevel _level)
                                        _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 20, 3, 3, 3, 0);
                                }
							}
						}
					}
					loop = 0;
					particleAmount = 20;
					xRadius = 3;
					zRadius = 3;
					while (loop < particleAmount) {
						level.levelEvent(2001, new BlockPos(x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius, y, z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius),
								Block.getId((level.getBlockState(new BlockPos(x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius, y - 1, z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius)))));
						loop = loop + 1;
					}
				}
			}
		}
	}
}