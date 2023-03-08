package snaker.snakerbone.entity.boss.utterfly.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import snaker.snakerbone.entity.boss.utterfly.Utterfly;
import snaker.snakerbone.entity.boss.utterfly.model.UtterflyModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 4/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class UtterflyRender extends GeoEntityRenderer<Utterfly> {
    public UtterflyRender(EntityRendererProvider.Context renderManager) {

        super(renderManager, new UtterflyModel());

    }
}
