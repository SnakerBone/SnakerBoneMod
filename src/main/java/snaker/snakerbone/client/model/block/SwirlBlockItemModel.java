package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockitem.SwirlBlockItem;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class SwirlBlockItemModel extends AnimatedGeoModel<SwirlBlockItem> {
    @Override
    public ResourceLocation getModelResource(SwirlBlockItem item) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(SwirlBlockItem item) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(SwirlBlockItem item) {
        return Utilities.noAnimation();
    }
}