package snaker.snakerbone.entity.mob.flare.shader;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.SnakerBone;
import snaker.snakerbone.client.SnakerBoneShaders;
import snaker.snakerbone.entity.mob.flare.Flare;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class FlareShader extends GeoLayerRenderer<Flare> {
    private static final ResourceLocation MODEL = new ResourceLocation(SnakerBone.MODID, "geo/flare.geo.json");

    public FlareShader(IGeoRenderer<Flare> renderer) {

        super(renderer);

    }

    @Override
    public void render(PoseStack ps, MultiBufferSource mbs, int light, Flare entity, float swing, float amount, float pt, float age, float yaw, float pitch) {

        this.getRenderer().render(this.getEntityModel().getModel(MODEL), entity, pt, SnakerBoneShaders.EFIRE, ps, mbs, null, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);

    }
}
