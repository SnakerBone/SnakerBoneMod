package snaker.snakerbone.entity.creature.flutterfly.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.creature.flutterfly.Flutterfly;
import snaker.snakerbone.util.SnakerBonePolicy;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(SnakerBonePolicy.WarningSuppression.CUSTOM_SET)
public class FlutterflyModel extends AnimatedGeoModel<Flutterfly> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/flutterfly.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/entity/creature/flutterfly.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/flutterfly.animation.json");

    @Override
    public ResourceLocation getModelResource(Flutterfly entity) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(Flutterfly entity) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(Flutterfly entity) {

        return ANIMATION;

    }
}
