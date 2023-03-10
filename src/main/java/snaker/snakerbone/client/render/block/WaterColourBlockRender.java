package snaker.snakerbone.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.blockentity.WaterColourBlockEntity;
import snaker.snakerbone.client.Shaders;
import snaker.snakerbone.client.model.block.WaterColourBlockModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class WaterColourBlockRender extends GeoBlockRenderer<WaterColourBlockEntity> {
    public WaterColourBlockRender(BlockEntityRendererProvider.Context rendererProvider) {
        super(rendererProvider, new WaterColourBlockModel());
    }

    @Override
    public RenderType getRenderType(WaterColourBlockEntity animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        return Shaders.BWATERCOLOUR;
    }
}
