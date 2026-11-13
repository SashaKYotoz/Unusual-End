package net.sweety.unusualend.util;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.entity.FlampyrEntity;
import net.sweety.unusualend.init.UnusualendModEntities;

import java.util.Comparator;
import java.util.Map;
import java.util.UUID;

public final class ProcedureHelper {
	private ProcedureHelper() {
	}

	public static Direction getDirection(BlockState state) {
		Property<?> property = state.getBlock().getStateDefinition().getProperty("facing");
		if (property instanceof DirectionProperty directionProperty)
			return state.getValue(directionProperty);
		property = state.getBlock().getStateDefinition().getProperty("axis");
		if (property instanceof EnumProperty<?> enumProperty) {
			Object value = state.getValue(enumProperty);
			if (value instanceof Direction.Axis axis)
				return Direction.fromAxisAndDirection(axis, Direction.AxisDirection.POSITIVE);
		}
		return Direction.NORTH;
	}

	public static boolean isCreative(Entity entity) {
		return entity instanceof Player player && player.isCreative();
	}

	public static boolean isSpectator(Entity entity) {
		return entity instanceof Player player && player.isSpectator();
	}

	public static boolean isOrderedToSit(Entity entity) {
		return entity instanceof TamableAnimal tamable && tamable.isOrderedToSit();
	}

	public static void addEffect(Entity entity, MobEffectInstance effect) {
		if (entity instanceof LivingEntity living && !living.level().isClientSide())
			living.addEffect(effect);
	}

	public static double getBlockEntityDouble(LevelAccessor level, BlockPos pos, String tag) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1;
	}

	public static String getBlockEntityString(LevelAccessor level, BlockPos pos, String tag) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
	}

	public static boolean getBlockEntityBoolean(LevelAccessor level, BlockPos pos, String tag) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		return blockEntity != null && blockEntity.getPersistentData().getBoolean(tag);
	}

	public static ItemStack getItemStack(LevelAccessor level, BlockPos pos, int slot) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		if (blockEntity == null)
			return ItemStack.EMPTY;
		return blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).map(handler -> handler.getStackInSlot(slot).copy()).orElse(ItemStack.EMPTY);
	}

	public static int getItemCount(LevelAccessor level, BlockPos pos, int slot) {
		return getItemStack(level, pos, slot).getCount();
	}

	public static String getSpawnDimension(Entity entity) {
		if (entity instanceof ServerPlayer player && player.getRespawnPosition() != null)
			return player.getRespawnDimension().location().toString();
		return "";
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void replaceBlockKeepingState(LevelAccessor level, BlockPos pos, BlockState newState, int flags) {
		BlockState state = newState;
		for (Map.Entry<Property<?>, Comparable<?>> entry : level.getBlockState(pos).getValues().entrySet()) {
			Property property = state.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
			if (property != null && property.getPossibleValues().contains(entry.getValue()))
				state = state.setValue(property, (Comparable) entry.getValue());
		}
		level.setBlock(pos, state, flags);
	}

	public static Comparator<Entity> byDistanceTo(double x, double y, double z) {
		return Comparator.comparingDouble(entity -> entity.distanceToSqr(x, y, z));
	}

	public static void playSound(LevelAccessor level, double x, double y, double z, SoundEvent sound, SoundSource source, float volume, float pitch) {
		if (level instanceof Level world) {
			if (world.isClientSide())
				world.playLocalSound(x, y, z, sound, source, volume, pitch, false);
			else
				world.playSound(null, BlockPos.containing(x, y, z), sound, source, volume, pitch);
		}
	}

	public static void dropItem(LevelAccessor level, double x, double y, double z, ItemStack stack, int pickUpDelay) {
		if (level instanceof ServerLevel serverLevel) {
			ItemEntity item = new ItemEntity(serverLevel, x, y, z, stack);
			item.setPickUpDelay(pickUpDelay);
			serverLevel.addFreshEntity(item);
		}
	}

	public static void spawnProtectedItem(LevelAccessor level, double x, double y, double z, ItemStack stack, boolean glowing) {
		if (level instanceof ServerLevel serverLevel) {
			ItemEntity item = new ItemEntity(serverLevel, x, y, z, stack, 0, 0, 0);
			item.setInvulnerable(true);
			item.setGlowingTag(glowing);
			serverLevel.addFreshEntity(item);
		}
	}

	public static void spawnEnderFirefly(LevelAccessor level, double x, double y, double z, int age, String owner) {
		if (!(level instanceof ServerLevel serverLevel))
			return;
		FlampyrEntity firefly = UnusualendModEntities.ENDER_FIREFLY.get().create(serverLevel);
		if (firefly == null)
			return;
		firefly.moveTo(x, y, z, serverLevel.getRandom().nextFloat() * 360.0F, 0.0F);
		if (age != 0)
			firefly.setAge(age);
		if (owner != null && !owner.isEmpty()) {
			try {
				firefly.setOwnerUUID(UUID.fromString(owner));
				firefly.setTame(true);
			} catch (IllegalArgumentException ignored) {
			}
		}
		serverLevel.addFreshEntity(firefly);
	}

	private static Advancement advancement(ServerPlayer player, String path) {
		return player.server.getAdvancements().getAdvancement(new ResourceLocation(UnusualEnd.MODID, path));
	}

	public static boolean hasAdvancement(Entity entity, String path) {
		if (!(entity instanceof ServerPlayer player))
			return false;
		Advancement advancement = advancement(player, path);
		return advancement != null && player.getAdvancements().getOrStartProgress(advancement).isDone();
	}

	public static void awardAdvancement(Entity entity, String path) {
		if (!(entity instanceof ServerPlayer player))
			return;
		Advancement advancement = advancement(player, path);
		if (advancement == null)
			return;
		AdvancementProgress progress = player.getAdvancements().getOrStartProgress(advancement);
		if (!progress.isDone()) {
			for (String criteria : progress.getRemainingCriteria())
				player.getAdvancements().award(advancement, criteria);
		}
	}
}
