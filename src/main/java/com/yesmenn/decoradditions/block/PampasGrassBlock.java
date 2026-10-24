package com.yesmenn.decoradditions.block;

import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PampasGrassBlock extends DoublePlantBlock {
    protected static final VoxelShape BOTTOM_SHAPE = box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    protected static final VoxelShape TOP_SHAPE = box(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

    public PampasGrassBlock(BlockBehaviour.Properties properties) {
        super(properties.dynamicShape());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        DoubleBlockHalf half = state.getValue(HALF);
        if (half == DoubleBlockHalf.LOWER) {
            return BOTTOM_SHAPE;
        } else {
            return TOP_SHAPE;
        }
    }

}