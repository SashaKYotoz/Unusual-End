package net.sweety.unusualend.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.ModList;
import net.sweety.unusualend.compat.CuriosCompat;
import net.sweety.unusualend.entity.SummonedDraglingEntity;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModTags;
import net.sweety.unusualend.util.ItemCooldownHelper;

import java.util.List;
import java.util.Set;

public class PearlescentRingItem extends Item {
    public static final String CHARGE_KEY = "ringCooldown";
    private static final int CURIO_RECHARGE_INTERVAL = 20;

    public PearlescentRingItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        Set<Enchantment> e = Set.of(UnusualendModEnchantments.ARCANE_RECOVERY.get());
        return e.contains(enchantment);
    }

    @Override
    public int getEnchantmentValue() {
        return 8;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return stack.getOrCreateTag().getDouble(CHARGE_KEY) < ItemCooldownHelper.MAX_CHARGE && stack.getOrCreateTag().getDouble(CHARGE_KEY) > 0;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 16400310;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return (int) (stack.getOrCreateTag().getDouble(CHARGE_KEY) * 0.0025f * 14f);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add(Component.literal("§7" + Component.translatable("lore.unusualend.when_offhand").getString()));
        list.add(Component.literal("§7 " + Component.translatable("lore.unusualend.on_hit").getString()));
        list.add(Component.literal("§9 " + Component.translatable("lore.unusualend.spirit_ring_1").getString()));
        list.add(Component.literal("§9 " + Component.translatable("lore.unusualend.spirit_ring_2").getString()));
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, level, entity, slot, selected);
        ItemCooldownHelper.recharge(itemstack, CHARGE_KEY, 0.4, 0.2);
    }

    public static void onHolderAttack(LivingHurtEvent event) {
        if (event.getAmount() <= 0 || !(event.getSource().getEntity() instanceof Player player))
            return;
        LivingEntity target = event.getEntity();
        if (target == player || !(player.level() instanceof ServerLevel level))
            return;
        if (target instanceof TamableAnimal pet && pet.isOwnedBy(player))
            return;
        Item ring = UnusualendModItems.PEARLESCENT_RING.get();
        if (player.getCooldowns().isOnCooldown(ring))
            return;
        ItemStack stack = findChargedRing(player, ring);
        if (stack.isEmpty())
            return;
        stack.getOrCreateTag().putDouble(CHARGE_KEY, 0);
        player.getCooldowns().addCooldown(ring, 10);
        int count = player.getItemBySlot(EquipmentSlot.HEAD).is(UnusualendModTags.Items.ENDERLING_MASK) ? 2 : 1;
        for (int i = 0; i < count; i++)
            summonDragling(level, player, target);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 0.8f, 1.4f);
    }

    public static void rechargeCurios(Player player) {
        if (player.tickCount % CURIO_RECHARGE_INTERVAL != 0 || !ModList.get().isLoaded("curios"))
            return;
        CuriosCompat.forEach(player, UnusualendModItems.PEARLESCENT_RING.get(), stack -> ItemCooldownHelper.recharge(stack, CHARGE_KEY, 0.4 * CURIO_RECHARGE_INTERVAL, 0.2 * CURIO_RECHARGE_INTERVAL));
    }

    private static ItemStack findChargedRing(Player player, Item ring) {
        ItemStack offhand = player.getOffhandItem();
        if (offhand.is(ring) && isCharged(offhand))
            return offhand;
        if (ModList.get().isLoaded("curios"))
            return CuriosCompat.findFirst(player, ring, PearlescentRingItem::isCharged);
        return ItemStack.EMPTY;
    }

    private static boolean isCharged(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag != null && tag.getDouble(CHARGE_KEY) >= ItemCooldownHelper.MAX_CHARGE;
    }

    private static void summonDragling(ServerLevel level, Player player, LivingEntity target) {
        SummonedDraglingEntity dragling = UnusualendModEntities.SUMMONED_DRAGLING.get().create(level);
        if (dragling == null)
            return;
        RandomSource random = player.getRandom();
        double x = player.getX() + (random.nextDouble() - 0.5) * 2;
        double y = player.getY() + 1 + random.nextDouble();
        double z = player.getZ() + (random.nextDouble() - 0.5) * 2;
        dragling.moveTo(x, y, z, player.getYRot(), 0);
        if (!level.noCollision(dragling))
            dragling.moveTo(player.getX(), player.getY(), player.getZ(), player.getYRot(), 0);
        dragling.finalizeSpawn(level, level.getCurrentDifficultyAt(dragling.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
        dragling.setTame(true);
        dragling.setOwnerUUID(player.getUUID());
        if (target.isAlive())
            dragling.setTarget(target);
        level.addFreshEntity(dragling);
        level.sendParticles(ParticleTypes.REVERSE_PORTAL, dragling.getX(), dragling.getY() + 0.9, dragling.getZ(), 12, 0.3, 0.4, 0.3, 0.05);
    }
}