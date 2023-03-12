package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.SnowBlockEntity;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class SnowBlockModel extends AnimatedGeoModel<SnowBlockEntity> {
    @Override
    public ResourceLocation getModelResource(SnowBlockEntity block) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(SnowBlockEntity block) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(SnowBlockEntity block) {
        return Utilities.noAnimation();
    }
}
