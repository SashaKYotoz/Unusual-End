package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class EndermiteEggUpdateTickProcedure {
    public static void execute(LevelAccessor level, double x, double y, double z, BlockState blockstate) {
        boolean nearby_player = false;
        if (!level.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
            nearby_player = false;
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = level.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (entityiterator instanceof Player) {
                        if (!entityiterator.isShiftKeyDown()) {
                            if (!(entityiterator instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.INVISIBILITY))) {
                                if (!(ProcedureHelper.isCreative(entityiterator) || ProcedureHelper.isSpectator(entityiterator))) {
                                    nearby_player = true;
                                }
                            }
                        }
                    }
                }
            }
            if (nearby_player) {
                level.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(UnusualEndBlocks.ENDERMITE_EGGS.get().defaultBlockState()));
                ProcedureHelper.playSound(level, x, y, z, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS, 1, 1);
                if (Math.random() < 0.9) {

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = UnusualEndBlocks.CRACKED_ENDERMITE_EGGS.get().defaultBlockState();
                    BlockState _bso = level.getBlockState(_bp);
                    for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null)
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception e) {
                            }
                    }
                    BlockEntity _be = level.getBlockEntity(_bp);
                    CompoundTag _bnbt = null;
                    if (_be != null) {
                        _bnbt = _be.saveWithFullMetadata(level.registryAccess());
                        _be.setRemoved();
                    }
                    level.setBlock(_bp, _bs, 3);
                    if (_bnbt != null) {
                        _be = level.getBlockEntity(_bp);
                        if (_be != null) {
                            try {
                                _be.loadWithComponents(_bnbt, level.registryAccess());
                            } catch (Exception ignored) {
                            }
                        }
                    }
                }
            }
        }
        if (!((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep11 ? blockstate.getValue(_getep11).toString() : "").equals("FLOOR") && level.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()
                || (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep14 ? blockstate.getValue(_getep14).toString() : "").equals("CEILING")
                && level.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
                || (ProcedureHelper.getDirection(blockstate)) == Direction.NORTH && level.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude() || (ProcedureHelper.getDirection(blockstate)) == Direction.EAST && level.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude() || (ProcedureHelper.getDirection(blockstate)) == Direction.SOUTH && level.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude() || (ProcedureHelper.getDirection(blockstate)) == Direction.WEST && level.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude())) {
            BreakEggProcedure.execute(level, x, y, z);
        }
    }
}
