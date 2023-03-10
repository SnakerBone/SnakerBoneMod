package snaker.snakerbone.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.blockentity.FireBlockEntity;
import snaker.snakerbone.client.SnakerBoneShaders;
import snaker.snakerbone.client.model.block.FireBlockModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class FireBlockRender extends GeoBlockRenderer<FireBlockEntity> {
    public FireBlockRender(BlockEntityRendererProvider.Context context) {

        super(context, new FireBlockModel());

    }

    @Override
    public RenderType getRenderType(FireBlockEntity block, float partialTick, PoseStack stack, @Nullable MultiBufferSource source, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {

        return SnakerBoneShaders.BFIRE;

    }
}
