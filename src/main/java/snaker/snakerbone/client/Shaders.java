package snaker.snakerbone.client;

import codechicken.lib.render.shader.CCShaderInstance;
import codechicken.lib.render.shader.CCUniform;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.RegisterShadersEvent;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import snaker.snakerbone.utility.Utilities;

import static net.minecraft.client.renderer.RenderStateShard.*;
import static snaker.snakerbone.utility.Utilities.RANDOM_PLACEHOLDER;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class Shaders {

    public static CCShaderInstance swirl;
    public static CCUniform swirlTime;

    public static CCShaderInstance snow;
    public static CCUniform snowTime;

    public static CCShaderInstance watercolour;
    public static CCUniform watercolourTime;

    public static CCShaderInstance multicolour;
    public static CCUniform multicolourTime;

    public static CCShaderInstance stars;
    public static CCUniform starsTime;
    public static CCUniform starsColour;
    public static CCUniform starsBackground;

    public static CCShaderInstance redStars;
    public static CCUniform redStarsTime;
    public static CCUniform redStarsColour;
    public static CCUniform redStarsBackground;

    public static CCShaderInstance greenStars;
    public static CCUniform greenStarsTime;
    public static CCUniform greenStarsColour;
    public static CCUniform greenStarsBackground;

    public static CCShaderInstance blueStars;
    public static CCUniform blueStarsTime;
    public static CCUniform blueStarsColour;
    public static CCUniform blueStarsBackground;

    public static CCShaderInstance yellowStars;
    public static CCUniform yellowStarsTime;
    public static CCUniform yellowStarsColour;
    public static CCUniform yellowStarsBackground;

    public static CCShaderInstance pinkStars;
    public static CCUniform pinkStarsTime;
    public static CCUniform pinkStarsColour;
    public static CCUniform pinkStarsBackground;

    public static CCShaderInstance purpleStars;
    public static CCUniform purpleStarsTime;
    public static CCUniform purpleStarsColour;
    public static CCUniform purpleStarsBackground;

    public static CCShaderInstance fire;
    public static CCUniform fireTime;

    public static CCShaderInstance plain;
    public static CCUniform plainColour;

    public static CCShaderInstance blurFog;
    public static CCUniform blurFogTime;
    public static CCUniform blurFogHSV;
    public static CCUniform blurFogRGB;
    public static CCUniform blurFogAlpha;

    public static RenderType ISTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> stars))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType IREDSTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> redStars))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType IGREENSTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> greenStars))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType IBLUESTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> blueStars))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType IYELLOWSTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> yellowStars))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType IPINKSTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> pinkStars))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType IPURPLESTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> purpleStars))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType IPLAIN = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.TRIANGLES, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> plain))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType BSWIRL = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> swirl))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType BSNOW = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> snow))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType BWATERCOLOUR = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> watercolour))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType BMULTICOLOUR = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> multicolour))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType BFIRE = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> fire))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType BSTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> stars))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType BPLAIN = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> plain))
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setOverlayState(OVERLAY)
            .createCompositeState(false));
    public static RenderType EFIRE = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> fire))
            .setCullState(NO_CULL)
            .setDepthTestState(EQUAL_DEPTH_TEST)
            .setLightmapState(LIGHTMAP)
            .createCompositeState(false));
    public static RenderType ESTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> stars))
            .setCullState(NO_CULL)
            .setDepthTestState(EQUAL_DEPTH_TEST)
            .setLightmapState(LIGHTMAP)
            .createCompositeState(false));
    public static RenderType EREDSTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> redStars))
            .setCullState(NO_CULL)
            .setDepthTestState(EQUAL_DEPTH_TEST)
            .setLightmapState(LIGHTMAP)
            .createCompositeState(false));
    public static RenderType EGREENSTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> greenStars))
            .setCullState(NO_CULL)
            .setDepthTestState(EQUAL_DEPTH_TEST)
            .setLightmapState(LIGHTMAP)
            .createCompositeState(false));
    public static RenderType EBLUESTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> blueStars))
            .setCullState(NO_CULL)
            .setDepthTestState(EQUAL_DEPTH_TEST)
            .setLightmapState(LIGHTMAP)
            .createCompositeState(false));
    public static RenderType EYELLOWSTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> yellowStars))
            .setCullState(NO_CULL)
            .setDepthTestState(EQUAL_DEPTH_TEST)
            .setLightmapState(LIGHTMAP)
            .createCompositeState(false));
    public static RenderType EPINKSTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> pinkStars))
            .setCullState(NO_CULL)
            .setDepthTestState(EQUAL_DEPTH_TEST)
            .setLightmapState(LIGHTMAP)
            .createCompositeState(false));
    public static RenderType EPURPLESTARS = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> purpleStars))
            .setCullState(NO_CULL)
            .setDepthTestState(EQUAL_DEPTH_TEST)
            .setLightmapState(LIGHTMAP)
            .createCompositeState(false));
    public static RenderType EPLAIN = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> plain))
            .setCullState(NO_CULL)
            .setDepthTestState(EQUAL_DEPTH_TEST)
            .setLightmapState(LIGHTMAP)
            .createCompositeState(false));
    public static RenderType EBLURFOG = RenderType.create(RANDOM_PLACEHOLDER, DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(() -> blurFog))
            .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
            .setLightmapState(LIGHTMAP)
            .setCullState(NO_CULL)
            .setDepthTestState(EQUAL_DEPTH_TEST)
            .createCompositeState(false));

    public static void register(RegisterShadersEvent event) {
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("swirl"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            swirl = (CCShaderInstance) shaderObj;
            swirlTime = swirl.getUniform("Time");
            swirl.onApply(() -> swirlTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20));
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("snow"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            snow = (CCShaderInstance) shaderObj;
            snowTime = snow.getUniform("Time");
            snow.onApply(() -> snowTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20));
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("watercolour"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            watercolour = (CCShaderInstance) shaderObj;
            watercolourTime = watercolour.getUniform("Time");
            watercolour.onApply(() -> watercolourTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20));
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("multicolour"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            multicolour = (CCShaderInstance) shaderObj;
            multicolourTime = multicolour.getUniform("Time");
            multicolour.onApply(() -> multicolourTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20));
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("fire"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            fire = (CCShaderInstance) shaderObj;
            fireTime = fire.getUniform("Time");
            fire.onApply(() -> fireTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20));
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("stars"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            stars = (CCShaderInstance) shaderObj;
            starsTime = stars.getUniform("Time");
            starsColour = stars.getUniform("Colour");
            starsBackground = stars.getUniform("Background");
            stars.onApply(() -> {
                starsTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20);
                starsColour.glUniform3f(1, 1, 1);
                starsBackground.glUniform1b(false);
            });
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("stars"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            redStars = (CCShaderInstance) shaderObj;
            redStarsTime = redStars.getUniform("Time");
            redStarsColour = redStars.getUniform("Colour");
            redStarsBackground = redStars.getUniform("Background");
            redStars.onApply(() -> {
                redStarsTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20);
                redStarsColour.glUniform3f(0.85F, 0.1F, 0.25F);
                redStarsBackground.glUniform1b(true);
            });
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("stars"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            greenStars = (CCShaderInstance) shaderObj;
            greenStarsTime = greenStars.getUniform("Time");
            greenStarsColour = greenStars.getUniform("Colour");
            greenStarsBackground = greenStars.getUniform("Background");
            greenStars.onApply(() -> {
                greenStarsTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20);
                greenStarsColour.glUniform3f(0.5F, 1, 0.25F);
                greenStarsBackground.glUniform1b(true);
            });
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("stars"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            blueStars = (CCShaderInstance) shaderObj;
            blueStarsTime = blueStars.getUniform("Time");
            blueStarsColour = blueStars.getUniform("Colour");
            blueStarsBackground = blueStars.getUniform("Background");
            blueStars.onApply(() -> {
                blueStarsTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20);
                blueStarsColour.glUniform3f(0, 0.5F, 1);
                blueStarsBackground.glUniform1b(true);
            });
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("stars"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            yellowStars = (CCShaderInstance) shaderObj;
            yellowStarsTime = yellowStars.getUniform("Time");
            yellowStarsColour = yellowStars.getUniform("Colour");
            yellowStarsBackground = yellowStars.getUniform("Background");
            yellowStars.onApply(() -> {
                yellowStarsTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20);
                yellowStarsColour.glUniform3f(1, 1, 0);
                yellowStarsBackground.glUniform1b(true);
            });
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("stars"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            pinkStars = (CCShaderInstance) shaderObj;
            pinkStarsTime = pinkStars.getUniform("Time");
            pinkStarsColour = pinkStars.getUniform("Colour");
            pinkStarsBackground = pinkStars.getUniform("Background");
            pinkStars.onApply(() -> {
                pinkStarsTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20);
                pinkStarsColour.glUniform3f(1, 0.5F, 0.8F);
                pinkStarsBackground.glUniform1b(true);
            });
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("stars"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            purpleStars = (CCShaderInstance) shaderObj;
            purpleStarsTime = purpleStars.getUniform("Time");
            purpleStarsColour = purpleStars.getUniform("Colour");
            purpleStarsBackground = purpleStars.getUniform("Background");
            purpleStars.onApply(() -> {
                purpleStarsTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20);
                purpleStarsColour.glUniform3f(0.6F, 0, 0.8F);
                purpleStarsBackground.glUniform1b(true);
            });
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("plain"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            plain = (CCShaderInstance) shaderObj;
            plainColour = plain.getUniform("Colour");
            plain.onApply(() -> {
                plainColour.glUniform4f(0, 0, 0, 0);
            });
        });
        event.registerShader(CCShaderInstance.create(event.getResourceManager(), new SnakerBoneResourceLocation("blur_fog"), DefaultVertexFormat.POSITION_TEX), shaderObj -> {
            blurFog = (CCShaderInstance) shaderObj;
            blurFogTime = blurFog.getUniform("Time");
            blurFogAlpha = blurFog.getUniform("Alpha");
            blurFogHSV = blurFog.getUniform("HSV");
            blurFogRGB = blurFog.getUniform("RGB");
            blurFog.onApply(() -> {
                blurFogTime.glUniform1f((Utilities.ticksElapsed + Minecraft.getInstance().getFrameTime()) / 20);
            });
        });
    }
}
