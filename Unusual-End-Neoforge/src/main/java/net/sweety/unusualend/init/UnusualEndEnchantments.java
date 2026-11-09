package net.sweety.unusualend.init;

import net.minecraft.advancements.critereon.DamageSourcePredicate;
import net.minecraft.advancements.critereon.TagPredicate;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.DamageSourceCondition;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.datagen.tags.UnusualEndTags;
import net.sweety.unusualend.enchantment.BoloksWingsEnchantment;
import net.sweety.unusualend.enchantment.FullHealthCondition;

public class UnusualEndEnchantments {
    public static final ResourceKey<Enchantment> EVERLASTING = ResourceKey.create(Registries.ENCHANTMENT,
            UnusualEnd.makeUEID("everlasting"));
    public static final ResourceKey<Enchantment> BOLOKS_FURY = ResourceKey.create(Registries.ENCHANTMENT,
            UnusualEnd.makeUEID("boloks_fury"));
    public static final ResourceKey<Enchantment> BOLOKS_WINGS = ResourceKey.create(Registries.ENCHANTMENT,
            UnusualEnd.makeUEID("boloks_wings"));
    public static final ResourceKey<Enchantment> BOLOKS_HEAD = ResourceKey.create(Registries.ENCHANTMENT,
            UnusualEnd.makeUEID("boloks_head"));
    public static final ResourceKey<Enchantment> JOUST = ResourceKey.create(Registries.ENCHANTMENT,
            UnusualEnd.makeUEID("joust"));
    public static final ResourceKey<Enchantment> ARCANE_RECOVERY = ResourceKey.create(Registries.ENCHANTMENT,
            UnusualEnd.makeUEID("arcane_recovery"));
    public static final ResourceKey<Enchantment> BONDING = ResourceKey.create(Registries.ENCHANTMENT,
            UnusualEnd.makeUEID("bonding"));
    public static final ResourceKey<Enchantment> BENEVOLENCE = ResourceKey.create(Registries.ENCHANTMENT,
            UnusualEnd.makeUEID("benevolence"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);
        register(context, BOLOKS_FURY, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(UnusualEndTags.Items.BOLOK_ENCHANTABLE),
                        4,
                        3,
                        Enchantment.dynamicCost(3, 5),
                        Enchantment.dynamicCost(20, 5),
                        2,
                        EquipmentSlotGroup.MAINHAND))
                .withEffect(EnchantmentEffectComponents.DAMAGE, new AddValue(LevelBasedValue.perLevel(2.0F)),
                        FullHealthCondition.of(LootContext.EntityTarget.THIS)));
        register(context, BOLOKS_WINGS, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(UnusualEndTags.Items.ELYTRA_ENCHANTABLE),
                        4,
                        3,
                        Enchantment.dynamicCost(3, 5),
                        Enchantment.dynamicCost(20, 5),
                        2,
                        EquipmentSlotGroup.CHEST))
                .withEffect(EnchantmentEffectComponents.TICK, new BoloksWingsEnchantment()));
        register(context, BOLOKS_HEAD, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.HEAD_ARMOR_ENCHANTABLE),
                4,
                3,
                Enchantment.dynamicCost(3, 5),
                Enchantment.dynamicCost(20, 5),
                2,
                EquipmentSlotGroup.HEAD))
                .withEffect(EnchantmentEffectComponents.DAMAGE_PROTECTION, new AddValue(LevelBasedValue.perLevel(6.0F)), DamageSourceCondition.hasDamageSource(DamageSourcePredicate.Builder.damageType()
                        .tag(TagPredicate.is(DamageTypeTags.BYPASSES_ARMOR)).tag(TagPredicate.isNot(DamageTypeTags.BYPASSES_INVULNERABILITY)).tag(TagPredicate.isNot(DamageTypeTags.PANIC_CAUSES)))));
        register(context, EVERLASTING, Enchantment.enchantment(Enchantment.definition(
                        (items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE)),
                        (items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE)),
                        5,
                        1,
                        Enchantment.dynamicCost(3, 5),
                        Enchantment.dynamicCost(20, 5),
                        2))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.CURSE)));
        register(context, ARCANE_RECOVERY, Enchantment.enchantment(Enchantment.definition(
                        (items.getOrThrow(UnusualEndTags.Items.ARCANE_ENCHANTABLE)),
                        5,
                        3,
                        Enchantment.dynamicCost(3, 5),
                        Enchantment.dynamicCost(20, 5),
                        2))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.CURSE)));
        register(context, BONDING, Enchantment.enchantment(Enchantment.definition(
                        (items.getOrThrow(UnusualEndTags.Items.LEECHING_WAND_ENCHANTABLE)),
                        5,
                        1,
                        Enchantment.dynamicCost(18, 2),
                        Enchantment.dynamicCost(24, 4),
                        2,
                        EquipmentSlotGroup.HEAD))
                .exclusiveWith(HolderSet.direct(enchantments.getOrThrow(BENEVOLENCE))));
        register(context, BENEVOLENCE, Enchantment.enchantment(Enchantment.definition(
                        (items.getOrThrow(UnusualEndTags.Items.LEECHING_WAND_ENCHANTABLE)),
                        4,
                        1,
                        Enchantment.dynamicCost(32, 2),
                        Enchantment.dynamicCost(40, 4),
                        2))
                .exclusiveWith(HolderSet.direct(enchantments.getOrThrow(BONDING))));
        register(context, JOUST, Enchantment.enchantment(Enchantment.definition(
                        (items.getOrThrow(UnusualEndTags.Items.SPEAR_ENCHANTABLE)),
                        5,
                        2,
                        Enchantment.dynamicCost(2, 2),
                        Enchantment.dynamicCost(10, 4),
                        2,
                        EquipmentSlotGroup.MAINHAND)));
    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key,
                                 Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }
}