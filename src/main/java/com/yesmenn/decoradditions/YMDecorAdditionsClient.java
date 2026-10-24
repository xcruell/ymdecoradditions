package com.yesmenn.decoradditions;

import com.yesmenn.decoradditions.client.renderer.EnvoKiller3000Renderer;
import com.yesmenn.decoradditions.registry.YMBlockEntities;
import com.yesmenn.decoradditions.client.model.LargeCampfireModel;
import com.yesmenn.decoradditions.client.renderer.LargeCampfireRenderer;
import com.yesmenn.decoradditions.registry.YMBlocks;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = YMDecorAdditions.MODID, value = Dist.CLIENT)
public final class YMDecorAdditionsClient {
    private YMDecorAdditionsClient() {
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
        }, YMBlocks.MEADOW_BUSH.get());

        event.register((state, level, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return 0xFFFFFF;
            }

            return level != null && pos != null
                    ? BiomeColors.getAverageGrassColor(level, pos)
                    : GrassColor.get(0.5D, 1.0D);
        }, YMBlocks.MEADOW_GRASS.get());

        event.register((state, level, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return 0xFFFFFF;
            }

            return level != null && pos != null
                    ? BiomeColors.getAverageGrassColor(level, pos)
                    : GrassColor.get(0.5D, 1.0D);
        }, YMBlocks.FERN_BUSH.get());
        
        event.register((state, level, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return 0xFFFFFF;
            }

            return level != null && pos != null
                    ? BiomeColors.getAverageGrassColor(level, pos)
                    : GrassColor.get(0.5D, 1.0D);
        }, YMBlocks.PAMPAS_GRASS.get());
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
                YMBlockEntities.LARGE_CAMPFIRE.get(),
                LargeCampfireRenderer::new
        );
        event.registerBlockEntityRenderer(
                YMBlockEntities.ENVOKILLER3000.get(),
                EnvoKiller3000Renderer::new
        );
    }

    @SubscribeEvent
    public static void registerAdditionalModels(
            ModelEvent.RegisterAdditional event
    ) {
        event.register(
                LargeCampfireRenderer.FIRE_MODEL
        );
        event.register(
                EnvoKiller3000Renderer.ENVO_FLAME
        );
    }


}
