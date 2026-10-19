package com.yesmenn.natureadditions.registry;

import com.yesmenn.natureadditions.YMNatureAdditions;
import com.yesmenn.natureadditions.block.*;
import com.yesmenn.natureadditions.block.LargeCampfireBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(YMNatureAdditions.MODID);

    public static final DeferredBlock<Block> MEADOW_BUSH = BLOCKS.register("meadow_bush",
            () -> new MeadowBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)));

    public static final DeferredBlock<Block> MEADOW_GRASS = BLOCKS.register("meadow_grass",
            () -> new MeadowGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)));
    
    public static final DeferredBlock<Block> FERN_BUSH = BLOCKS.register("fern_bush",
            () -> new FernBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)));
    
    public static final DeferredBlock<Block> PAMPAS_GRASS = BLOCKS.register("pampas_grass",
            () -> new PampasGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)));

    public static final DeferredBlock<Block> MASCHEN_FENCE = BLOCKS.register("maschen_fence",
            () -> new MaschenFenceBlock(BlockBehaviour.Properties.of().strength(2.0f, 3.0f)
                    .dynamicShape()));


    public static final DeferredBlock<LargeCampfireBlock> LARGE_CAMPFIRE =
            BLOCKS.registerBlock(
                    "large_campfire",
                    LargeCampfireBlock::new,
                    BlockBehaviour.Properties.of()
                            .strength(2.0F)
                            .noOcclusion()
            );
    
    public static final DeferredBlock<PicketFenceBlock> PICKET_FENCE =
            BLOCKS.registerBlock(
                    "picket_fence",
                    PicketFenceBlock::new,
                    BlockBehaviour.Properties.of()
                            .strength(2.0F)
                            .noOcclusion()
            );

}