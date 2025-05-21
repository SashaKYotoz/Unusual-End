package net.mcreator.unusualend.client.model;

import net.mcreator.unusualend.UnusualEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.unusualend.entity.EndstoneGolemEntity;

import custom.mcreator.unusualend.client.animation.endstonegolemAnimation;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelendstonegolem<T extends EndstoneGolemEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(UnusualEnd.makeUEID("modelendstonegolem"), "main");
	public final ModelPart all;
	public final ModelPart head;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart left_leg;
	public final ModelPart right_leg;
	public final ModelPart lower_body;
	public final ModelPart upper_body;

	public Modelendstonegolem(ModelPart root) {
		this.all = root.getChild("all");
		this.head = all.getChild("head");
		this.right_arm = all.getChild("right_arm");
		this.left_arm = all.getChild("left_arm");
		this.left_leg = all.getChild("left_leg");
		this.right_leg = all.getChild("right_leg");
		this.lower_body = all.getChild("lower_body");
		this.upper_body = all.getChild("upper_body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition head = all.addOrReplaceChild("head", CubeListBuilder.create().texOffs(72, 65).addBox(-6.0F, -3.5F, -4.9F, 12.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
				.addBox(6.0F, -9.0F, -1.4F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(9, 9).addBox(9.0F, -9.0F, -1.4F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -48.5F, 0.9F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, -8.0F, 0.1F, 0.0F, 3.1416F, 0.0F));
		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 42).addBox(-2.0F, -9.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.6F, 0.0F, 3.1416F, 0.0F));
		PartDefinition right_arm = all.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 65).mirror().addBox(-9.5F, -6.0F, -4.5F, 9.0F, 40.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-17.5F, -42.0F, 0.5F));
		PartDefinition left_arm = all.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(36, 65).addBox(0.5F, -6.0F, -4.5F, 9.0F, 40.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(90, 0).addBox(4.5F, -10.0F, -4.5F, 5.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(17.5F, -42.0F, 0.5F));
		PartDefinition left_leg = all.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(72, 81).addBox(-4.0F, 6.0F, -4.0F, 8.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -19.0F, 0.0F));
		PartDefinition right_leg = all.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(72, 81).mirror().addBox(-4.0F, 6.0F, -4.0F, 8.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -19.0F, 0.0F));
		PartDefinition lower_body = all.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(0, 42).addBox(-9.0F, -21.0F, -7.0F, 28.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 0.0F));
		PartDefinition upper_body = all.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(0, 0).addBox(-35.0F, -33.0F, -12.0F, 36.0F, 24.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(17.0F, -12.0F, 3.0F));
		PartDefinition cube_r3 = upper_body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(70, 42).addBox(-9.0F, -7.0F, -1.0F, 10.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -33.0F, 0.0F, 0.0F, 0.4363F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.attackAnimationState, endstonegolemAnimation.ATTACK, ageInTicks);
		this.animate(entity.pushAnimationState, endstonegolemAnimation.PUSH, ageInTicks);
		this.animate(entity.idleAnimationState, endstonegolemAnimation.IDLE, ageInTicks);
		if (!entity.isInWaterOrBubble()) {
			this.animateWalk(endstonegolemAnimation.WALK, limbSwing, limbSwingAmount, 2.0F, 4.0F);
		}
	}

	@Override
	public ModelPart root() {
		return this.all;
	}

	private record ModelParts(ModelPart all) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
