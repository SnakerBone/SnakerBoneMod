package snaker.snakerbone.block.shader.watercolour.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.shader.watercolour.WaterColourBlockEntity;
import snaker.snakerbone.util.SnakerBonePolicy;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(SnakerBonePolicy.WarningSuppression.CUSTOM_SET)
public class WaterColourBlockModel extends AnimatedGeoModel<WaterColourBlockEntity> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/block.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/model/base.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/dummy.animation.json");

    @Override
    public ResourceLocation getModelResource(WaterColourBlockEntity object) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(WaterColourBlockEntity object) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(WaterColourBlockEntity animatable) {

        return ANIMATION;

    }
}
