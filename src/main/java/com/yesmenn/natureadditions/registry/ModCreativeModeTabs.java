package com.yesmenn.natureadditions.registry;

import com.yesmenn.natureadditions.YMNatureAdditions;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> YM_NATURE_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(YMNatureAdditions.MODID, "yes_menn"));

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, YMNatureAdditions.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> YM_NATURE =
            CREATIVE_MODE_TABS.register("yes_menn", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ymnatureadditions"))
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
        output.accept(ModBlocks.FERN_BUSH.get());
        output.accept(ModBlocks.MEADOW_BUSH.get());
        output.accept(ModBlocks.MEADOW_GRASS.get());
        output.accept(ModBlocks.PAMPAS_GRASS.get());
        output.accept(ModBlocks.PICKET_FENCE.get());
        output.accept(ModBlocks.MASCHEN_FENCE.get());
        output.accept(ModBlocks.LARGE_CAMPFIRE.get());
    }

    private static void acceptItems(CreativeModeTab.Output output) {
        //output.accept(ModItems.FERN_BUSH_ITEM.get());
        //output.accept(ModItems.MEADOW_BUSH_ITEM.get());
        //output.accept(ModItems.PAMPAS_GRASS_ITEM.get());
    }
}