package custom.mcreator.unusualend.event;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

import net.mcreator.unusualend.init.UnusualendModBlockEntities;
import net.mcreator.unusualend.block.entity.GloopslatePedestralBlockEntity;
import net.mcreator.unusualend.block.entity.AncientPodiumBlockEntity;
import net.mcreator.unusualend.UnusualendMod;

import custom.mcreator.unusualend.block.entity.renderer.GloopslatePedestralEntityRenderer;
import custom.mcreator.unusualend.block.entity.renderer.AncientPodiumEntityRenderer;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = UnusualendMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusClientEvents {
	@SubscribeEvent
	public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
		event.<GloopslatePedestralBlockEntity>registerBlockEntityRenderer((BlockEntityType<GloopslatePedestralBlockEntity>) UnusualendModBlockEntities.GLOOPSLATE_PEDESTRAL.get(),
				(BlockEntityRendererProvider<GloopslatePedestralBlockEntity>) GloopslatePedestralEntityRenderer::new);
		event.<AncientPodiumBlockEntity>registerBlockEntityRenderer((BlockEntityType<AncientPodiumBlockEntity>) UnusualendModBlockEntities.ANCIENT_PODIUM.get(),
				(BlockEntityRendererProvider<AncientPodiumBlockEntity>) AncientPodiumEntityRenderer::new);
	}
}
