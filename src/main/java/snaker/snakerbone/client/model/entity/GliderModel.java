package snaker.snakerbone.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.creature.Glider;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class GliderModel extends AnimatedGeoModel<Glider> {
    @Override
    public ResourceLocation getModelResource(Glider entity) {
        return new SnakerBoneResourceLocation("geo/glider.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Glider entity) {
        return new SnakerBoneResourceLocation("textures/entity/creature/glider.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Glider entity) {
        return new SnakerBoneResourceLocation("animations/glider.animation.json");
    }
}
