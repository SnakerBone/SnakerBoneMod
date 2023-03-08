package snaker.snakerbone.entity.boss.utterfly.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.boss.utterfly.Utterfly;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 4/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class UtterflyModel extends AnimatedGeoModel<Utterfly> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/utterfly.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/entity/boss/utterfly.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/utterfly.animation.json");

    @Override
    public ResourceLocation getModelResource(Utterfly entity) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(Utterfly entity) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(Utterfly entity) {

        return ANIMATION;

    }
}
