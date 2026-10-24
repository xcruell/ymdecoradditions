package com.yesmenn.decoradditions.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PicketFenceBlock extends HorizontalDirectionalBlock {

            private static final VoxelShape SHAPE = Shapes.or(
            Shapes.box(
                    0.0, 0.0, 0.0,
                    1.0, 0.5, 1.0
            ),
            Shapes.box(
                    0.25, 0.5, 0.25,
                    0.75, 1.0, 0.75
            )
    );

    public static final MapCodec<PicketFenceBlock> CODEC =
            simpleCodec(PicketFenceBlock::new);

    public static final BooleanProperty NORTH =
            BooleanProperty.create("north");

    public static final BooleanProperty EAST =
            BooleanProperty.create("east");

    public static final BooleanProperty SOUTH =
            BooleanProperty.create("south");

    public static final BooleanProperty WEST =
            BooleanProperty.create("west");

    public PicketFenceBlock(Properties properties) {
        super(properties);

        registerDefaultState(stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        BlockGetter level = context.getLevel();

        Direction facing = getFacingFromPlayer(context);

        return defaultBlockState()
                .setValue(FACING, facing)
                .setValue(NORTH, connectsTo(level, pos.north()))
                .setValue(EAST, connectsTo(level, pos.east()))
                .setValue(SOUTH, connectsTo(level, pos.south()))
                .setValue(WEST, connectsTo(level, pos.west()));
    }

    private Direction getFacingFromPlayer(BlockPlaceContext context) {
        if (context.getPlayer() == null) {
            return Direction.NORTH;
        }

        BlockPos pos = context.getClickedPos();

        double dx = context.getPlayer().getX() - (pos.getX() + 0.5);
        double dz = context.getPlayer().getZ() - (pos.getZ() + 0.5);

        if (Math.abs(dx) > Math.abs(dz)) {
            return dx > 0 ? Direction.EAST : Direction.WEST;
        }

        return dz > 0 ? Direction.SOUTH : Direction.NORTH;
    }

    @Override
    protected BlockState updateShape(
            BlockState state,
            Direction direction,
            BlockState neighborState,
            LevelAccessor level,
            BlockPos currentPos,
            BlockPos neighborPos
    ) {
        if (!direction.getAxis().isHorizontal()) {
            return state;
        }

        return switch (direction) {
            case NORTH -> state.setValue(
                    NORTH,
                    connectsTo(neighborState)
            );

            case EAST -> state.setValue(
                    EAST,
                    connectsTo(neighborState)
            );

            case SOUTH -> state.setValue(
                    SOUTH,
                    connectsTo(neighborState)
            );

            case WEST -> state.setValue(
                    WEST,
                    connectsTo(neighborState)
            );

            default -> state;
        };
    }

    private boolean connectsTo(BlockGetter level, BlockPos pos) {
        return connectsTo(level.getBlockState(pos));
    }

    private boolean connectsTo(BlockState state) {
        return state.getBlock() instanceof PicketFenceBlock;
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> builder
    ) {
        builder.add(
                FACING,
                NORTH,
                EAST,
                SOUTH,
                WEST
        );
    }
}