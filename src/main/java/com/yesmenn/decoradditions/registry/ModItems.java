package com.yesmenn.decoradditions.registry;

import com.yesmenn.decoradditions.YMDecorAdditions;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YMDecorAdditions.MODID);

    public static final DeferredItem<BlockItem> MEADOW_BUSH_ITEM = ITEMS.registerSimpleBlockItem(YMBlocks.MEADOW_BUSH);
    public static final DeferredItem<BlockItem> MEADOW_GRASS_ITEM = ITEMS.registerSimpleBlockItem(YMBlocks.MEADOW_GRASS);
    public static final DeferredItem<BlockItem> FERN_BUSH_ITEM = ITEMS.registerSimpleBlockItem(YMBlocks.FERN_BUSH);
    public static final DeferredItem<BlockItem> PAMPAS_GRASS_ITEM = ITEMS.registerSimpleBlockItem(YMBlocks.PAMPAS_GRASS);
    public static final DeferredItem<BlockItem> PICKET_FENCE_ITEM = ITEMS.registerSimpleBlockItem(YMBlocks.PICKET_FENCE);
    public static final DeferredItem<BlockItem> MASCHEN_FENCE_ITEM = ITEMS.registerSimpleBlockItem(YMBlocks.MASCHEN_FENCE);

    public static final DeferredItem<BlockItem> LARGE_CAMPFIRE =
            ITEMS.register(
                    "large_campfire",
                    () -> new BlockItem(
                            YMBlocks.LARGE_CAMPFIRE.get(),
                            new Item.Properties()
                    )
            );

    public static final DeferredItem<BlockItem> ENVOKILLER3000 =
            ITEMS.register(
                    "envokiller3000",
                    () -> new BlockItem(
                            YMBlocks.ENVOKILLER3000.get(),
                            new Item.Properties()
                    )
            );

    private ModItems() {
    }
}