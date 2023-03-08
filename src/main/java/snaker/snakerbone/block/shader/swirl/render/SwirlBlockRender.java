package snaker.snakerbone.block.shader.swirl.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.shader.swirl.SwirlBlockEntity;
import snaker.snakerbone.block.shader.swirl.model.SwirlBlockModel;
import snaker.snakerbone.client.SnakerBoneShaders;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SwirlBlockRender extends GeoBlockRenderer<SwirlBlockEntity> {
    public SwirlBlockRender(BlockEntityRendererProvider.Context context) {

        super(context, new SwirlBlockModel());

    }

    @Override
    public RenderType getRenderType(SwirlBlockEntity animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {

        return SnakerBoneShaders.BSWIRL;

    }
}
