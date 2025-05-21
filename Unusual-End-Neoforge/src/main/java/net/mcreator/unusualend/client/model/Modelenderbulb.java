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
public class Modelenderbulb<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(UnusualEnd.makeUEID("modelenderbulb"), "main");
	public final ModelPart eye_1;
	public final ModelPart eye_2;
	public final ModelPart eye_3;

	public Modelenderbulb(ModelPart root) {
		this.eye_1 = root.getChild("eye_1");
		this.eye_2 = root.getChild("eye_2");
		this.eye_3 = root.getChild("eye_3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition eye_1 = partdefinition.addOrReplaceChild("eye_1", CubeListBuilder.create(), PartPose.offset(0.0F, 10.8881F, 0.4139F));
		PartDefinition cube_r1 = eye_1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 36).addBox(-2.0F, -3.5F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, -1.3459F, -1.2289F, -0.6981F, 0.0F, 0.0F));
		PartDefinition cube_r2 = eye_1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.1119F, 0.5861F, -0.3927F, 0.0F, 0.0F));
		PartDefinition eye_2 = partdefinition.addOrReplaceChild("eye_2", CubeListBuilder.create(), PartPose.offset(-0.0969F, 16.9699F, -2.9165F));
		PartDefinition cube_r3 = eye_2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.8396F, 1.8002F, -1.5353F, -0.2919F, -0.0913F, -0.2756F));
		PartDefinition cube_r4 = eye_2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 20).addBox(-6.0F, -2.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.2412F, -2.913F, 2.3945F, 0.2753F, -0.0913F, -0.2756F));
		PartDefinition eye_3 = partdefinition.addOrReplaceChild("eye_3", CubeListBuilder.create(), PartPose.offset(5.2681F, 17.0F, -3.7535F));
		PartDefinition cube_r5 = eye_3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(26, 30).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3054F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		eye_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.eye_3.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.eye_2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.eye_1.xRot = headPitch / (180F / (float) Math.PI);
	}
}
