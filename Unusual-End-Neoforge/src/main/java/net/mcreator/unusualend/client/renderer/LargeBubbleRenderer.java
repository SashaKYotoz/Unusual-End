
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.entity.LargeBubbleEntity;
import net.mcreator.unusualend.client.model.Modelbubble;

public class LargeBubbleRenderer extends MobRenderer<LargeBubbleEntity, Modelbubble<LargeBubbleEntity>> {
	public LargeBubbleRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbubble(context.bakeLayer(Modelbubble.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LargeBubbleEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/large_warped_bubble.png");
	}
}
