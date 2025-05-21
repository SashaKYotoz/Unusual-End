
package net.mcreator.unusualend.client.renderer;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.unusualend.entity.SummonedDraglingEntity;
import net.mcreator.unusualend.client.model.Modeltameddragling;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SummonedDraglingRenderer extends MobRenderer<SummonedDraglingEntity, Modeltameddragling<SummonedDraglingEntity>> {
	public SummonedDraglingRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltameddragling(context.bakeLayer(Modeltameddragling.LAYER_LOCATION)), 0.4f);
		this.addLayer(new RenderLayer<>(this) {
            final ResourceLocation LAYER_TEXTURE = UnusualEnd.makeUEID("textures/entities/tamed_dragling_glow_layer.png");

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SummonedDraglingEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
                this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
            }
        });
	}

	@Override
	public ResourceLocation getTextureLocation(SummonedDraglingEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/tamed_dragling.png");
	}
}
