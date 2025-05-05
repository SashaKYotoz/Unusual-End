package net.sashakyotoz.unusualend.common.items.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.sashakyotoz.unusualend.common.effects.ModEffects;
import net.sashakyotoz.unusualend.common.networking.IEntityDataSaver;
import net.sashakyotoz.unusualend.common.networking.data.ClothOverlayValuesHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpectralClothItem extends Item {
    public SpectralClothItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.literal(Text.translatable("effect.minecraft.invisibility").getString() + " II (1:00)").formatted(Formatting.BLUE));
        tooltip.add(Text.literal(Text.translatable("effect.unusualend.spectral_stride").getString() + " (1:00)").formatted(Formatting.BLUE));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        user.swingHand(hand);
        if (user instanceof ServerPlayerEntity player) {
            ClothOverlayValuesHandler.add((IEntityDataSaver) player, 1200);
            player.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(player.getX(), player.getY(), player.getZ()), Vec2f.ZERO, player.getServerWorld(), 4, "", Text.literal(""), player.getServer(), null).withSilent(),
                    "particle dust_color_transition 0.827 0.216 0.741 1.5 0.047 0.047 0.047 ~ ~1 ~ 0.4 0.5 0.4 0 40 normal");
        }
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 1200, 0, false, false));
        user.addStatusEffect(new StatusEffectInstance(ModEffects.SPECTRAL_STRIDE, 1200, 0, false, false));
        Team team = user.getWorld().getScoreboard().getTeam(user.getUuidAsString()) == null ?
                user.getWorld().getScoreboard().addTeam(user.getUuidAsString())
                : user.getWorld().getScoreboard().getTeam(user.getUuidAsString());
        user.getWorld().getScoreboard().addPlayerToTeam(user.getGameProfile().getName(),team);
        stack.decrement(1);
        user.getItemCooldownManager().set(stack.getItem(), 100);
        user.playSound(SoundEvents.ENTITY_GENERIC_BURN, 0.3f, 1.2f);
        return super.use(world, user, hand);
    }
}