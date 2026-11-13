package net.sweety.unusualend.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nullable;
import java.util.UUID;

public final class MobBucketHelper {
	private static final String NAMED = "isNamed";
	private static final String HEALTH = "tagHealth";
	private static final String BABY = "isBaby";
	private static final String TAMED = "isTamed";
	private static final String OWNER = "Owner";
	private static final int BUCKETED_BABY_AGE = -6000;

	private MobBucketHelper() {
	}

	@Nullable
	private static InteractionHand handHolding(LivingEntity living, Item item) {
		if (living.getMainHandItem().is(item))
			return InteractionHand.MAIN_HAND;
		if (living.getOffhandItem().is(item))
			return InteractionHand.OFF_HAND;
		return null;
	}

	public static void capture(Entity mob, Entity holder, Item bucketItem) {
		if (mob == null || !(holder instanceof LivingEntity living))
			return;
		InteractionHand hand = handHolding(living, Items.BUCKET);
		if (hand == null)
			return;
		ItemStack bucket = new ItemStack(bucketItem);
		CompoundTag tag = bucket.getOrCreateTag();
		if (mob.hasCustomName() && mob.getCustomName() != null) {
			bucket.setHoverName(mob.getCustomName());
			tag.putBoolean(NAMED, true);
		}
		if (mob instanceof LivingEntity livingMob) {
			tag.putDouble(HEALTH, livingMob.getHealth());
			tag.putBoolean(BABY, livingMob.isBaby());
		}
		if (mob instanceof TamableAnimal tamable) {
			tag.putBoolean(TAMED, tamable.isTame());
			if (tamable.isTame() && tamable.getOwnerUUID() != null)
				tag.putString(OWNER, tamable.getOwnerUUID().toString());
		}
		living.swing(hand, true);
		if (mob.level().isClientSide())
			return;
		mob.discard();
		ItemStack held = living.getItemInHand(hand);
		if (held.getCount() == 1) {
			living.setItemInHand(hand, bucket);
		} else {
			held.shrink(1);
			if (living instanceof Player player)
				ItemHandlerHelper.giveItemToPlayer(player, bucket);
		}
	}

	@Nullable
	public static <T extends Mob> T release(Level level, BlockPos clickedPos, Direction face, @Nullable Entity user, ItemStack bucket, EntityType<T> type, SoundEvent sound) {
		if (face == null || user == null || user.isShiftKeyDown())
			return null;
		if (user instanceof LivingEntity living) {
			InteractionHand hand = handHolding(living, bucket.getItem());
			if (hand != null) {
				if (!ProcedureHelper.isCreative(user))
					living.setItemInHand(hand, new ItemStack(Items.BUCKET));
				living.swing(hand, true);
			}
		}
		ProcedureHelper.playSound(level, clickedPos.getX(), clickedPos.getY(), clickedPos.getZ(), sound, SoundSource.NEUTRAL, 1, 1);
		if (!(level instanceof ServerLevel serverLevel))
			return null;
		T mob = type.spawn(serverLevel, clickedPos.relative(face), MobSpawnType.MOB_SUMMONED);
		if (mob == null)
			return null;
		CompoundTag tag = bucket.getOrCreateTag();
		if (tag.getBoolean(NAMED))
			mob.setCustomName(bucket.getHoverName());
		if (tag.getDouble(HEALTH) != 0)
			mob.setHealth((float) tag.getDouble(HEALTH));
		if (tag.contains(BABY)) {
			if (mob instanceof AgeableMob ageable) {
				if (tag.getBoolean(BABY))
					ageable.setAge(BUCKETED_BABY_AGE);
			} else {
				mob.setBaby(tag.getBoolean(BABY));
			}
		}
		if (mob instanceof TamableAnimal tamable && tag.getBoolean(TAMED)) {
			UUID owner = parseOwner(tag.getString(OWNER));
			if (owner == null && user instanceof Player player)
				owner = player.getUUID();
			if (owner != null) {
				tamable.setTame(true);
				tamable.setOwnerUUID(owner);
			}
		}
		return mob;
	}

	@Nullable
	private static UUID parseOwner(String value) {
		try {
			return value.isEmpty() ? null : UUID.fromString(value);
		} catch (IllegalArgumentException exception) {
			return null;
		}
	}
}
