package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockitem.MultiColourBlockItem;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class MultiColourBlockItemModel extends AnimatedGeoModel<MultiColourBlockItem> {
    @Override
    public ResourceLocation getModelResource(MultiColourBlockItem item) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(MultiColourBlockItem item) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(MultiColourBlockItem item) {
        return Utilities.noAnimation();
    }
}