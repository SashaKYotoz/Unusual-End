package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.mcreator.unusualend.entity.EnderblobEntity;

public class EnderInfectionOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double X = 0;
		double Y = 0;
		double Z = 0;
		if (entity instanceof EnderblobEntity || entity instanceof Endermite) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(UnusualendModMobEffects.ENDER_INFECTION.get());
		}
		if (Math.random() < 0.5) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getYRot() + 0.1));
				_ent.setXRot(entity.getXRot());
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		} else {
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getYRot() - 0.1));
				_ent.setXRot(entity.getXRot());
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		}
		if (Math.random() < 0.5) {
			{
				Entity _ent = entity;
				_ent.setYRot(entity.getYRot());
				_ent.setXRot((float) (entity.getXRot() + 0.1));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		} else {
			{
				Entity _ent = entity;
				_ent.setYRot(entity.getYRot());
				_ent.setXRot((float) (entity.getXRot() - 0.1));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		}
		if (Math.random() < 0.005) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("unusualend:infection_damages")))), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.endermite.hurt")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.endermite.hurt")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 20, 0.5, 0.5, 0.5, 0);
		}
		if (Math.random() < 0.005) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, y, z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.endermite.hurt")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.endermite.hurt")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index0 = 0; index0 < 100; index0++) {
				X = x + Mth.nextInt(RandomSource.create(), -3, 3);
				Y = y + Mth.nextInt(RandomSource.create(), -2, 2);
				Z = z + Mth.nextInt(RandomSource.create(), -3, 3);
				if ((world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.VOID_AIR
						|| (world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.AIR) {
					if (world.getBlockState(BlockPos.containing(X, Y - 1, Z)).canOcclude()) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.PORTAL, X, Y, Z, 30, 0.5, 1.5, 0.5, 0);
						{
							Entity _ent = entity;
							_ent.teleportTo(X, Y, Z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(X, Y, Z, _ent.getYRot(), _ent.getXRot());
						}
						break;
					}
				}
			}
		}
		if (entity instanceof EnderMan) {
			if (entity instanceof Mob) {
				try {
					((Mob) entity).setTarget(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
