package net.mcreator.unusualend.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ModelBabyGlub<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("unusualend", "baby_glub"), "main");
    private final ModelPart body;
    private final ModelPart tentacles;

    public ModelBabyGlub(ModelPart root) {
        this.body = root.getChild("body");
        this.tentacles = root.getChild("tentacles");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.8F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.8F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 5).addBox(0.25F, -0.5F, -2.5F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.7F, 2.5F, 1.5708F, -1.0472F, -1.5708F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 6).addBox(-0.25F, -0.5F, -2.5F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.7F, -2.5F, -1.5708F, -1.0472F, 1.5708F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 7).addBox(0.25F, -0.5F, -2.5F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 2.7F, 0.0F, 0.0F, 0.0F, -0.5236F));

        PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 8).addBox(-0.25F, -0.5F, -2.5F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 2.7F, 0.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition tentacles = partdefinition.addOrReplaceChild("tentacles", CubeListBuilder.create(), PartPose.offset(0.0F, 17.75F, 0.0F));

        PartDefinition cube_r5 = tentacles.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 16).addBox(-3.5F, 1.0F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r6 = tentacles.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 16).addBox(-3.5F, 1.0F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.tentacles.zRot = (Mth.sin(ageInTicks * 0.35F) * 0.2F);
        this.tentacles.xRot = (Mth.sin(ageInTicks * 0.2F + 2) * 0.1F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        tentacles.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}