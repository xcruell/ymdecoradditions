package com.yesmenn.decoradditions.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.yesmenn.decoradditions.YMDecorAdditions;
import com.yesmenn.decoradditions.client.model.LargeCampfireModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class LargeCampfireItemRenderer
        extends BlockEntityWithoutLevelRenderer {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(
                    YMDecorAdditions.MODID,
                    "textures/entity/large_campfire.png"
            );

    private LargeCampfireModel model;

    public LargeCampfireItemRenderer() {
        super(
                Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                Minecraft.getInstance().getEntityModels()
        );
    }

    private void ensureModel() {
        if (model == null) {
            EntityModelSet modelSet =
                    Minecraft.getInstance().getEntityModels();

            model = new LargeCampfireModel(
                    modelSet.bakeLayer(
                            LargeCampfireModel.LAYER_LOCATION
                    )
            );
        }
    }

    @Override
    public void renderByItem(
            ItemStack stack,
            ItemDisplayContext transform,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            int packedOverlay
    ) {
        ensureModel();

        poseStack.pushPose();

        if (transform == ItemDisplayContext.GUI) {

            // Modell um seinen Mittelpunkt zentrieren
            poseStack.translate(0.5F, 0.3F, 0.5F);

            // Isometrische Ansicht
            poseStack.mulPose(
                    com.mojang.math.Axis.XP.rotationDegrees(30.0F)
            );

            poseStack.mulPose(
                    com.mojang.math.Axis.YP.rotationDegrees(45.0F)
            );

            // GUI-Größe
            poseStack.scale(
                    0.4F,
                    0.4F,
                    0.4F
            );

        } else {

            poseStack.translate(0.5F, 0.5F, 0.5F);

            poseStack.scale(
                    0.25F,
                    0.25F,
                    0.25F
            );
        }

        VertexConsumer buffer =
                bufferSource.getBuffer(
                        RenderType.entityCutoutNoCull(TEXTURE)
                );

        model.renderToBuffer(
                poseStack,
                buffer,
                packedLight,
                packedOverlay,
                0xFFFFFFFF
        );

        poseStack.popPose();
    }
}