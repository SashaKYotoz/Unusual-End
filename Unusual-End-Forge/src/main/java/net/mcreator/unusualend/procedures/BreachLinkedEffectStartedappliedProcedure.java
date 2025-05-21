package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.unusualend.init.UnusualendModMobEffects;

public class BreachLinkedEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == Level.OVERWORLD || (entity.level().dimension()) == Level.NETHER || (entity.level().dimension()) == Level.END) {
			entity.getPersistentData().putDouble("BreachX", x);
			entity.getPersistentData().putDouble("BreachY", y);
			entity.getPersistentData().putDouble("BreachZ", z);
			entity.getPersistentData().putBoolean("isBreached", true);
			entity.getPersistentData().putString("BreachW", ("" + (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))));
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("text.unusualend.cant_open_breach").getString())), true);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(UnusualendModMobEffects.BREACH_LINKED.get());
		}
	}
}
