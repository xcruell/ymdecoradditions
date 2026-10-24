package com.yesmenn.decoradditions.block.entity;

import com.yesmenn.decoradditions.block.LargeCampfireBlock;
import com.yesmenn.decoradditions.registry.YMBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LargeCampfireBlockEntity extends BlockEntity {

    public LargeCampfireBlockEntity(BlockPos pos, BlockState state) {
        super(YMBlockEntities.LARGE_CAMPFIRE.get(), pos, state);
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