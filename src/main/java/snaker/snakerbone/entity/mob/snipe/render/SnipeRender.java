package snaker.snakerbone.entity.mob.snipe.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import snaker.snakerbone.entity.mob.snipe.Snipe;
import snaker.snakerbone.entity.mob.snipe.model.SnipeModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SnipeRender extends GeoEntityRenderer<Snipe> {
    public SnipeRender(EntityRendererProvider.Context renderManager) {

        super(renderManager, new SnipeModel());

    }
}
