
package net.mcreator.unusualend.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.entity.EnderTrapperEntity;
import net.mcreator.unusualend.client.model.Modelendertrapper118;

public class EnderTrapperRenderer extends MobRenderer<EnderTrapperEntity, Modelendertrapper118<EnderTrapperEntity>> {
	public EnderTrapperRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelendertrapper118(context.bakeLayer(Modelendertrapper118.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnderTrapperEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/ender_trapper.png");
	}
}
