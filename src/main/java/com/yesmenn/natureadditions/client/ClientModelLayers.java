package com.yesmenn.natureadditions.client;

import com.yesmenn.natureadditions.YMNatureAdditions;
import com.yesmenn.natureadditions.client.model.LargeCampfireModel;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(
        modid = YMNatureAdditions.MODID
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