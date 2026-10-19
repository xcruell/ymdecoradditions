package com.yesmenn.natureadditions.block.entity;

import com.yesmenn.natureadditions.block.LargeCampfireBlock;
import com.yesmenn.natureadditions.block.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LargeCampfireBlockEntity extends BlockEntity {

    public LargeCampfireBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LARGE_CAMPFIRE.get(), pos, state);
    }

    public boolean isLit() {
        return getBlockState().getValue(LargeCampfireBlock.LIT);
    }

    public void setLit(boolean lit) {
        if (level != null) {
            BlockState newState = getBlockState()
                    .setValue(LargeCampfireBlock.LIT, lit);

            level.setBlock(
                    worldPosition,
                    newState,
                    3
            );
        }
    }
}