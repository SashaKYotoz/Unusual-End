package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.entity.EndstoneGolemEntity;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.Comparator;
import java.util.List;

public class GolemAltarOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.DRAGON_BREATH) {
			if (!(ProcedureHelper.isCreative(entity))) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y + 1), (z + 0.5), 10, 0, 0, 0, 0.1);
			UnusualEnd.queueServerWork(10, () -> {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
				UnusualEnd.queueServerWork(20, () -> {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y + 1), (z + 0.5), 5, 0, 0, 0, 0.1);
					UnusualEnd.queueServerWork(5, () -> {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						EndstoneGolemBreakSurroundingsProcedure.execute(world, x, y - 1, z);
						UnusualEnd.queueServerWork(10, () -> {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.EXPLOSION, (x + 0.5), y, (z + 0.5), 10, 0.5, 0.5, 0.5, 0);
							UnusualEnd.queueServerWork(10, () -> {
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x + 0.5, y, z + 0.5)));
									entityToSpawn.setVisualOnly(true);
									_level.addFreshEntity(entityToSpawn);
								}
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof Player) {
											ProcedureHelper.awardAdvancement(entityiterator, "use_golem_altar");
											if (entityiterator instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.translatable("text.unusualend.golem_theme"), true);
										}
									}
								}
								ProcedureHelper.playSound(world, x + 0.5, y, z + 0.5, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.place")), SoundSource.NEUTRAL, 1, 1);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = UnusualendModEntities.ENDSTONE_GOLEM.get().spawn(_level, BlockPos.containing(x + 0.5, y - 1, z + 0.5), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								if ((((Entity) world.getEntitiesOfClass(EndstoneGolemEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y - 1), (z + 0.5)), 16, 16, 16), e -> true).stream().sorted(ProcedureHelper.byDistanceTo((x + 0.5), (y - 1), (z + 0.5))).findFirst().orElse(null)).level().dimension()) == Level.END) {
									((Entity) world.getEntitiesOfClass(EndstoneGolemEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y - 1), (z + 0.5)), 16, 16, 16), e -> true).stream().sorted(ProcedureHelper.byDistanceTo((x + 0.5), (y - 1), (z + 0.5))).findFirst().orElse(null)).getPersistentData().putDouble("x", x);
									((Entity) world.getEntitiesOfClass(EndstoneGolemEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y - 1), (z + 0.5)), 16, 16, 16), e -> true).stream().sorted(ProcedureHelper.byDistanceTo((x + 0.5), (y - 1), (z + 0.5))).findFirst().orElse(null)).getPersistentData().putDouble("y", y);
									((Entity) world.getEntitiesOfClass(EndstoneGolemEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y - 1), (z + 0.5)), 16, 16, 16), e -> true).stream().sorted(ProcedureHelper.byDistanceTo((x + 0.5), (y - 1), (z + 0.5))).findFirst().orElse(null)).getPersistentData().putDouble("z", z);
								}
								ParticleHelper.spawn(world, ParticleHelper.block(UnusualendModBlocks.RAW_PURPUR_BLOCK.get()), (x + 0.5), y, (z + 0.5), 100, 1, 2, 1, 0.1, true);
								ParticleHelper.spawn(world, ParticleHelper.block(Blocks.END_STONE_BRICKS), (x + 0.5), y, (z + 0.5), 100, 1, 2, 1, 0.1, true);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.EXPLOSION, (x + 0.5), (y + 1), (z + 0.5), 10, 0.5, 1, 0.5, 0);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.DRAGON_BREATH, (x + 0.5), y, (z + 0.5), 40, 0.8, 0.8, 0.8, 0.3);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), y, (z + 0.5), 40, 0.8, 0.8, 0.8, 0.3);
							});
						});
					});
				});
			});
		}
	}
}
