package net.mcreator.unusualend.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelenderling<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("unusualend", "modelenderling"), "main");
	public final ModelPart head2;
	public final ModelPart body;
	public final ModelPart right_wing2;
	public final ModelPart left_wing2;

	public Modelenderling(ModelPart root) {
		this.head2 = root.getChild("head2");
		this.body = root.getChild("body");
		this.right_wing2 = root.getChild("right_wing2");
		this.left_wing2 = root.getChild("left_wing2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, -2.0F));
		PartDefinition head2_r1 = head2.addOrReplaceChild("head2_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-4.0F, -1.9569F, -1.0227F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.5F, -0.5F, 1.6144F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 16.5F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -0.0837F, -7.7945F, 8.0F, 5.0F, 17.0F, new CubeDeformation(-0.1F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition right_wing2 = partdefinition.addOrReplaceChild("right_wing2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 9.25F, -0.5F, 1.5708F, 0.0F, 0.0F));
		PartDefinition arm4_r1_r1 = right_wing2.addOrReplaceChild("arm4_r1_r1", CubeListBuilder.create().texOffs(33, 0).addBox(-0.9F, -0.9695F, -7.8824F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, -0.4363F, 0.0F, 0.0F));
		PartDefinition left_wing2 = partdefinition.addOrReplaceChild("left_wing2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 9.25F, -0.5F, 1.5708F, 0.0F, 0.0F));
		PartDefinition arm5_r1_r1 = left_wing2.addOrReplaceChild("arm5_r1_r1", CubeListBuilder.create().texOffs(20, 26).addBox(-1.1F, -1.3536F, -7.9393F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, -0.7854F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_wing2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.head2.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head2.xRot = headPitch / (180F / (float) Math.PI);
		this.left_wing2.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
