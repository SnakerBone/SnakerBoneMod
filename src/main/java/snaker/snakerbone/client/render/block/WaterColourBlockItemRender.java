package snaker.snakerbone.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.shader.watercolour.WaterColourBlockItem;
import snaker.snakerbone.client.SnakerBoneShaders;
import snaker.snakerbone.client.model.block.WaterColourBlockItemModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class WaterColourBlockItemRender extends GeoItemRenderer<WaterColourBlockItem> {
    public WaterColourBlockItemRender() {

        super(new WaterColourBlockItemModel());

    }

    @Override
    public RenderType getRenderType(WaterColourBlockItem animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {

        return SnakerBoneShaders.BWATERCOLOUR;

    }
}