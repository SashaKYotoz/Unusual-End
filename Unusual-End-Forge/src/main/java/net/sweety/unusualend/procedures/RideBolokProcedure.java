package net.sweety.unusualend.procedures;

import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.entity.BolokEntity;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.init.UnusualendModItems;
import net.sweety.unusualend.jei_recipes.BolokTradingRecipe;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

import javax.annotation.Nullable;
import java.util.List;

@Mod.EventBusSubscriber
public class RideBolokProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
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
					UnusualEnd.queueServerWork(60, () -> {
						ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
						Enchantment[] bolokEnchantments = {UnusualendModEnchantments.BOLOKS_FURY.get(), UnusualendModEnchantments.BOLOKS_WINGS.get(), UnusualendModEnchantments.BOLOKS_HEAD.get()};
						EnchantedBookItem.addEnchantment(enchantedBook, new EnchantmentInstance(bolokEnchantments[world.getRandom().nextInt(bolokEnchantments.length)], 1));
						ProcedureHelper.dropItem(world, entity.getX(), entity.getY(), entity.getZ(), enchantedBook, 10);
					});
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.translatable("text.unusualend.no_xp_bolok"), true);
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualendModItems.SHINY_CRYSTAL.get()) {
				((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
				ProcedureHelper.playSound(world, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.HOSTILE, 1, 1);
				ParticleHelper.spawn(world, ParticleTypes.GLOW_SQUID_INK, ParticleHelper.localToEyes(entity, 0, 0, 0.6), 10, 0.1, 0.1, 0.1, 0.01, true);
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
				ProcedureHelper.addEffect(entity, new MobEffectInstance(MobEffects.WITHER, 300, 1));
				ProcedureHelper.awardAdvancement(sourceentity, "give_bolok_crystal");
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
				ProcedureHelper.dropItem(world, (entity.getX()), (entity.getY()), (entity.getZ()), rest, 10);
			}
		}
	}
}
