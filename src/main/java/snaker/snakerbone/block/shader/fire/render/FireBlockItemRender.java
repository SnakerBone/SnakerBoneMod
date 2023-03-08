package snaker.snakerbone.block.shader.fire.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.shader.fire.FireBlockItem;
import snaker.snakerbone.block.shader.fire.model.FireBlockItemModel;
import snaker.snakerbone.client.SnakerBoneShaders;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class FireBlockItemRender extends GeoItemRenderer<FireBlockItem> {
    public FireBlockItemRender() {

        super(new FireBlockItemModel());

    }

    @Override
    public RenderType getRenderType(FireBlockItem item, float partialTick, PoseStack stack, @Nullable MultiBufferSource source, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {

        return SnakerBoneShaders.BFIRE;

    }
}