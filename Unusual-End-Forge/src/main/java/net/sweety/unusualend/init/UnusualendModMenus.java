package net.sweety.unusualend.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.world.inventory.BolokNotesMenu;
import net.sweety.unusualend.world.inventory.BuildingInhibitorGUIMenu;
import net.sweety.unusualend.world.inventory.InfuserGUIMenu;
import net.sweety.unusualend.world.inventory.PurpurTankGUIMenu;

public class UnusualendModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, UnusualEnd.MODID);
	public static final RegistryObject<MenuType<PurpurTankGUIMenu>> PURPUR_TANK_GUI = REGISTRY.register("purpur_tank_gui", () -> IForgeMenuType.create(PurpurTankGUIMenu::new));
	public static final RegistryObject<MenuType<BolokNotesMenu>> BOLOK_NOTES = REGISTRY.register("bolok_notes", () -> IForgeMenuType.create(BolokNotesMenu::new));
	public static final RegistryObject<MenuType<BuildingInhibitorGUIMenu>> BUILDING_INHIBITOR_GUI = REGISTRY.register("building_inhibitor_gui", () -> IForgeMenuType.create(BuildingInhibitorGUIMenu::new));
	public static final RegistryObject<MenuType<InfuserGUIMenu>> INFUSER_GUI = REGISTRY.register("infuser_gui", () -> IForgeMenuType.create(InfuserGUIMenu::new));
}
