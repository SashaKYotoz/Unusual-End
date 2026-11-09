package net.sweety.unusualend.enchantment;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.sweety.unusualend.init.UnusualEndMiscRegister;

import java.util.Set;

public record FullHealthCondition(LootContext.EntityTarget target) implements LootItemCondition {
    public static final MapCodec<FullHealthCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            LootContext.EntityTarget.CODEC.fieldOf("entity").forGetter(FullHealthCondition::target)
    ).apply(instance, FullHealthCondition::new));

    public static LootItemCondition.Builder of(LootContext.EntityTarget target) {
        return () -> new FullHealthCondition(target);
    }

    public static boolean isAtFullHealth(Entity entity) {
        return entity instanceof LivingEntity living && living.isAlive() && living.getHealth() >= living.getMaxHealth();
    }

    @Override
    public LootItemConditionType getType() {
        return UnusualEndMiscRegister.FULL_HEALTH_CONDITION.get();
    }

    @Override
    public Set<LootContextParam<?>> getReferencedContextParams() {
        return Set.of(this.target.getParam());
    }

    @Override
    public boolean test(LootContext context) {
        return isAtFullHealth(context.getParamOrNull(this.target.getParam()));
    }
}
