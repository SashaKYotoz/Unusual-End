package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.configuration.UEConfig;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;

@Mod.EventBusSubscriber
public class UltraInstinctChorusProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getAmount());
		}
	}

	private static void execute(LivingHurtEvent event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		double X;
		double Y;
		double Z;
        if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == UnusualendModItems.CHORUS_HELMET.get()) {
			if (!entity.isShiftKeyDown()) {
				if (Math.random() < UEConfig.CHORUS_HELMET_PROBABILITY_TO_TELEPORT.get() / 100) {
					for (int index0 = 0; index0 < 1000; index0++) {
						X = x + Mth.nextInt(RandomSource.create(), -5, 5);
						Y = y + Mth.nextInt(RandomSource.create(), -2, 2);
						Z = z + Mth.nextInt(RandomSource.create(), -5, 5);
						if ((world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.VOID_AIR
								|| (world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.AIR) {
							if (world.getBlockState(BlockPos.containing(X, Y - 1, Z)).canOcclude()) {
								{
									Entity _ent = entity;
									_ent.teleportTo(X, Y, Z);
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(X, Y, Z, _ent.getYRot(), _ent.getXRot());
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.PORTAL, X, Y, Z, 30, 0.5, 1.5, 0.5, 0);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1, 1, false);
									}
								}
								if (amount <= UEConfig.MAX_DAMAGE_CHORUS_HELMET_CAN_DODGE_WITH_TP_.get()) {
									if (event != null) {
										event.setCanceled(true);
									}
									if (!(entity instanceof ServerPlayer _plr18 && _plr18.level() instanceof ServerLevel
											&& _plr18.getAdvancements().getOrStartProgress(_plr18.server.getAdvancements().get(UnusualEnd.makeUEID("use_chorus_helmet"))).isDone())) {
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(UnusualEnd.makeUEID("use_chorus_helmet"));
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
								}
								break;
							}
						}
					}
				}
			}
		}
	}
}
