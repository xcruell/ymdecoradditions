package com.yesmenn.decoradditions.block;

import com.mojang.serialization.MapCodec;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.foundation.block.IBE;
import com.yesmenn.decoradditions.block.entity.EnvoKiller3000BlockEntity;
import com.yesmenn.decoradditions.registry.YMBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class EnvoKiller3000Block extends Block implements IBE<EnvoKiller3000BlockEntity>, IWrenchable {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    private static final VoxelShape SHAPE = Block.box(4, 4, 4, 12, 24, 12);

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public EnvoKiller3000Block(Properties properties) {
        super(properties
                .lightLevel(state -> state.getValue(LIT) ? 15 : 0));

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LIT, false)
                .setValue(POWERED, false)
        );
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {

        return this.defaultBlockState()
                .setValue(LIT, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, POWERED);
    }

    @Override
    protected MapCodec<EnvoKiller3000Block> codec() {
        return simpleCodec(EnvoKiller3000Block::new);
    }

    @Override
    public Class<EnvoKiller3000BlockEntity> getBlockEntityClass() {
        return EnvoKiller3000BlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends EnvoKiller3000BlockEntity> getBlockEntityType() {
        return YMBlockEntities.ENVOKILLER3000.get();
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EnvoKiller3000BlockEntity(pos, state);
    }


    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    //Redstone gedönse
    @Override
    protected void neighborChanged(
            BlockState state,
            Level level,
            BlockPos pos,
            Block sourceBlock,
            BlockPos sourcePos,
            boolean isMoving) {

        super.neighborChanged(
                state, level, pos, sourceBlock, sourcePos, isMoving
        );

        if (!level.isClientSide) {
            boolean powered = level.hasNeighborSignal(pos);

            if (state.getValue(POWERED) != powered) {
                level.setBlock(
                        pos,
                        state.setValue(POWERED, powered),
                        3
                );
            }
        }
    }


}