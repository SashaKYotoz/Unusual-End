package net.mcreator.unusualend.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.unusualend.jei_recipes.BolokTradingRecipe;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.entity.BolokEntity;
import net.mcreator.unusualend.UnusualendMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Iterator;

@Mod.EventBusSubscriber
public class RideBolokProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack rest = ItemStack.EMPTY;
		if (entity instanceof BolokEntity) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.ENCHANTED_BOOK) {
				if ((sourceentity instanceof Player _plr ? _plr.experienceLevel : 0) >= 15) {
					BolokTradeEffectsProcedure.execute(world, x, y, z, entity, sourceentity);
					if (sourceentity instanceof Player _player)
						_player.giveExperiencePoints(-(315));
					UnusualendMod.queueServerWork(60, () -> {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(Items.ENCHANTED_BOOK));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (!world.isClientSide()) {
							if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute at @s run data merge entity @e[type=minecraft:item,limit=1,distance=..0.1,nbt={Item:{id:\"minecraft:enchanted_book\"}}] {Item:{id:\"minecraft:enchanted_book\",tag:{StoredEnchantments:[{id:\"unusualend:boloks_fury\",lvl:1s}]}}}");
									}
								}
							} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute at @s run data merge entity @e[type=minecraft:item,limit=1,distance=..0.1,nbt={Item:{id:\"minecraft:enchanted_book\"}}] {Item:{id:\"minecraft:enchanted_book\",tag:{StoredEnchantments:[{id:\"unusualend:boloks_wings\",lvl:1s}]}}}");
									}
								}
							} else {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute at @s run data merge entity @e[type=minecraft:item,limit=1,distance=..0.1,nbt={Item:{id:\"minecraft:enchanted_book\"}}] {Item:{id:\"minecraft:enchanted_book\",tag:{StoredEnchantments:[{id:\"unusualend:boloks_head\",lvl:1s}]}}}");
									}
								}
							}
						}
					});
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("text.unusualend.no_xp_bolok").getString())), true);
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.SHINY_CRYSTAL.get()) {
				((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute at " + entity.getStringUUID() + " anchored eyes run particle minecraft:glow_squid_ink ^ ^ ^0.6 0.1 0.1 0.1 0.01 10 force"));
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 300, 1));
				if (!(sourceentity instanceof ServerPlayer _plr31 && _plr31.level() instanceof ServerLevel
						&& _plr31.getAdvancements().getOrStartProgress(_plr31.server.getAdvancements().getAdvancement(new ResourceLocation("unusualend:give_bolok_crystal"))).isDone())) {
					if (sourceentity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("unusualend:give_bolok_crystal"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemainingCriteria().iterator();
							while (_iterator.hasNext())
								_player.getAdvancements().award(_adv, (String) _iterator.next());
						}
					}
				}
			} else if (!((new Object() {
				public ItemStack getResult() {
					if (world instanceof Level _lvl) {
						net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
						List<BolokTradingRecipe> recipes = rm.getAllRecipesFor(BolokTradingRecipe.Type.INSTANCE);
						for (BolokTradingRecipe recipe : recipes) {
							NonNullList<Ingredient> ingredients = recipe.getIngredients();
							if (!ingredients.get(0).test((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))
								continue;
							return recipe.getResultItem(null);
						}
					}
					return ItemStack.EMPTY;
				}
			}.getResult()).getItem() == Blocks.AIR.asItem())) {
				rest = (new Object() {
					public ItemStack getResult() {
						if (world instanceof Level _lvl) {
							net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
							List<BolokTradingRecipe> recipes = rm.getAllRecipesFor(BolokTradingRecipe.Type.INSTANCE);
							for (BolokTradingRecipe recipe : recipes) {
								NonNullList<Ingredient> ingredients = recipe.getIngredients();
								if (!ingredients.get(0).test((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))
									continue;
								return recipe.getResultItem(null);
							}
						}
						return ItemStack.EMPTY;
					}
				}.getResult());
				BolokTradeEffectsProcedure.execute(world, x, y, z, entity, sourceentity);
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), rest);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
