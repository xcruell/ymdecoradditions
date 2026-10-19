package com.yesmenn.natureadditions.client;

import com.yesmenn.natureadditions.YMNatureAdditions;
import com.yesmenn.natureadditions.block.ModBlockEntities;
import com.yesmenn.natureadditions.client.renderer.LargeCampfireRenderer;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(
        modid = YMNatureAdditions.MODID,
        value = Dist.CLIENT
)
public class ClientRenderers {

    @SubscribeEvent
    public static void registerRenderers(
            EntityRenderersEvent.RegisterRenderers event
    ) {
        event.registerBlockEntityRenderer(
                ModBlockEntities.LARGE_CAMPFIRE.get(),
                LargeCampfireRenderer::new
        );
    }
}