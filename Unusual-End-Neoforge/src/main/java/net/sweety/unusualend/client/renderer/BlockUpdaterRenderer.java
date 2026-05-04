
package net.sweety.unusualend.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelStructureSpawn;
import net.sweety.unusualend.entity.BlockUpdaterEntity;

public class BlockUpdaterRenderer extends MobRenderer<BlockUpdaterEntity, ModelStructureSpawn<BlockUpdaterEntity>> {
	public BlockUpdaterRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelStructureSpawn(context.bakeLayer(ModelStructureSpawn.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlockUpdaterEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/structure_spawn.png");
	}
}
