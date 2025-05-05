package custom.mcreator.unusualend.event;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

import net.mcreator.unusualend.init.UnusualendModBlockEntities;
import net.mcreator.unusualend.block.entity.GloopslatePedestralBlockEntity;
import net.mcreator.unusualend.block.entity.AncientPodiumBlockEntity;
import net.mcreator.unusualend.UnusualendMod;

import custom.mcreator.unusualend.block.entity.renderer.GloopslatePedestralEntityRenderer;
import custom.mcreator.unusualend.block.entity.renderer.AncientPodiumEntityRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = UnusualendMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusClientEvents {
	@SubscribeEvent
	public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer((BlockEntityType<GloopslatePedestralBlockEntity>) UnusualendModBlockEntities.GLOOPSLATE_PEDESTRAL.get(),
                GloopslatePedestralEntityRenderer::new);
		event.registerBlockEntityRenderer((BlockEntityType<AncientPodiumBlockEntity>) UnusualendModBlockEntities.ANCIENT_PODIUM.get(),
                AncientPodiumEntityRenderer::new);
	}
}
