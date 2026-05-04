
package net.sweety.unusualend.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelEndstoneGolem;
import net.sweety.unusualend.entity.EndstoneGolemEntity;

public class EndstoneGolemRenderer extends MobRenderer<EndstoneGolemEntity, ModelEndstoneGolem<EndstoneGolemEntity>> {
	public EndstoneGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelEndstoneGolem(context.bakeLayer(ModelEndstoneGolem.LAYER_LOCATION)), 1.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(EndstoneGolemEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/endstone_golem.png");
	}
}
