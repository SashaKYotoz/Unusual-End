package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.init.UnusualendModBlocks;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CrystalCatalystRightclickedOnBlockProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.CRYSTAL_CATALYST.get()) {
			if (entity.isShiftKeyDown()) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BEACON) {
					ProcedureHelper.awardAdvancement(entity, "obtain_catalyst");
					if (!(entity instanceof Player _player ? _player.getCooldowns().isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) : false)) {
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 10);
					}
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Catalyser", 1);
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("buff", (Component.translatable("text.unusualend.catalyst_description_beacon").getString()));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.CRYSTAL_CATALYST.get()) {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.OFF_HAND, true);
					}
					ProcedureHelper.playSound(world, x, y, z, SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS, 1, 1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 0.5), (z + 0.5), 15, 0.4, 0.4, 0.4, 0);
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CONDUIT) {
					ProcedureHelper.awardAdvancement(entity, "obtain_catalyst");
					if (!(entity instanceof Player _player ? _player.getCooldowns().isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) : false)) {
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 10);
					}
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Catalyser", 2);
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.CRYSTAL_CATALYST.get()) {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.OFF_HAND, true);
					}
					ProcedureHelper.playSound(world, x, y, z, SoundEvents.CONDUIT_ACTIVATE, SoundSource.BLOCKS, 1, 1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SPLASH, (x + 0.5), (y + 0.5), (z + 0.5), 15, 0.4, 0.4, 0.4, 1);
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("buff", (Component.translatable("text.unusualend.catalyst_description_conduit").getString()));
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualendModBlocks.PEARLESCENT_INFUSER.get()) {
					if (!(entity instanceof Player _player ? _player.getCooldowns().isOnCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) : false)) {
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 10);
					}
					ProcedureHelper.awardAdvancement(entity, "obtain_catalyst");
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Catalyser", 3);
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.CRYSTAL_CATALYST.get()) {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.OFF_HAND, true);
					}
					ProcedureHelper.playSound(world, x, y, z, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1, (float) 0.5);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WITCH, (x + 0.5), (y + 0.5), (z + 0.5), 15, 0.4, 0.4, 0.4, 1);
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("buff", (Component.translatable("text.unusualend.catalyst_description_infuser").getString()));
				}
			}
		}
	}
}
