package com.yesmenn.decoradditions.client;

import com.yesmenn.decoradditions.YMDecorAdditions;
import com.yesmenn.decoradditions.client.renderer.LargeCampfireItemRenderer;
import com.yesmenn.decoradditions.registry.ModItems;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@SuppressWarnings("removal")
@EventBusSubscriber(
        modid = YMDecorAdditions.MODID,
        value = Dist.CLIENT,
        bus = EventBusSubscriber.Bus.MOD
)
public class ClientItemExtensions {

    @SubscribeEvent
    public static void registerClientExtensions(
            RegisterClientExtensionsEvent event
    ) {
        event.registerItem(
                new IClientItemExtensions() {

                    private final LargeCampfireItemRenderer renderer =
                            new LargeCampfireItemRenderer();

                    @Override
                    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                        return renderer;
                    }
                },
                ModItems.LARGE_CAMPFIRE.get()
        );
    }
}