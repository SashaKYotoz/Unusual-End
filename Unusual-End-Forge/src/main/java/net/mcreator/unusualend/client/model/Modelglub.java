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

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelglub<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("unusualend", "modelglub"), "main");
	public final ModelPart body;
	public final ModelPart tentacle1;
	public final ModelPart tentacle2;
	public final ModelPart tentacle3;
	public final ModelPart tentacle4;
	public final ModelPart middle_tentacle;

	public Modelglub(ModelPart root) {
		this.body = root.getChild("body");
		this.tentacle1 = root.getChild("tentacle1");
		this.tentacle2 = root.getChild("tentacle2");
		this.tentacle3 = root.getChild("tentacle3");
		this.tentacle4 = root.getChild("tentacle4");
		this.middle_tentacle = root.getChild("middle_tentacle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -15.0F, -6.0F, 12.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(6, 3)
				.addBox(-6.0F, -12.0F, -6.15F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(1, 7).addBox(3.0F, -12.0F, -6.15F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 62).mirror().addBox(-5.75F, -0.25F, 0.0F, 11.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-5.75F, -6.0F, -0.25F, 0.0F, 1.5708F, 0.7854F));
		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 62).addBox(-5.25F, -0.25F, 0.0F, 11.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.75F, -6.0F, -0.25F, 0.0F, -1.5708F, -0.7854F));
		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 62).addBox(-5.75F, -0.25F, 0.0F, 11.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.25F, -6.0F, 5.75F, 2.3562F, 0.0F, -3.1416F));
		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 62).addBox(-5.25F, -0.25F, 0.0F, 11.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.25F, -6.0F, -5.75F, -0.7854F, 0.0F, 0.0F));
		PartDefinition tentacle1 = partdefinition.addOrReplaceChild("tentacle1", CubeListBuilder.create(), PartPose.offset(-4.0F, 18.0F, 0.0F));
		PartDefinition cube_r5 = tentacle1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(24, 9).mirror().addBox(-2.0F, 0.75F, -6.0F, 0.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, -0.75F, 0.0F, 0.0F, 0.0F, 0.2182F));
		PartDefinition tentacle2 = partdefinition.addOrReplaceChild("tentacle2", CubeListBuilder.create(), PartPose.offset(4.0F, 18.0F, 0.0F));
		PartDefinition cube_r6 = tentacle2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 9).addBox(2.0F, 0.75F, -6.0F, 0.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -0.75F, 0.0F, 0.0F, 0.0F, -0.2182F));
		PartDefinition tentacle3 = partdefinition.addOrReplaceChild("tentacle3", CubeListBuilder.create(), PartPose.offset(0.0F, 18.25F, 4.0F));
		PartDefinition cube_r7 = tentacle3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 18).addBox(0.052F, -0.4633F, -6.0F, 0.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.25F, 0.0F, 1.5708F, -1.3526F, -1.5708F));
		PartDefinition tentacle4 = partdefinition.addOrReplaceChild("tentacle4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 18.25F, -4.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r8 = tentacle4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(-0.052F, 9.2867F, -6.0F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r9 = tentacle4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 9).addBox(0.052F, 9.2867F, -6.0F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition middle_tentacle = partdefinition.addOrReplaceChild("middle_tentacle", CubeListBuilder.create().texOffs(0, 39).addBox(-6.0F, 5.5F, 1.0F, 12.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.5F, -1.0F));
		PartDefinition cube_r10 = middle_tentacle.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(36, 0).addBox(-6.0F, -4.5F, 0.0F, 12.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, 1.0F, 0.0F, 1.5708F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		middle_tentacle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tentacle1.zRot = (Mth.sin(ageInTicks * 0.35F) * 0.2F);
		this.middle_tentacle.xRot = (Mth.sin(ageInTicks * 0.2F + 2) * 0.1F);
		this.tentacle4.xRot = (Mth.sin(ageInTicks * 0.35F + 2) * 0.2F);
		this.tentacle2.zRot = (Mth.sin(ageInTicks * 0.35F + 3) * 0.2F);
		this.tentacle3.xRot = (Mth.sin(ageInTicks * 0.35F + 2) * 0.2F);
	}
}
