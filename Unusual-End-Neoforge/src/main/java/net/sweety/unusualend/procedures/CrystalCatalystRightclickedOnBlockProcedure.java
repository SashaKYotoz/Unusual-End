package net.sweety.unusualend.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.init.UnusualEndItems;

import java.util.Iterator;

@EventBusSubscriber
public class CrystalCatalystRightclickedOnBlockProcedure {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }

    private static void execute(LevelAccessor level, double x, double y, double z, Player player) {
        if (player.getMainHandItem().is(UnusualEndItems.CRYSTAL_CATALYST.get())) {
            if (player.isShiftKeyDown()) {
                if ((level.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BEACON) {
                    if (!(player instanceof ServerPlayer _plr5 && _plr5.level() instanceof ServerLevel
                            && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().get(UnusualEnd.makeUEID("obtain_catalyst"))).isDone())) {
                        if (player instanceof ServerPlayer _player) {
                            AdvancementHolder _adv = _player.server.getAdvancements().get(UnusualEnd.makeUEID("obtain_catalyst"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone())
                                for (String s : _ap.getRemainingCriteria()) _player.getAdvancements().award(_adv, s);
                        }
                    }
                    if (!player.getCooldowns().isOnCooldown((player.getMainHandItem().getItem())))
                        player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 10);

                    NBTProcessor.setNBTDouble(player.getMainHandItem(),"Catalyser", 1);
                    NBTProcessor.setNBTString(player.getMainHandItem(),"buff", (Component.translatable("text.unusualend.catalyst_description_beacon").getString()));
                    if (player.getMainHandItem().is(UnusualEndItems.CRYSTAL_CATALYST.get()))
                        player.swing(InteractionHand.MAIN_HAND, true);
                    else
                        player.swing(InteractionHand.OFF_HAND, true);
                    if (level instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS, 1, 1, false);
                        }
                    }
                    if (level instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 0.5), (z + 0.5), 15, 0.4, 0.4, 0.4, 0);
                } else if ((level.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CONDUIT) {
                    if (!(player instanceof ServerPlayer _plr24 && _plr24.level() instanceof ServerLevel
                            && _plr24.getAdvancements().getOrStartProgress(_plr24.server.getAdvancements().get(UnusualEnd.makeUEID("obtain_catalyst"))).isDone())) {
                        if (player instanceof ServerPlayer _player) {
                            AdvancementHolder _adv = _player.server.getAdvancements().get(UnusualEnd.makeUEID("obtain_catalyst"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String s : _ap.getRemainingCriteria()) _player.getAdvancements().award(_adv, s);
                            }
                        }
                    }
                    if (!(player instanceof Player _player ? _player.getCooldowns().isOnCooldown((player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) : false)) {
                        if (player instanceof Player _player)
                            _player.getCooldowns().addCooldown((player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 10);
                    }
                    NBTProcessor.setNBTDouble(player.getMainHandItem(),"Catalyser", 2);
                    if ((player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualEndItems.CRYSTAL_CATALYST.get()) {
                        if (player instanceof LivingEntity _entity)
                            _entity.swing(InteractionHand.MAIN_HAND, true);
                    } else {
                        if (player instanceof LivingEntity _entity)
                            _entity.swing(InteractionHand.OFF_HAND, true);
                    }
                    if (level instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CONDUIT_ACTIVATE, SoundSource.BLOCKS, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, SoundEvents.CONDUIT_ACTIVATE, SoundSource.BLOCKS, 1, 1, false);
                        }
                    }
                    if (level instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.SPLASH, (x + 0.5), (y + 0.5), (z + 0.5), 15, 0.4, 0.4, 0.4, 1);
                    NBTProcessor.setNBTString(player.getMainHandItem(),"buff", (Component.translatable("text.unusualend.catalyst_description_conduit").getString()));
                } else if ((level.getBlockState(BlockPos.containing(x, y, z))).getBlock() == UnusualEndBlocks.PEARLESCENT_INFUSER.get()) {
                    if (!(player instanceof Player _player ? _player.getCooldowns().isOnCooldown((player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) : false)) {
                        if (player instanceof Player _player)
                            _player.getCooldowns().addCooldown((player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 10);
                    }
                    if (!(player instanceof ServerPlayer _plr47 && _plr47.level() instanceof ServerLevel
                            && _plr47.getAdvancements().getOrStartProgress(_plr47.server.getAdvancements().get(UnusualEnd.makeUEID("obtain_catalyst"))).isDone())) {
                        if (player instanceof ServerPlayer _player) {
                            AdvancementHolder _adv = _player.server.getAdvancements().get(UnusualEnd.makeUEID("obtain_catalyst"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                Iterator _iterator = _ap.getRemainingCriteria().iterator();
                                while (_iterator.hasNext())
                                    _player.getAdvancements().award(_adv, (String) _iterator.next());
                            }
                        }
                    }
                    NBTProcessor.setNBTDouble(player.getMainHandItem(),"Catalyser", 3);
                    if ((player instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualEndItems.CRYSTAL_CATALYST.get()) {
                        if (player instanceof LivingEntity _entity)
                            _entity.swing(InteractionHand.MAIN_HAND, true);
                    } else {
                        if (player instanceof LivingEntity _entity)
                            _entity.swing(InteractionHand.OFF_HAND, true);
                    }
                    if (level instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1, (float) 0.5);
                        } else {
                            _level.playLocalSound(x, y, z, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1, (float) 0.5, false);
                        }
                    }
                    if (level instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.WITCH, (x + 0.5), (y + 0.5), (z + 0.5), 15, 0.4, 0.4, 0.4, 1);
                    NBTProcessor.setNBTString(player.getMainHandItem(),"buff", (Component.translatable("text.unusualend.catalyst_description_infuser").getString()));
                }
            }
        }
    }
}