package snaker.snakerbone.client.model.item;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.item.CosmoSpine;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * Created by SnakerBone on 22/02/2023
 **/
public class CosmoSpineItemModel {
    private static final ResourceLocation MODEL = new SnakerBoneResourceLocation("geo/cosmo_spine.geo.json");

    public static class Red extends AnimatedGeoModel<CosmoSpine.Red> {
        @Override
        public ResourceLocation getModelResource(CosmoSpine.Red item) {
            return MODEL;
        }

        @Override
        public ResourceLocation getTextureResource(CosmoSpine.Red item) {
            return Utilities.soildTexture();
        }

        @Override
        public ResourceLocation getAnimationResource(CosmoSpine.Red item) {
            return Utilities.noAnimation();
        }
    }

    public static class Green extends AnimatedGeoModel<CosmoSpine.Green> {
        @Override
        public ResourceLocation getModelResource(CosmoSpine.Green item) {
            return MODEL;
        }

        @Override
        public ResourceLocation getTextureResource(CosmoSpine.Green item) {
            return Utilities.soildTexture();
        }

        @Override
        public ResourceLocation getAnimationResource(CosmoSpine.Green item) {
            return Utilities.noAnimation();
        }
    }

    public static class Blue extends AnimatedGeoModel<CosmoSpine.Blue> {
        @Override
        public ResourceLocation getModelResource(CosmoSpine.Blue item) {
            return MODEL;
        }

        @Override
        public ResourceLocation getTextureResource(CosmoSpine.Blue item) {
            return Utilities.soildTexture();
        }

        @Override
        public ResourceLocation getAnimationResource(CosmoSpine.Blue item) {
            return Utilities.noAnimation();
        }
    }

    public static class Yellow extends AnimatedGeoModel<CosmoSpine.Yellow> {
        @Override
        public ResourceLocation getModelResource(CosmoSpine.Yellow item) {
            return MODEL;
        }

        @Override
        public ResourceLocation getTextureResource(CosmoSpine.Yellow item) {
            return Utilities.soildTexture();
        }

        @Override
        public ResourceLocation getAnimationResource(CosmoSpine.Yellow item) {
            return Utilities.noAnimation();
        }
    }

    public static class Pink extends AnimatedGeoModel<CosmoSpine.Pink> {
        @Override
        public ResourceLocation getModelResource(CosmoSpine.Pink item) {
            return MODEL;
        }

        @Override
        public ResourceLocation getTextureResource(CosmoSpine.Pink item) {
            return Utilities.soildTexture();
        }

        @Override
        public ResourceLocation getAnimationResource(CosmoSpine.Pink item) {
            return Utilities.noAnimation();
        }
    }

    public static class Purple extends AnimatedGeoModel<CosmoSpine.Purple> {
        @Override
        public ResourceLocation getModelResource(CosmoSpine.Purple item) {
            return MODEL;
        }

        @Override
        public ResourceLocation getTextureResource(CosmoSpine.Purple item) {
            return Utilities.soildTexture();
        }

        @Override
        public ResourceLocation getAnimationResource(CosmoSpine.Purple item) {
            return Utilities.noAnimation();
        }
    }

    public static class Alpha extends AnimatedGeoModel<CosmoSpine.Alpha> {
        @Override
        public ResourceLocation getModelResource(CosmoSpine.Alpha item) {
            return MODEL;
        }

        @Override
        public ResourceLocation getTextureResource(CosmoSpine.Alpha item) {
            return Utilities.soildTexture();
        }

        @Override
        public ResourceLocation getAnimationResource(CosmoSpine.Alpha item) {
            return Utilities.noAnimation();
        }
    }
}