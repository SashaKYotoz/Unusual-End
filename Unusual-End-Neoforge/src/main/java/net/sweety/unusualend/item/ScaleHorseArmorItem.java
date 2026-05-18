
package net.sweety.unusualend.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.sweety.unusualend.init.UnusualEndItems;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ScaleHorseArmorItem extends AnimalArmorItem {
    public static final Holder<ArmorMaterial> BOLOK = register(Util.make(new EnumMap<>(Type.class), (o) ->
    {
        o.put(Type.BOOTS, 3);
        o.put(Type.LEGGINGS, 6);
        o.put(Type.CHESTPLATE, 8);
        o.put(Type.HELMET, 3);
        o.put(Type.BODY, 11);
    }), () -> Ingredient.of(UnusualEndItems.BOLOK_SCALE.get()));

    public ScaleHorseArmorItem() {
        super(BOLOK, BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    private static Holder<ArmorMaterial> register(EnumMap<Type, Integer> defense, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace("scale")));
        return register(defense, repairIngredient, list);
    }

    private static Holder<ArmorMaterial> register(EnumMap<Type, Integer> defense, Supplier<Ingredient> repairIngridient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type armoritem$type : Type.values()) enummap.put(armoritem$type, defense.get(armoritem$type));

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.withDefaultNamespace("scale"), new ArmorMaterial(enummap, 10, SoundEvents.ARMOR_EQUIP_WOLF, repairIngridient, layers, (float) 0.0, (float) 0.0));
    }
}