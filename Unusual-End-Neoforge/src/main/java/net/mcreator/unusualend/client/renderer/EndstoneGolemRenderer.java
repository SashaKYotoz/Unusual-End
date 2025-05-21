
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.entity.EndstoneGolemEntity;
import net.mcreator.unusualend.client.model.Modelendstonegolem;

public class EndstoneGolemRenderer extends MobRenderer<EndstoneGolemEntity, Modelendstonegolem<EndstoneGolemEntity>> {
	public EndstoneGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelendstonegolem(context.bakeLayer(Modelendstonegolem.LAYER_LOCATION)), 1.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(EndstoneGolemEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/endstone_golem.png");
	}
}
