package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class FireflyEggRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		itemstack.shrink(1);
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(UnusualendModItems.ENDER_FIREFLY_EGG.get(), 5);
		if (world.isClientSide()) {
			ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.egg_break")), SoundSource.PLAYERS, (float) 0.5, (float) 1.3);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.ENDER_FIREFLY_EGG.get()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.OFF_HAND, true);
		}
		if (Math.random() < 0.4) {
			if (world instanceof ServerLevel _level)
				ProcedureHelper.spawnEnderFirefly(_level, x + 0.5, y + 1, z + 0.5, -24000, null);
			ParticleHelper.spawn(world, ParticleHelper.item(UnusualendModItems.ENDER_FIREFLY_EGG.get()), (x + 0.5), (y + 1), (z + 0.5), 15, 0.2, 0.2, 0.2, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 1), (z + 0.5), 5, 0.5, 0.5, 0.5, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.DRAGON_BREATH, (x + 0.5), (y + 1), (z + 0.5), 5, 0.5, 0.5, 0.5, 0);
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mangrove_swamp")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("swamp"))) {
				ProcedureHelper.awardAdvancement(entity, "firefly_in_swamp");
			}
		} else {
			ParticleHelper.spawn(world, ParticleHelper.item(UnusualendModItems.ENDER_FIREFLY_EGG.get()), (x + 0.5), (y + 1), (z + 0.5), 25, 0.2, 0.2, 0.2, 0);
		}
	}
}
