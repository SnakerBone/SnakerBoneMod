package snaker.snakerbone.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.mob.Snipe;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class SnipeModel extends AnimatedGeoModel<Snipe> {
    @Override
    public ResourceLocation getModelResource(Snipe object) {
        return new SnakerBoneResourceLocation("geo/snipe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Snipe object) {
        return new SnakerBoneResourceLocation("textures/entity/mob/snipe.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Snipe animatable) {
        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;
    }
}