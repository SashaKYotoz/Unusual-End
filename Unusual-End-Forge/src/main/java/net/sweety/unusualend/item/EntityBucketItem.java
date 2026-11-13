package net.sweety.unusualend.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.sweety.unusualend.util.MobBucketHelper;

import java.util.function.Supplier;

public class EntityBucketItem extends Item {
	private final Supplier<? extends EntityType<? extends Mob>> entityType;
	private final Supplier<SoundEvent> releaseSound;

	public EntityBucketItem(Supplier<? extends EntityType<? extends Mob>> entityType, Supplier<SoundEvent> releaseSound) {
		super(new Item.Properties().stacksTo(1));
		this.entityType = entityType;
		this.releaseSound = releaseSound;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		MobBucketHelper.release(context.getLevel(), context.getClickedPos(), context.getClickedFace(), context.getPlayer(), context.getItemInHand(), this.entityType.get(), this.releaseSound.get());
		return InteractionResult.SUCCESS;
	}
}
