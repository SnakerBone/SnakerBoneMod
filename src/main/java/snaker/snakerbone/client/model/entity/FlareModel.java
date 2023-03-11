package snaker.snakerbone.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.mob.Flare;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class FlareModel extends AnimatedGeoModel<Flare> {
    @Override
    public ResourceLocation getModelResource(Flare entity) {
        return new SnakerBoneResourceLocation("geo/flare.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Flare entity) {
        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(Flare entity) {
        return new SnakerBoneResourceLocation("animations/flare.animation.json");
    }
}
