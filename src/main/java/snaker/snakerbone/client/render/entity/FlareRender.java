package snaker.snakerbone.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import snaker.snakerbone.client.layer.entity.FlareLayer;
import snaker.snakerbone.client.model.entity.FlareModel;
import snaker.snakerbone.entity.mob.Flare;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class FlareRender extends GeoEntityRenderer<Flare> {
    public FlareRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FlareModel());
        addLayer(new FlareLayer(this));
    }
}
