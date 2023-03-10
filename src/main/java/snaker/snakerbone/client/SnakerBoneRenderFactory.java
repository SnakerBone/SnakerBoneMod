package snaker.snakerbone.client;

import codechicken.lib.math.MathHelper;
import codechicken.lib.vec.Matrix4;
import codechicken.lib.vec.Vector3;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;
import snaker.snakerbone.utility.SnakerBoneUtilities;

import java.awt.*;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * Created by SnakerBone on 20/02/2023
 **/
public class SnakerBoneRenderFactory {
    public static void renderRays(PoseStack stack, MultiBufferSource source, Color colour, int minScale, float maxScale, int amount, double offsetX, double offsetY, double offsetZ) {

        RandomSource random = RandomSource.create(432L);
        VertexConsumer buffer = source.getBuffer(RenderType.lightning());

        float time = (float) SnakerBoneUtilities.ticksElapsed / 200;

        stack.pushPose();

        if ((offsetX + offsetY + offsetZ) != 0) {

            stack.translate(offsetX, offsetY, offsetZ);

        }

        for (int i = 0; i < amount; ++i) {

            stack.pushPose();

            stack.mulPose(Vector3f.XP.rotationDegrees(random.nextFloat() * 360));
            stack.mulPose(Vector3f.YP.rotationDegrees(random.nextFloat() * 360));
            stack.mulPose(Vector3f.ZP.rotationDegrees(random.nextFloat() * 360));
            stack.mulPose(Vector3f.XP.rotationDegrees(random.nextFloat() * 360));
            stack.mulPose(Vector3f.YP.rotationDegrees(random.nextFloat() * 360));
            stack.mulPose(Vector3f.ZP.rotationDegrees(random.nextFloat() * 360 + time * 360));

            Matrix4f m4f = stack.last().pose();

            float lerp1 = random.nextFloat() * 20 + 5;
            float lerp2 = random.nextFloat() * 2 + 1;

            lerp1 /= 30 / (Math.min((float) minScale, 10 * maxScale) / 10);
            lerp2 /= 30 / (Math.min((float) minScale, 10 * maxScale) / 10);

            buffer.vertex(m4f, 0, 0, 0).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 255).endVertex();
            buffer.vertex(m4f, 0, 0, 0).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 255).endVertex();
            buffer.vertex(m4f, -0.7F * lerp2, lerp1, -0.5F * lerp2).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 0).endVertex();
            buffer.vertex(m4f, 0.7F * lerp2, lerp1, -0.5F * lerp2).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 0).endVertex();
            buffer.vertex(m4f, 0, 0, 0).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 255).endVertex();
            buffer.vertex(m4f, 0, 0, 0).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 255).endVertex();
            buffer.vertex(m4f, 0.7F * lerp2, lerp1, -0.5F * lerp2).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 0).endVertex();
            buffer.vertex(m4f, 0, lerp1, lerp2).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 0).endVertex();
            buffer.vertex(m4f, 0, 0, 0).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 255).endVertex();
            buffer.vertex(m4f, 0, 0, 0).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 255).endVertex();
            buffer.vertex(m4f, 0, lerp1, lerp2).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 0).endVertex();
            buffer.vertex(m4f, -0.7F * lerp2, lerp1, -0.5F * lerp2).color(colour.getRed(), colour.getGreen(), colour.getBlue(), 0).endVertex();

            stack.popPose();
        }

        stack.popPose();

        bind(buffer, RenderType.lightning());
    }

    private static void bind(VertexConsumer vc, RenderType type) {

        if (vc instanceof BufferBuilder) {

            type.end((BufferBuilder) vc, 0, 0, 0);

            ((BufferBuilder) vc).begin(type.mode(), type.format());

        }
    }

    public static void transform(Matrix4 matrix4, double x, double y, double z, double scale) {

        matrix4.translate(x, y, z);
        matrix4.rotate(MathHelper.torad * 90, Vector3.Y_NEG);
        matrix4.rotate(MathHelper.torad * 45, Vector3.X_POS);
        matrix4.scale(scale);

    }

    public static class PublicRenderStateShards {

        // @formatter:off

        public static final RenderStateShard.TransparencyStateShard NO_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("no_transparency", RenderSystem::disableBlend, () -> {});
        public static final RenderStateShard.TransparencyStateShard ADDITIVE_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("additive_transparency", () -> {RenderSystem.enableBlend();RenderSystem.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);}, () -> {RenderSystem.disableBlend();RenderSystem.defaultBlendFunc();});
        public static final RenderStateShard.TransparencyStateShard LIGHTNING_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("lightning_transparency", () -> {RenderSystem.enableBlend();RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);}, () -> {RenderSystem.disableBlend();RenderSystem.defaultBlendFunc();});
        public static final RenderStateShard.TransparencyStateShard GLINT_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("glint_transparency", () -> {RenderSystem.enableBlend();RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_COLOR, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);}, () -> {RenderSystem.disableBlend();RenderSystem.defaultBlendFunc();});
        public static final RenderStateShard.TransparencyStateShard CRUMBLING_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("crumbling_transparency", () -> {RenderSystem.enableBlend();RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);}, () -> {RenderSystem.disableBlend();RenderSystem.defaultBlendFunc();});
        public static final RenderStateShard.TransparencyStateShard TRANSLUCENT_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("translucent_transparency", () -> {RenderSystem.enableBlend();RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);}, () -> {RenderSystem.disableBlend();RenderSystem.defaultBlendFunc();});
        public static final RenderStateShard.ShaderStateShard NO_SHADER = new RenderStateShard.ShaderStateShard();
        public static final RenderStateShard.ShaderStateShard BLOCK_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getBlockShader);
        public static final RenderStateShard.ShaderStateShard NEW_ENTITY_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getNewEntityShader);
        public static final RenderStateShard.ShaderStateShard POSITION_COLOR_LIGHTMAP_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getPositionColorLightmapShader);
        public static final RenderStateShard.ShaderStateShard POSITION_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getPositionShader);
        public static final RenderStateShard.ShaderStateShard POSITION_COLOR_TEX_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getPositionColorTexShader);
        public static final RenderStateShard.ShaderStateShard POSITION_TEX_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getPositionTexShader);
        public static final RenderStateShard.ShaderStateShard POSITION_COLOR_TEX_LIGHTMAP_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getPositionColorTexLightmapShader);
        public static final RenderStateShard.ShaderStateShard POSITION_COLOR_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getPositionColorShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_SOLID_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeSolidShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_CUTOUT_MIPPED_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeCutoutMippedShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_CUTOUT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeCutoutShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_TRANSLUCENT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeTranslucentShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_TRANSLUCENT_MOVING_BLOCK_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeTranslucentMovingBlockShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_TRANSLUCENT_NO_CRUMBLING_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeTranslucentNoCrumblingShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ARMOR_CUTOUT_NO_CULL_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeArmorCutoutNoCullShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_SOLID_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntitySolidShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_CUTOUT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityCutoutShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_CUTOUT_NO_CULL_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityCutoutNoCullShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_CUTOUT_NO_CULL_Z_OFFSET_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityCutoutNoCullZOffsetShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ITEM_ENTITY_TRANSLUCENT_CULL_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeItemEntityTranslucentCullShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityTranslucentCullShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_TRANSLUCENT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityTranslucentShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_TRANSLUCENT_EMISSIVE_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityTranslucentEmissiveShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_SMOOTH_CUTOUT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntitySmoothCutoutShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_BEACON_BEAM_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeBeaconBeamShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_DECAL_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityDecalShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_NO_OUTLINE_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityNoOutlineShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_SHADOW_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityShadowShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_ALPHA_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityAlphaShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_EYES_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEyesShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENERGY_SWIRL_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEnergySwirlShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_LEASH_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeLeashShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_WATER_MASK_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeWaterMaskShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_OUTLINE_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeOutlineShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ARMOR_GLINT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeArmorGlintShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ARMOR_ENTITY_GLINT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeArmorEntityGlintShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_GLINT_TRANSLUCENT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeGlintTranslucentShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_GLINT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeGlintShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_GLINT_DIRECT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeGlintDirectShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_GLINT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityGlintShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENTITY_GLINT_DIRECT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityGlintDirectShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_CRUMBLING_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeCrumblingShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_TEXT_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeTextShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_TEXT_INTENSITY_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeTextIntensityShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_TEXT_SEE_THROUGH_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeTextSeeThroughShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_TEXT_INTENSITY_SEE_THROUGH_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeTextIntensitySeeThroughShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_LIGHTNING_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeLightningShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_TRIPWIRE_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeTripwireShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_END_PORTAL_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEndPortalShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_END_GATEWAY_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEndGatewayShader);
        public static final RenderStateShard.ShaderStateShard RENDERTYPE_LINES_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeLinesShader);
        public static final RenderStateShard.TextureStateShard BLOCK_SHEET_MIPPED = new RenderStateShard.TextureStateShard(TextureAtlas.LOCATION_BLOCKS, false, true);
        public static final RenderStateShard.TextureStateShard BLOCK_SHEET = new RenderStateShard.TextureStateShard(TextureAtlas.LOCATION_BLOCKS, false, false);
        public static final EmptyTextureStateShard NO_TEXTURE = new EmptyTextureStateShard();
        public static final RenderStateShard.TexturingStateShard DEFAULT_TEXTURING = new RenderStateShard.TexturingStateShard("default_texturing", () -> {}, () -> {});
        public static final RenderStateShard.TexturingStateShard GLINT_TEXTURING = new RenderStateShard.TexturingStateShard("glint_texturing", () -> setupGlintTexturing(8), RenderSystem::resetTextureMatrix);
        public static final RenderStateShard.TexturingStateShard ENTITY_GLINT_TEXTURING = new RenderStateShard.TexturingStateShard("entity_glint_texturing", () -> setupGlintTexturing(0.16F), RenderSystem::resetTextureMatrix);
        public static final RenderStateShard.LightmapStateShard LIGHTMAP = new RenderStateShard.LightmapStateShard(true);
        public static final RenderStateShard.LightmapStateShard NO_LIGHTMAP = new RenderStateShard.LightmapStateShard(false);
        public static final RenderStateShard.OverlayStateShard OVERLAY = new RenderStateShard.OverlayStateShard(true);
        public static final RenderStateShard.OverlayStateShard NO_OVERLAY = new RenderStateShard.OverlayStateShard(false);
        public static final RenderStateShard.CullStateShard CULL = new RenderStateShard.CullStateShard(true);
        public static final RenderStateShard.CullStateShard NO_CULL = new RenderStateShard.CullStateShard(false);
        public static final RenderStateShard.DepthTestStateShard NO_DEPTH_TEST = new RenderStateShard.DepthTestStateShard("always", 519);
        public static final RenderStateShard.DepthTestStateShard EQUAL_DEPTH_TEST = new RenderStateShard.DepthTestStateShard("==", 514);
        public static final RenderStateShard.DepthTestStateShard LEQUAL_DEPTH_TEST = new RenderStateShard.DepthTestStateShard("<=", 515);
        public static final RenderStateShard.WriteMaskStateShard COLOR_DEPTH_WRITE = new RenderStateShard.WriteMaskStateShard(true, true);
        public static final RenderStateShard.WriteMaskStateShard COLOR_WRITE = new RenderStateShard.WriteMaskStateShard(true, false);
        public static final RenderStateShard.WriteMaskStateShard DEPTH_WRITE = new RenderStateShard.WriteMaskStateShard(false, true);
        public static final RenderStateShard.LayeringStateShard NO_LAYERING = new RenderStateShard.LayeringStateShard("no_layering", () -> {}, () -> {});
        public static final RenderStateShard.LayeringStateShard POLYGON_OFFSET_LAYERING = new RenderStateShard.LayeringStateShard("polygon_offset_layering", () -> {RenderSystem.polygonOffset(-1, -10);RenderSystem.enablePolygonOffset();}, () -> {RenderSystem.polygonOffset(0, 0);RenderSystem.disablePolygonOffset();});
        public static final RenderStateShard.LayeringStateShard VIEW_OFFSET_Z_LAYERING = new RenderStateShard.LayeringStateShard("view_offset_z_layering", () -> {PoseStack posestack = RenderSystem.getModelViewStack();posestack.pushPose();posestack.scale(0.99975586F, 0.99975586F, 0.99975586F);RenderSystem.applyModelViewMatrix();}, () -> {PoseStack posestack = RenderSystem.getModelViewStack();posestack.popPose();RenderSystem.applyModelViewMatrix();});
        public static final RenderStateShard.OutputStateShard MAIN_TARGET = new RenderStateShard.OutputStateShard("main_target", () -> {}, () -> {});
        public static final RenderStateShard.OutputStateShard OUTLINE_TARGET = new RenderStateShard.OutputStateShard("outline_target", () -> Objects.requireNonNull(Minecraft.getInstance().levelRenderer.entityTarget()).bindWrite(false), () -> Minecraft.getInstance().getMainRenderTarget().bindWrite(false));
        public static final RenderStateShard.OutputStateShard TRANSLUCENT_TARGET = new RenderStateShard.OutputStateShard("translucent_target", () -> {if (Minecraft.useShaderTransparency()) Objects.requireNonNull(Minecraft.getInstance().levelRenderer.getTranslucentTarget()).bindWrite(false);}, () -> {if (Minecraft.useShaderTransparency()) Minecraft.getInstance().getMainRenderTarget().bindWrite(false);});
        public static final RenderStateShard.OutputStateShard PARTICLES_TARGET = new RenderStateShard.OutputStateShard("particles_target", () -> {if (Minecraft.useShaderTransparency()) Objects.requireNonNull(Minecraft.getInstance().levelRenderer.getParticlesTarget()).bindWrite(false);}, () -> {if (Minecraft.useShaderTransparency()) Minecraft.getInstance().getMainRenderTarget().bindWrite(false);});
        public static final RenderStateShard.OutputStateShard WEATHER_TARGET = new RenderStateShard.OutputStateShard("weather_target", () -> {if (Minecraft.useShaderTransparency()) Objects.requireNonNull(Minecraft.getInstance().levelRenderer.getWeatherTarget()).bindWrite(false);}, () -> {if (Minecraft.useShaderTransparency()) Minecraft.getInstance().getMainRenderTarget().bindWrite(false);});
        public static final RenderStateShard.OutputStateShard CLOUDS_TARGET = new RenderStateShard.OutputStateShard("clouds_target", () -> {if (Minecraft.useShaderTransparency()) Objects.requireNonNull(Minecraft.getInstance().levelRenderer.getCloudsTarget()).bindWrite(false);}, () -> {if (Minecraft.useShaderTransparency()) Minecraft.getInstance().getMainRenderTarget().bindWrite(false);});
        public static final RenderStateShard.OutputStateShard ITEM_ENTITY_TARGET = new RenderStateShard.OutputStateShard("item_entity_target", () -> {if (Minecraft.useShaderTransparency()) Objects.requireNonNull(Minecraft.getInstance().levelRenderer.getItemEntityTarget()).bindWrite(false);}, () -> {if (Minecraft.useShaderTransparency()) Minecraft.getInstance().getMainRenderTarget().bindWrite(false);});
        public static final LineStateShard DEFAULT_LINE = new LineStateShard(OptionalDouble.of(1));

        private static void setupGlintTexturing(float pScale) {long i = Util.getMillis() * 8L;float f = (float)(i % 110000L) / 110000, f1 = (float)(i % 30000L) / 30000; Matrix4f matrix4f = Matrix4f.createTranslateMatrix(-f, f1, 0); matrix4f.multiply(Vector3f.ZP.rotationDegrees(10)); matrix4f.multiply(Matrix4f.createScaleMatrix(pScale, pScale, pScale)); RenderSystem.setTextureMatrix(matrix4f); }

        public static class EmptyTextureStateShard extends RenderStateShard { public EmptyTextureStateShard(Runnable pSetupState, Runnable pClearState) {super("texture", pSetupState, pClearState);}EmptyTextureStateShard() {super("texture", () -> {}, () -> {});}public Optional<ResourceLocation> cutoutTexture() {return Optional.empty();}}

        public static class LineStateShard extends RenderStateShard { private final OptionalDouble width;public LineStateShard(OptionalDouble width) {super("line_width", () -> {if (!Objects.equals(width, OptionalDouble.of(1))) if (width.isPresent()) RenderSystem.lineWidth((float)width.getAsDouble()); else RenderSystem.lineWidth(Math.max(2.5F, (float)Minecraft.getInstance().getWindow().getWidth() / 1920 * 2.5F));}, () -> {if (!Objects.equals(width, OptionalDouble.of(1))) RenderSystem.lineWidth(1);});this.width = width;}public @NotNull String toString() {return this.name + "[" + (this.width.isPresent() ? this.width.getAsDouble() : "window_scale") + "]";}}

        // @formatter:on

    }
}
