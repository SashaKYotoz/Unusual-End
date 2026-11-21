package net.sweety.unusualend.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.sweety.unusualend.init.UnusualendModEnchantments;
import net.sweety.unusualend.init.UnusualendModParticleTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    public ItemEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void onTickReturn(CallbackInfo ci) {
        if (this.getY() >= -64 || this.isRemoved() || !(this.level() instanceof ServerLevel level))
            return;
        ItemEntity self = (ItemEntity) (Object) this;
        if (self.getItem().getEnchantmentLevel(UnusualendModEnchantments.EVERLASTING.get()) <= 0)
            return;
        level.sendParticles(UnusualendModParticleTypes.WARPED_BUBBLES.get(), this.getX(), this.getY(), this.getZ(), 10, 0.1, 0.1, 0.1, 0);
        BlockPos surface = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, this.blockPosition());
        double targetY = surface.getY() > level.getMinBuildHeight() ? surface.getY() + 1 : this.getY() + 1;
        this.teleportTo(this.getX(), targetY, this.getZ());
    }
}