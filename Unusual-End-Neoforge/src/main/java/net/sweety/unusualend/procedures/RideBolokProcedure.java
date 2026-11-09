package net.sweety.unusualend.procedures;

import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.entity.BolokEntity;
import net.sweety.unusualend.init.UnusualEndEnchantments;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.jei_recipes.BolokTradingRecipe;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.List;

@EventBusSubscriber
public class RideBolokProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack rest;
		if (entity instanceof BolokEntity) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.ENCHANTED_BOOK) {
				if ((sourceentity instanceof Player _plr ? _plr.experienceLevel : 0) >= 15) {
					BolokTradeEffectsProcedure.execute(world, x, y, z, entity, sourceentity);
					if (sourceentity instanceof Player _player)
						_player.giveExperiencePoints(-(315));
					UnusualEnd.queueServerWork(60, () -> {
                        if (world instanceof Level _level && !_level.isClientSide()) {
                            ResourceKey<Enchantment> enchantmentKey = switch (Mth.nextInt(_level.getRandom(), 1, 3)) {
                                case 1 -> UnusualEndEnchantments.BOLOKS_FURY;
                                case 2 -> UnusualEndEnchantments.BOLOKS_WINGS;
                                default -> UnusualEndEnchantments.BOLOKS_HEAD;
                            };
                            ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
                            _level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolder(enchantmentKey).ifPresent(holder -> {
                                ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
                                mutable.set(holder, 1);
                                enchantedBook.set(DataComponents.STORED_ENCHANTMENTS, mutable.toImmutable());
                            });
                            ProcedureHelper.dropItem(_level, entity.getX(), entity.getY(), entity.getZ(), enchantedBook, 10);
                        }
					});
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.translatable("text.unusualend.no_xp_bolok"), true);
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualEndItems.SHINY_CRYSTAL.get()) {
				((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
				ProcedureHelper.playSound(world, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.GENERIC_EAT, SoundSource.HOSTILE, 1, 1);
				ParticleHelper.spawn(world, ParticleTypes.GLOW_SQUID_INK, ParticleHelper.localToEyes(entity, 0, 0, 0.6), 10, 0.1, 0.1, 0.1, 0.01, true);
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
				ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.WITHER, 300, 1));
				ProcedureHelper.awardAdvancement(sourceentity, "give_bolok_crystal");
			} else if (!((new Object() {
				public ItemStack getResult() {
					if (world instanceof Level _lvl) {
						net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
						List<RecipeHolder<BolokTradingRecipe>> recipes = rm.getAllRecipesFor(BolokTradingRecipe.Type.INSTANCE);
						for (RecipeHolder<BolokTradingRecipe> recipe : recipes) {
							NonNullList<Ingredient> ingredients = recipe.value().getIngredients();
							if (!ingredients.getFirst().test((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))
								continue;
							return recipe.value().getResultItem(null);
						}
					}
					return ItemStack.EMPTY;
				}
			}.getResult()).getItem() == Blocks.AIR.asItem())) {
				rest = (new Object() {
					public ItemStack getResult() {
						if (world instanceof Level _lvl) {
							net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
							List<RecipeHolder<BolokTradingRecipe>> recipes = rm.getAllRecipesFor(BolokTradingRecipe.Type.INSTANCE);
							for (RecipeHolder<BolokTradingRecipe> recipe : recipes) {
								NonNullList<Ingredient> ingredients = recipe.value().getIngredients();
								if (!ingredients.getFirst().test((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))
									continue;
								return recipe.value().getResultItem(null);
							}
						}
						return ItemStack.EMPTY;
					}
				}.getResult());
				BolokTradeEffectsProcedure.execute(world, x, y, z, entity, sourceentity);
				ProcedureHelper.dropItem(world, (entity.getX()), (entity.getY()), (entity.getZ()), rest, 10);
			}
		}
	}
}
