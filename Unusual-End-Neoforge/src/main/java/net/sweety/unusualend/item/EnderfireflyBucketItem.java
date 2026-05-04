
package net.sweety.unusualend.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.sweety.unusualend.procedures.UnbucketFireflyProcedure;

public class EnderfireflyBucketItem extends Item {
    public EnderfireflyBucketItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        UnbucketFireflyProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
        return InteractionResult.SUCCESS;
    }
}
