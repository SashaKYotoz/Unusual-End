package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.network.UnusualendModVariables;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class EnderlingClothRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		itemstack.shrink(1);
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.OFF_HAND, true);
		}
		{
			double _setval = 1200;
			entity.getCapability(UnusualendModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ScrapeOverlay = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		ParticleHelper.spawn(world, ParticleHelper.enderClothDust(), new Vec3(x, y, z).add(0, 1, 0), 40, 0.4, 0.5, 0.4, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 10, 0.5, 0.5, 0.5, 0);
		ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 1, false, false));
		ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualendModMobEffects.SPECTRAL_STRIDE.get(), 1200, 0, false, false));
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(UnusualendModItems.SPECTRAL_CLOTH.get(), 100);
		if (world instanceof Level _level)
			_level.getScoreboard().addPlayerTeam((entity.getStringUUID()));
		{
            PlayerTeam team = entity.level().getScoreboard().getPlayerTeam((entity.getStringUUID()));
			if (team != null) {
				if (entity instanceof Player _player)
					entity.level().getScoreboard().addPlayerToTeam(_player.getGameProfile().getName(), team);
				else
					entity.level().getScoreboard().addPlayerToTeam(entity.getStringUUID(), team);
			}
		}
		if (world.isClientSide()) {
			ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.burn")), SoundSource.PLAYERS, (float) 0.3, 1);
		}
	}
}
