package snaker.snakerbone.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.blockentity.SwirlBlockEntity;
import snaker.snakerbone.client.Shaders;
import snaker.snakerbone.client.model.block.SwirlBlockModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class SwirlBlockRender extends GeoBlockRenderer<SwirlBlockEntity> {
    public SwirlBlockRender(BlockEntityRendererProvider.Context context) {
        super(context, new SwirlBlockModel());
    }

    @Override
    public RenderType getRenderType(SwirlBlockEntity animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        return Shaders.BSWIRL;
    }
}
