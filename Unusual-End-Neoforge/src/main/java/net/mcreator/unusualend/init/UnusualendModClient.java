
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.mcreator.unusualend.client.gui.BolokNotesScreen;
import net.mcreator.unusualend.client.gui.BuildingInhibitorGUIScreen;
import net.mcreator.unusualend.client.gui.InfuserGUIScreen;
import net.mcreator.unusualend.client.gui.PurpurTankGUIScreen;
import net.mcreator.unusualend.client.model.Modelwarped_jellyfish;
import net.mcreator.unusualend.client.model.Modelvoid_explosive;
import net.mcreator.unusualend.client.model.Modeltameddragling;
import net.mcreator.unusualend.client.model.Modelstructure_spawn;
import net.mcreator.unusualend.client.model.Modelspunkler;
import net.mcreator.unusualend.client.model.Modelspirit_mask_base;
import net.mcreator.unusualend.client.model.Modelsmall_enderbulb;
import net.mcreator.unusualend.client.model.Modelqueen;
import net.mcreator.unusualend.client.model.Modelglub;
import net.mcreator.unusualend.client.model.Modelendstonegolem;
import net.mcreator.unusualend.client.model.Modelendertrapper118;
import net.mcreator.unusualend.client.model.Modelenderling_mask;
import net.mcreator.unusualend.client.model.Modelenderling;
import net.mcreator.unusualend.client.model.Modelenderbulb;
import net.mcreator.unusualend.client.model.Modelenderblob;
import net.mcreator.unusualend.client.model.Modelender_firefly;
import net.mcreator.unusualend.client.model.Modeldragling;
import net.mcreator.unusualend.client.model.Modelchorus_helmet;
import net.mcreator.unusualend.client.model.Modelbubble;
import net.mcreator.unusualend.client.model.Modelbolok;
import net.mcreator.unusualend.client.model.Modelbluk;
import net.mcreator.unusualend.client.model.ModelCustomModel;
import net.mcreator.unusualend.client.model.ModelArrowModelEntity;
import net.mcreator.unusualend.client.particle.BolokParticleParticle;
import net.mcreator.unusualend.client.particle.CitrineShineParticle;
import net.mcreator.unusualend.client.particle.PinkFlameParticle;
import net.mcreator.unusualend.client.particle.WarpedBubblesParticle;
import net.mcreator.unusualend.client.renderer.*;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UnusualendModClient {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelspunkler.LAYER_LOCATION, Modelspunkler::createBodyLayer);
		event.registerLayerDefinition(Modeldragling.LAYER_LOCATION, Modeldragling::createBodyLayer);
		event.registerLayerDefinition(Modelvoid_explosive.LAYER_LOCATION, Modelvoid_explosive::createBodyLayer);
		event.registerLayerDefinition(Modelbolok.LAYER_LOCATION, Modelbolok::createBodyLayer);
		event.registerLayerDefinition(Modelenderling.LAYER_LOCATION, Modelenderling::createBodyLayer);
		event.registerLayerDefinition(Modelbluk.LAYER_LOCATION, Modelbluk::createBodyLayer);
		event.registerLayerDefinition(Modelenderblob.LAYER_LOCATION, Modelenderblob::createBodyLayer);
		event.registerLayerDefinition(Modelender_firefly.LAYER_LOCATION, Modelender_firefly::createBodyLayer);
		event.registerLayerDefinition(Modelwarped_jellyfish.LAYER_LOCATION, Modelwarped_jellyfish::createBodyLayer);
		event.registerLayerDefinition(Modelenderbulb.LAYER_LOCATION, Modelenderbulb::createBodyLayer);
		event.registerLayerDefinition(Modelsmall_enderbulb.LAYER_LOCATION, Modelsmall_enderbulb::createBodyLayer);
		event.registerLayerDefinition(Modelendstonegolem.LAYER_LOCATION, Modelendstonegolem::createBodyLayer);
		event.registerLayerDefinition(Modeltameddragling.LAYER_LOCATION, Modeltameddragling::createBodyLayer);
		event.registerLayerDefinition(Modelenderling_mask.LAYER_LOCATION, Modelenderling_mask::createBodyLayer);
		event.registerLayerDefinition(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
		event.registerLayerDefinition(Modelspirit_mask_base.LAYER_LOCATION, Modelspirit_mask_base::createBodyLayer);
		event.registerLayerDefinition(Modelendertrapper118.LAYER_LOCATION, Modelendertrapper118::createBodyLayer);
		event.registerLayerDefinition(Modelbubble.LAYER_LOCATION, Modelbubble::createBodyLayer);
		event.registerLayerDefinition(Modelglub.LAYER_LOCATION, Modelglub::createBodyLayer);
		event.registerLayerDefinition(Modelstructure_spawn.LAYER_LOCATION, Modelstructure_spawn::createBodyLayer);
		event.registerLayerDefinition(Modelchorus_helmet.LAYER_LOCATION, Modelchorus_helmet::createBodyLayer);
		event.registerLayerDefinition(ModelArrowModelEntity.LAYER_LOCATION, ModelArrowModelEntity::createBodyLayer);
		event.registerLayerDefinition(Modelqueen.LAYER_LOCATION, Modelqueen::createBodyLayer);
	}
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
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(UnusualendModMenus.PURPUR_TANK_GUI.get(), PurpurTankGUIScreen::new);
		event.register(UnusualendModMenus.BOLOK_NOTES.get(), BolokNotesScreen::new);
		event.register(UnusualendModMenus.BUILDING_INHIBITOR_GUI.get(), BuildingInhibitorGUIScreen::new);
		event.register(UnusualendModMenus.INFUSER_GUI.get(), InfuserGUIScreen::new);
	}
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(UnusualendModParticleTypes.BOLOK_PARTICLE.get(), BolokParticleParticle::provider);
		event.registerSpriteSet(UnusualendModParticleTypes.PINK_FLAME.get(), PinkFlameParticle::provider);
		event.registerSpriteSet(UnusualendModParticleTypes.WARPED_BUBBLES.get(), WarpedBubblesParticle::provider);
		event.registerSpriteSet(UnusualendModParticleTypes.CITRINE_SHINE.get(), CitrineShineParticle::provider);
	}
}
