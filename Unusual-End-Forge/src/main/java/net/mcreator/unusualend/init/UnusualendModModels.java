package net.mcreator.unusualend.init;

import net.mcreator.unusualend.client.model.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class UnusualendModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelSpunkler.LAYER_LOCATION, ModelSpunkler::createBodyLayer);
		event.registerLayerDefinition(ModelDragling.LAYER_LOCATION, ModelDragling::createBodyLayer);
		event.registerLayerDefinition(ModelVoidExplosive.LAYER_LOCATION, ModelVoidExplosive::createBodyLayer);
		event.registerLayerDefinition(ModelBolok.LAYER_LOCATION, ModelBolok::createBodyLayer);
		event.registerLayerDefinition(ModelBabyBolok.LAYER_LOCATION, ModelBabyBolok::createBodyLayer);
		event.registerLayerDefinition(ModelEnderling.LAYER_LOCATION, ModelEnderling::createBodyLayer);
		event.registerLayerDefinition(ModelBluk.LAYER_LOCATION, ModelBluk::createBodyLayer);
		event.registerLayerDefinition(ModelEnderBlob.LAYER_LOCATION, ModelEnderBlob::createBodyLayer);
		event.registerLayerDefinition(ModelFlampyr.LAYER_LOCATION, ModelFlampyr::createBodyLayer);
		event.registerLayerDefinition(ModelBabyFlampyr.LAYER_LOCATION, ModelBabyFlampyr::createBodyLayer);
		event.registerLayerDefinition(ModelWarpedJellyfish.LAYER_LOCATION, ModelWarpedJellyfish::createBodyLayer);
		event.registerLayerDefinition(ModelEnderBulb.LAYER_LOCATION, ModelEnderBulb::createBodyLayer);
		event.registerLayerDefinition(ModelSmallEnderBulb.LAYER_LOCATION, ModelSmallEnderBulb::createBodyLayer);
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
}
