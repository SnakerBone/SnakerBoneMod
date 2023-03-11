package snaker.snakerbone.client.render.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.entity.projectile.HommingArrow;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;

/**
 * Created by SnakerBone on 4/01/2023
 **/
public class HommingArrowRender extends ArrowRenderer<HommingArrow> {
    public HommingArrowRender(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(HommingArrow entity) {
        return new SnakerBoneResourceLocation("textures/entity/projectile/homming_arrow.png");
    }
}
