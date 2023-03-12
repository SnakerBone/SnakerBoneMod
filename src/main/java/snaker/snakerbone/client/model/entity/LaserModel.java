package snaker.snakerbone.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.projectile.Laser;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 20/02/2023
 **/
public class LaserModel extends AnimatedGeoModel<Laser> {
    @Override
    public ResourceLocation getModelResource(Laser entity) {
        return Utilities.noModel();
    }

    @Override
    public ResourceLocation getTextureResource(Laser entity) {
        return Utilities.noTexture();
    }

    @Override
    public ResourceLocation getAnimationResource(Laser animatable) {
        return Utilities.noAnimation();
    }
}
