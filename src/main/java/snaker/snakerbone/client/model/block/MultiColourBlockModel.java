package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.MultiColourBlockEntity;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class MultiColourBlockModel extends AnimatedGeoModel<MultiColourBlockEntity> {
    @Override
    public ResourceLocation getModelResource(MultiColourBlockEntity block) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(MultiColourBlockEntity block) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(MultiColourBlockEntity block) {
        return Utilities.noAnimation();
    }
}
