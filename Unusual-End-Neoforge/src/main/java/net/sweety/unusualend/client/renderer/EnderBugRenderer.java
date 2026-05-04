
package net.sweety.unusualend.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelFlampyr;
import net.sweety.unusualend.entity.FlampyrEntity;

public class EnderBugRenderer extends MobRenderer<FlampyrEntity, ModelFlampyr<FlampyrEntity>> {
	public EnderBugRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFlampyr(context.bakeLayer(ModelFlampyr.LAYER_LOCATION)), 0.4f);
		this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(UnusualEnd.makeUEID("textures/entities/ender_firefly_glow_layer.png"));
            }
        });
	}

	protected void scale(FlampyrEntity entity, PoseStack posestack, float partialTicks) {
		posestack.scale(entity.getScale(), entity.getScale(), entity.getScale());
	}

	@Override
	public ResourceLocation getTextureLocation(FlampyrEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/ender_firefly.png");
	}
}
