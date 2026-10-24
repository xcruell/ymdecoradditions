
package com.yesmenn.decoradditions.client.renderer;

import com.yesmenn.decoradditions.YMDecorAdditions;
import com.yesmenn.decoradditions.block.EnvoKiller3000Block;
import com.yesmenn.decoradditions.block.entity.EnvoKiller3000BlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;

public class EnvoKiller3000Renderer
        implements BlockEntityRenderer<EnvoKiller3000BlockEntity> {

    public static final ModelResourceLocation ENVO_FLAME =
            ModelResourceLocation.standalone(
                    ResourceLocation.fromNamespaceAndPath(
                            YMDecorAdditions.MODID,
                            "envokiller3000_flame"
                    )
            );

    public EnvoKiller3000Renderer(
            BlockEntityRendererProvider.Context context
    ) {
    }

    @Override
    public void render(
            EnvoKiller3000BlockEntity blockEntity,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            int packedOverlay
    ) {
        if (!blockEntity.getBlockState().getValue(EnvoKiller3000Block.LIT)) {
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();

        BakedModel flameModel =
                minecraft.getModelManager().getModel(ENVO_FLAME);

        ModelBlockRenderer modelRenderer =
                minecraft.getBlockRenderer().getModelRenderer();

        VertexConsumer buffer =
                bufferSource.getBuffer(RenderType.cutoutMipped());

        poseStack.pushPose();

        poseStack.translate(0.0F, 2.0F, 0.0F);

        modelRenderer.renderModel(
                poseStack.last(),
                buffer,
                null,
                flameModel,
                1.0F,
                1.0F,
                1.0F,
                LightTexture.FULL_BRIGHT,
                OverlayTexture.NO_OVERLAY
        );

        poseStack.popPose();
    }

    @Override
    public AABB getRenderBoundingBox(EnvoKiller3000BlockEntity blockEntity) {
        BlockPos pos = blockEntity.getBlockPos();

        return new AABB(
                pos.getX(),
                pos.getY(),
                pos.getZ(),
                pos.getX() + 1.0,
                pos.getY() + 4.0,
                pos.getZ() + 1.0
        );
    }

    @Override
    public boolean shouldRenderOffScreen(EnvoKiller3000BlockEntity blockEntity) {
        return true;
    }

    @Override
    public int getViewDistance() {
        return 256;
    }

}
