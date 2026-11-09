package net.sweety.unusualend.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.init.UnusualEndMiscRegister;
import net.sweety.unusualend.util.ProcedureHelper;

public class CrystalCatalystRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Player player, ItemStack stack) {
        if (player == null)
            return;
        if (NBTProcessor.getNBTDouble(stack, "Catalyser") >= 1) {
            if (NBTProcessor.getNBTDouble(stack, "cataCooldown") >= 400) {
                if ((player instanceof Player _plr ? _plr.experienceLevel : 0) >= 1) {
                    NBTProcessor.setNBTDouble(stack, "cataCooldown", 0);
                    if (player instanceof Player _player)
                        _player.giveExperiencePoints(-(7));
                    if (player.getMainHandItem().getItem() == UnusualEndItems.CRYSTAL_CATALYST.get()) {
                        player.swing(InteractionHand.MAIN_HAND, true);
                    } else
                        player.swing(InteractionHand.OFF_HAND, true);
                    stack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(stack));
                    if (player instanceof Player _player)
                        _player.getCooldowns().addCooldown(stack.getItem(), 10);
                    if (NBTProcessor.getNBTDouble(stack, "Catalyser") == 1) {
                        ProcedureHelper.playSound(world, x, y, z, SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, (float) 0.5, 2);
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.END_ROD, x, (y + 1.5), z, 30, 0.9, 0.9, 0.9, 0);
                        if (Math.random() < 0.5) {
                            if (!player.level().isClientSide()) {
                                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, true, false));
                                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 400, 0, true, false));
                                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 400, 0, true, false));
                            }
                        } else {
                            if (!player.level().isClientSide()) {
                                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0, false, false));
                                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0, false, false));
                                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 0, false, false));
                            }
                        }
                    } else if (NBTProcessor.getNBTDouble(stack, "Catalyser") == 2) {
                        ProcedureHelper.playSound(world, x, y, z, SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, (float) 0.5, 2);
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.SPLASH, x, (y + 1.5), z, 30, 0.9, 0.9, 0.9, 0);
                        ProcedureHelper.addEffect(player, new MobEffectInstance(MobEffects.CONDUIT_POWER, 400, 0, false, false));
                    } else if (NBTProcessor.getNBTDouble(stack, "Catalyser") == 3) {
                        ProcedureHelper.playSound(world, x, y, z, SoundEvents.GENERIC_BURN, SoundSource.PLAYERS, (float) 0.5, 2);
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.WITCH, x, (y + 1.5), z, 30, 0.9, 0.9, 0.9, 0);
                        if (Math.random() < 0.3) {
                            if (!player.level().isClientSide())
                                player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, 0, true, false));
                            if (!player.level().isClientSide())
                                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
                        } else if (Math.random() < 0.3) {
                            if (!player.level().isClientSide())
                                player.addEffect(new MobEffectInstance(UnusualEndMiscRegister.SWIFT_STRIKES, 400, 0, true, false));
                        } else {
                            if (!player.level().isClientSide())
                                player.addEffect(new MobEffectInstance(UnusualEndMiscRegister.SERENITY, 400, 0, true, false));
                        }
                    }
                } else {
                    if (player instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.translatable("text.unusualend.no_xp"), true);
                }
            }
        }
    }
}
