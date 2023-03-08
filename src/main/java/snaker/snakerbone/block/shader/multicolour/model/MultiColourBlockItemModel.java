package snaker.snakerbone.block.shader.multicolour.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.shader.multicolour.MultiColourBlockItem;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class MultiColourBlockItemModel extends AnimatedGeoModel<MultiColourBlockItem> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/block.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/model/base.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/dummy.animation.json");

    @Override
    public ResourceLocation getModelResource(MultiColourBlockItem item) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(MultiColourBlockItem item) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(MultiColourBlockItem item) {

        return ANIMATION;

    }
}