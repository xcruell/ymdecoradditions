package com.yesmenn.natureadditions;

import com.yesmenn.natureadditions.block.ModBlockEntities;
import com.yesmenn.natureadditions.client.model.LargeCampfireModel;
import com.yesmenn.natureadditions.client.renderer.LargeCampfireRenderer;
import com.yesmenn.natureadditions.registry.ModBlocks;
import com.yesmenn.natureadditions.registry.ModItems;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = YMNatureAdditions.MODID, value = Dist.CLIENT)
public final class YMNatureAdditionsClient {
    private YMNatureAdditionsClient() {
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return 0xFFFFFF;
            }

            return level != null && pos != null
                    ? BiomeColors.getAverageGrassColor(level, pos)
                    : GrassColor.get(0.5D, 1.0D);
        }, ModBlocks.MEADOW_BUSH.get());

        event.register((state, level, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return 0xFFFFFF;
            }

            return level != null && pos != null
                    ? BiomeColors.getAverageGrassColor(level, pos)
                    : GrassColor.get(0.5D, 1.0D);
        }, ModBlocks.MEADOW_GRASS.get());

        event.register((state, level, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return 0xFFFFFF;
            }

            return level != null && pos != null
                    ? BiomeColors.getAverageGrassColor(level, pos)
                    : GrassColor.get(0.5D, 1.0D);
        }, ModBlocks.FERN_BUSH.get());
        
        event.register((state, level, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return 0xFFFFFF;
            }

            return level != null && pos != null
                    ? BiomeColors.getAverageGrassColor(level, pos)
                    : GrassColor.get(0.5D, 1.0D);
        }, ModBlocks.PAMPAS_GRASS.get());
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(
            EntityRenderersEvent.RegisterLayerDefinitions event
    ) {
        event.registerLayerDefinition(
                LargeCampfireModel.LAYER_LOCATION,
                LargeCampfireModel::createBodyLayer
        );
    }

    @SubscribeEvent
    public static void registerRenderers(
            EntityRenderersEvent.RegisterRenderers event
    ) {
        event.registerBlockEntityRenderer(
                ModBlockEntities.LARGE_CAMPFIRE.get(),
                LargeCampfireRenderer::new
        );
    }

    @SubscribeEvent
    public static void registerAdditionalModels(
            ModelEvent.RegisterAdditional event
    ) {
        event.register(
                LargeCampfireRenderer.FIRE_MODEL
        );
    }


}
