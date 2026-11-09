
package net.sweety.unusualend.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sweety.unusualend.init.UnusualEndItems;

import java.util.Comparator;
import java.util.List;

public class AncientSwordItem extends SwordItem {
    public AncientSwordItem() {
        super(new Tier() {
            public int getUses() {
                return 1024;
            }

            public float getSpeed() {
                return 8f;
            }

            public float getAttackDamageBonus() {
                return 4f;
            }

            @Override
            public TagKey<Block> getIncorrectBlocksForDrops() {
                return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
            }

            public int getEnchantmentValue() {
                return 16;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(UnusualEndItems.ANCIENT_SHARD.get()));
            }
        }, new Item.Properties().fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack itemstack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("tooltip.unusualend.ancient_sword.0"));
        list.add(Component.translatable("tooltip.unusualend.ancient_sword.1"));
        list.add(Component.translatable("tooltip.unusualend.ancient_sword.2"));
        list.add(Component.translatable("tooltip.unusualend.ancient_sword.3"));
    }

    @SuppressWarnings("removal")
    @Override
    public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
        double xRadius, loop, zRadius, particleAmount;
        Level level = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if (entity.isShiftKeyDown() && entity instanceof Player player) {
            if (!player.getCooldowns().isOnCooldown(itemstack.getItem())) {
                if (!player.isCreative())
                    itemstack.hurtAndBreak(1, player, getEquipmentSlot(itemstack));
                player.getCooldowns().addCooldown(itemstack.getItem(), 200);
                loop = 0;
                particleAmount = 15;
                xRadius = 3;
                zRadius = 3;
                while (loop < particleAmount) {
                    if (level instanceof ServerLevel serverLevel) {
                        double xV = Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius;
                        double zV = Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius;
                        serverLevel.sendParticles(ParticleTypes.SQUID_INK, (x + 0.5 + xV), (y + 1), (z + 0.5 + zV), 3, 0.3, 0.2, 0.3, 0.1);
                        serverLevel.sendParticles(ParticleTypes.END_ROD, (x + 0.5 + xV), (y + 1), (z + 0.5 + zV), 3, 0.3, 0.2, 0.3, 0.1);
                        ParticleHelper.spawn(serverLevel, ParticleHelper.voidParticles(), (x + 0.5 + xV), (y + 1), (z + 0.5 + zV), 5, 0, 0.05, 0, 0);
                    }
                    loop = loop + 1;
                }
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = level.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity iterator : _entfound) {
                    if (iterator != entity && !(iterator instanceof TamableAnimal tamIsTamedBy && tamIsTamedBy.isOwnedBy(player))) {
                        iterator.invulnerableTime = 0;
                        iterator.hurt(new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity), 12);
                    }
                }
                ProcedureHelper.playSound(level, x, y, z, SoundEvents.RESPAWN_ANCHOR_SET_SPAWN, SoundSource.PLAYERS, 1, 2);
            }
        }
        return super.onEntitySwing(itemstack, entity);
    }
}
