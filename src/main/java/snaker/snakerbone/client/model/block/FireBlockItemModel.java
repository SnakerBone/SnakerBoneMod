package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockitem.FireBlockItem;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class FireBlockItemModel extends AnimatedGeoModel<FireBlockItem> {
    @Override
    public ResourceLocation getModelResource(FireBlockItem item) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(FireBlockItem item) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(FireBlockItem item) {
        return Utilities.noAnimation();
    }
}