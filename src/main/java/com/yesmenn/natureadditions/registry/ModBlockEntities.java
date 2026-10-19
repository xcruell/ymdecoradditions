package com.yesmenn.natureadditions.block;

import com.yesmenn.natureadditions.YMNatureAdditions;
import com.yesmenn.natureadditions.block.entity.LargeCampfireBlockEntity;

import com.yesmenn.natureadditions.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(
                    Registries.BLOCK_ENTITY_TYPE,
                    YMNatureAdditions.MODID
            );

    public static final DeferredHolder<
            BlockEntityType<?>,
            BlockEntityType<LargeCampfireBlockEntity>
            > LARGE_CAMPFIRE =
            BLOCK_ENTITIES.register(
                    "large_campfire",
                    () -> BlockEntityType.Builder.of(
                            LargeCampfireBlockEntity::new,
                            ModBlocks.LARGE_CAMPFIRE.get()
                    ).build(null)
            );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}