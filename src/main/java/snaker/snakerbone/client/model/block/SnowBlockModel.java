package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.SnowBlockEntity;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class SnowBlockModel extends AnimatedGeoModel<SnowBlockEntity> {
    @Override
    public ResourceLocation getModelResource(SnowBlockEntity block) {
        return SnakerBoneResourceLocation.BLOCK_GEO_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(SnowBlockEntity block) {
        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(SnowBlockEntity block) {
        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;
    }
}
