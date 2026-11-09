package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.sweety.unusualend.entity.FlampyrEntity;
import net.sweety.unusualend.init.UnusualEndEntities;
import net.sweety.unusualend.init.UnusualEndItems;
import net.sweety.unusualend.util.ParticleHelper;
import net.sweety.unusualend.util.ProcedureHelper;

public class FireflyEggRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        itemstack.shrink(1);
        if (entity instanceof Player _player)
            _player.getCooldowns().addCooldown(UnusualEndItems.ENDER_FIREFLY_EGG.get(), 5);
        if (world.isClientSide()) {
            ProcedureHelper.playSound(world, x, y, z, SoundEvents.TURTLE_EGG_BREAK, SoundSource.PLAYERS, (float) 0.5, (float) 1.3);
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
                {
                    FlampyrEntity firefly = UnusualEndEntities.FLAMPYR.get().create(_level);
                    if (firefly != null) {
                        firefly.moveTo(x + 0.5, y + 1, z + 0.5, _level.getRandom().nextFloat() * 360f, 0);
                        firefly.setAge(-24000);
                        _level.addFreshEntity(firefly);
                    }
                }
            if (world instanceof ServerLevel level)
                ParticleHelper.spawn(level, ParticleHelper.item(UnusualEndItems.ENDER_FIREFLY_EGG.get()), x + 0.5, y + 1, z + 0.5, 25, 0.2, 0.2, 0.2, 0);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 1), (z + 0.5), 5, 0.5, 0.5, 0.5, 0);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.DRAGON_BREATH, (x + 0.5), (y + 1), (z + 0.5), 5, 0.5, 0.5, 0.5, 0);
            if (world.getBiome(BlockPos.containing(x, y, z)).is(Biomes.MANGROVE_SWAMP) || world.getBiome(BlockPos.containing(x, y, z)).is(Biomes.SWAMP)) {
                ProcedureHelper.awardAdvancement(entity, "firefly_in_swamp");
            }
        } else {
            if (world instanceof ServerLevel level)
                ParticleHelper.spawn(level, ParticleHelper.item(UnusualEndItems.ENDER_FIREFLY_EGG.get()), x + 0.5, y + 1, z + 0.5, 25, 0.2, 0.2, 0.2, 0);
        }
    }
}
