package net.sweety.unusualend.procedures;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.block.entity.AncientPodiumBlockEntity;
import net.sweety.unusualend.block.entity.GloopslatePedestralBlockEntity;
import net.sweety.unusualend.block.entity.renderer.AncientPodiumEntityRenderer;
import net.sweety.unusualend.block.entity.renderer.GloopslatePedestralEntityRenderer;
import net.sweety.unusualend.init.UnusualendModBlockEntities;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = UnusualEnd.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusClientEvents {
	@SubscribeEvent
	public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer((BlockEntityType<GloopslatePedestralBlockEntity>) UnusualendModBlockEntities.GLOOPSLATE_PEDESTRAL.get(),
                GloopslatePedestralEntityRenderer::new);
		event.registerBlockEntityRenderer((BlockEntityType<AncientPodiumBlockEntity>) UnusualendModBlockEntities.ANCIENT_PODIUM.get(),
                AncientPodiumEntityRenderer::new);
	}
}
