package net.mcreator.unusualend.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;

import net.mcreator.unusualend.network.UnusualendModVariables;
import net.mcreator.unusualend.init.UnusualendModItems;
import net.mcreator.unusualend.configuration.UEConfig;
import net.mcreator.unusualend.UnusualEnd;

public class VoidTotemItemInInventoryTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (entity.getY() < UEConfig.VOID_TOTEM_Y.get()) {
            if ((entity.level().dimension()) == Level.END) {
                if (!((entity instanceof Player _plrCldRem6 ? _plrCldRem6.getCooldowns().getCooldownPercent(itemstack.getItem(), 0f) * 100 : 0) > 0)) {
                    if (world.isClientSide()) {
                        if (world.isClientSide())
                            Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(UnusualendModItems.VOID_TOTEM.get()));
                    }
                    if (entity instanceof Player _player)
                        _player.getCooldowns().addCooldown(itemstack.getItem(), (int) (double) UEConfig.VOID_TOTEM.get());
                    if (entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack(UnusualendModItems.VOID_TOTEM.get());
                        _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
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
                    if (itemstack.getOrCreateTag().getBoolean("LinkedTotem")) {
                        if (!(itemstack.getOrCreateTag().getString("TpW")).equals("" + entity.level().dimension())) {
                            if ((itemstack.getOrCreateTag().getString("TpW")).equals("" + Level.OVERWORLD)) {
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
                                            _player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
                                        _player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                                    }
                                }
                            }
                            if ((itemstack.getOrCreateTag().getString("TpW")).equals("" + Level.NETHER)) {
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
                                            _player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
                                        _player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                                    }
                                }
                            }
                            if ((itemstack.getOrCreateTag().getString("TpW")).equals("" + Level.END)) {
                                if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
                                    ResourceKey<Level> destinationType = Level.END;
                                    if (_player.level().dimension() == destinationType)
                                        return;
                                    ServerLevel nextLevel = _player.server.getLevel(destinationType);
                                    if (nextLevel != null) {
                                        _player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                                        _player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
                                        _player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
                                        for (MobEffectInstance _effectinstance : _player.getActiveEffects())
                                            _player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
                                        _player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
                                    }
                                }
                            }
                        }
                        entity.fallDistance = 0;
                        {
                            Entity _ent = entity;
                            _ent.teleportTo((itemstack.getOrCreateTag().getDouble("TpX")), (itemstack.getOrCreateTag().getDouble("TpY")), (itemstack.getOrCreateTag().getDouble("TpZ")));
                            if (_ent instanceof ServerPlayer _serverPlayer)
                                _serverPlayer.connection.teleport((itemstack.getOrCreateTag().getDouble("TpX")), (itemstack.getOrCreateTag().getDouble("TpY")), (itemstack.getOrCreateTag().getDouble("TpZ")), _ent.getYRot(), _ent.getXRot());
                        }
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
                            entity.getPersistentData().putString("TargetDimension", (itemstack.getOrCreateTag().getString("TpW")));
                            entity.getPersistentData().putDouble("TargetX", (itemstack.getOrCreateTag().getDouble("TpX") - 0.5));
                            entity.getPersistentData().putDouble("TargetY", (itemstack.getOrCreateTag().getDouble("TpY")));
                            entity.getPersistentData().putDouble("TargetZ", (itemstack.getOrCreateTag().getDouble("TpZ") - 0.5));
                            UnusualendModVariables.PlayerVariables variables = entity.getData(UnusualendModVariables.PLAYER_VARIABLES.get());
                            variables.isTeleporting = true;
                            variables.syncPlayerVariables(entity);
                        }
                    } else {
                        {
                            Entity _ent = entity;
                            _ent.teleportTo(x, 260, z);
                            if (_ent instanceof ServerPlayer _serverPlayer)
                                _serverPlayer.connection.teleport(x, 260, z, _ent.getYRot(), _ent.getXRot());
                        }
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
