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

import net.mcreator.unusualend.procedures.EndMathProcedure;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelbolok<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("unusualend", "modelbolok"), "main");
	public final ModelPart body;
	public final ModelPart left_fin;
	public final ModelPart right_fin;
	public final ModelPart fin_back;
	public final ModelPart tail;

	public Modelbolok(ModelPart root) {
		this.body = root.getChild("body");
		this.left_fin = root.getChild("left_fin");
		this.right_fin = root.getChild("right_fin");
		this.fin_back = root.getChild("fin_back");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 3.5F, -7.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, -2.0F));
		PartDefinition left_fin = partdefinition.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(18, 23).addBox(0.5F, -0.5F, -2.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3487F, 21.0381F, -3.0F, 0.0F, 0.0F, 0.0873F));
		PartDefinition right_fin = partdefinition.addOrReplaceChild("right_fin", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.5F, 21.0F, -3.0F, 0.0F, 0.0F, -0.0873F));
		PartDefinition right_fin_r1 = right_fin.addOrReplaceChild("right_fin_r1", CubeListBuilder.create().texOffs(0, 28).addBox(-1.3463F, -8.4715F, -5.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.8463F, -7.9715F, 3.0F, 0.0F, 0.0F, -3.1416F));
		PartDefinition fin_back = partdefinition.addOrReplaceChild("fin_back", CubeListBuilder.create().texOffs(18, 12).addBox(0.0F, -7.5F, -7.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));
		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -4.5F, 1.0F, 0.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 2.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		fin_back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.left_fin.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_fin.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.tail.yRot = (EndMathProcedure.sin(ageInTicks * 0.2F + 2) * 0.1F);
	}
}
