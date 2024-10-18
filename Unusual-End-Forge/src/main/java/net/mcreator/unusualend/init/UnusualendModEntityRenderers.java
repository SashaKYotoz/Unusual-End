
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.unusualend.client.renderer.WarpedJellyfishRenderer;
import net.mcreator.unusualend.client.renderer.VoidCrackRenderer;
import net.mcreator.unusualend.client.renderer.VoidBombRenderer;
import net.mcreator.unusualend.client.renderer.VoidArrowProjectileRenderer;
import net.mcreator.unusualend.client.renderer.SummonedDraglingRenderer;
import net.mcreator.unusualend.client.renderer.SpunklerRenderer;
import net.mcreator.unusualend.client.renderer.SmallEnderbulbRenderer;
import net.mcreator.unusualend.client.renderer.PhantomArrowProjectileRenderer;
import net.mcreator.unusualend.client.renderer.LargeBubbleRenderer;
import net.mcreator.unusualend.client.renderer.EndstoneGolemRenderer;
import net.mcreator.unusualend.client.renderer.EnderlingRenderer;
import net.mcreator.unusualend.client.renderer.EnderbulbRenderer;
import net.mcreator.unusualend.client.renderer.EnderblobRenderer;
import net.mcreator.unusualend.client.renderer.EnderblobQueenRenderer;
import net.mcreator.unusualend.client.renderer.EnderTrapperRenderer;
import net.mcreator.unusualend.client.renderer.EnderBugRenderer;
import net.mcreator.unusualend.client.renderer.DraglingRenderer;
import net.mcreator.unusualend.client.renderer.BolokRenderer;
import net.mcreator.unusualend.client.renderer.BlukRenderer;
import net.mcreator.unusualend.client.renderer.BlockUpdaterRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UnusualendModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(UnusualendModEntities.ENDER_BLOB.get(), EnderblobRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.UNDEAD_ENDERLING.get(), EnderlingRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.ENDSTONE_TRAPPER.get(), EnderTrapperRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.ENDER_FIREFLY.get(), EnderBugRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.ENDSTONE_GOLEM.get(), EndstoneGolemRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.DRAGLING.get(), DraglingRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.BOLOK.get(), BolokRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.ENDERBLOB_QUEEN.get(), EnderblobQueenRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.BLOCK_UPDATER.get(), BlockUpdaterRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.SPUNKLER.get(), SpunklerRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.VOID_CRACK.get(), VoidCrackRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.WARPED_BALLOON.get(), LargeBubbleRenderer::new);
		event.registerEntityRenderer(UnusualendModEntities.GLUB.get(), WarpedJellyfishRenderer::new);
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
