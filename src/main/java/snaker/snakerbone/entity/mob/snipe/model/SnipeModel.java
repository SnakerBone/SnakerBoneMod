package snaker.snakerbone.entity.mob.snipe.model;


import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.mob.snipe.Snipe;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SnipeModel extends AnimatedGeoModel<Snipe> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/snipe.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/entity/mob/snipe.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/dummy.animation.json");

    @Override
    public ResourceLocation getModelResource(Snipe object) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(Snipe object) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(Snipe animatable) {

        return ANIMATION;

    }
}