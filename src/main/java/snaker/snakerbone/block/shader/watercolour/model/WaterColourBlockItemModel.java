package snaker.snakerbone.block.shader.watercolour.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.shader.watercolour.WaterColourBlockItem;
import snaker.snakerbone.util.SnakerBonePolicy;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(SnakerBonePolicy.WarningSuppression.CUSTOM_SET)
public class WaterColourBlockItemModel extends AnimatedGeoModel<WaterColourBlockItem> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/block.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/model/base.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/dummy.animation.json");

    @Override
    public ResourceLocation getModelResource(WaterColourBlockItem object) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(WaterColourBlockItem object) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(WaterColourBlockItem animatable) {

        return ANIMATION;

    }
}