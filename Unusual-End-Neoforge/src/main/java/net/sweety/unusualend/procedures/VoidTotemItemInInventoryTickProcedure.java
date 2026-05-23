package net.sweety.unusualend.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.network.UnusualEndVariables;

public class VoidTotemItemInInventoryTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack stack) {
        if (entity == null)
            return;
        if (entity.getY() < UEConfig.VOID_TOTEM_Y.get()) {
            if ((entity.level().dimension()) == Level.END) {
                if (!((entity instanceof Player _plrCldRem6 ? _plrCldRem6.getCooldowns().getCooldownPercent(stack.getItem(), 0f) * 100 : 0) > 0)) {
                    if (world.isClientSide()) {
                        if (world.isClientSide())
                            Minecraft.getInstance().gameRenderer.displayItemActivation(UnusualEndItems.VOID_TOTEM.get().getDefaultInstance());
                    }
                    if (entity instanceof Player _player)
                        _player.getCooldowns().addCooldown(stack.getItem(), (int) (double) UEConfig.VOID_TOTEM.get());
                    if (entity instanceof Player player) {
                        ItemStack stack1 = new ItemStack(UnusualEndItems.VOID_TOTEM.get());
                        player.getInventory().clearOrCountMatchingItems(p -> stack1.getItem() == p.getItem(), 1, player.inventoryMenu.getCraftSlots());
                    }
                    if (!(entity instanceof ServerPlayer _plr13 && _plr13.level() instanceof ServerLevel
                            && _plr13.getAdvancements().getOrStartProgress(_plr13.server.getAdvancements().get(UnusualEnd.makeUEID("worse_than_death"))).isDone())) {
                        if (entity instanceof ServerPlayer _player) {
                            AdvancementHolder _adv = _player.server.getAdvancements().get(UnusualEnd.makeUEID("worse_than_death"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String criteria : _ap.getRemainingCriteria())
                                    _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }
                    if (NBTProcessor.getNBTBoolean(stack, "LinkedTotem")) {
                        if (!NBTProcessor.getNBTString(stack, "TpW").equals("" + entity.level().dimension())) {
                            if (NBTProcessor.getNBTString(stack, "TpW").equals("" + Level.OVERWORLD)) {
                                if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                                    ResourceKey<Level> destinationType = Level.OVERWORLD;
                                    if (_player.level().dimension() == destinationType)
                                        return;
                                    ServerLevel nextLevel = _player.server.getLevel(destinationType);
                                    if (nextLevel != null) {
                                        _player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                                        _player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
                                        _player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
                                        for (MobEffectInstance _effectinstance : _player.getActiveEffects())
                                            _player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, true));
                                        _player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                                    }
                                }
                            }
                            if (NBTProcessor.getNBTString(stack, "TpW").equals("" + Level.NETHER)) {
                                if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                                    ResourceKey<Level> destinationType = Level.NETHER;
                                    if (_player.level().dimension() == destinationType)
                                        return;
                                    ServerLevel nextLevel = _player.server.getLevel(destinationType);
                                    if (nextLevel != null) {
                                        _player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                                        _player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
                                        _player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
                                        for (MobEffectInstance _effectinstance : _player.getActiveEffects())
                                            _player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, true));
                                        _player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                                    }
                                }
                            }
                            if (NBTProcessor.getNBTString(stack, "TpW").equals("" + Level.END)) {
                                if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                                    ResourceKey<Level> destinationType = Level.END;
                                    if (_player.level().dimension() == destinationType)
                                        return;
                                    ServerLevel nextLevel = _player.server.getLevel(destinationType);
                                    if (nextLevel != null) {
                                        _player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                                        _player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
                                        _player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
                                        for (MobEffectInstance instance : _player.getActiveEffects())
                                            _player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), instance, true));
                                        _player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                                    }
                                }
                            }
                        }
                        entity.fallDistance = 0;
                        entity.teleportTo(NBTProcessor.getNBTDouble(stack, "TpX"), NBTProcessor.getNBTDouble(stack, "TpY"), NBTProcessor.getNBTDouble(stack, "TpZ"));
                        if (entity instanceof ServerPlayer _serverPlayer)
                            _serverPlayer.connection.teleport(NBTProcessor.getNBTDouble(stack, "TpX"), NBTProcessor.getNBTDouble(stack, "TpY"), NBTProcessor.getNBTDouble(stack, "TpZ"), entity.getYRot(), entity.getXRot());
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY()), (entity.getZ()), 50, 0.5, 1.5, 0.5, 0);
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.NEUTRAL, 1, 1);
                            } else {
                                _level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.NEUTRAL, 1, 1, false);
                            }
                        }
                        if (UEConfig.NEED_ANCHOR.get()) {
                            entity.getPersistentData().putString("TargetDimension", NBTProcessor.getNBTString(stack, "TpW"));
                            entity.getPersistentData().putDouble("TargetX", NBTProcessor.getNBTDouble(stack, "TpX") - 0.5);
                            entity.getPersistentData().putDouble("TargetY", NBTProcessor.getNBTDouble(stack, "TpY"));
                            entity.getPersistentData().putDouble("TargetZ", NBTProcessor.getNBTDouble(stack, "TpZ") - 0.5);
                            UnusualEndVariables.PlayerVariables variables = entity.getData(UnusualEndVariables.PLAYER_VARIABLES.get());
                            variables.teleporting = true;
                            variables.syncPlayerVariables(entity);
                        }
                    } else {
                        entity.teleportTo(x, 260, z);
                        if (entity instanceof ServerPlayer _serverPlayer)
                            _serverPlayer.connection.teleport(x, 260, z, entity.getYRot(), entity.getXRot());
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.PHANTOM_AMBIENT, SoundSource.PLAYERS, 2, 1);
                            } else {
                                _level.playLocalSound(x, y, z, SoundEvents.PHANTOM_AMBIENT, SoundSource.PLAYERS, 2, 1, false);
                            }
                        }
                        if (!world.isClientSide()) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0, false, true));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 0));
                        }
                        UnusualEnd.queueServerWork(5, () -> {
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y, z, 25, 0.5, 0.5, 0.5, 0);
                        });
                    }
                }
            }
        }
    }
}
