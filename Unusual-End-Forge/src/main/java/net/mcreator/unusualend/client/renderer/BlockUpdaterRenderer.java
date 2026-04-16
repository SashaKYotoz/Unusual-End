
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.client.model.ModelStructureSpawn;
import net.mcreator.unusualend.entity.BlockUpdaterEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BlockUpdaterRenderer extends MobRenderer<BlockUpdaterEntity, ModelStructureSpawn<BlockUpdaterEntity>> {
	public BlockUpdaterRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelStructureSpawn(context.bakeLayer(ModelStructureSpawn.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlockUpdaterEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/structure_spawn.png");
	}
}
