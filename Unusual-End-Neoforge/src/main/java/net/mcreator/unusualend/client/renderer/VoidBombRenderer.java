
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.entity.VoidBombEntity;
import net.mcreator.unusualend.client.model.Modelvoid_explosive;

public class VoidBombRenderer extends MobRenderer<VoidBombEntity, Modelvoid_explosive<VoidBombEntity>> {
	public VoidBombRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelvoid_explosive(context.bakeLayer(Modelvoid_explosive.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(VoidBombEntity entity) {
		if (entity.getPersistentData().getBoolean("isWhite"))
			return UnusualEnd.makeUEID("textures/entities/primed_void_explosive.png");
		return UnusualEnd.makeUEID("textures/entities/void_explosive.png");
	}
}
