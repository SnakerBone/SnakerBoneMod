package snaker.snakerbone.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.blockentity.MultiColourBlockEntity;
import snaker.snakerbone.client.SnakerBoneShaders;
import snaker.snakerbone.client.model.block.MultiColourBlockModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class MultiColourBlockRender extends GeoBlockRenderer<MultiColourBlockEntity> {
    public MultiColourBlockRender(BlockEntityRendererProvider.Context context) {

        super(context, new MultiColourBlockModel());

    }

    @Override
    public RenderType getRenderType(MultiColourBlockEntity block, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource source, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {

        return SnakerBoneShaders.BMULTICOLOUR;

    }
}
