package com.yesmenn.decoradditions.client.model;

import com.yesmenn.decoradditions.YMDecorAdditions;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.ModelLayerLocation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

public class LargeCampfireModel extends Model {

	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(
					ResourceLocation.fromNamespaceAndPath(
							YMDecorAdditions.MODID,
							"large_campfire"
					),
					"main"
			);

	private final ModelPart wood;
	private final ModelPart stone_circle;
	private final ModelPart coal;
	private final ModelPart gravel;

	public LargeCampfireModel(ModelPart root) {
		super(RenderType::entityCutoutNoCull);

		this.wood = root.getChild("wood");
		this.stone_circle = root.getChild("stone_circle");
		this.coal = root.getChild("coal");
		this.gravel = root.getChild("gravel");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition wood = partdefinition.addOrReplaceChild(
				"wood",
				CubeListBuilder.create(),
				PartPose.offsetAndRotation(
						0.0528F,
						12.4353F,
						-0.1489F,
						(float) Math.PI,
						0.0F,
						0.0F
				)
		);

		PartDefinition cube_r1 = wood.addOrReplaceChild(
				"cube_r1",
				CubeListBuilder.create()
						.texOffs(4, 5)
						.addBox(
								-1.0F, -1.0F, -12.5F,
								2.0F, 2.0F, 25.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						6.4304F, -0.4236F, 0.187F,
						1.5708F, -1.1781F, -0.4363F
				)
		);

		PartDefinition cube_r2 = wood.addOrReplaceChild(
				"cube_r2",
				CubeListBuilder.create()
						.texOffs(2, 3)
						.addBox(
								-1.0F, -1.0F, -13.5F,
								2.0F, 2.0F, 27.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-0.0528F, 0.4827F, 6.2476F,
						-2.0382F, 0.3542F, 2.9683F
				)
		);

		PartDefinition cube_r3 = wood.addOrReplaceChild(
				"cube_r3",
				CubeListBuilder.create()
						.texOffs(3, 4)
						.mirror()
						.addBox(
								-1.0F, -1.0F, -13.0F,
								2.0F, 2.0F, 26.0F,
								new CubeDeformation(0.0F)
						)
						.mirror(false),
				PartPose.offsetAndRotation(
						-0.0528F, -0.0885F, -6.6216F,
						1.1493F, -0.3614F, 0.1572F
				)
		);

		PartDefinition cube_r4 = wood.addOrReplaceChild(
				"cube_r4",
				CubeListBuilder.create()
						.texOffs(3, 4)
						.addBox(
								-1.0F, -1.0F, -13.0F,
								2.0F, 2.0F, 26.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-6.3248F, 0.0295F, 0.187F,
						-1.5708F, 1.1781F, -2.7053F
				)
		);

		PartDefinition bone3 = wood.addOrReplaceChild(
				"bone3",
				CubeListBuilder.create(),
				PartPose.offsetAndRotation(
						-4.4336F, 1.0F, -0.1053F,
						0.0F, 0.7854F, 0.0F
				)
		);

		PartDefinition cube_r5 = bone3.addOrReplaceChild(
				"cube_r5",
				CubeListBuilder.create()
						.texOffs(6, 7)
						.addBox(
								-1.0F, -1.0F, -11.5F,
								2.0F, 2.0F, 23.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						3.0784F, -0.2165F, -3.2034F,
						0.0F, -1.0908F, 1.5708F
				)
		);

		PartDefinition cube_r6 = bone3.addOrReplaceChild(
				"cube_r6",
				CubeListBuilder.create()
						.texOffs(5, 6)
						.addBox(
								-1.0F, -1.0F, -12.0F,
								2.0F, 2.0F, 24.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-3.0784F, 0.2165F, 3.2034F,
						1.5708F, 0.7854F, 0.5236F
				)
		);

		PartDefinition bone2 = wood.addOrReplaceChild(
				"bone2",
				CubeListBuilder.create(),
				PartPose.offsetAndRotation(
						3.886F, 0.0F, -0.0169F,
						0.0F, -0.7854F, 0.0F
				)
		);

		PartDefinition cube_r7 = bone2.addOrReplaceChild(
				"cube_r7",
				CubeListBuilder.create()
						.texOffs(4, 5)
						.addBox(
								-1.0F, -1.0F, -13.0F,
								2.0F, 2.0F, 25.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-2.8284F, 0.0F, -2.8284F,
						0.8861F, -0.6591F, 0.4636F
				)
		);

		PartDefinition cube_r8 = bone2.addOrReplaceChild(
				"cube_r8",
				CubeListBuilder.create()
						.texOffs(5, 6)
						.addBox(
								-1.0F, -1.0F, -13.0F,
								2.0F, 2.0F, 24.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						2.8284F, 0.0F, 2.8284F,
						-1.5708F, -0.7854F, 2.618F
				)
		);

		PartDefinition stone_circle = partdefinition.addOrReplaceChild(
				"stone_circle",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-3.0F, -2.0F, -4.0F,
								5.0F, 4.0F, 5.0F,
								new CubeDeformation(0.0F)
						)
						.texOffs(0, 0)
						.addBox(
								-4.0F, -2.0F, -35.0F,
								6.0F, 4.0F, 5.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offset(0.0F, 2.0F, 17.0F)
		);

		PartDefinition cube_r9 = stone_circle.addOrReplaceChild(
				"cube_r9",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-2.5F, -1.5F, -2.5F,
								5.0F, 3.0F, 5.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-6.3935F, -0.5F, -31.1288F,
						1.4311F, -1.294F, -1.7105F
				)
		);

		PartDefinition cube_r10 = stone_circle.addOrReplaceChild(
				"cube_r10",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-2.5F, -1.5F, -3.0F,
								5.0F, 3.0F, 6.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						5.2783F, -0.5F, -31.0495F,
						0.0F, -1.1781F, 0.0F
				)
		);

		PartDefinition cube_r11 = stone_circle.addOrReplaceChild(
				"cube_r11",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-3.0F, -2.0F, -2.5F,
								6.0F, 4.0F, 5.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						14.0824F, -0.9034F, -11.2439F,
						-2.1338F, -1.1429F, 2.7098F
				)
		);

		PartDefinition cube_r12 = stone_circle.addOrReplaceChild(
				"cube_r12",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-3.0F, -3.5F, -2.0F,
								6.0F, 7.0F, 4.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-14.7483F, 0.2412F, -23.3795F,
						1.6049F, 0.1264F, -2.8776F
				)
		);

		PartDefinition cube_r13 = stone_circle.addOrReplaceChild(
				"cube_r13",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-3.0F, -1.5F, -3.0F,
								6.0F, 3.0F, 6.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						5.7402F, -0.5F, -3.1418F,
						-3.1416F, -0.3927F, 3.1416F
				)
		);

		PartDefinition cube_r14 = stone_circle.addOrReplaceChild(
				"cube_r14",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-3.5F, -1.5F, -3.5F,
								7.0F, 3.0F, 7.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						14.0609F, -0.2264F, -22.1056F,
						2.699F, -1.2638F, -2.5853F
				)
		);

		PartDefinition cube_r15 = stone_circle.addOrReplaceChild(
				"cube_r15",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-2.0F, -3.5F, -2.0F,
								4.0F, 7.0F, 4.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-14.7821F, 0.0F, -10.8771F,
						-1.8557F, -0.274F, 0.8249F
				)
		);

		PartDefinition cube_r16 = stone_circle.addOrReplaceChild(
				"cube_r16",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-2.5F, -3.0F, -2.0F,
								5.0F, 6.0F, 4.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-10.6073F, 0.0F, -28.3445F,
						1.5708F, -0.829F, -3.1416F
				)
		);

		PartDefinition cube_r17 = stone_circle.addOrReplaceChild(
				"cube_r17",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-2.5F, -2.0F, -2.5F,
								5.0F, 4.0F, 5.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-11.3137F, 0.0F, -6.3934F,
						0.0869F, -0.7816F, -0.1231F
				)
		);

		PartDefinition cube_r18 = stone_circle.addOrReplaceChild(
				"cube_r18",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-3.0F, -2.0F, -2.5F,
								6.0F, 4.0F, 5.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						10.9602F, 0.0F, -27.9602F,
						0.1309F, -0.7854F, 0.0F
				)
		);

		PartDefinition cube_r19 = stone_circle.addOrReplaceChild(
				"cube_r19",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-3.0F, -2.0F, -2.5F,
								6.0F, 4.0F, 5.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						10.253F, 0.0F, -6.747F,
						-3.1416F, -0.7854F, 3.1416F
				)
		);

		PartDefinition cube_r20 = stone_circle.addOrReplaceChild(
				"cube_r20",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-2.5F, -2.0F, -3.0F,
								5.0F, 4.0F, 6.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-16.0381F, 0.0F, -16.6913F,
						0.0F, -1.1781F, 0.0F
				)
		);

		PartDefinition cube_r21 = stone_circle.addOrReplaceChild(
				"cube_r21",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-2.5F, -2.0F, -3.0F,
								5.0F, 4.0F, 6.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						16.0F, 0.0F, -16.5F,
						0.0F, -1.5708F, 0.0F
				)
		);

		PartDefinition cube_r22 = stone_circle.addOrReplaceChild(
				"cube_r22",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(
								-2.0F, -3.5F, -2.0F,
								4.0F, 7.0F, 4.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-6.5681F, -0.3319F, -2.4745F,
						0.6753F, -0.9732F, -2.4628F
				)
		);

		PartDefinition coal = partdefinition.addOrReplaceChild(
				"coal",
				CubeListBuilder.create()
						.texOffs(46, 0)
						.addBox(
								1.0F, 0.0F, -2.0F,
								4.0F, 3.0F, 5.0F,
								new CubeDeformation(0.0F)
						)
						.texOffs(38, 0)
						.addBox(
								0.0F, 0.0F, -8.0F,
								7.0F, 4.0F, 6.0F,
								new CubeDeformation(0.0F)
						)
						.texOffs(42, 0)
						.addBox(
								-5.0F, 0.0F, -1.0F,
								6.0F, 4.0F, 5.0F,
								new CubeDeformation(0.0F)
						)
						.texOffs(42, 0)
						.addBox(
								-2.0F, 3.0F, -5.0F,
								6.0F, 4.0F, 5.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offset(0.0F, 0.2F, 2.0F)
		);

		PartDefinition cube_r23 = coal.addOrReplaceChild(
				"cube_r23",
				CubeListBuilder.create()
						.texOffs(36, 0)
						.addBox(
								-2.5F, -1.5F, -3.0F,
								6.0F, 3.0F, 8.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-2.5F, 1.5F, -4.0F,
						0.0F, 3.1416F, 0.0F
				)
		);

		PartDefinition gravel = partdefinition.addOrReplaceChild(
				"gravel",
				CubeListBuilder.create()
						.texOffs(-11, 18)
						.addBox(
								-11.0F, 0.0F, -14.0F,
								12.0F, 0.0F, 12.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offset(-1.0F, 0.2F, 2.0F)
		);

		PartDefinition cube_r24 = gravel.addOrReplaceChild(
				"cube_r24",
				CubeListBuilder.create()
						.texOffs(-11, 18)
						.addBox(
								-4.5F, 0.0F, -12.0F,
								12.0F, 0.0F, 12.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						8.5F, 0.0F, -2.0F,
						-3.1416F, 0.0F, 3.1416F
				)
		);

		PartDefinition cube_r25 = gravel.addOrReplaceChild(
				"cube_r25",
				CubeListBuilder.create()
						.texOffs(-11, 18)
						.addBox(
								-12.0F, 0.0F, -4.5F,
								12.0F, 0.0F, 12.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						8.5F, 0.0F, -2.0F,
						0.0F, -1.5708F, 0.0F
				)
		);

		PartDefinition cube_r26 = gravel.addOrReplaceChild(
				"cube_r26",
				CubeListBuilder.create()
						.texOffs(-11, 18)
						.addBox(
								-4.5F, 0.0F, -4.5F,
								12.0F, 0.0F, 12.0F,
								new CubeDeformation(0.0F)
						),
				PartPose.offsetAndRotation(
						-6.5F, 0.0F, 5.5F,
						0.0F, 1.5708F, 0.0F
				)
		);

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(
			PoseStack poseStack,
			VertexConsumer vertexConsumer,
			int packedLight,
			int packedOverlay,
			int color
	) {
		wood.render(
				poseStack,
				vertexConsumer,
				packedLight,
				packedOverlay,
				color
		);

		stone_circle.render(
				poseStack,
				vertexConsumer,
				packedLight,
				packedOverlay,
				color
		);

		coal.render(
				poseStack,
				vertexConsumer,
				packedLight,
				packedOverlay,
				color
		);

		gravel.render(
				poseStack,
				vertexConsumer,
				packedLight,
				packedOverlay,
				color
		);
	}
}