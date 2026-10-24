package com.yesmenn.decoradditions.client;

import java.util.ArrayList;
import java.util.List;

public final class CreativeBannerManager {

    private static final List<CreativeBanner> BANNERS = new ArrayList<>();

    private CreativeBannerManager() {
    }

    public static void init() {
        BANNERS.clear();

        //BANNERS.add(CreativeBanners.NATURE);
        // BANNERS.add(CreativeBanners.TOOLS);
        // BANNERS.add(CreativeBanners.REST);
    }

    public static List<CreativeBanner> getBanners() {
        return BANNERS;
    }
}