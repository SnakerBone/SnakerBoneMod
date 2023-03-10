package snaker.snakerbone.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import snaker.snakerbone.client.model.entity.SnipeModel;
import snaker.snakerbone.entity.mob.Snipe;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class SnipeRender extends GeoEntityRenderer<Snipe> {
    public SnipeRender(EntityRendererProvider.Context renderManager) {

        super(renderManager, new SnipeModel());

    }
}
