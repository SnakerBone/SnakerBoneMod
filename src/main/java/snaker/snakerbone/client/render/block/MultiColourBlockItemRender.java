package snaker.snakerbone.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.blockitem.MultiColourBlockItem;
import snaker.snakerbone.client.Shaders;
import snaker.snakerbone.client.model.block.MultiColourBlockItemModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class MultiColourBlockItemRender extends GeoItemRenderer<MultiColourBlockItem> {
    public MultiColourBlockItemRender() {
        super(new MultiColourBlockItemModel());
    }

    @Override
    public RenderType getRenderType(MultiColourBlockItem item, float partialTick, PoseStack stack, @Nullable MultiBufferSource source, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        return Shaders.BMULTICOLOUR;
    }
}