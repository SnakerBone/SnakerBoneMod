package snaker.snakerbone.entity.mob.cosmo.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snaker.snakerbone.entity.mob.cosmo.Cosmo;
import snaker.snakerbone.entity.mob.cosmo.model.CosmoModel;
import snaker.snakerbone.entity.mob.cosmo.shader.CosmoShader;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class CosmoRender extends GeoEntityRenderer<Cosmo> {
    public CosmoRender(EntityRendererProvider.Context renderer) {

        super(renderer, new CosmoModel());

        addLayer(new CosmoShader(this));

    }

    @Override
    public RenderType getRenderType(Cosmo entity, float pt, PoseStack ms, @Nullable MultiBufferSource buffer, @Nullable VertexConsumer vb, int light, ResourceLocation texture) {

        if (entity.getVariant().getId() == 6) {

            Component alphaName = Component.translatable("entity.snakerbone.alpha_cosmo");

            ms.scale(1.45F, 1.45F, 1.45F);

            entity.setCustomName(alphaName);
            entity.setCustomNameVisible(true);

        }

        return super.getRenderType(entity, pt, ms, buffer, vb, light, texture);
    }
}