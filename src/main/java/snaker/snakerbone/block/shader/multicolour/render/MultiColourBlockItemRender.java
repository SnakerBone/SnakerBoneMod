package snaker.snakerbone.block.shader.multicolour.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.shader.multicolour.MultiColourBlockItem;
import snaker.snakerbone.block.shader.multicolour.model.MultiColourBlockItemModel;
import snaker.snakerbone.client.SnakerBoneShaders;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class MultiColourBlockItemRender extends GeoItemRenderer<MultiColourBlockItem> {
    public MultiColourBlockItemRender() {

        super(new MultiColourBlockItemModel());

    }

    @Override
    public RenderType getRenderType(MultiColourBlockItem item, float partialTick, PoseStack stack, @Nullable MultiBufferSource source, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {

        return SnakerBoneShaders.BMULTICOLOUR;

    }
}