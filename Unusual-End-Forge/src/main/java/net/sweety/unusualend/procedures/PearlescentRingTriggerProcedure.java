package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.compat.CuriosCompat;
import net.sweety.unusualend.entity.SummonedDraglingEntity;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModTags;
import net.sweety.unusualend.util.ItemCooldownHelper;

@Mod.EventBusSubscriber
public class PearlescentRingTriggerProcedure {
    public static final String CHARGE_KEY = "ringCooldown";
    private static final int CURIO_RECHARGE_INTERVAL = 20;

    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
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

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (event.phase != TickEvent.Phase.END || player.level().isClientSide() || player.tickCount % CURIO_RECHARGE_INTERVAL != 0)
            return;
        if (ModList.get().isLoaded("curios"))
            CuriosCompat.forEach(player, UnusualendModItems.PEARLESCENT_RING.get(), stack -> ItemCooldownHelper.recharge(stack, CHARGE_KEY, 0.4 * CURIO_RECHARGE_INTERVAL, 0.2 * CURIO_RECHARGE_INTERVAL));
    }

    private static ItemStack findChargedRing(Player player, Item ring) {
        ItemStack offhand = player.getOffhandItem();
        if (offhand.is(ring) && isCharged(offhand))
            return offhand;
        if (ModList.get().isLoaded("curios"))
            return CuriosCompat.findFirst(player, ring, PearlescentRingTriggerProcedure::isCharged);
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