package com.yesmenn.natureadditions.registry;

import com.yesmenn.natureadditions.YMNatureAdditions;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YMNatureAdditions.MODID);

    public static final DeferredItem<BlockItem> MEADOW_BUSH_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.MEADOW_BUSH);
    public static final DeferredItem<BlockItem> MEADOW_GRASS_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.MEADOW_GRASS);
    public static final DeferredItem<BlockItem> FERN_BUSH_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.FERN_BUSH);
    public static final DeferredItem<BlockItem> PAMPAS_GRASS_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.PAMPAS_GRASS);
    public static final DeferredItem<BlockItem> PICKET_FENCE_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.PICKET_FENCE);
    public static final DeferredItem<BlockItem> MASCHEN_FENCE_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.MASCHEN_FENCE);

    public static final DeferredItem<BlockItem> LARGE_CAMPFIRE =
            ITEMS.register(
                    "large_campfire",
                    () -> new BlockItem(
                            ModBlocks.LARGE_CAMPFIRE.get(),
                            new Item.Properties()
                    )
            );

    private ModItems() {
    }
}