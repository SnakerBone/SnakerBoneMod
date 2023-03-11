package snaker.snakerbone.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import snaker.snakerbone.client.model.entity.UtterflyModel;
import snaker.snakerbone.entity.boss.Utterfly;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

/**
 * Created by SnakerBone on 4/01/2023
 **/
public class UtterflyRender extends GeoEntityRenderer<Utterfly> {
    public UtterflyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UtterflyModel());
    }
}
