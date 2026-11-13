package net.sweety.unusualend.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sweety.unusualend.client.particle.BolokParticleParticle;
import net.sweety.unusualend.client.particle.CitrineShineParticle;
import net.sweety.unusualend.client.particle.PinkFlameParticle;
import net.sweety.unusualend.client.particle.WarpedBubblesParticle;

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
