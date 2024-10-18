
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class UnusualendModModels {
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
}
