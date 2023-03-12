package snaker.snakerbone.client.model.block;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.block.blockentity.FireBlockEntity;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class FireBlockModel extends AnimatedGeoModel<FireBlockEntity> {
    @Override
    public ResourceLocation getModelResource(FireBlockEntity block) {
        return Utilities.blockModel();
    }

    @Override
    public ResourceLocation getTextureResource(FireBlockEntity block) {
        return Utilities.soildTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(FireBlockEntity block) {
        return Utilities.noAnimation();
    }
}
