package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockitem.SnowBlockItem;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class SnowBlockItemModel extends AnimatedGeoModel<SnowBlockItem> {
    @Override
    public ResourceLocation getModelResource(SnowBlockItem item) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(SnowBlockItem item) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(SnowBlockItem item) {
        return Utilities.noAnimation();
    }
}