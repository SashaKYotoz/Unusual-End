
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.client.model.ModelBubble;
import net.mcreator.unusualend.entity.LargeBubbleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LargeBubbleRenderer extends MobRenderer<LargeBubbleEntity, ModelBubble<LargeBubbleEntity>> {
	public LargeBubbleRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBubble(context.bakeLayer(ModelBubble.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LargeBubbleEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/large_warped_bubble.png");
	}
}
