package net.mcreator.unusualend.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.unusualend.entity.BolokEntity;
import net.mcreator.unusualend.procedures.EndMathProcedure;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ModelBabyBolok<T extends BolokEntity> extends ModelBolok<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("unusualend", "model_baby_bolok"), "main");
    private final ModelPart body;
    private final ModelPart left_fin;
    private final ModelPart right_fin;
    private final ModelPart fin_back;
    private final ModelPart tail;

    public ModelBabyBolok(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.left_fin = root.getChild("left_fin");
        this.right_fin = root.getChild("right_fin");
        this.fin_back = root.getChild("fin_back");
        this.tail = root.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(7, 0).addBox(-3.0F, 3.5F, -7.0F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 1.0F));

        PartDefinition left_fin = partdefinition.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(6, 16).addBox(-0.5872F, -1.4962F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3487F, 23.0381F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition right_fin = partdefinition.addOrReplaceChild("right_fin", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, 23.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition right_fin_r1 = right_fin.addOrReplaceChild("right_fin_r1", CubeListBuilder.create().texOffs(6, 16).addBox(-2.4335F, -7.4753F, -6.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8463F, -7.9715F, 3.0F, 0.0F, 0.0F, -3.1416F));

        PartDefinition fin_back = partdefinition.addOrReplaceChild("fin_back", CubeListBuilder.create().texOffs(32, 1).addBox(0.0F, -6.5F, -7.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 3.0F));

        PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(3, -6).addBox(0.0F, -4.5F, -2.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 5.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(BolokEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.left_fin.zRot = Mth.cos(limbSwing) * -1.0F * limbSwingAmount;
        this.right_fin.zRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.tail.yRot = (EndMathProcedure.sin(ageInTicks * 0.15F + 2) * 0.1F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        fin_back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}