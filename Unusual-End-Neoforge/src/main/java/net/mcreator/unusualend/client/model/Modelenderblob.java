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

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelenderblob<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("unusualend", "modelenderblob"), "main");
	public final ModelPart body1;
	public final ModelPart body2;
	public final ModelPart body3;
	public final ModelPart body4;

	public Modelenderblob(ModelPart root) {
		this.body1 = root.getChild("body1");
		this.body2 = root.getChild("body2");
		this.body3 = root.getChild("body3");
		this.body4 = root.getChild("body4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body1 = partdefinition.addOrReplaceChild("body1",
				CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, -3.0F, 0.0F, 10.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 22)
						.addBox(-4.0F, -2.0F, 7.0F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 22).addBox(-2.0F, 0.0F, 9.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 21.0F, -3.5F));
		PartDefinition body2 = partdefinition.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 0.0F));
		PartDefinition body3 = partdefinition.addOrReplaceChild("body3", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 3.0F));
		PartDefinition body4 = partdefinition.addOrReplaceChild("body4", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 4.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body1.xRot = (Mth.sin(ageInTicks * 0.3F + 1) * 0.05F) + ((headPitch * 0.017453292F) / 2);
		this.body1.zRot = (Mth.sin(ageInTicks * 0.6F + 1) * 0.05F);
		this.body1.yRot = (netHeadYaw * 0.017453292F / 2);
	}
}
