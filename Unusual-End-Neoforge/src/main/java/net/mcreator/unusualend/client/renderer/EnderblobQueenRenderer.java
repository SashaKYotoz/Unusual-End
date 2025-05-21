
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.entity.EnderblobQueenEntity;
import net.mcreator.unusualend.client.model.Modelqueen;

public class EnderblobQueenRenderer extends MobRenderer<EnderblobQueenEntity, Modelqueen<EnderblobQueenEntity>> {
	public EnderblobQueenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelqueen(context.bakeLayer(Modelqueen.LAYER_LOCATION)), 0.7f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnderblobQueenEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/enderblob_queen.png");
	}
}
