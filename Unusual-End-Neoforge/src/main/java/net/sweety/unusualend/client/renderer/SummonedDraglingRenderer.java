
package net.sweety.unusualend.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelTamedDragling;
import net.sweety.unusualend.entity.SummonedDraglingEntity;

public class SummonedDraglingRenderer extends MobRenderer<SummonedDraglingEntity, ModelTamedDragling<SummonedDraglingEntity>> {
	public SummonedDraglingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelTamedDragling(context.bakeLayer(ModelTamedDragling.LAYER_LOCATION)), 0.4f);
		this.addLayer(new RenderLayer<>(this) {
            final ResourceLocation LAYER_TEXTURE = UnusualEnd.makeUEID("textures/entities/tamed_dragling_glow_layer.png");

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SummonedDraglingEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
                this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
            }
        });
	}

	@Override
	public ResourceLocation getTextureLocation(SummonedDraglingEntity entity) {
		return UnusualEnd.makeUEID("textures/entities/tamed_dragling.png");
	}
}
