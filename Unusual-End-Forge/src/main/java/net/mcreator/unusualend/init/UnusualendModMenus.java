
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.unusualend.world.inventory.PurpurTankGUIMenu;
import net.mcreator.unusualend.world.inventory.InfuserGUIMenu;
import net.mcreator.unusualend.world.inventory.BuildingInhibitorGUIMenu;
import net.mcreator.unusualend.world.inventory.BolokNotesMenu;
import net.mcreator.unusualend.UnusualendMod;

public class UnusualendModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, UnusualendMod.MODID);
	public static final RegistryObject<MenuType<PurpurTankGUIMenu>> PURPUR_TANK_GUI = REGISTRY.register("purpur_tank_gui", () -> IForgeMenuType.create(PurpurTankGUIMenu::new));
	public static final RegistryObject<MenuType<BolokNotesMenu>> BOLOK_NOTES = REGISTRY.register("bolok_notes", () -> IForgeMenuType.create(BolokNotesMenu::new));
	public static final RegistryObject<MenuType<BuildingInhibitorGUIMenu>> BUILDING_INHIBITOR_GUI = REGISTRY.register("building_inhibitor_gui", () -> IForgeMenuType.create(BuildingInhibitorGUIMenu::new));
	public static final RegistryObject<MenuType<InfuserGUIMenu>> INFUSER_GUI = REGISTRY.register("infuser_gui", () -> IForgeMenuType.create(InfuserGUIMenu::new));
}
