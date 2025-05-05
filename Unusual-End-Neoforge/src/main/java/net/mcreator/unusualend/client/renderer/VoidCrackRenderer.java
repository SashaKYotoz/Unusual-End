
package net.mcreator.unusualend.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.unusualend.procedures.ReturnTrueProcedure;
import net.mcreator.unusualend.entity.VoidCrackEntity;
import net.mcreator.unusualend.client.model.Modelstructure_spawn;

public class VoidCrackRenderer extends MobRenderer<VoidCrackEntity, Modelstructure_spawn<VoidCrackEntity>> {
	public VoidCrackRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstructure_spawn(context.bakeLayer(Modelstructure_spawn.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(VoidCrackEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/structure_spawn.png");
	}

	@Override
	protected boolean isBodyVisible(VoidCrackEntity entity) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return !ReturnTrueProcedure.execute();
	}
}
