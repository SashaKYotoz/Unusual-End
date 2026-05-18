package net.sweety.unusualend.procedures;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import org.jetbrains.annotations.Nullable;

public class NBTProcessor {
    public static void setNBTBoolean(ItemStack stack, String key, boolean value) {
        if (stack.has(DataComponents.CUSTOM_DATA))
            CustomData.update(DataComponents.CUSTOM_DATA, stack, tag -> tag.putBoolean(key, value));
    }

    public static boolean getNBTBoolean(ItemStack stack, String key) {
        if (stack.has(DataComponents.CUSTOM_DATA))
            return stack.get(DataComponents.CUSTOM_DATA).copyTag().getBoolean(key);
        return false;
    }

    public static void setNBTDouble(ItemStack stack, String key, double value) {
        if (stack.has(DataComponents.CUSTOM_DATA))
            CustomData.update(DataComponents.CUSTOM_DATA, stack, tag -> tag.putDouble(key, value));
    }

    public static double getNBTDouble(ItemStack stack, String key) {
        if (stack.has(DataComponents.CUSTOM_DATA))
            return stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(key);
        return 0;
    }

    public static void setNBTString(ItemStack stack, String key, String value) {
        if (stack.has(DataComponents.CUSTOM_DATA))
            CustomData.update(DataComponents.CUSTOM_DATA, stack, tag -> tag.putString(key, value));
    }

    public static String getNBTString(ItemStack stack, String key) {
        if (stack.has(DataComponents.CUSTOM_DATA))
            return stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(key);
        return "";
    }

    public static CompoundTag formBabyTag(Mob entity) {
        CompoundTag tag = new CompoundTag();
        tag.putString("Owner", entity instanceof OwnableEntity ownable && ownable.getOwner() != null ? ownable.getOwner().getDisplayName().getString() : "");
        tag.putBoolean("isTamed", entity instanceof OwnableEntity ownable && ownable.getOwner() != null);
        tag.putBoolean("isBaby", entity.isBaby());
        tag.putDouble("tagHealth", entity.getHealth());
        if (!getCustomName(entity).isEmpty())
            tag.putString("CustomName", entity.getDisplayName().getString());
        return tag;
    }

    public static void writeTagsIntoEntity(@Nullable CompoundTag tag, Mob entity) {
        if (tag != null) {
            if (tag.contains("tagHealth"))
                entity.setHealth(tag.getInt("tagHealth"));
            if (tag.contains("isBaby"))
                entity.setBaby(tag.getBoolean("isBaby"));
            if (tag.contains("CustomName"))
                entity.setCustomName(Component.literal(tag.getString("CustomName")));
        }
    }

    private static String getCustomName(LivingEntity entity) {
        CompoundTag dataIndex = new CompoundTag();
        entity.saveWithoutId(dataIndex);
        return dataIndex.getString("CustomName");
    }
}