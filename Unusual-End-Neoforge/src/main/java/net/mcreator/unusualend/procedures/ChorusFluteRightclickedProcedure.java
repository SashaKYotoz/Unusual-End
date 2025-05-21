package net.mcreator.unusualend.procedures;

import net.mcreator.unusualend.UnusualEnd;
import net.mcreator.unusualend.init.UnusualendModSounds;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

public class ChorusFluteRightclickedProcedure {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        double random = 0;
        if (entity instanceof Player _player)
            _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
        if (!(entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel
                && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().get(UnusualEnd.makeUEID("using_chorus_flute"))).isDone())) {
            if (entity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(UnusualEnd.makeUEID("using_chorus_flute"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria())
                        _player.getAdvancements().award(_adv, criteria);
                }
            }
        }
        if ((itemstack.getOrCreateTag().getString("track")).equals("Circus")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_CIRCUS.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_CIRCUS.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Suspicious")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_CIRCUS.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_CIRCUS.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Storms")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_STORMS.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_STORMS.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Saria")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_SARIA.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_SARIA.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Party")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_PARTY.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_PARTY.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Docks")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_DOCKS.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_DOCKS.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Tapion")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_TAPION.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_TAPION.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Drift")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_DRIFT.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_DRIFT.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Doctor")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_DOCTOR.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_DOCTOR.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Fishe")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_FISHE.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_FISHE.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Aria")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_ARIA.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_ARIA.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else if ((itemstack.getOrCreateTag().getString("track")).equals("Moog")) {
            if (!world.isClientSide()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_MOOG.get(), SoundSource.RECORDS, 6, 1);
                    } else {
                        _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_MOOG.get(), SoundSource.RECORDS, 6, 1, false);
                    }
                }
            }
        } else {
            random = Mth.nextInt(RandomSource.create(), 1, 12);
            if (!world.isClientSide()) {
                if (random == 1) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_CIRCUS.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_CIRCUS.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 2) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_TAPION.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_TAPION.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 3) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_STRANGE.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_STRANGE.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 4) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_STORMS.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_STORMS.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 5) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_SARIA.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_SARIA.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 6) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_PARTY.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_PARTY.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 7) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_DOCKS.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_DOCKS.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 8) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_DRIFT.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()),UnusualendModSounds.FLUTE_DRIFT.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 9) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_DOCTOR.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_DOCTOR.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 10) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_ARIA.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_ARIA.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 11) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_MOOG.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_MOOG.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                } else if (random == 12) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), UnusualendModSounds.FLUTE_FISHE.get(), SoundSource.RECORDS, 6, 1);
                        } else {
                            _level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), UnusualendModSounds.FLUTE_FISHE.get(), SoundSource.RECORDS, 6, 1, false);
                        }
                    }
                }
            }
        }
    }
}