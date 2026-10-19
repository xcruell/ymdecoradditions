package com.yesmenn.natureadditions.client.renderer;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.yesmenn.natureadditions.YMNatureAdditions;
import com.yesmenn.natureadditions.block.entity.LargeCampfireBlockEntity;
import com.yesmenn.natureadditions.client.model.LargeCampfireModel;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;

import net.minecraft.resources.ResourceLocation;

public class LargeCampfireRenderer
        implements BlockEntityRenderer<LargeCampfireBlockEntity> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(
                    YMNatureAdditions.MODID,
                    "textures/entity/large_campfire.png"
            );

    public static final ModelResourceLocation FIRE_MODEL =
            ModelResourceLocation.standalone(
                    ResourceLocation.fromNamespaceAndPath(
                            YMNatureAdditions.MODID,
                            "fire_pyramid"
                    )
            );

    private final LargeCampfireModel model;

    public LargeCampfireRenderer(
            BlockEntityRendererProvider.Context context
    ) {
        this.model = new LargeCampfireModel(
                context.bakeLayer(
                        LargeCampfireModel.LAYER_LOCATION
                )
        );
    }

    @Override
    public void render(
            LargeCampfireBlockEntity blockEntity,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            int packedOverlay
    ) {
        poseStack.pushPose();

        poseStack.translate(0.5F, 0.0F, 0.5F);

        // ------------------------------------------------------------
        // STATIC CAMPFIRE
        // ------------------------------------------------------------

        VertexConsumer campfireBuffer =
                bufferSource.getBuffer(
                        model.renderType(TEXTURE)
                );

        model.renderToBuffer(
                poseStack,
                campfireBuffer,
                packedLight,
                packedOverlay,
                0xFFFFFFFF
        );

        // ------------------------------------------------------------
        // FIRE
        // ------------------------------------------------------------

        if (blockEntity.isLit()) {
            renderFire(
                    poseStack,
                    bufferSource,
                    packedLight,
                    packedOverlay
            );
        }
/*        renderFire(
                poseStack,
                bufferSource,
                packedLight,
                packedOverlay
        );*/

        poseStack.popPose();
    }

    private void renderFire(
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            int packedOverlay
    ) {
        Minecraft minecraft = Minecraft.getInstance();

        BakedModel fireModel =
                minecraft.getModelManager().getModel(FIRE_MODEL);

        ModelBlockRenderer modelRenderer =
                minecraft.getBlockRenderer().getModelRenderer();

        VertexConsumer buffer =
                bufferSource.getBuffer(RenderType.translucent());

        poseStack.pushPose();

        // Feuer verschieben
        poseStack.translate(-0.5F, 0.0F, -0.5F);

        modelRenderer.renderModel(
                poseStack.last(),
                buffer,
                null,
                fireModel,
                1.0F,
                1.0F,
                1.0F,
                LightTexture.FULL_BRIGHT,
                OverlayTexture.NO_OVERLAY
        );

        poseStack.popPose();
    }
}