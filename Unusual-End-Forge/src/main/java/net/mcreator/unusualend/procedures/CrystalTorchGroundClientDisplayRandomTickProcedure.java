package net.mcreator.unusualend.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;

import net.mcreator.unusualend.init.UnusualendModParticleTypes;

public class CrystalTorchGroundClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep1 ? blockstate.getValue(_getep1).toString() : "").equals("FLOOR")) {
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				world.addParticle((SimpleParticleType) (UnusualendModParticleTypes.PINK_FLAME.get()), (x + 0.5), (y + 0.75), (z + 0.5), 0, 0, 0);
			} else {
				world.addParticle(ParticleTypes.ELECTRIC_SPARK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), (y + 0.75 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)),
						(z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), 0, 0, 0);
			}
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.EAST) {
			world.addParticle((SimpleParticleType) (UnusualendModParticleTypes.PINK_FLAME.get()), (x + 0.22), (y + 0.88), (z + 0.5), 0, 0, 0);
			world.addParticle(ParticleTypes.ELECTRIC_SPARK, (x + 0.22 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), (y + 0.88 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)),
					(z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), 0, 0, 0);
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.NORTH) {
			world.addParticle((SimpleParticleType) (UnusualendModParticleTypes.PINK_FLAME.get()), (x + 0.5), (y + 0.88), (z + 0.78), 0, 0, 0);
			world.addParticle(ParticleTypes.ELECTRIC_SPARK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), (y + 0.88 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)),
					(z + 0.78 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), 0, 0, 0);
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.SOUTH) {
			world.addParticle((SimpleParticleType) (UnusualendModParticleTypes.PINK_FLAME.get()), (x + 0.5), (y + 0.88), (z + 0.22), 0, 0, 0);
			world.addParticle(ParticleTypes.ELECTRIC_SPARK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), (y + 0.88 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)),
					(z + 0.22 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), 0, 0, 0);
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.WEST) {
			world.addParticle((SimpleParticleType) (UnusualendModParticleTypes.PINK_FLAME.get()), (x + 0.78), (y + 0.88), (z + 0.5), 0, 0, 0);
			world.addParticle(ParticleTypes.ELECTRIC_SPARK, (x + 0.78 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), (y + 0.88 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)),
					(z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), 0, 0, 0);
		}
	}
}
