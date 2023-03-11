package snaker.snakerbone.client.layer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import snaker.snakerbone.client.Shaders;
import snaker.snakerbone.entity.mob.Flare;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class FlareLayer extends GeoLayerRenderer<Flare> {
    public FlareLayer(IGeoRenderer<Flare> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack ps, MultiBufferSource mbs, int light, Flare entity, float swing, float amount, float pt, float age, float yaw, float pitch) {
        getRenderer().render(getEntityModel().getModel(new SnakerBoneResourceLocation("geo/flare.geo.json")), entity, pt, Shaders.EFIRE, ps, mbs, null, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
    }
}
