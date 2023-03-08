package snaker.snakerbone.entity.creature.glider.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.creature.glider.Glider;
import snaker.snakerbone.entity.creature.glider.model.GliderModel;
import snaker.snakerbone.util.SnakerBonePolicy;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(SnakerBonePolicy.WarningSuppression.CUSTOM_SET)
public class GliderRender extends GeoEntityRenderer<Glider> {
    public GliderRender(EntityRendererProvider.Context renderManager) {

        super(renderManager, new GliderModel());

    }

    @Override
    public RenderType getRenderType(Glider entity, float pt, PoseStack stack, @Nullable MultiBufferSource source, @Nullable VertexConsumer buffer, int light, ResourceLocation location) {

        if (entity.isBaby()) {

            stack.scale(0.5F, 0.5F, 0.5F);

        }

        return super.getRenderType(entity, pt, stack, source, buffer, light, location);
    }
}
