package net.sashakyotoz.unusualend.common.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EntityShapeContext;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.sashakyotoz.unusualend.common.blocks.ModBlocks;

public class CustomCollisionBlock extends Block {
    public CustomCollisionBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.isOf(ModBlocks.SPECTRAL_BLOCK))
            return ((EntityShapeContext) context).getEntity() instanceof PlayerEntity ? VoxelShapes.empty() : getOutlineShape(state, world, pos, context);
        if (state.isOf(ModBlocks.PHANTOM_MEMBRANE_BLOCK))
            return ((EntityShapeContext) context).getEntity() instanceof PlayerEntity ? getOutlineShape(state, world, pos, context) : VoxelShapes.empty();
        return super.getOutlineShape(state, world, pos, context);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0.5, 0.5, 0.5, 15.5, 15.5, 15.5);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (state.isOf(ModBlocks.SPECTRAL_BLOCK) && entity instanceof PlayerEntity player)
            player.fallDistance = 0;
    }
}