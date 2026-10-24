package com.yesmenn.decoradditions;

import com.yesmenn.decoradditions.registry.YMBlockEntities;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.yesmenn.decoradditions.registry.YMBlocks;
import com.yesmenn.decoradditions.registry.ModCreativeModeTabs;
import com.yesmenn.decoradditions.registry.ModItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(YMDecorAdditions.MODID)
public class YMDecorAdditions {
    public static final String MODID = "ymdecoradditions";
    private static final Logger LOGGER = LogUtils.getLogger();

    public YMDecorAdditions(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        YMBlocks.BLOCKS.register(modEventBus);
        YMBlockEntities.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("YM! Decor & Additions loaded.");
    }

}
