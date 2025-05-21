
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.entity.BlockUpdaterEntity;
import net.mcreator.unusualend.client.model.Modelstructure_spawn;

public class BlockUpdaterRenderer extends MobRenderer<BlockUpdaterEntity, Modelstructure_spawn<BlockUpdaterEntity>> {
	public BlockUpdaterRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstructure_spawn(context.bakeLayer(Modelstructure_spawn.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlockUpdaterEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/structure_spawn.png");
	}
}
