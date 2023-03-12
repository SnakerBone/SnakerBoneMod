package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.WaterColourBlockEntity;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class WaterColourBlockModel extends AnimatedGeoModel<WaterColourBlockEntity> {
    @Override
    public ResourceLocation getModelResource(WaterColourBlockEntity object) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(WaterColourBlockEntity object) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(WaterColourBlockEntity animatable) {
        return Utilities.noAnimation();
    }
}
