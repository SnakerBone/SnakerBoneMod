package snaker.snakerbone.entity.creature.glider.model;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.creature.glider.Glider;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class GliderModel extends AnimatedGeoModel<Glider> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/glider.geo.json");
    private static final ResourceLocation TEXTURE = new SnakerBoneResourceLocation("textures/entity/creature/glider.png");
    private static final ResourceLocation ANIMATION = new SnakerBoneResourceLocation("animations/glider.animation.json");

    @Override
    public ResourceLocation getModelResource(Glider entity) {

        return MODEL;

    }

    @Override
    public ResourceLocation getTextureResource(Glider entity) {

        return TEXTURE;

    }

    @Override
    public ResourceLocation getAnimationResource(Glider entity) {

        return ANIMATION;

    }
}
