package custom.mcreator.unusualend.block.entity.renderer;

import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.Minecraft;

import net.mcreator.unusualend.block.entity.AncientPodiumBlockEntity;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;

public class AncientPodiumEntityRenderer implements BlockEntityRenderer<AncientPodiumBlockEntity> {
	public AncientPodiumEntityRenderer(BlockEntityRendererProvider.Context context) {
	}

	@Override
	public void render(AncientPodiumBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		ItemStack itemStack = pBlockEntity.getRenderStack();
		Level level = pBlockEntity.getLevel();
		if (level == null)
			return;
		double relativeGameTime = level.getGameTime() + pPartialTick;
		double offset = Math.sin(relativeGameTime / 10.0) / 30.0;
		double rotation = Math.sin(relativeGameTime / 10000) * 20000;
		pPoseStack.pushPose();
		pPoseStack.translate(0.5f, 1.2f + offset, 0.5f);
		pPoseStack.scale(0.6f, 0.6f, 0.6f);
		pPoseStack.mulPose(Axis.YP.rotationDegrees((float) rotation));
		itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, pBlockEntity.getLevel(), 1);
		pPoseStack.popPose();
	}

	private int getLightLevel(Level level, BlockPos pos) {
		int bLight = level.getBrightness(LightLayer.BLOCK, pos);
		int sLight = level.getBrightness(LightLayer.SKY, pos);
		return LightTexture.pack(bLight, sLight);
	}
}
