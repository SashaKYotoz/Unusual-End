package net.sweety.unusualend.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.init.UnusualendModMobEffects;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import net.sweety.unusualend.init.UnusualendModTags;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public enum InfuserGem {
	CITRINE("Citrine", UnusualendModTags.Items.CITRINE_BASE, 0, 14, UnusualendModItems.CITRINE_CHUNK::get, () -> ParticleTypes.FLAME,
			(entity, value) -> ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualendModMobEffects.SERENITY.get(), (int) (value * 6000), 0, false, false))),
	SHINY("Shiny", UnusualendModTags.Items.SHINY_BASE, 1, 68, UnusualendModItems.SHINY_CRYSTAL::get, UnusualendModParticleTypes.PINK_FLAME::get,
			(entity, value) -> {
				ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.HEALTH_BOOST, (int) (value * 6000), 1, false, false));
				ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.REGENERATION, 200, 1, false, false));
			}),
	PRISMATIC("Prismatic", UnusualendModTags.Items.PRISMATIC_BASE, 2, 122, UnusualendModItems.PRISMALITE_GEM::get, () -> ParticleTypes.SOUL_FIRE_FLAME,
			(entity, value) -> ProcedureHelper.addEffect(entity, new MobEffectInstance(UnusualendModMobEffects.SWIFT_STRIKES.get(), (int) (value * 6000), 0, false, false)));

	public static final int MAX_CHARGE = 8;
	public static final int[] AMOUNTS = {1, 4, 8};
	private static final int REQUIRED_BASE_BLOCKS = 4;

	private final String key;
	private final TagKey<Item> baseTag;
	private final int slot;
	private final int screenX;
	private final Supplier<Item> fuel;
	private final Supplier<? extends ParticleOptions> chargeParticle;
	private final BiConsumer<Entity, Double> effects;
	private final ResourceLocation chargeTexture;

	InfuserGem(String key, TagKey<Item> baseTag, int slot, int screenX, Supplier<Item> fuel, Supplier<? extends ParticleOptions> chargeParticle, BiConsumer<Entity, Double> effects) {
		this.key = key;
		this.baseTag = baseTag;
		this.slot = slot;
		this.screenX = screenX;
		this.fuel = fuel;
		this.chargeParticle = chargeParticle;
		this.effects = effects;
		this.chargeTexture = new ResourceLocation("unusualend", "textures/screens/" + name().toLowerCase() + "_charge.png");
	}

	public int screenX() {
		return screenX;
	}

	public ResourceLocation chargeTexture() {
		return chargeTexture;
	}

	public static void handleButton(LevelAccessor world, BlockPos pos, Entity entity, int buttonId) {
		InfuserGem[] gems = values();
		if (buttonId < 0 || buttonId >= gems.length * AMOUNTS.length)
			return;
		gems[buttonId % gems.length].consume(world, pos, entity, AMOUNTS[buttonId / gems.length]);
	}

	public static void tick(LevelAccessor world, BlockPos pos) {
		for (InfuserGem gem : values())
			gem.charge(world, pos);
	}

	public double getCharge(LevelAccessor world, BlockPos pos) {
		return ProcedureHelper.getBlockEntityDouble(world, pos, key);
	}

	public boolean hasCharge(LevelAccessor world, BlockPos pos, double amount) {
		return getCharge(world, pos) >= amount;
	}

	public boolean hasValidBase(LevelAccessor world, BlockPos pos) {
		int count = 0;
		for (BlockPos check : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, -1, 1))) {
			if (new ItemStack(world.getBlockState(check).getBlock()).is(baseTag))
				count++;
		}
		return count >= REQUIRED_BASE_BLOCKS;
	}

	private void setCharge(LevelAccessor world, BlockPos pos, double value) {
		if (world.isClientSide())
			return;
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity == null)
			return;
		blockEntity.getPersistentData().putDouble(key, value);
		BlockState state = world.getBlockState(pos);
		if (world instanceof Level level)
			level.sendBlockUpdated(pos, state, state, 3);
	}

	public void consume(LevelAccessor world, BlockPos pos, Entity entity, double amount) {
		if (entity == null || !hasCharge(world, pos, amount))
			return;
		double x = pos.getX() + 0.5;
		double y = pos.getY() + 1.2;
		double z = pos.getZ() + 0.5;
		if (entity instanceof Player player)
			player.closeContainer();
		if (!hasValidBase(world, pos)) {
			ProcedureHelper.playSound(world, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BEACON_DEACTIVATE, SoundSource.BLOCKS, 1, 0.6f);
			if (entity instanceof Player player && !player.level().isClientSide())
				player.displayClientMessage(Component.translatable("text.unusualend.no_base"), true);
			sendParticles(world, ParticleTypes.LARGE_SMOKE, x, y, z);
			return;
		}
		setCharge(world, pos, getCharge(world, pos) - amount);
		effects.accept(entity, amount);
		sendParticles(world, ParticleTypes.WITCH, x, y, z);
		ProcedureHelper.playSound(world, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS, 1, 0.6f);
	}

	public void charge(LevelAccessor world, BlockPos pos) {
		if (!ProcedureHelper.getItemStack(world, pos, slot).is(fuel.get()) || getCharge(world, pos) >= MAX_CHARGE)
			return;
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity == null)
			return;
		blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(handler -> {
			if (handler instanceof IItemHandlerModifiable modifiable) {
				ItemStack stack = handler.getStackInSlot(slot).copy();
				stack.shrink(1);
				modifiable.setStackInSlot(slot, stack);
			}
		});
		setCharge(world, pos, getCharge(world, pos) + 1);
		sendParticles(world, chargeParticle.get(), pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5);
		ProcedureHelper.playSound(world, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CONDUIT_AMBIENT_SHORT, SoundSource.NEUTRAL, 2, 1.8f);
	}

	private static void sendParticles(LevelAccessor world, ParticleOptions particle, double x, double y, double z) {
		if (world instanceof ServerLevel level) {
			level.sendParticles(particle, x, y, z, 6, 0.1, 0.1, 0.1, 0);
			level.sendParticles(ParticleTypes.SMOKE, x, y, z, 8, 0.1, 0.1, 0.1, 0);
		}
	}
}
