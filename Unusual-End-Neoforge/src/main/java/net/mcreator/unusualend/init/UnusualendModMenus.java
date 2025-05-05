package net.mcreator.unusualend.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;

import net.mcreator.unusualend.world.inventory.PurpurTankGUIMenu;
import net.mcreator.unusualend.world.inventory.InfuserGUIMenu;
import net.mcreator.unusualend.world.inventory.BuildingInhibitorGUIMenu;
import net.mcreator.unusualend.world.inventory.BolokNotesMenu;
import net.mcreator.unusualend.UnusualendMod;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UnusualendModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.MENU, UnusualendMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<PurpurTankGUIMenu>> PURPUR_TANK_GUI = REGISTRY.register("purpur_tank_gui", () -> IMenuTypeExtension.create(PurpurTankGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BolokNotesMenu>> BOLOK_NOTES = REGISTRY.register("bolok_notes", () -> IMenuTypeExtension.create(BolokNotesMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BuildingInhibitorGUIMenu>> BUILDING_INHIBITOR_GUI = REGISTRY.register("building_inhibitor_gui", () -> IMenuTypeExtension.create(BuildingInhibitorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<InfuserGUIMenu>> INFUSER_GUI = REGISTRY.register("infuser_gui", () -> IMenuTypeExtension.create(InfuserGUIMenu::new));
}