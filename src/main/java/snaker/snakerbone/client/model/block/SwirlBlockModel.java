package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.SwirlBlockEntity;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class SwirlBlockModel extends AnimatedGeoModel<SwirlBlockEntity> {
    @Override
    public ResourceLocation getModelResource(SwirlBlockEntity block) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(SwirlBlockEntity block) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(SwirlBlockEntity block) {
        return Utilities.noAnimation();
    }
}
