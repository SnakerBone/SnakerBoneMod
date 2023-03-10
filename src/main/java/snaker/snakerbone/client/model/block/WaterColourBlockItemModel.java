package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockitem.WaterColourBlockItem;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class WaterColourBlockItemModel extends AnimatedGeoModel<WaterColourBlockItem> {
    @Override
    public ResourceLocation getModelResource(WaterColourBlockItem object) {

        return SnakerBoneResourceLocation.BLOCK_GEO_LOCATION;

    }

    @Override
    public ResourceLocation getTextureResource(WaterColourBlockItem object) {

        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;

    }

    @Override
    public ResourceLocation getAnimationResource(WaterColourBlockItem animatable) {

        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;

    }
}