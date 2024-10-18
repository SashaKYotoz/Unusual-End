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
public class Modelsmall_enderbulb<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("unusualend", "modelsmall_enderbulb"), "main");
	public final ModelPart small_enderbulb;

	public Modelsmall_enderbulb(ModelPart root) {
		this.small_enderbulb = root.getChild("small_enderbulb");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition small_enderbulb = partdefinition.addOrReplaceChild("small_enderbulb", CubeListBuilder.create(), PartPose.offset(0.0181F, 21.0F, -0.0035F));
		PartDefinition cube_r1 = small_enderbulb.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(26, 30).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		small_enderbulb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.small_enderbulb.xRot = (Mth.sin(ageInTicks * 0.3F + 2) * 0.05F) + ((headPitch * 0.017453292F) / 2);
		this.small_enderbulb.zRot = (Mth.sin(ageInTicks * 0.6F + 2) * 0.05F);
		this.small_enderbulb.yRot = ((netHeadYaw * 0.017453292F) / 2);
	}
}
