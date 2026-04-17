
package net.mcreator.unusualend.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.unusualend.client.model.ModelBabyFlampyr;
import net.mcreator.unusualend.client.model.ModelFlampyr;
import net.mcreator.unusualend.entity.FlampyrEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class FlampyrRenderer extends MobRenderer<FlampyrEntity, ModelFlampyr<FlampyrEntity>> {
    private final ModelFlampyr<FlampyrEntity> baseModel;
    private final ModelBabyFlampyr<FlampyrEntity> babyModel;
    private final ResourceLocation FLAMPYR = new ResourceLocation("unusualend:textures/entities/flampyr.png");
    private final ResourceLocation BABY_FLAMPYR = new ResourceLocation("unusualend:textures/entities/baby_flampyr.png");
    private final ResourceLocation GLOWING_FLAMPYR = new ResourceLocation("unusualend:textures/entities/flampyr_glow_layer.png");
    private final ResourceLocation GLOWING_BABY_FLAMPYR = new ResourceLocation("unusualend:textures/entities/baby_flampyr_glow.png");

    public FlampyrRenderer(EntityRendererProvider.Context context) {
        super(context, new ModelFlampyr(context.bakeLayer(ModelFlampyr.LAYER_LOCATION)), 0.4f);
        this.baseModel = new ModelFlampyr<>(context.bakeLayer(ModelFlampyr.LAYER_LOCATION));
        this.babyModel = new ModelBabyFlampyr<>(context.bakeLayer(ModelBabyFlampyr.LAYER_LOCATION));
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public void render(PoseStack stack, MultiBufferSource source, int i, FlampyrEntity entity, float p_116987_, float p_116988_, float p_116989_, float p_116990_, float p_116991_, float p_116992_) {
                VertexConsumer vertexconsumer = entity.isBaby() ? source.getBuffer(RenderType.eyes(GLOWING_BABY_FLAMPYR)) : source.getBuffer(this.renderType());
                this.getParentModel().renderToBuffer(stack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            }

            @Override
            public RenderType renderType() {
                return RenderType.eyes(GLOWING_FLAMPYR);
            }
        });
    }

    @Override
    public void render(FlampyrEntity entity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.model = entity.isBaby() ? babyModel : baseModel;
        super.render(entity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(FlampyrEntity entity) {
        return entity.isBaby() ? BABY_FLAMPYR : FLAMPYR;
    }
}
