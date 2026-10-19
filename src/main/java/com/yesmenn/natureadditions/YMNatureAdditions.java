package com.yesmenn.natureadditions;

import com.yesmenn.natureadditions.block.ModBlockEntities;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.yesmenn.natureadditions.registry.ModBlocks;
import com.yesmenn.natureadditions.registry.ModCreativeModeTabs;
import com.yesmenn.natureadditions.registry.ModItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(YMNatureAdditions.MODID)
public class YMNatureAdditions {
    public static final String MODID = "ymnatureadditions";
    private static final Logger LOGGER = LogUtils.getLogger();

    public YMNatureAdditions(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModBlocks.BLOCKS.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("YM! Nature Additions loaded.");
    }

}
