package snaker.snakerbone.block.shader.swirl.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.shader.swirl.SwirlBlockItem;
import snaker.snakerbone.block.shader.swirl.model.SwirlBlockItemModel;
import snaker.snakerbone.client.SnakerBoneShaders;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SwirlBlockItemRender extends GeoItemRenderer<SwirlBlockItem> {
    public SwirlBlockItemRender() {

        super(new SwirlBlockItemModel());

    }

    @Override
    public RenderType getRenderType(SwirlBlockItem animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {

        return SnakerBoneShaders.BSWIRL;

    }
}