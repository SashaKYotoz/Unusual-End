
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.unusualend.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UnusualendModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(UnusualendModParticleTypes.BOLOK_PARTICLE.get(), BolokParticleParticle::provider);
		event.registerSpriteSet(UnusualendModParticleTypes.PINK_FLAME.get(), PinkFlameParticle::provider);
		event.registerSpriteSet(UnusualendModParticleTypes.WARPED_BUBBLES.get(), WarpedBubblesParticle::provider);
		event.registerSpriteSet(UnusualendModParticleTypes.CITRINE_SHINE.get(), CitrineShineParticle::provider);
	}
}
