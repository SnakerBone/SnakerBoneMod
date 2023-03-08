package snaker.snakerbone.util;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

/**
 * Created by SnakerBone on 20/02/2023
 **/
public class SnakerBoneTools {

    /**
     * Current client tick count
     **/
    public static long ticksElapsed = 0;

    /**
     * Used to generate a random hexadecimal colour code
     **/
    public static int randomHex() {

        Random random = new Random();

        return random.nextInt(0xffffff + 1);

    }

    /**
     * Used to convert a hexadecimal colour code to a decimal
     **/
    public static int hexToInt(String hexCode) {

        hexCode = hexCode.replace("#", "");

        return Integer.parseInt(hexCode, 16);

    }

    /**
     * Stops counting if the user pauses the game or if the user is tabbed out
     **/
    @SubscribeEvent
    public void tickEnd(TickEvent.ClientTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;

        if (Minecraft.getInstance().isPaused()) return;

        ticksElapsed++;
    }
}
