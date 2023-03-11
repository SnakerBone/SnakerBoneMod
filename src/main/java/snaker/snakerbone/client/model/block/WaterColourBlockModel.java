package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.WaterColourBlockEntity;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class WaterColourBlockModel extends AnimatedGeoModel<WaterColourBlockEntity> {
    @Override
    public ResourceLocation getModelResource(WaterColourBlockEntity object) {
        return SnakerBoneResourceLocation.BLOCK_GEO_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(WaterColourBlockEntity object) {
        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(WaterColourBlockEntity animatable) {
        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;
    }
}
