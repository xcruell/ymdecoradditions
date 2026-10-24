package com.yesmenn.decoradditions.client;

import com.yesmenn.decoradditions.YMDecorAdditions;
import com.yesmenn.decoradditions.client.renderer.EnvoKiller3000Renderer;
import com.yesmenn.decoradditions.registry.YMBlockEntities;
import com.yesmenn.decoradditions.client.renderer.LargeCampfireRenderer;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(
        modid = YMDecorAdditions.MODID,
        value = Dist.CLIENT
)
public class ClientRenderers {

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
}