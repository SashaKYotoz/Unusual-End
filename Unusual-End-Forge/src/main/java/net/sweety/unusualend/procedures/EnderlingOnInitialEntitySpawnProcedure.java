package net.sweety.unusualend.procedures;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.config.Config;
import net.sweety.unusualend.init.UnusualendModTags;

public class EnderlingOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (!world.isClientSide()) {
            if (Math.random() < Config.ENDERLING_MASK.get() / 100) {
                if (entity instanceof Player player) {
                    player.getInventory().armor.set(3, new ItemStack((ForgeRegistries.ITEMS.tags().getTag(UnusualendModTags.Items.ENDERLING_MASK).getRandomElement(world.getRandom()).orElseGet(() -> Items.AIR))));
                    player.getInventory().setChanged();
                } else if (entity instanceof LivingEntity living) {
                    living.setItemSlot(EquipmentSlot.HEAD,
                            new ItemStack((ForgeRegistries.ITEMS.tags().getTag(UnusualendModTags.Items.ENDERLING_MASK).getRandomElement(world.getRandom()).orElseGet(() -> Items.AIR))));
                }

                ItemStack stack = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
                if (stack.hurt((int) Mth.nextDouble(world.getRandom(), 0, 155), world.getRandom(), null)) {
                    stack.shrink(1);
                    stack.setDamageValue(0);
                }
                if (!entity.level().isClientSide() && entity.getServer() != null) {
                    if (entity instanceof Mob mob) {
                        mob.setDropChance(EquipmentSlot.FEET, 0f);
                        mob.setDropChance(EquipmentSlot.LEGS, 0f);
                        mob.setDropChance(EquipmentSlot.CHEST, 0f);
                        mob.setDropChance(EquipmentSlot.HEAD, 0.6f);
                    }
                }
            }
        }
    }
}
