package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockitem.FireBlockItem;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class FireBlockItemModel extends AnimatedGeoModel<FireBlockItem> {
    @Override
    public ResourceLocation getModelResource(FireBlockItem item) {
        return SnakerBoneResourceLocation.BLOCK_GEO_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(FireBlockItem item) {
        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(FireBlockItem item) {
        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;
    }
}