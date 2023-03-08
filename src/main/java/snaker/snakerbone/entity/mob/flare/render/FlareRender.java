package snaker.snakerbone.entity.mob.flare.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import snaker.snakerbone.entity.mob.flare.Flare;
import snaker.snakerbone.entity.mob.flare.model.FlareModel;
import snaker.snakerbone.entity.mob.flare.shader.FlareShader;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class FlareRender extends GeoEntityRenderer<Flare> {
    public FlareRender(EntityRendererProvider.Context renderManager) {

        super(renderManager, new FlareModel());

        addLayer(new FlareShader(this));

    }
}
