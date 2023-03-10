package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.SwirlBlockEntity;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class SwirlBlockModel extends AnimatedGeoModel<SwirlBlockEntity> {
    @Override
    public ResourceLocation getModelResource(SwirlBlockEntity block) {

        return SnakerBoneResourceLocation.BLOCK_GEO_LOCATION;

    }

    @Override
    public ResourceLocation getTextureResource(SwirlBlockEntity block) {

        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;

    }

    @Override
    public ResourceLocation getAnimationResource(SwirlBlockEntity block) {

        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;

    }
}
