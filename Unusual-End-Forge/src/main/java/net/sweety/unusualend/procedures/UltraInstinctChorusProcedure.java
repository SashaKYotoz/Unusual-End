package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UltraInstinctChorusProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getAmount());
		}
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		double X = 0;
		double Y = 0;
		double Z = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == UnusualendModItems.CHORUS_HELMET.get()) {
			if (!entity.isShiftKeyDown()) {
				if (Math.random() < (double) Config.CHORUS_HELMET_PROBABILITY_TO_TELEPORT.get() / 100) {
					for (int index0 = 0; index0 < 1000; index0++) {
						X = x + Mth.nextInt(world.getRandom(), -5, 5);
						Y = y + Mth.nextInt(world.getRandom(), -2, 2);
						Z = z + Mth.nextInt(world.getRandom(), -5, 5);
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
								ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1);
								if (amount <= (double) Config.MAX_DAMAGE_CHORUS_HELMET_CAN_DODGE_WITH_TP_.get()) {
									if (event != null && event.isCancelable()) {
										event.setCanceled(true);
									}
									ProcedureHelper.awardAdvancement(entity, "use_chorus_helmet");
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
