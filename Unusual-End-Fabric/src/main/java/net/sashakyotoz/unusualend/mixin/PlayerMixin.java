package net.sashakyotoz.unusualend.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.sashakyotoz.unusualend.common.networking.IEntityDataSaver;
import net.sashakyotoz.unusualend.common.networking.data.ClothOverlayValuesHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) ((Object) this);
        if (player instanceof ServerPlayerEntity player1) {
            if (ClothOverlayValuesHandler.get((IEntityDataSaver) player1) > 0)
                ClothOverlayValuesHandler.remove((IEntityDataSaver) player1, 1);
            else {
                if (player1.getWorld().getScoreboard().getTeam(player1.getUuidAsString()) != null && player1.getWorld().getScoreboard().getTeam(player1.getUuidAsString()).getPlayerList().contains(player1.getGameProfile().getName())){
                    player1.getWorld().getScoreboard().removePlayerFromTeam(player1.getGameProfile().getName(), player1.getWorld().getScoreboard().getTeam(player1.getUuidAsString()));
                }
            }
        }
    }
}