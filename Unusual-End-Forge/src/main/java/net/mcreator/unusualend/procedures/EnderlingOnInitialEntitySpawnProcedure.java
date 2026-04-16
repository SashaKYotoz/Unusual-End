package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.configuration.Config;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class EnderlingOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (!world.isClientSide()) {
            if (Math.random() < Config.ENDERLING_MASK.get() / 100) {
                if (entity instanceof Player player) {
                    player.getInventory().armor.set(3, new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("unusualend:enderling_mask"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
                    player.getInventory().setChanged();
                } else if (entity instanceof LivingEntity living) {
                    living.setItemSlot(EquipmentSlot.HEAD,
                            new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("unusualend:enderling_mask"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
                }

                ItemStack stack = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
                if (stack.hurt((int) Mth.nextDouble(RandomSource.create(), 0, 155), RandomSource.create(), null)) {
                    stack.shrink(1);
                    stack.setDamageValue(0);
                }
                if (!entity.level().isClientSide() && entity.getServer() != null) {
                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
                            entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {ArmorDropChances: [0f, 0f, 0f, 0.6f]}");
                }
            }
        }
    }
}
