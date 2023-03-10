package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.shader.multicolour.MultiColourBlockEntity;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class MultiColourBlockModel extends AnimatedGeoModel<MultiColourBlockEntity> {
    @Override
    public ResourceLocation getModelResource(MultiColourBlockEntity block) {

        return SnakerBoneResourceLocation.BLOCK_GEO_LOCATION;

    }

    @Override
    public ResourceLocation getTextureResource(MultiColourBlockEntity block) {

        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;

    }

    @Override
    public ResourceLocation getAnimationResource(MultiColourBlockEntity block) {

        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;

    }
}
