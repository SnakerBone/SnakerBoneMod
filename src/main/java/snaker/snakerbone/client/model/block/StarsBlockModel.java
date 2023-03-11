package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.StarsBlockEntity;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class StarsBlockModel extends AnimatedGeoModel<StarsBlockEntity> {
    @Override
    public ResourceLocation getModelResource(StarsBlockEntity block) {
        return SnakerBoneResourceLocation.BLOCK_GEO_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(StarsBlockEntity block) {
        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(StarsBlockEntity block) {
        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;
    }
}
