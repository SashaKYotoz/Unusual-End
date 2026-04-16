package net.mcreator.unusualend.init;

import net.mcreator.unusualend.client.renderer.*;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UnusualendModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(UnusualendModEntities.ENDER_BLOB.get(), EnderblobRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.UNDEAD_ENDERLING.get(), EnderlingRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.ENDSTONE_TRAPPER.get(), EnderTrapperRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.ENDER_FIREFLY.get(), FlampyrRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.ENDSTONE_GOLEM.get(), EndstoneGolemRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.DRAGLING.get(), DraglingRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.BOLOK.get(), BolokRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.ENDERBLOB_QUEEN.get(), EnderblobQueenRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.BLOCK_UPDATER.get(), BlockUpdaterRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.SPUNKLER.get(), SpunklerRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.VOID_CRACK.get(), VoidCrackRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.WARPED_BALLOON.get(), LargeBubbleRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.GLUB.get(), GlubRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.VOID_BOMB.get(), VoidBombRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.ENDERBULB.get(), EnderbulbRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.SMALL_ENDERBULB.get(), SmallEnderbulbRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.BLUK.get(), BlukRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.PHANTOM_ARROW_PROJECTILE.get(), PhantomArrowProjectileRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.WANDERING_PEARL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.SHINY_GRENADE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.LEECHING_CHARGE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.VOID_ARROW_PROJECTILE.get(), VoidArrowProjectileRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.SUMMONED_DRAGLING.get(), SummonedDraglingRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.BOND_LEECHING_CHARGE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.BENEVOLENT_LEECHING_CHARGE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.WARPED_BALLOON_PROJ.get(), ThrownItemRenderer::new);
	}
}
