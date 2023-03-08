package snaker.snakerbone.block.shader.snow.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.shader.snow.SnowBlockItem;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SnowBlockItemModel extends AnimatedGeoModel<SnowBlockItem> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/block.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/model/base.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/dummy.animation.json");

    @Override
    public ResourceLocation getModelResource(SnowBlockItem item) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(SnowBlockItem item) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(SnowBlockItem item) {

        return ANIMATION;

    }
}