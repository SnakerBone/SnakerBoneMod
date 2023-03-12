package snaker.snakerbone.client.layer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import snaker.snakerbone.entity.mob.Cosmo;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

import static snaker.snakerbone.client.render.entity.CosmoRender.ENTITY_VARIANT;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class CosmoLayer extends GeoLayerRenderer<Cosmo> {
    public CosmoLayer(IGeoRenderer<Cosmo> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack ps, MultiBufferSource buffer, int light, Cosmo entity, float swing, float amount, float pt, float age, float yaw, float pitch) {
        getRenderer().render(getEntityModel().getModel(new SnakerBoneResourceLocation("geo/cosmo.geo.json")), entity, pt, ENTITY_VARIANT.get(entity.getVariant()), ps, buffer, null, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
    }
}