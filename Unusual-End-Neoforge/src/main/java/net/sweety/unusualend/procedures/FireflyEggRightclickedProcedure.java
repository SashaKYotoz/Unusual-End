package net.sweety.unusualend.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndItems;

public class FireflyEggRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        itemstack.shrink(1);
        if (entity instanceof Player _player)
            _player.getCooldowns().addCooldown(UnusualEndItems.ENDER_FIREFLY_EGG.get(), 5);
        if (world.isClientSide()) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.TURTLE_EGG_BREAK, SoundSource.PLAYERS, (float) 0.5, (float) 1.3);
                } else {
                    _level.playLocalSound(x, y, z, SoundEvents.TURTLE_EGG_BREAK, SoundSource.PLAYERS, (float) 0.5, (float) 1.3, false);
                }
            }
        }
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualEndItems.ENDER_FIREFLY_EGG.get()) {
            if (entity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.MAIN_HAND, true);
        } else {
            if (entity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.OFF_HAND, true);
        }
        if (Math.random() < 0.4) {
            if (world instanceof ServerLevel _level)
                _level.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 1), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                        "summon unusualend:ender_firefly ~ ~ ~ {Age:-24000}");
            if (world instanceof ServerLevel level)
                level.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(
                                CommandSource.NULL,
                                new Vec3((x + 0.5), (y + 1), (z + 0.5)),
                                Vec2.ZERO,
                                level,
                                4,
                                "",
                                Component.literal(""),
                                level.getServer(),
                                null
                        ).withSuppressedOutput(),
                        "particle minecraft:item[item=\"unusualend:ender_firefly_egg\"] ~ ~ ~ 0.2 0.2 0.2 0 25"
                );
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 1), (z + 0.5), 5, 0.5, 0.5, 0.5, 0);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.DRAGON_BREATH, (x + 0.5), (y + 1), (z + 0.5), 5, 0.5, 0.5, 0.5, 0);
            if (world.getBiome(BlockPos.containing(x, y, z)).is(Biomes.MANGROVE_SWAMP) || world.getBiome(BlockPos.containing(x, y, z)).is(Biomes.SWAMP)) {
                if (!(entity instanceof ServerPlayer _plr16 && _plr16.level() instanceof ServerLevel
                        && _plr16.getAdvancements().getOrStartProgress(_plr16.server.getAdvancements().get(UnusualEnd.makeUEID("firefly_in_swamp"))).isDone())) {
                    if (entity instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(UnusualEnd.makeUEID("firefly_in_swamp"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria())
                                _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
            }
        } else {
            if (world instanceof ServerLevel level)
                level.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(
                                CommandSource.NULL,
                                new Vec3((x + 0.5), (y + 1), (z + 0.5)),
                                Vec2.ZERO,
                                level,
                                4,
                                "",
                                Component.literal(""),
                                level.getServer(),
                                null
                        ).withSuppressedOutput(),
                        "particle minecraft:item[item=\"unusualend:ender_firefly_egg\"] ~ ~ ~ 0.2 0.2 0.2 0 25"
                );
        }
    }
}
