package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockitem.WaterColourBlockItem;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class WaterColourBlockItemModel extends AnimatedGeoModel<WaterColourBlockItem> {
    @Override
    public ResourceLocation getModelResource(WaterColourBlockItem object) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(WaterColourBlockItem object) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(WaterColourBlockItem animatable) {
        return Utilities.noAnimation();
    }
}