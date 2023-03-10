package snaker.snakerbone.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.block.blockitem.FireBlockItem;
import snaker.snakerbone.client.SnakerBoneShaders;
import snaker.snakerbone.client.model.block.FireBlockItemModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class FireBlockItemRender extends GeoItemRenderer<FireBlockItem> {
    public FireBlockItemRender() {

        super(new FireBlockItemModel());

    }

    @Override
    public RenderType getRenderType(FireBlockItem item, float partialTick, PoseStack stack, @Nullable MultiBufferSource source, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {

        return SnakerBoneShaders.BFIRE;

    }
}