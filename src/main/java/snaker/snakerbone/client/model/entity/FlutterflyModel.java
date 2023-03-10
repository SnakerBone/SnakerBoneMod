package snaker.snakerbone.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.creature.Flutterfly;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class FlutterflyModel extends AnimatedGeoModel<Flutterfly> {
    @Override
    public ResourceLocation getModelResource(Flutterfly entity) {

        return new SnakerBoneResourceLocation("geo/flutterfly.geo.json");

    }

    @Override
    public ResourceLocation getTextureResource(Flutterfly entity) {

        return new SnakerBoneResourceLocation("textures/entity/creature/flutterfly.png");

    }

    @Override
    public ResourceLocation getAnimationResource(Flutterfly entity) {

        return new SnakerBoneResourceLocation("animations/flutterfly.animation.json");

    }
}
