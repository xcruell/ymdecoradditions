package com.yesmenn.natureadditions.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ScreenEvent;

@EventBusSubscriber(
        modid = "ymnatureadditions",
        value = Dist.CLIENT
)
public class CreativeBannerRenderer {

    private static final ResourceLocation BANNER =
            ResourceLocation.fromNamespaceAndPath(
                    "ymnatureadditions",
                    "textures/gui/creative_banner.png"
            );

    /*
     * Vanilla Creative Inventory:
     *
     * 9 columns
     * 5 rows
     *
     * We cover one complete row.
     */
    private static final int SLOT_SIZE = 18;

    // Width of 9 Creative slots
    private static final int BANNER_WIDTH = SLOT_SIZE * 9;

    // Height of one slot row
    private static final int BANNER_HEIGHT = SLOT_SIZE;

    @SubscribeEvent
    public static void onCreativeScreenRender(ScreenEvent.Render.Post event) {

        if (!(event.getScreen() instanceof CreativeModeInventoryScreen screen)) {
            return;
        }

        GuiGraphics graphics = event.getGuiGraphics();

        /*
         * Creative inventory is centered.
         *
         * Vanilla creative inventory background is 176px wide.
         */
        int left = (screen.width - 176) / 2;

        /*
         * Top of the actual item grid.
         *
         * Adjust this if necessary depending on exactly
         * which row you want to replace.
         */
        int top = (screen.height - 166) / 2;

        /*
         * Row to replace.
         *
         * 0 = first item row
         * 1 = second
         * 2 = third
         * 3 = fourth
         * 4 = fifth
         */
        int row = 2;

        int x = left + 7;
        int y = top + 30 + row * SLOT_SIZE;

        /*
         * Draw the banner over the complete row.
         */
        RenderSystem.enableBlend();

         /*
        graphics.blit(
                BANNER,
                x,
                y,
                0,
                0,
                BANNER_WIDTH,
                BANNER_HEIGHT,
                BANNER_WIDTH,
                BANNER_HEIGHT
        );

          */

        RenderSystem.disableBlend();
    }
}