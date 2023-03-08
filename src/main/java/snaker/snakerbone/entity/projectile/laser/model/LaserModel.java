package snaker.snakerbone.entity.projectile.laser.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.projectile.laser.Laser;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 20/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class LaserModel extends AnimatedGeoModel<Laser> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/laser.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/model/transparent.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/dummy.animation.json");

    @Override
    public ResourceLocation getModelResource(Laser entity) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(Laser entity) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(Laser animatable) {

        return ANIMATION;

    }
}
