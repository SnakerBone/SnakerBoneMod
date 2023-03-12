package snaker.snakerbone.client.render.entity;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.client.layer.entity.CosmoLayer;
import snaker.snakerbone.client.model.entity.CosmoModel;
import snaker.snakerbone.entity.MobVariants;
import snaker.snakerbone.entity.mob.Cosmo;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

import static snaker.snakerbone.client.Shaders.*;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class CosmoRender extends GeoEntityRenderer<Cosmo> {

    public CosmoRender(EntityRendererProvider.Context renderer) {
        super(renderer, new CosmoModel());
        addLayer(new CosmoLayer(this));
    }

    @Override
    public RenderType getRenderType(Cosmo entity, float pt, PoseStack ms, @Nullable MultiBufferSource buffer, @Nullable VertexConsumer vb, int light, ResourceLocation texture) {
        if (entity.getVariant().equals(MobVariants.Cosmo.ALPHA)) {
            ms.scale(1.45F, 1.45F, 1.45F);
        }
        return super.getRenderType(entity, pt, ms, buffer, vb, light, texture);
    }

    public static final Map<MobVariants.Cosmo, RenderType> ENTITY_VARIANT = Util.make(Maps.newEnumMap(MobVariants.Cosmo.class), (map) -> {
        map.put(MobVariants.Cosmo.PURPLE, EPURPLESTARS);
        map.put(MobVariants.Cosmo.RED, EREDSTARS);
        map.put(MobVariants.Cosmo.GREEN, EGREENSTARS);
        map.put(MobVariants.Cosmo.BLUE, EBLUESTARS);
        map.put(MobVariants.Cosmo.YELLOW, EYELLOWSTARS);
        map.put(MobVariants.Cosmo.PINK, EPINKSTARS);
        map.put(MobVariants.Cosmo.ALPHA, ESTARS);
    });
}