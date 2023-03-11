package snaker.snakerbone.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.blockitem.SwirlBlockItem;
import snaker.snakerbone.client.Shaders;
import snaker.snakerbone.client.model.block.SwirlBlockItemModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class SwirlBlockItemRender extends GeoItemRenderer<SwirlBlockItem> {
    public SwirlBlockItemRender() {
        super(new SwirlBlockItemModel());
    }

    @Override
    public RenderType getRenderType(SwirlBlockItem animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        return Shaders.BSWIRL;
    }
}