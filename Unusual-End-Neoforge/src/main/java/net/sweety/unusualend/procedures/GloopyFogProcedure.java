package net.sweety.unusualend.procedures;

import com.mojang.blaze3d.shaders.FogShape;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.configuration.UEConfig;

@EventBusSubscriber(value = Dist.CLIENT)
public class GloopyFogProcedure {
    public static ViewportEvent.RenderFog provider = null;

    public static void setDistance(float start, float end) {
        provider.setNearPlaneDistance(start);
        provider.setFarPlaneDistance(end);
        if (!provider.isCanceled()) {
            provider.setCanceled(true);
        }
    }

    public static void setShape(FogShape shape) {
        provider.setFogShape(shape);
        if (!provider.isCanceled()) {
            provider.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void renderFog(ViewportEvent.RenderFog event) {
        provider = event;
        if (provider.getMode() == FogRenderer.FogMode.FOG_TERRAIN) {
            ClientLevel level = Minecraft.getInstance().level;
            Entity entity = provider.getCamera().getEntity();
            if (level != null && entity != null) {
                Vec3 pos = entity.getPosition((float) provider.getPartialTick());
                execute(level, pos.x(), pos.y(), pos.z());
            }
        }
    }

    private static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBiome(BlockPos.containing(x, y, z)).is(UnusualEnd.makeUEID("gloopstone_lands"))) {
            if (UEConfig.GLOOPY_FOG.get()) {
                setDistance(0, 200);
                setShape(FogShape.CYLINDER);
            }
        }
        if (world.getBiome(BlockPos.containing(x, y, z)).is(UnusualEnd.makeUEID("warped_reef"))) {
            if (UEConfig.WARPED_FOG.get()) {
                setDistance(10, 200);
                setShape(FogShape.SPHERE);
            }
        }
    }
}
