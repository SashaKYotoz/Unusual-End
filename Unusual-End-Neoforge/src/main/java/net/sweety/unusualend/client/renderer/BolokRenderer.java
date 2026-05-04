
package net.sweety.unusualend.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelBabyBolok;
import net.sweety.unusualend.client.model.ModelBolok;
import net.sweety.unusualend.entity.BolokEntity;

public class BolokRenderer extends MobRenderer<BolokEntity, ModelBolok<BolokEntity>> {
    private final ModelBolok<BolokEntity> baseModel;
    private final ModelBabyBolok<BolokEntity> babyModel;
    private final ResourceLocation BOLOK = UnusualEnd.makeUEID("textures/entities/bolok.png");
    private final ResourceLocation BABY_BOLOK = UnusualEnd.makeUEID("textures/entities/baby_bolok.png");
	public BolokRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBolok<>(context.bakeLayer(ModelBolok.LAYER_LOCATION)), 0.4f);
        this.baseModel = new ModelBolok<>(context.bakeLayer(ModelBolok.LAYER_LOCATION));
        this.babyModel = new ModelBabyBolok<>(context.bakeLayer(ModelBabyBolok.LAYER_LOCATION));
    }

    @Override
    public void render(BolokEntity entity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.model = entity.isBaby() ? babyModel : baseModel;
        super.render(entity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    protected void scale(BolokEntity entity, PoseStack posestack, float partialTicks) {
        float scale = entity.isBaby() ? 0.75f : 1.0F;
        posestack.scale(scale, scale, scale);
    }

	@Override
	public ResourceLocation getTextureLocation(BolokEntity entity) {
		return entity.isBaby() ? BABY_BOLOK : BOLOK;
	}
}
