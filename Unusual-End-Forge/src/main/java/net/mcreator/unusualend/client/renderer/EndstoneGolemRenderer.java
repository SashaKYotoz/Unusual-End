
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.client.model.ModelEndstoneGolem;
import net.mcreator.unusualend.entity.EndstoneGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EndstoneGolemRenderer extends MobRenderer<EndstoneGolemEntity, ModelEndstoneGolem<EndstoneGolemEntity>> {
	public EndstoneGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelEndstoneGolem(context.bakeLayer(ModelEndstoneGolem.LAYER_LOCATION)), 1.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(EndstoneGolemEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/endstone_golem.png");
	}
}
