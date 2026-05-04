
package net.sweety.unusualend.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.client.model.ModelBabyGlub;
import net.sweety.unusualend.client.model.ModelGlub;
import net.sweety.unusualend.entity.GlubEntity;

public class GlubRenderer extends MobRenderer<GlubEntity, EntityModel<GlubEntity>> {
    private final ModelGlub<GlubEntity> baseModel;
    private final ModelBabyGlub<GlubEntity> babyModel;
    private final ResourceLocation GLUB = UnusualEnd.makeUEID("textures/entities/glub.png");
    private final ResourceLocation BABY_GLUB = UnusualEnd.makeUEID("textures/entities/baby_glub.png");
	public GlubRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGlub<>(context.bakeLayer(ModelGlub.LAYER_LOCATION)), 0.3f);
        this.baseModel = new ModelGlub<>(context.bakeLayer(ModelGlub.LAYER_LOCATION));
        this.babyModel = new ModelBabyGlub<>(context.bakeLayer(ModelBabyGlub.LAYER_LOCATION));
	}

    @Override
    public void render(GlubEntity entity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.model = entity.isBaby() ? babyModel : baseModel;
        super.render(entity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

	@Override
	public ResourceLocation getTextureLocation(GlubEntity entity) {
		return entity.isBaby() ? BABY_GLUB : GLUB;
	}
}
