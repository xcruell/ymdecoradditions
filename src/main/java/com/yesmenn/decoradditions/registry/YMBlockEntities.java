package com.yesmenn.decoradditions.registry;

import com.yesmenn.decoradditions.YMDecorAdditions;
import com.yesmenn.decoradditions.block.entity.EnvoKiller3000BlockEntity;
import com.yesmenn.decoradditions.block.entity.LargeCampfireBlockEntity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class YMBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(
                    Registries.BLOCK_ENTITY_TYPE,
                    YMDecorAdditions.MODID
            );

    public static final DeferredHolder<
            BlockEntityType<?>,
            BlockEntityType<LargeCampfireBlockEntity>
            > LARGE_CAMPFIRE =
            BLOCK_ENTITIES.register(
                    "large_campfire",
                    () -> BlockEntityType.Builder.of(
                            LargeCampfireBlockEntity::new,
                            YMBlocks.LARGE_CAMPFIRE.get()
                    ).build(null)
            );

    public static final DeferredHolder<
            BlockEntityType<?>,
            BlockEntityType<EnvoKiller3000BlockEntity>
            > ENVOKILLER3000 =
            BLOCK_ENTITIES.register(
                    "envokiller3000",
                    () -> BlockEntityType.Builder.of(
                            EnvoKiller3000BlockEntity::new,
                            YMBlocks.ENVOKILLER3000.get()
                    ).build(null)
            );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}