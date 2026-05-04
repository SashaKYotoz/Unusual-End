
package net.sweety.unusualend.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelQueen;
import net.sweety.unusualend.entity.EnderblobQueenEntity;

public class EnderblobQueenRenderer extends MobRenderer<EnderblobQueenEntity, ModelQueen<EnderblobQueenEntity>> {
	public EnderblobQueenRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelQueen(context.bakeLayer(ModelQueen.LAYER_LOCATION)), 0.7f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnderblobQueenEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/enderblob_queen.png");
	}
}
