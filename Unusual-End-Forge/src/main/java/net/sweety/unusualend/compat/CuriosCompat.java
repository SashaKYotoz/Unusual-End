package net.sweety.unusualend.compat;

import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

public final class CuriosCompat {
	public static void enqueueSlotTypes() {
		for (SlotTypePreset preset : new SlotTypePreset[]{SlotTypePreset.RING, SlotTypePreset.NECKLACE, SlotTypePreset.BRACELET, SlotTypePreset.CHARM})
			InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> preset.getMessageBuilder().build());
	}
}