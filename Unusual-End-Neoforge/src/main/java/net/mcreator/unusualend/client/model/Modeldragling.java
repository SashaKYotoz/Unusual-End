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

import net.mcreator.unusualend.entity.DraglingEntity;

import custom.mcreator.unusualend.client.animation.draglingAnimation;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeldragling<T extends DraglingEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(UnusualEnd.makeUEID("modeldragling"), "main");
	public final ModelPart all;
	public final ModelPart head;
	public final ModelPart main_body;
	public final ModelPart body;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart left_wing;
	public final ModelPart right_wing;

	public Modeldragling(ModelPart root) {
		this.all = root.getChild("all");
		this.head = all.getChild("head");
		this.main_body = all.getChild("main_body");
		this.body = main_body.getChild("body");
		this.right_arm = main_body.getChild("right_arm");
		this.left_arm = main_body.getChild("left_arm");
		this.left_wing = main_body.getChild("left_wing");
		this.right_wing = main_body.getChild("right_wing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition head = all.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(23, 12).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.25F, -4.0F, 1.0F, -0.8271F, 0.0643F, 0.059F));
		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(23, 12).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.25F, -4.0F, 1.0F, -0.8271F, -0.0643F, -0.059F));
		PartDefinition main_body = all.addOrReplaceChild("main_body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition body = main_body.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 10).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 16).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition right_arm = main_body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-1.75F, 0.5F, 0.0F));
		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(23, 0).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.25F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.2182F));
		PartDefinition left_arm = main_body.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(1.75F, 0.5F, 0.0F));
		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(-0.5F, -0.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.25F, 0.0F, 0.0F, -0.3927F, 0.0F, -0.2182F));
		PartDefinition left_wing = main_body.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(0.5F, 0.75F, 1.0F));
		PartDefinition left_wing_r1 = left_wing.addOrReplaceChild("left_wing_r1", CubeListBuilder.create().texOffs(16, 14).addBox(0.0F, -1.5F, 0.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.2182F, 0.7418F, 0.0F));
		PartDefinition right_wing = main_body.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.75F, 1.0F));
		PartDefinition right_wing_r1 = right_wing.addOrReplaceChild("right_wing_r1", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(0.0F, -1.5F, 0.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.2182F, -0.7418F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.attackAnimationState, draglingAnimation.ATTACK, ageInTicks);
		this.animate(entity.idleAnimationState, draglingAnimation.IDLE, ageInTicks);
		if (!entity.isInWaterOrBubble()) {
			this.animateWalk(draglingAnimation.FLY, limbSwing, limbSwingAmount, 2.0F, 4.0F);
		}
	}

	@Override
	public ModelPart root() {
		return this.all;
	}

	private record ModelParts(ModelPart main_body) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
