package snaker.snakerbone.block.shader.multicolour.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.shader.multicolour.MultiColourBlockEntity;
import snaker.snakerbone.block.shader.multicolour.model.MultiColourBlockModel;
import snaker.snakerbone.client.SnakerBoneShaders;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class MultiColourBlockRender extends GeoBlockRenderer<MultiColourBlockEntity> {
    public MultiColourBlockRender(BlockEntityRendererProvider.Context context) {

        super(context, new MultiColourBlockModel());

    }

    @Override
    public RenderType getRenderType(MultiColourBlockEntity block, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource source, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {

        return SnakerBoneShaders.BMULTICOLOUR;

    }
}
