package net.mcreator.unusualend.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.unusualend.init.UnusualendModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PearlescentRingTriggerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity sourceentity) {
		execute(null, world, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		double dividedby = 0;
		boolean wasRingUsed = false;
		if (ModList.get().isLoaded("curios")) {
			if (sourceentity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(UnusualendModItems.PEARLESCENT_RING.get(), lv).isPresent() : false) {
				sourceentity.getPersistentData().putBoolean("wasRingUsed", false);
				if (sourceentity instanceof LivingEntity lv) {
					CuriosApi.getCuriosHelper().findCurios(lv, UnusualendModItems.PEARLESCENT_RING.get()).forEach(item -> {
						ItemStack itemstackiterator = item.stack();
						if (!((sourceentity instanceof Player _plrCldRem3 ? _plrCldRem3.getCooldowns().getCooldownPercent(UnusualendModItems.PEARLESCENT_RING.get(), 0f) * 100 : 0) > 0)) {
							if (itemstackiterator.getOrCreateTag().getDouble("ringCooldown") >= 400) {
								sourceentity.getPersistentData().putBoolean("wasRingUsed", true);
								if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("unusualend:enderling_mask")))) {
								}
								itemstackiterator.getOrCreateTag().putDouble("ringCooldown", 0);
								if (sourceentity instanceof Player _player)
									_player.getCooldowns().addCooldown(UnusualendModItems.PEARLESCENT_RING.get(), 10);
							}
						}
					});
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.PEARLESCENT_RING.get()) {
			if (!((sourceentity instanceof Player _plrCldRem15 ? _plrCldRem15.getCooldowns().getCooldownPercent(UnusualendModItems.PEARLESCENT_RING.get(), 0f) * 100 : 0) > 0)) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("ringCooldown") >= 400) {
					if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("unusualend:enderling_mask")))) {
					}
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("ringCooldown", 0);
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(UnusualendModItems.PEARLESCENT_RING.get(), 10);
				}
			}
		}
	}
}
