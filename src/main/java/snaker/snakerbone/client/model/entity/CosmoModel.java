package snaker.snakerbone.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.mob.Cosmo;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class CosmoModel extends AnimatedGeoModel<Cosmo> {
    @Override
    public ResourceLocation getModelResource(Cosmo object) {
        return new SnakerBoneResourceLocation("geo/cosmo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Cosmo object) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(Cosmo animatable) {
        return new SnakerBoneResourceLocation("animations/cosmo.animation.json");
    }
}