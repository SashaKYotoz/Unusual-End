
package net.mcreator.unusualend.item;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.unusualend.procedures.WarpedSpearToolInHandTickProcedure;
import net.mcreator.unusualend.init.UnusualendModItems;

import java.util.function.Consumer;

public class WarpedSpearItem extends SwordItem {
	public WarpedSpearItem() {
		super(new Tier() {
			public int getUses() {
				return 1024;
			}

			public float getSpeed() {
				return 8f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 16;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(UnusualendModItems.LURKER_SPINE.get()), new ItemStack(UnusualendModItems.BOLOK_SCALE.get()));
			}
		}, 3, -3.4f, new Item.Properties());
	}

	//	@Override
	//	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
	//		super.appendHoverText(itemstack, world, list, flag);
	//		list.add(Component.literal("\u00A77When Riding an Entity:"));
	//		list.add(Component.literal("\u00A79Swift Strikes (0:01)"));
	//		list.add(Component.literal("\u00A79Strength (0:01)"));
	//	}
	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			WarpedSpearToolInHandTickProcedure.execute(entity);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			private static final HumanoidModel.ArmPose SPEAR_POSE = HumanoidModel.ArmPose.create("SPEAR", false, (model, entity, arm) -> {
				if (arm == HumanoidArm.RIGHT) {
					model.rightArm.xRot = (-(float) Math.PI / 6.3F);
					model.rightArm.yRot = model.head.yRot;
					model.rightArm.zRot = -0.5F;
					model.leftArm.xRot = (-(float) Math.PI / 6.2F);
					model.leftArm.yRot = model.head.yRot;
					model.leftArm.zRot = 0.9F;
				} else {
					model.leftArm.xRot = (-(float) Math.PI / 1.9F) + model.head.xRot;
					model.leftArm.yRot = -0.1F + model.head.yRot;
					model.rightArm.yRot = 0.1F + model.head.yRot + 0.4F;
					model.rightArm.xRot = (-(float) Math.PI / 1.9F) + model.head.xRot;
				}
			});

			@Override
			public HumanoidModel.ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {
				if (!itemStack.isEmpty()) {
					if (entityLiving.getUsedItemHand() == hand) {
						return SPEAR_POSE;
					}
				}
				return HumanoidModel.ArmPose.EMPTY;
			}
		});
	}
}
