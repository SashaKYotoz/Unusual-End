package net.sweety.unusualend.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.sweety.unusualend.entity.GlubEntity;
import net.sweety.unusualend.init.UnusualendModEntities;
import net.sweety.unusualend.util.ProcedureHelper;

public class UnbucketGlubProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
		if (direction == null || entity == null)
			return;
		String name = "";
		if (!entity.isShiftKeyDown()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
				if (!(ProcedureHelper.isCreative(entity))) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
				if (!(ProcedureHelper.isCreative(entity))) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.OFF_HAND, true);
			}
			if (world instanceof ServerLevel _level) {
				GlubEntity entityToSpawn = UnusualendModEntities.GLUB.get().spawn(_level, BlockPos.containing(x + direction.getStepX(), y + direction.getStepY(), z + direction.getStepZ()), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null)
                    entityToSpawn.setBaby(itemstack.getOrCreateTag().getBoolean("isBaby"));
			}
			ProcedureHelper.playSound(world, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")), SoundSource.NEUTRAL, 1, 1);
			if (!world.getEntitiesOfClass(GlubEntity.class, AABB.ofSize(new Vec3((x + direction.getStepX()), (y + direction.getStepY()), (z + direction.getStepZ())), 1, 1, 1), e -> true).isEmpty()
					&& itemstack.getOrCreateTag().getBoolean("isNamed")) {
				name = itemstack.getDisplayName().getString();
				name = name.substring(1, (name).length() - 1);
				world.getEntitiesOfClass(GlubEntity.class, AABB.ofSize(new Vec3((x + direction.getStepX()), (y + direction.getStepY()), (z + direction.getStepZ())), 1, 1, 1), e -> true).stream().sorted(ProcedureHelper.byDistanceTo((x + direction.getStepX()), (y + direction.getStepY()), (z + direction.getStepZ()))).findFirst().orElse(null).setCustomName(Component.literal(name));
			}
			if (itemstack.getOrCreateTag().getDouble("tagHealth") != 0) {
				if (((Entity) world.getEntitiesOfClass(GlubEntity.class, AABB.ofSize(new Vec3((x + direction.getStepX()), (y + direction.getStepY()), (z + direction.getStepZ())), 1, 1, 1), e -> true).stream().sorted(ProcedureHelper.byDistanceTo((x + direction.getStepX()), (y + direction.getStepY()), (z + direction.getStepZ()))).findFirst().orElse(null)) instanceof LivingEntity _entity)
					_entity.setHealth((float) itemstack.getOrCreateTag().getDouble("tagHealth"));
			}
		}
	}
}
