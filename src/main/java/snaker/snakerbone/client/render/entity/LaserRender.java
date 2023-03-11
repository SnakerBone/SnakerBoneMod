package snaker.snakerbone.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import snaker.snakerbone.client.Renders;
import snaker.snakerbone.client.model.entity.LaserModel;
import snaker.snakerbone.entity.projectile.Laser;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

import javax.annotation.Nullable;
import java.awt.*;

/**
 * Created by SnakerBone on 20/02/2023
 **/
public class LaserRender extends GeoProjectilesRenderer<Laser> {
    public LaserRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LaserModel());
    }

    @Override
    public void render(GeoModel model, Laser entity, float pt, RenderType type, PoseStack ms, @Nullable MultiBufferSource rtb, @Nullable VertexConsumer vb, int light, int overlay, float red, float green, float blue, float alpha) {
        Renders.rays(ms, rtb, Color.white, 40, 40, 16, 0, 0, 0);
        super.render(model, entity, pt, type, ms, rtb, vb, light, overlay, red, green, blue, alpha);
    }
}
