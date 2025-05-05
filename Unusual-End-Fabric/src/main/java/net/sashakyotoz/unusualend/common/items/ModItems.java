package net.sashakyotoz.unusualend.common.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.ItemTags;
import net.sashakyotoz.unusualend.UnusualEnd;
import net.sashakyotoz.unusualend.common.ModRegistry;
import net.sashakyotoz.unusualend.common.items.custom.CustomSmithingTemplateItem;
import net.sashakyotoz.unusualend.common.items.custom.FloatingPouchItem;
import net.sashakyotoz.unusualend.common.items.custom.ModArmorItem;
import net.sashakyotoz.unusualend.common.items.custom.SpectralClothItem;

public class ModItems {
    public static void register() {
        UnusualEnd.log("Registering Items for modid : " + UnusualEnd.MOD_ID);
    }
    public static final Item PEARLESCENT_INGOT = ModRegistry.ofItem("pearlescent_ingot",
            new Item(new FabricItemSettings())).model(Models.GENERATED).build();
    public static final Item PEARLESCENT_UPGRADE_SMITHING_TEMPLATE = ModRegistry.ofItem("pearlescent_upgrade_smithing_template",
            new CustomSmithingTemplateItem(new FabricItemSettings())).model(Models.GENERATED).build();
    public static final Item PEARLESCENT_SWORD = ModRegistry.ofItem("pearlescent_sword",
            new SwordItem(ModTiers.PEARLESCENT,3,-2.7f,new FabricItemSettings())).model(Models.HANDHELD).tag(ItemTags.SWORDS).build();
    public static final Item PEARLESCENT_PICKAXE = ModRegistry.ofItem("pearlescent_pickaxe",
            new SwordItem(ModTiers.PEARLESCENT,1,-2.8f,new FabricItemSettings())).model(Models.HANDHELD).tag(ItemTags.PICKAXES).build();
    public static final Item PEARLESCENT_AXE = ModRegistry.ofItem("pearlescent_axe",
            new SwordItem(ModTiers.PEARLESCENT,5, -3f,new FabricItemSettings())).model(Models.HANDHELD).tag(ItemTags.AXES).build();
    public static final Item PEARLESCENT_SHOVEL = ModRegistry.ofItem("pearlescent_shovel",
            new SwordItem(ModTiers.PEARLESCENT,1,-3f,new FabricItemSettings())).model(Models.HANDHELD).tag(ItemTags.SHOVELS).build();
    public static final Item PEARLESCENT_HOE = ModRegistry.ofItem("pearlescent_hoe",
            new SwordItem(ModTiers.PEARLESCENT,0, -3f,new FabricItemSettings())).model(Models.HANDHELD).tag(ItemTags.HOES).build();
    public static final Item SPECTRAL_SCRAP = ModRegistry.ofItem("spectral_scrap",
            new Item(new FabricItemSettings())).model(Models.GENERATED).build();
    public static final Item SPECTRAL_CLOTH = ModRegistry.ofItem("spectral_cloth",
            new SpectralClothItem(new FabricItemSettings().maxCount(16))).model(Models.GENERATED).build();
    public static final Item FLOATING_POUCH = ModRegistry.ofItem("floating_pouch",
            new FloatingPouchItem(new FabricItemSettings().maxCount(1).maxDamage(384))).model(Models.GENERATED).build();
    public static final Item SPECTRAL_LEGGINGS = ModRegistry.ofItem("spectral_leggings",
            new ModArmorItem(ModArmorMaterials.SPECTRAL_SCRAP, ArmorItem.Type.LEGGINGS,new FabricItemSettings())).build();
}