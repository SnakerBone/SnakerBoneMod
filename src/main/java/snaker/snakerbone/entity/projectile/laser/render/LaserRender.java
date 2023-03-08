package snaker.snakerbone.entity.projectile.laser.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import snaker.snakerbone.client.SnakerBoneRenderHelper;
import snaker.snakerbone.entity.projectile.laser.Laser;
import snaker.snakerbone.entity.projectile.laser.model.LaserModel;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

import javax.annotation.Nullable;
import java.awt.*;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CONSTANT_CONDITIONS;
import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 20/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class LaserRender extends GeoProjectilesRenderer<Laser> {
    public LaserRender(EntityRendererProvider.Context renderManager) {

        super(renderManager, new LaserModel());

    }

    @SuppressWarnings(CONSTANT_CONDITIONS)
    @Override
    public void render(GeoModel model, Laser entity, float pt, RenderType type, PoseStack ms, @Nullable MultiBufferSource rtb, @Nullable VertexConsumer vb, int light, int overlay, float red, float green, float blue, float alpha) {

        SnakerBoneRenderHelper.renderRays(ms, rtb, Color.white, 40, 40, 16, 0, 0, 0);

        super.render(model, entity, pt, type, ms, rtb, vb, light, overlay, red, green, blue, alpha);

    }
}
