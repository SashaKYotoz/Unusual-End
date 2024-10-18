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
public class Modelbluk<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("unusualend", "modelbluk"), "main");
	public final ModelPart body;
	public final ModelPart tail;
	public final ModelPart left_fin;
	public final ModelPart right_fin;

	public Modelbluk(ModelPart root) {
		this.body = root.getChild("body");
		this.tail = root.getChild("tail");
		this.left_fin = root.getChild("left_fin");
		this.right_fin = root.getChild("right_fin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition
				.addOrReplaceChild(
						"body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -7.0F, -6.0F, 4.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 26).addBox(2.0F, -6.0F, -5.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
								.mirror().addBox(-3.0F, -6.0F, -5.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 12).addBox(0.0F, -9.0F, -3.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(0.5F, 0.25F, -8.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, 0.0F, 0.0F, -0.6109F));
		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, 0.25F, -8.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, 0.0F, 0.0F, 0.6109F));
		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -7.0F, 4.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition left_fin = partdefinition.addOrReplaceChild("left_fin", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 20.0F, -2.0F, 0.0F, 0.5236F, 0.0F));
		PartDefinition cube_r3 = left_fin.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 11).addBox(0.052F, -2.0F, 1.3702F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.352F, 0.0F, -1.3702F, 0.0F, 0.2182F, 0.0F));
		PartDefinition right_fin = partdefinition.addOrReplaceChild("right_fin", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 20.0F, -2.0F, 0.0F, -0.5236F, 0.0F));
		PartDefinition cube_r4 = right_fin.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 11).mirror().addBox(-0.052F, -2.0F, 1.3702F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.352F, 0.0F, -1.3702F, 0.0F, -0.2182F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.left_fin.yRot = (Mth.sin(ageInTicks * 0.05F + 3) * 0.4F) + 0.2F;
		this.tail.yRot = (Mth.sin(ageInTicks * 0.2F + 2) * 0.1F);
		this.right_fin.yRot = (Mth.sin(ageInTicks * 0.05F) * 0.4F) - 0.2F;
	}
}
