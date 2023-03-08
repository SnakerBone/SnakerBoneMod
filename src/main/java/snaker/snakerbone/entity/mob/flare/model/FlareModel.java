package snaker.snakerbone.entity.mob.flare.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.SnakerBone;
import snaker.snakerbone.entity.mob.flare.Flare;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class FlareModel extends AnimatedGeoModel<Flare> {
    private static final ResourceLocation MODEL = new ResourceLocation(SnakerBone.MODID, "geo/flare.geo.json");
    private static final ResourceLocation TEXTURE = new ResourceLocation(SnakerBone.MODID, "textures/model/base.png");
    private static final ResourceLocation ANIMATION = new ResourceLocation(SnakerBone.MODID, "animations/flare.animation.json");

    @Override
    public ResourceLocation getModelResource(Flare entity) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(Flare entity) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(Flare entity) {

        return ANIMATION;

    }
}
