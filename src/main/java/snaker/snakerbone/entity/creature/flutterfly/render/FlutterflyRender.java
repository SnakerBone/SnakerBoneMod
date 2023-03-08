package snaker.snakerbone.entity.creature.flutterfly.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.creature.flutterfly.Flutterfly;
import snaker.snakerbone.entity.creature.flutterfly.model.FlutterflyModel;
import snaker.snakerbone.util.SnakerBonePolicy;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(SnakerBonePolicy.WarningSuppression.CUSTOM_SET)
public class FlutterflyRender extends GeoEntityRenderer<Flutterfly> {
    public FlutterflyRender(EntityRendererProvider.Context renderManager) {

        super(renderManager, new FlutterflyModel());

    }

    @Override
    public RenderType getRenderType(Flutterfly entity, float pt, PoseStack ms, @Nullable MultiBufferSource rtb, @Nullable VertexConsumer vb, int light, ResourceLocation location) {

        if (entity.isBaby()) {

            ms.scale(0.5F, 0.5F, 0.5F);

        }

        return super.getRenderType(entity, pt, ms, rtb, vb, light, location);
    }
}
