package snaker.snakerbone.client.render.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.client.Shaders;
import snaker.snakerbone.client.model.item.CosmoSpineItemModel;
import snaker.snakerbone.item.CosmoSpine;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

/**
 * Created by SnakerBone on 12/03/2023
 **/
public class CosmoSpineItemRender {
    public static class Red extends GeoItemRenderer<CosmoSpine.Red> {
        public Red() {
            super(new CosmoSpineItemModel.Red());
        }

        @Override
        public RenderType getRenderType(CosmoSpine.Red animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
            return Shaders.IREDSTARS;
        }
    }

    public static class Green extends GeoItemRenderer<CosmoSpine.Green> {
        public Green() {
            super(new CosmoSpineItemModel.Green());
        }

        @Override
        public RenderType getRenderType(CosmoSpine.Green animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
            return Shaders.IGREENSTARS;
        }
    }

    public static class Blue extends GeoItemRenderer<CosmoSpine.Blue> {
        public Blue() {
            super(new CosmoSpineItemModel.Blue());
        }

        @Override
        public RenderType getRenderType(CosmoSpine.Blue animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
            return Shaders.IBLUESTARS;
        }
    }

    public static class Yellow extends GeoItemRenderer<CosmoSpine.Yellow> {
        public Yellow() {
            super(new CosmoSpineItemModel.Yellow());
        }

        @Override
        public RenderType getRenderType(CosmoSpine.Yellow animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
            return Shaders.IYELLOWSTARS;
        }
    }

    public static class Pink extends GeoItemRenderer<CosmoSpine.Pink> {
        public Pink() {
            super(new CosmoSpineItemModel.Pink());
        }

        @Override
        public RenderType getRenderType(CosmoSpine.Pink animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
            return Shaders.IPINKSTARS;
        }
    }

    public static class Purple extends GeoItemRenderer<CosmoSpine.Purple> {
        public Purple() {
            super(new CosmoSpineItemModel.Purple());
        }

        @Override
        public RenderType getRenderType(CosmoSpine.Purple animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
            return Shaders.IPURPLESTARS;
        }
    }

    public static class Alpha extends GeoItemRenderer<CosmoSpine.Alpha> {
        public Alpha() {
            super(new CosmoSpineItemModel.Alpha());
        }

        @Override
        public RenderType getRenderType(CosmoSpine.Alpha animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
            return Shaders.ISTARS;
        }
    }
}
