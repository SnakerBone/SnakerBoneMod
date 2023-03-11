package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.FireBlockEntity;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class FireBlockModel extends AnimatedGeoModel<FireBlockEntity> {
    @Override
    public ResourceLocation getModelResource(FireBlockEntity block) {
        return SnakerBoneResourceLocation.BLOCK_GEO_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(FireBlockEntity block) {
        return SnakerBoneResourceLocation.BLACK_TEX_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(FireBlockEntity block) {
        return SnakerBoneResourceLocation.DUMMY_ANIM_LOCATION;
    }
}
