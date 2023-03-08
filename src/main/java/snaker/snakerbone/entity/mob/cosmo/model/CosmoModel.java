package snaker.snakerbone.entity.mob.cosmo.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.mob.cosmo.Cosmo;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class CosmoModel extends AnimatedGeoModel<Cosmo> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/cosmo.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/model/base.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/cosmo.animation.json");

    @Override
    public ResourceLocation getModelResource(Cosmo object) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(Cosmo object) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(Cosmo animatable) {

        return ANIMATION;

    }
}