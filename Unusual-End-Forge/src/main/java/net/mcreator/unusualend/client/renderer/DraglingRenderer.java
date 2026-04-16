
package net.mcreator.unusualend.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.unusualend.client.model.ModelDragling;
import net.mcreator.unusualend.entity.DraglingEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class DraglingRenderer extends MobRenderer<DraglingEntity, ModelDragling<DraglingEntity>> {
	public DraglingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDragling(context.bakeLayer(ModelDragling.LAYER_LOCATION)), 0.4f);
		this.addLayer(new RenderLayer<DraglingEntity, ModelDragling<DraglingEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("unusualend:textures/entities/dragling_glow_layer.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, DraglingEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(DraglingEntity entity) {
		return new ResourceLocation("unusualend:textures/entities/dragling.png");
	}
}
