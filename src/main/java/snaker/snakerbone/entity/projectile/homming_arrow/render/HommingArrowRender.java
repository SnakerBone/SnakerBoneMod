package snaker.snakerbone.entity.projectile.homming_arrow.render;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.SnakerBone;
import snaker.snakerbone.entity.projectile.homming_arrow.HommingArrow;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 4/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class HommingArrowRender extends ArrowRenderer<HommingArrow> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SnakerBone.MODID, "textures/entity/projectile/homming_arrow.png");

    public HommingArrowRender(EntityRendererProvider.Context context) {

        super(context);

    }

    @Override
    public ResourceLocation getTextureLocation(HommingArrow entity) {

        return TEXTURE;

    }
}
