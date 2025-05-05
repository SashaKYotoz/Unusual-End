package net.mcreator.unusualend.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.unusualend.init.UnusualendModItems;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class AttributesModifiersProcedure {
    @SubscribeEvent
    public static void addAttributeModifier(ItemAttributeModifierEvent event) {
        execute(event, event.getItemStack());
    }

    private static void execute(ItemAttributeModifierEvent event, ItemStack itemstack) {
        AttributeModifier modifier;
        if (itemstack.getMaxStackSize() == 1) {
            if (event.getSlotType() == EquipmentSlot.FEET && itemstack.getItem() == UnusualendModItems.WARPED_BOOTS.get()) {
                modifier = new AttributeModifier(UUID.fromString("f654bc63-b67e-40ee-b11c-2d8abaab9f3e"), "unusualend.BolokBootsBoost", 0.5D, Operation.MULTIPLY_BASE);
                event.addModifier(NeoForgeMod.SWIM_SPEED.value(), modifier);
            }
            if (event.getSlotType() == EquipmentSlot.MAINHAND && itemstack.getItem() == UnusualendModItems.BOUNCY_DAGGER.get()) {
                modifier = new AttributeModifier(UUID.fromString("94fe2560-d356-4499-110c-94c8bb6c1bb2"), "unusualend.ReachDaggerDebuff", -0.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.ENTITY_REACH.value(), modifier);
                modifier = new AttributeModifier(UUID.fromString("94fe2560-d376-4499-110c-64c8bb6c1bb3"), "unusualend.BouncyDagger", 2.0D, Operation.ADDITION);
                event.addModifier(Attributes.ATTACK_KNOCKBACK, modifier);
            }
            if (event.getSlotType() == EquipmentSlot.MAINHAND && itemstack.getItem() == UnusualendModItems.WARPED_SPEAR.get()) {
                modifier = new AttributeModifier(UUID.fromString("33fe2130-d356-4749-110c-94c8bb6c1bb8"), "unusualend.ReachSpearBuff", 2.0D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.ENTITY_REACH.value(), modifier);
            }
            if (event.getSlotType() == EquipmentSlot.CHEST && itemstack.getItem() == UnusualendModItems.WARPED_CHESTPLATE.get()) {
                modifier = new AttributeModifier(UUID.fromString("34fe2560-d356-4799-110c-99c8bb6c1bb2"), "unusualend.SlowDebuff", -0.05D, Operation.MULTIPLY_BASE);
                event.addModifier(Attributes.MOVEMENT_SPEED, modifier);
            }
            if (event.getSlotType() == EquipmentSlot.MAINHAND && itemstack.getItem() == UnusualendModItems.PEARLESCENT_SWORD.get()) {
                modifier = new AttributeModifier(UUID.fromString("574188c2-554a-11ee-8c99-0242ac120002"), "unusualend.ReachSpectralBuff", 0.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.ENTITY_REACH.value(), modifier);
                modifier = new AttributeModifier(UUID.fromString("e5c352ec-554a-11ee-8c99-0242ac120002"), "unusualend.ReachSpectralBuff", 1.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.BLOCK_REACH.value(), modifier);
            }
            if (event.getSlotType() == EquipmentSlot.MAINHAND && itemstack.getItem() == UnusualendModItems.PEARLESCENT_AXE.get()) {
                modifier = new AttributeModifier(UUID.fromString("674188c2-554a-11ee-8c99-0242ac120002"), "unusualend.ReachSpectralBuff", 0.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.ENTITY_REACH.value(), modifier);
                modifier = new AttributeModifier(UUID.fromString("65c352ec-554a-11ee-8c99-0242ac120002"), "unusualend.ReachSpectralBuff", 1.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.BLOCK_REACH.value(), modifier);
            }
            if (event.getSlotType() == EquipmentSlot.MAINHAND && itemstack.getItem() == UnusualendModItems.PEARLESCENT_PICKAXE.get()) {
                modifier = new AttributeModifier(UUID.fromString("584188c2-554a-11ee-8c99-0242ac120002"), "unusualend.ReachSpectralBuff", 0.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.ENTITY_REACH.value(), modifier);
                modifier = new AttributeModifier(UUID.fromString("e5c952ec-554a-11ee-8c99-0242ac120002"), "unusualend.ReachSpectralBuff", 1.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.BLOCK_REACH.value(), modifier);
            }
            if (event.getSlotType() == EquipmentSlot.MAINHAND && itemstack.getItem() == UnusualendModItems.PEARLESCENT_HOE.get()) {
                modifier = new AttributeModifier(UUID.fromString("574108c2-554a-11ee-8c99-0242ac120002"), "unusualend.ReachSpectralBuff", 0.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.ENTITY_REACH.value(), modifier);
                modifier = new AttributeModifier(UUID.fromString("e5c352fc-554a-11ee-8c99-0242ac120002"), "unusualend.ReachSpectralBuff", 1.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.BLOCK_REACH.value(), modifier);
            }
            if (event.getSlotType() == EquipmentSlot.MAINHAND && itemstack.getItem() == UnusualendModItems.PEARLESCENT_SHOVEL.get()) {
                modifier = new AttributeModifier(UUID.fromString("573188c2-554a-11ee-8c99-0242ac120002"), "unusualend.ReachSpectralBuff", 0.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.ENTITY_REACH.value(), modifier);
                modifier = new AttributeModifier(UUID.fromString("e5c352ec-554a-11fe-8c99-0242ac120002"), "unusualend.ReachSpectralBuff", 1.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.BLOCK_REACH.value(), modifier);
            }
            if (event.getSlotType() == EquipmentSlot.MAINHAND && itemstack.getItem() == UnusualendModItems.ANCIENT_SWORD.get()) {
                modifier = new AttributeModifier(UUID.fromString("573188c2-554a-11ee-8c99-0242ac128802"), "unusualend.ReachAncientBuff", 0.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.ENTITY_REACH.value(), modifier);
            }
            if (event.getSlotType() == EquipmentSlot.OFFHAND && itemstack.getItem() == UnusualendModItems.CITRINE_AMULET.get()) {
                modifier = new AttributeModifier(UUID.fromString("584182c5-332a-12ee-8c99-0242ac128802"), "unusualend.ExtraLuck", 1.0D, Operation.ADDITION);
                event.addModifier(Attributes.LUCK, modifier);
            }
            if (event.getSlotType() == EquipmentSlot.CHEST && itemstack.getItem() == UnusualendModItems.SCALE_HORSE_ARMOR.get()) {
                modifier = new AttributeModifier(UUID.fromString("784142c5-312a-12ee-8c49-0242ac128802"), "unusualend.HorseWaterBuff", 2.0D, Operation.MULTIPLY_BASE);
                event.addModifier(NeoForgeMod.SWIM_SPEED.value(), modifier);
                modifier = new AttributeModifier(UUID.fromString("704142c5-312a-12ee-8c49-0242ac125502"), "unusualend.HorseBuff", 1.0D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.STEP_HEIGHT.value(), modifier);
            }
            if (event.getSlotType() == EquipmentSlot.MAINHAND && itemstack.getItem() == UnusualendModItems.WARPED_ANCHOR.get()) {
                modifier = new AttributeModifier(UUID.fromString("0c948739-fac0-431d-854c-9ed62408760d"), "unusualend.AnchorDebuff", -0.5D, Operation.ADDITION);
                event.addModifier(NeoForgeMod.ENTITY_REACH.value(), modifier);
            }
        }
    }
}
