package snaker.snakerbone.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.boss.Utterfly;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 4/01/2023
 **/
public class UtterflyModel extends AnimatedGeoModel<Utterfly> {
    @Override
    public ResourceLocation getModelResource(Utterfly entity) {

        return new SnakerBoneResourceLocation("geo/utterfly.geo.json");

    }

    @Override
    public ResourceLocation getTextureResource(Utterfly entity) {

        return new SnakerBoneResourceLocation("textures/entity/boss/utterfly.png");

    }

    @Override
    public ResourceLocation getAnimationResource(Utterfly entity) {

        return new SnakerBoneResourceLocation("animations/utterfly.animation.json");

    }
}
