
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sweety.unusualend.client;

import custom.sweety.unusualend.block.entity.renderer.AncientPodiumEntityRenderer;
import custom.sweety.unusualend.block.entity.renderer.GloopslatePedestralEntityRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.block.entity.AncientPodiumBlockEntity;
import net.sweety.unusualend.block.entity.GloopslatePedestralBlockEntity;
import net.sweety.unusualend.client.gui.BolokNotesScreen;
import net.sweety.unusualend.client.gui.BuildingInhibitorGUIScreen;
import net.sweety.unusualend.client.gui.InfuserGUIScreen;
import net.sweety.unusualend.client.gui.PurpurTankGUIScreen;
import net.sweety.unusualend.client.model.*;
import net.sweety.unusualend.client.particle.BolokParticleParticle;
import net.sweety.unusualend.client.particle.CitrineShineParticle;
import net.sweety.unusualend.client.particle.PinkFlameParticle;
import net.sweety.unusualend.client.particle.WarpedBubblesParticle;
import net.sweety.unusualend.client.renderer.*;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.init.UnusualendModBlockEntities;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.procedures.CrystalCatalystPropertyValueProviderProcedure;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UnusualEndClient {
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer((BlockEntityType<GloopslatePedestralBlockEntity>) UnusualendModBlockEntities.GLOOPSLATE_PEDESTRAL.get(),
                GloopslatePedestralEntityRenderer::new);
        event.registerBlockEntityRenderer((BlockEntityType<AncientPodiumBlockEntity>) UnusualendModBlockEntities.ANCIENT_PODIUM.get(),
                AncientPodiumEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelSpunkler.LAYER_LOCATION, ModelSpunkler::createBodyLayer);
        event.registerLayerDefinition(ModelDragling.LAYER_LOCATION, ModelDragling::createBodyLayer);
        event.registerLayerDefinition(ModelVoidExplosive.LAYER_LOCATION, ModelVoidExplosive::createBodyLayer);
        event.registerLayerDefinition(ModelBolok.LAYER_LOCATION, ModelBolok::createBodyLayer);
        event.registerLayerDefinition(ModelBabyBolok.LAYER_LOCATION, ModelBabyBolok::createBodyLayer);
        event.registerLayerDefinition(ModelEnderling.LAYER_LOCATION, ModelEnderling::createBodyLayer);
        event.registerLayerDefinition(ModelBluk.LAYER_LOCATION, ModelBluk::createBodyLayer);
        event.registerLayerDefinition(ModelEnderblob.LAYER_LOCATION, ModelEnderblob::createBodyLayer);
        event.registerLayerDefinition(ModelFlampyr.LAYER_LOCATION, ModelFlampyr::createBodyLayer);
        event.registerLayerDefinition(ModelBabyFlampyr.LAYER_LOCATION, ModelBabyFlampyr::createBodyLayer);
        event.registerLayerDefinition(ModelWarpedJellyfish.LAYER_LOCATION, ModelWarpedJellyfish::createBodyLayer);
        event.registerLayerDefinition(ModelEnderbulb.LAYER_LOCATION, ModelEnderbulb::createBodyLayer);
        event.registerLayerDefinition(ModelSmallEnderbulb.LAYER_LOCATION, ModelSmallEnderbulb::createBodyLayer);
        event.registerLayerDefinition(ModelEndstoneGolem.LAYER_LOCATION, ModelEndstoneGolem::createBodyLayer);
        event.registerLayerDefinition(ModelTamedDragling.LAYER_LOCATION, ModelTamedDragling::createBodyLayer);
        event.registerLayerDefinition(ModelEnderlingMask.LAYER_LOCATION, ModelEnderlingMask::createBodyLayer);
        event.registerLayerDefinition(ModelSpiritMaskBase.LAYER_LOCATION, ModelSpiritMaskBase::createBodyLayer);
        event.registerLayerDefinition(ModelEnderTrapper118.LAYER_LOCATION, ModelEnderTrapper118::createBodyLayer);
        event.registerLayerDefinition(ModelBubble.LAYER_LOCATION, ModelBubble::createBodyLayer);
        event.registerLayerDefinition(ModelGlub.LAYER_LOCATION, ModelGlub::createBodyLayer);
        event.registerLayerDefinition(ModelBabyGlub.LAYER_LOCATION, ModelBabyGlub::createBodyLayer);
        event.registerLayerDefinition(ModelStructureSpawn.LAYER_LOCATION, ModelStructureSpawn::createBodyLayer);
        event.registerLayerDefinition(ModelChorusHelmet.LAYER_LOCATION, ModelChorusHelmet::createBodyLayer);
        event.registerLayerDefinition(ModelArrowModelEntity.LAYER_LOCATION, ModelArrowModelEntity::createBodyLayer);
        event.registerLayerDefinition(ModelQueen.LAYER_LOCATION, ModelQueen::createBodyLayer);
    }

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

    @SubscribeEvent
    public static void clientLoad(RegisterMenuScreensEvent event) {
        event.register(UnusualEndMiscRegister.PURPUR_TANK_GUI.get(), PurpurTankGUIScreen::new);
        event.register(UnusualEndMiscRegister.BOLOK_NOTES.get(), BolokNotesScreen::new);
        event.register(UnusualEndMiscRegister.BUILDING_INHIBITOR_GUI.get(), BuildingInhibitorGUIScreen::new);
        event.register(UnusualEndMiscRegister.INFUSER_GUI.get(), InfuserGUIScreen::new);
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(UnusualEndMiscRegister.BOLOK_PARTICLE.get(), BolokParticleParticle::provider);
        event.registerSpriteSet(UnusualEndMiscRegister.PINK_FLAME.get(), PinkFlameParticle::provider);
        event.registerSpriteSet(UnusualEndMiscRegister.WARPED_BUBBLES.get(), WarpedBubblesParticle::provider);
        event.registerSpriteSet(UnusualEndMiscRegister.CITRINE_SHINE.get(), CitrineShineParticle::provider);
    }

    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemProperties.register(UnusualEndItems.CRYSTAL_CATALYST.get(), UnusualEnd.makeUEID("crystal_catalyst_is_renamed"),
                    (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) CrystalCatalystPropertyValueProviderProcedure.execute(itemStackToRender));
            ItemProperties.register(UnusualEndItems.ENDERBLOB_SHIELD.get(), ResourceLocation.withDefaultNamespace("blocking"), ItemProperties.getProperty(Items.SHIELD.getDefaultInstance(), ResourceLocation.withDefaultNamespace("blocking")));
        });
    }
}