package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.unusualend.configuration.UEConfig;

public class EnderlingOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (!world.isClientSide()) {
            if (Math.random() < UEConfig.ENDERLING_MASK.get() / 100) {
                Entity _entity = entity;
                if (_entity instanceof Player _player) {
                    _player.getInventory().armor.set(3, new ItemStack((BuiltInRegistries.ITEM.getTag(ItemTags.create(UnusualEnd.makeUEID("enderling_mask"))).flatMap(enderlingMask -> enderlingMask.getRandomElement(RandomSource.create())).orElseGet(Items.AIR::builtInRegistryHolder))));
                    _player.getInventory().setChanged();
                } else if (_entity instanceof LivingEntity _living) {
                    _living.setItemSlot(EquipmentSlot.HEAD,
                            new ItemStack((BuiltInRegistries.ITEM.getTag(ItemTags.create(UnusualEnd.makeUEID("enderling_mask"))).flatMap(tag -> tag.getRandomElement(RandomSource.create())).orElseGet(Items.AIR::builtInRegistryHolder))));
                }
                ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
                if (_ist.hurt((int) Mth.nextDouble(RandomSource.create(), 0, 155), RandomSource.create(), null)) {
                    _ist.shrink(1);
                    _ist.setDamageValue(0);
                }
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {ArmorDropChances: [0f, 0f, 0f, 0.6f]}");
                }
            }
        }
    }
}
