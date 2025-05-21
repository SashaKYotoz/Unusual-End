
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.unusualend.entity.EnderBugEntity;
import net.mcreator.unusualend.client.model.Modelender_firefly;

import com.mojang.blaze3d.vertex.PoseStack;

public class EnderBugRenderer extends MobRenderer<EnderBugEntity, Modelender_firefly<EnderBugEntity>> {
	public EnderBugRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelender_firefly(context.bakeLayer(Modelender_firefly.LAYER_LOCATION)), 0.4f);
		this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(UnusualEnd.makeUEID("textures/entities/ender_firefly_glow_layer.png"));
            }
        });
	}

	protected void scale(EnderBugEntity entity, PoseStack posestack, float partialTicks) {
		posestack.scale(entity.getScale(), entity.getScale(), entity.getScale());
	}

	@Override
	public ResourceLocation getTextureLocation(EnderBugEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/ender_firefly.png");
	}
}
