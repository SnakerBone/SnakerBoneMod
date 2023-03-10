package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockitem.SnowBlockItem;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class SnowBlockItemModel extends AnimatedGeoModel<SnowBlockItem> {
    @Override
    public ResourceLocation getModelResource(SnowBlockItem item) {

        return SnakerBoneResourceLocation.BLOCK_GEO_LOCATION;

    }

    @Override
    public ResourceLocation getTextureResource(SnowBlockItem item) {

        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;

    }

    @Override
    public ResourceLocation getAnimationResource(SnowBlockItem item) {

        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;

    }
}