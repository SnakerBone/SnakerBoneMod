package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.StarsBlockEntity;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class StarsBlockModel extends AnimatedGeoModel<StarsBlockEntity> {
    @Override
    public ResourceLocation getModelResource(StarsBlockEntity block) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(StarsBlockEntity block) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(StarsBlockEntity block) {
        return Utilities.noAnimation();
    }
}
