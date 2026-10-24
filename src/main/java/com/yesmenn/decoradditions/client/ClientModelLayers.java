package com.yesmenn.decoradditions.client;

import com.yesmenn.decoradditions.YMDecorAdditions;
import com.yesmenn.decoradditions.client.model.LargeCampfireModel;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(
        modid = YMDecorAdditions.MODID
)
public class ClientModelLayers {

    @SubscribeEvent
    public static void registerLayerDefinitions(
            EntityRenderersEvent.RegisterLayerDefinitions event
    ) {
        event.registerLayerDefinition(
                LargeCampfireModel.LAYER_LOCATION,
                LargeCampfireModel::createBodyLayer
        );
    }
}