package snaker.snakerbone.client;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.RandomSource;
import snaker.snakerbone.utility.Utilities;

import java.awt.*;

/**
 * Created by SnakerBone on 20/02/2023
 **/
public class Renders {
    public static void rays(PoseStack stack, MultiBufferSource source, Color colour, int minScale, float maxScale, int amount, double offsetX, double offsetY, double offsetZ) {

        RandomSource random = RandomSource.create(432L);
        VertexConsumer buffer = source.getBuffer(RenderType.lightning());

        float time = (float) Utilities.ticksElapsed / 200;

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
}
