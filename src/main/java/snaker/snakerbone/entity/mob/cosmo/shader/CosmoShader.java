package snaker.snakerbone.entity.mob.cosmo.shader;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.client.SnakerBoneShaders;
import snaker.snakerbone.entity.mob.cosmo.Cosmo;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class CosmoShader extends GeoLayerRenderer<Cosmo> {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/cosmo.geo.json");

    public CosmoShader(IGeoRenderer<Cosmo> renderer) {

        super(renderer);

    }

    @Override
    public void render(PoseStack ps, MultiBufferSource buffer, int light, Cosmo entity, float swing, float amount, float pt, float age, float yaw, float pitch) {

        GeoModel model = this.getEntityModel().getModel(MODEL);

        this.getRenderer().render(model, entity, pt, SnakerBoneShaders.COSMO_VARIANT.get(entity.getVariant()), ps, buffer, null, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);

    }
}
