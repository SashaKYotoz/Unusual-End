package net.sweety.unusualend.compat;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("removal")
public final class CuriosCompat {

    public static void enqueueSlotTypes() {
        for (SlotTypePreset preset : new SlotTypePreset[]{SlotTypePreset.RING, SlotTypePreset.NECKLACE, SlotTypePreset.BRACELET, SlotTypePreset.CHARM})
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> preset.getMessageBuilder().build());
    }
    public static ItemStack findFirst(LivingEntity entity, Item item, Predicate<ItemStack> filter) {
        for (SlotResult result : CuriosApi.getCuriosHelper().findCurios(entity, item)) {
            if (filter.test(result.stack()))
                return result.stack();
        }
        return ItemStack.EMPTY;
    }
    public static void forEach(LivingEntity entity, Item item, Consumer<ItemStack> action) {
        for (SlotResult result : CuriosApi.getCuriosHelper().findCurios(entity, item))
            action.accept(result.stack());
    }
}