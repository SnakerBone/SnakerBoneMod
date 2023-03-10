package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockitem.MultiColourBlockItem;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class MultiColourBlockItemModel extends AnimatedGeoModel<MultiColourBlockItem> {
    @Override
    public ResourceLocation getModelResource(MultiColourBlockItem item) {

        return SnakerBoneResourceLocation.BLOCK_GEO_LOCATION;

    }

    @Override
    public ResourceLocation getTextureResource(MultiColourBlockItem item) {

        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;

    }

    @Override
    public ResourceLocation getAnimationResource(MultiColourBlockItem item) {

        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;

    }
}