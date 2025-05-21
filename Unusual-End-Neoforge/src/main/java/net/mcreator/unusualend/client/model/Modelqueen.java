package net.mcreator.unusualend.client.model;

import net.mcreator.unusualend.UnusualEnd;
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

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelqueen<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(UnusualEnd.makeUEID("modelqueen"), "main");
	public final ModelPart tail;
	public final ModelPart body;
	public final ModelPart right_wings;
	public final ModelPart left_wing;
	public final ModelPart left_arm;
	public final ModelPart right_arm;
	public final ModelPart head;

	public Modelqueen(ModelPart root) {
		this.tail = root.getChild("tail");
		this.body = root.getChild("body");
		this.right_wings = root.getChild("right_wings");
		this.left_wing = root.getChild("left_wing");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition tail = partdefinition.addOrReplaceChild("tail",
				CubeListBuilder.create().texOffs(0, 41).addBox(-8.0F, 9.0F, 2.0F, 16.0F, 15.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(104, 58).addBox(-6.0F, 14.0F, 21.0F, 12.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.0F, 2.0F));
		PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(70, 88).addBox(-6.0F, -3.5F, -6.0F, 12.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.184F, -2.5067F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -11.0F, -9.5F, 18.0F, 22.0F, 19.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.0209F, 3.5042F, 0.3927F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(59, 26).addBox(-7.0F, -8.5F, -8.5F, 14.0F, 17.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.6511F, 0.3145F));
		PartDefinition right_wings = partdefinition.addOrReplaceChild("right_wings", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.25F, -6.0F, 6.25F, 0.0F, 0.0873F, 0.0F));
		PartDefinition cube_r3 = right_wings.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 88).addBox(-34.459F, -10.0652F, 0.5455F, 35.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0512F, 0.2096F, 0.1873F));
		PartDefinition cube_r4 = right_wings.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(55, 0).addBox(-17.1262F, -6.9555F, -0.9264F, 35.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-13.8955F, -5.2043F, 6.2448F, -0.0349F, 0.2967F, -0.1396F));
		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offsetAndRotation(1.25F, -6.0F, 6.25F, 0.0F, -0.0873F, 0.0F));
		PartDefinition cube_r5 = left_wing.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 88).mirror().addBox(-1.541F, -10.0652F, 0.7955F, 35.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0512F, -0.2096F, -0.1873F));
		PartDefinition cube_r6 = left_wing.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(55, 0).mirror().addBox(-16.8738F, -5.4555F, -0.9264F, 35.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(12.8108F, -6.6511F, 5.9029F, -0.0349F, -0.2967F, 0.1396F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(7.5F, -15.0F, 2.0F, 0.0076F, 0.0433F, 0.0873F));
		PartDefinition cube_r7 = left_arm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 76).addBox(0.8614F, -22.9567F, -0.9939F, 17.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 14.0025F, -8.6067F, -3.1416F, 1.0472F, 1.5708F));
		PartDefinition cube_r8 = left_arm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 102).addBox(-1.9332F, -5.1079F, -3.3628F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.0F, 3.0F, -3.0F, -3.1416F, 0.6109F, 1.5708F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.5F, -15.0F, 2.0F, 0.0076F, -0.0433F, -0.0873F));
		PartDefinition cube_r9 = right_arm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 102).mirror().addBox(-14.0668F, -5.1079F, -3.3628F, 16.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(15.0F, 3.0F, -3.0F, -3.1416F, -0.6109F, -1.5708F));
		PartDefinition cube_r10 = right_arm.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 76).mirror().addBox(-17.8614F, -22.9567F, -0.9939F, 17.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.0F, 14.0025F, -8.6067F, -3.1416F, -1.0472F, -1.5708F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(57, 61).addBox(-8.0F, -6.0F, -8.5F, 16.0F, 12.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -21.1511F, -6.6855F));
		PartDefinition cube_r11 = head.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(4, 0).addBox(-5.5F, -5.5F, 1.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(3.5F, -5.5F, 1.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -9.0501F, 0.2724F, -1.0472F, 0.0F, 0.0F));
		PartDefinition cube_r12 = head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(74, 15).addBox(-7.0F, -5.0F, -0.75F, 14.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 9.5F, -8.5F, -0.829F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wings.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// this.root().getAllParts().forEach(ModelPart::resetPose);
		// this.animate(entity.idleAnim, EnderblobQueenAnimation.idle, ageInTicks);
		if (!(entity.getDeltaMovement().x() == 0 && entity.getDeltaMovement().z() == 0)) {
			this.tail.xRot = (Mth.sin(ageInTicks * 0.1F + 2) * 0.05F) + ((headPitch * 0.017453292F) / 2);
			this.tail.zRot = (Mth.sin(ageInTicks * 0.2F + 2) * 0.05F);
			this.tail.yRot = ((netHeadYaw * 0.017453292F) / 2);
		}
		if (entity.isSprinting()) {
			this.right_arm.yRot = (Mth.sin(ageInTicks * -1F) * 0.4F);
			this.left_arm.yRot = (Mth.sin(ageInTicks * 1F) * 0.4F);
			this.left_arm.xRot = 0;
			this.right_arm.xRot = 0;
		} else {
			this.left_arm.xRot = (Mth.sin(ageInTicks * 0.05F) * 0.15F);
			this.right_arm.xRot = (Mth.sin(ageInTicks * 0.05F) * 0.15F);
			this.left_arm.yRot = 0;
			this.right_arm.yRot = 0;
		}
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_wings.yRot = 0.2F + (Mth.sin(ageInTicks * 0.15F + 2) * 0.05F);
		this.left_wing.yRot = -0.2F + (Mth.sin(ageInTicks * 0.15F + 5) * 0.05F);
		this.right_wings.zRot = 0.2F + (Mth.sin(ageInTicks * 0.15F + 2) * 0.05F);
		this.left_wing.zRot = -0.2F + (Mth.sin(ageInTicks * 0.15F + 5) * 0.05F);
	}

	public ModelPart root() {
		return this.body;
	}
}
