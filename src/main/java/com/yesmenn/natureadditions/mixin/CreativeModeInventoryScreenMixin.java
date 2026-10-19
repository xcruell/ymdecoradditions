package com.yesmenn.natureadditions.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;

@Mixin(CreativeModeInventoryScreen.class)
public abstract class CreativeModeInventoryScreenMixin {

    /*
     * Hier greifen wir später in die Creative-Slot-Berechnung ein.
     *
     * Ziel:
     *
     * Vanilla:
     *
     *   Item Item Item Item Item Item Item Item Item
     *   Item Item Item Item Item Item Item Item Item
     *   Item Item Item Item Item Item Item Item Item
     *
     * Unsere Variante:
     *
     *   BANNER
     *   Item Item Item Item Item Item Item Item Item
     *   Item Item Item Item Item Item Item Item Item
     *   BANNER
     *   Item Item Item Item Item Item Item Item Item
     */

}