package snaker.snakerbone.block.shader.fire.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.shader.fire.FireBlockItem;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 22/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class FireBlockItemModel extends AnimatedGeoModel<FireBlockItem> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/block.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/model/base.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/dummy.animation.json");

    @Override
    public ResourceLocation getModelResource(FireBlockItem item) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(FireBlockItem item) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(FireBlockItem item) {

        return ANIMATION;

    }
}