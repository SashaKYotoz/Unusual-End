package net.mcreator.unusualend.client.model;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.world.entity.Entity;
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

import net.mcreator.unusualend.procedures.EndMathProcedure;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.7.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelender_firefly<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(UnusualEnd.makeUEID("modelender_firefly"), "main");
	public final ModelPart torso;
	public final ModelPart left_wing;
	public final ModelPart right_wing;

	public Modelender_firefly(ModelPart root) {
		this.torso = root.getChild("torso");
		this.left_wing = root.getChild("left_wing");
		this.right_wing = root.getChild("right_wing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(17, 53).addBox(-2.0F, -3.25F, -6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition right_leg_r1 = torso.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(0, 57).addBox(-3.0F, -3.25F, -3.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.1642F, 0.0594F, 0.3442F));
		PartDefinition right_leg_r2 = torso.addOrReplaceChild("right_leg_r2", CubeListBuilder.create().texOffs(0, 57).addBox(3.0F, -3.25F, -3.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.1666F, -0.0522F, -0.3011F));
		PartDefinition antenna_r1 = torso.addOrReplaceChild("antenna_r1", CubeListBuilder.create().texOffs(-2, 59).addBox(0.0F, -0.75F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -3.25F, -7.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition torso_r1 = torso.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(1, 31).addBox(-1.5F, -8.0F, 1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 20)
				.addBox(-2.5F, -9.0F, 1.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(3, 42).addBox(-2.5F, -9.0F, -5.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 1.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(1.5F, 15.5F, -2.0F));
		PartDefinition left_wing_r1 = left_wing.addOrReplaceChild("left_wing_r1", CubeListBuilder.create().texOffs(25, 40).addBox(-1.5F, 0.25F, -4.0F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.5F, 4.0F, -0.1745F, 0.0F, -0.1745F));
		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-1.5F, 15.5F, -2.0F));
		PartDefinition right_wing_r1 = right_wing.addOrReplaceChild("right_wing_r1", CubeListBuilder.create().texOffs(14, 35).addBox(-6.25F, 0.25F, -4.0F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.25F, 0.5F, 4.0F, -0.1745F, 0.0F, 0.1745F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_wing.zRot = (EndMathProcedure.sin(ageInTicks * 0.6F) * 0.6F);
		this.left_wing.zRot = (EndMathProcedure.sin(ageInTicks * 0.6F + 3) * 0.6F);
	}
}
