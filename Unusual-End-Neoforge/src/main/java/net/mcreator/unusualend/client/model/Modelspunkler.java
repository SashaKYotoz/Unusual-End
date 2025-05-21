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

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelspunkler<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(UnusualEnd.makeUEID("modelspunkler"), "main");
	public final ModelPart shell;
	public final ModelPart head;

	public Modelspunkler(ModelPart root) {
		this.shell = root.getChild("shell");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition shell = partdefinition.addOrReplaceChild("shell",
				CubeListBuilder.create().texOffs(0, 14).addBox(-5.0F, 5.0F, -5.0F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, 11.0F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 9.0F, 0.0F));
		PartDefinition shell1 = shell.addOrReplaceChild("shell1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition spine_r1 = shell1.addOrReplaceChild("spine_r1", CubeListBuilder.create().texOffs(0, 38).addBox(0.0F, -1.0F, -7.0F, 0.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 2.3562F, 0.0F));
		PartDefinition spine_r2 = shell1.addOrReplaceChild("spine_r2", CubeListBuilder.create().texOffs(28, 16).addBox(0.0F, -1.0F, -7.0F, 0.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition spine_r3 = shell1.addOrReplaceChild("spine_r3", CubeListBuilder.create().texOffs(0, 38).addBox(0.0F, -2.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 5.0F, 5.0F, -1.5708F, 0.7854F, -1.5708F));
		PartDefinition spine_r4 = shell1.addOrReplaceChild("spine_r4", CubeListBuilder.create().texOffs(20, 38).addBox(0.0F, -2.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 5.0F, -5.0F, 1.5708F, 0.7854F, 1.5708F));
		PartDefinition spine_r5 = shell1.addOrReplaceChild("spine_r5", CubeListBuilder.create().texOffs(0, 40).addBox(0.0F, -2.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition shell2 = shell.addOrReplaceChild("shell2", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 6.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition spine_r6 = shell2.addOrReplaceChild("spine_r6", CubeListBuilder.create().texOffs(0, 26).addBox(2.8284F, -1.0F, -9.8284F, 0.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.3562F, 0.0F));
		PartDefinition spine_r7 = shell2.addOrReplaceChild("spine_r7", CubeListBuilder.create().texOffs(0, 28).addBox(-2.8284F, -1.0F, -9.8284F, 0.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition spine_r8 = shell2.addOrReplaceChild("spine_r8", CubeListBuilder.create().texOffs(20, 34).addBox(0.0F, -2.0F, -9.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 5.0F, -1.5708F, 0.7854F, -1.5708F));
		PartDefinition spine_r9 = shell2.addOrReplaceChild("spine_r9", CubeListBuilder.create().texOffs(0, 36).addBox(0.0F, -2.0F, -9.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, -5.0F, 1.5708F, 0.7854F, 1.5708F));
		PartDefinition spine_r10 = shell2.addOrReplaceChild("spine_r10", CubeListBuilder.create().texOffs(30, 6).addBox(-2.8284F, -4.8284F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition spine_r11 = shell2.addOrReplaceChild("spine_r11", CubeListBuilder.create().texOffs(20, 36).addBox(-2.8284F, 0.8284F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition shell3 = shell.addOrReplaceChild("shell3", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 6.0F, 0.0F, 3.1416F, 0.0F, -1.5708F));
		PartDefinition spine_r12 = shell3.addOrReplaceChild("spine_r12", CubeListBuilder.create().texOffs(0, 22).addBox(2.8284F, -1.0F, -9.8284F, 0.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.3562F, 0.0F));
		PartDefinition spine_r13 = shell3.addOrReplaceChild("spine_r13", CubeListBuilder.create().texOffs(0, 24).addBox(-2.8284F, -1.0F, -9.8284F, 0.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition spine_r14 = shell3.addOrReplaceChild("spine_r14", CubeListBuilder.create().texOffs(30, 10).addBox(0.0F, -2.0F, -9.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 5.0F, -1.5708F, 0.7854F, -1.5708F));
		PartDefinition spine_r15 = shell3.addOrReplaceChild("spine_r15", CubeListBuilder.create().texOffs(30, 12).addBox(0.0F, -2.0F, -9.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, -5.0F, 1.5708F, 0.7854F, 1.5708F));
		PartDefinition spine_r16 = shell3.addOrReplaceChild("spine_r16", CubeListBuilder.create().texOffs(0, 34).addBox(-2.8284F, -4.8284F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition shell4 = shell.addOrReplaceChild("shell4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition spine_r17 = shell4.addOrReplaceChild("spine_r17", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -5.0F, -7.0F, 0.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.3562F, 0.0F));
		PartDefinition spine_r18 = shell4.addOrReplaceChild("spine_r18", CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, -5.0F, -7.0F, 0.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition spine_r19 = shell4.addOrReplaceChild("spine_r19", CubeListBuilder.create().texOffs(30, 4).addBox(2.8284F, -4.8284F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 5.0F, -1.5708F, 0.7854F, -1.5708F));
		PartDefinition spine_r20 = shell4.addOrReplaceChild("spine_r20", CubeListBuilder.create().texOffs(30, 8).addBox(-2.8284F, -4.8284F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, -5.0F, 1.5708F, 0.7854F, 1.5708F));
		PartDefinition shell5 = shell.addOrReplaceChild("shell5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 6.0F, -6.0F, 1.5708F, 0.0F, -1.5708F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 32).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		shell.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
	}
}
