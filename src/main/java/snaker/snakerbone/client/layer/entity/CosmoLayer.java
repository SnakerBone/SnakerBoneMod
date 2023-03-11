package snaker.snakerbone.client.layer.entity;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import snaker.snakerbone.entity.MobVariants;
import snaker.snakerbone.entity.mob.Cosmo;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

import java.util.Map;

import static snaker.snakerbone.client.Shaders.*;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class CosmoLayer extends GeoLayerRenderer<Cosmo> {
    public CosmoLayer(IGeoRenderer<Cosmo> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack ps, MultiBufferSource buffer, int light, Cosmo entity, float swing, float amount, float pt, float age, float yaw, float pitch) {
        getRenderer().render(getEntityModel().getModel(new SnakerBoneResourceLocation("geo/cosmo.geo.json")), entity, pt, COSMO_VARIANT.get(entity.getVariant()), ps, buffer, null, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
    }

    private static final Map<MobVariants.Cosmo, RenderType> COSMO_VARIANT = Util.make(Maps.newEnumMap(MobVariants.Cosmo.class), (map) -> {
        map.put(MobVariants.Cosmo.PURPLE, EPURPLE_STARS);
        map.put(MobVariants.Cosmo.RED, ERED_STARS);
        map.put(MobVariants.Cosmo.GREEN, EGREEN_STARS);
        map.put(MobVariants.Cosmo.BLUE, EBLUE_STARS);
        map.put(MobVariants.Cosmo.YELLOW, EYELLOW_STARS);
        map.put(MobVariants.Cosmo.PINK, EPINK_STARS);
        map.put(MobVariants.Cosmo.ALPHA, ESTARS);
    });
}