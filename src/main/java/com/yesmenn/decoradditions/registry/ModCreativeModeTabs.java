package com.yesmenn.decoradditions.registry;

import com.yesmenn.decoradditions.YMDecorAdditions;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> YM_DECOR_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(YMDecorAdditions.MODID, "yes_menn"));

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, YMDecorAdditions.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YM_DECOR =
            CREATIVE_MODE_TABS.register("yes_menn", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ymdecoradditions"))
                    .icon(() -> ModItems.MEADOW_BUSH_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        acceptItems(output);
                        acceptBlocks(output);
                    }).build());

    private ModCreativeModeTabs() {
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        acceptBlocks(event);
        acceptItems(event);
    }

    private static void acceptBlocks(CreativeModeTab.Output output) {
        output.accept(YMBlocks.FERN_BUSH.get());
        output.accept(YMBlocks.MEADOW_BUSH.get());
        output.accept(YMBlocks.MEADOW_GRASS.get());
        output.accept(YMBlocks.PAMPAS_GRASS.get());
        output.accept(YMBlocks.PICKET_FENCE.get());
        output.accept(YMBlocks.MASCHEN_FENCE.get());
        output.accept(YMBlocks.LARGE_CAMPFIRE.get());
        output.accept(YMBlocks.ENVOKILLER3000.get());

    }

    private static void acceptItems(CreativeModeTab.Output output) {
        //output.accept(ModItems.FERN_BUSH_ITEM.get());
        //output.accept(ModItems.MEADOW_BUSH_ITEM.get());
        //output.accept(ModItems.PAMPAS_GRASS_ITEM.get());
    }
}