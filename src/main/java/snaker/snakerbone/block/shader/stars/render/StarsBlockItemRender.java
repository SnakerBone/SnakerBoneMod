package snaker.snakerbone.block.shader.stars.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.shader.stars.StarsBlockItem;
import snaker.snakerbone.block.shader.stars.model.StarsBlockItemModel;
import snaker.snakerbone.client.SnakerBoneShaders;
import snaker.snakerbone.util.SnakerBonePolicy;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(SnakerBonePolicy.WarningSuppression.CUSTOM_SET)
public class StarsBlockItemRender extends GeoItemRenderer<StarsBlockItem> {
    public StarsBlockItemRender() {

        super(new StarsBlockItemModel());

    }

    @Override
    public RenderType getRenderType(StarsBlockItem item, float partialTick, PoseStack stack, @Nullable MultiBufferSource source, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {

        return SnakerBoneShaders.BSTARS;

    }
}