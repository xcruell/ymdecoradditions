package com.yesmenn.decoradditions.registry;

import com.yesmenn.decoradditions.YMDecorAdditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

import static com.yesmenn.decoradditions.registry.YMTags.NameSpace.COMMON;

public class YMTags {
    public enum NameSpace {
        MOD(YMDecorAdditions.MODID),
        COMMON("c");

        public final String id;
        NameSpace(String id) {
            this.id = id;
        }
    }

    public enum YMFluidTags {
        GAS,
        FLAMMABLE,
        FIREBOX_FUEL,
        BLAST_STOVE_FUEL,
        AIR(COMMON),
        COOLING_FLUID(COMMON),

        GASOLINE(COMMON),
        DIESEL(COMMON),
        KEROSENE(COMMON),

        CREOSOTE(COMMON),
        FURNACE_GAS(COMMON),

        LPG(COMMON),
        HEAVY_OIL(COMMON),
        LUBRICATION_OIL(COMMON),
        NAPHTHA(COMMON),
        CRUDE_OIL(COMMON),
        MOLTEN_STEEL(COMMON),
        FUEL(COMMON)

        ;

        public final TagKey<Fluid> tag;

        YMFluidTags() {
            this(NameSpace.MOD);
        }
        YMFluidTags(NameSpace namespace) {
            this(namespace, null);
        }
        YMFluidTags(NameSpace namespace, String path) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace.id, path == null ? YMLang.asId(name()) : path);
            this.tag = FluidTags.create(id);
        }
    }

}
