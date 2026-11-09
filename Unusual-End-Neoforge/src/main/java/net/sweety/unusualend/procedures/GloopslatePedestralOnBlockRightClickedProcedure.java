package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.sweety.unusualend.init.UnusualEndBlocks;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.util.ProcedureHelper;

import java.util.concurrent.atomic.AtomicInteger;

public class GloopslatePedestralOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UnusualEndItems.PRISMATIC_PEARL.get()) {
            if (new Object() {
                public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                    AtomicInteger _retval = new AtomicInteger(0);
                    BlockEntity _ent = world.getBlockEntity(pos);
                    if (_ent instanceof BaseContainerBlockEntity entity1) {
                        InvWrapper wrapper = new InvWrapper(entity1);
                        return wrapper.getStackInSlot(slotid).getCount();
                    }
                    return _retval.get();
                }
            }.getAmount(world, BlockPos.containing(x, y, z), 0) == 0) {
                if (!(ProcedureHelper.isCreative(entity))) {
                    (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                }
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y + 1.5), (z + 0.5), 15, 0.4, 0.4, 0.4, 0.01);
                ProcedureHelper.playSound(world, x, y, z, SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1, 1);
                {
                    BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                    if (_ent instanceof BaseContainerBlockEntity entity1) {
                        final ItemStack _setstack = new ItemStack(UnusualEndBlocks.PRISMATIC_PEARL_DISPLAY.get()).copy();
                        _setstack.setCount(1);
                        InvWrapper wrapper = new InvWrapper(entity1);
                        wrapper.setStackInSlot(0, _setstack);
                    }
                }
            }
        }
    }
}
