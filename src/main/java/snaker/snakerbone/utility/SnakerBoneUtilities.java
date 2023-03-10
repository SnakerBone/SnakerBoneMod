package snaker.snakerbone.utility;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

import static snaker.snakerbone.SnakerBone.MODID;

/**
 * Created by SnakerBone on 20/02/2023
 **/
public class SnakerBoneUtilities {

    /**
     * Current client tick count
     **/
    public static long ticksElapsed = 0;

    /**
     * Randomly generated placeholders
     **/
    public static final String PLACEHOLDER = MODID + ":" + PlaceHolders.PH8;
    public static final String PLACEHOLDER_NO_MODID = PlaceHolders.PH8;
    public static String RANDOM_PLACEHOLDER = MODID + ":" + PlaceHolders.PH8;
    public static String RANDOM_PLACEHOLDER_NO_MODID = PlaceHolders.PH8;

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

    /**
     * Helper function
     **/
    private static String generatePlaceholder(int limit) {

        return RandomStringUtils.randomAlphanumeric(limit).toUpperCase();

    }

    static class PlaceHolders {
        static String PH2 = generatePlaceholder(2);
        static String PH4 = generatePlaceholder(4);
        static String PH8 = generatePlaceholder(8);
        static String PH16 = generatePlaceholder(16);
        static String PH32 = generatePlaceholder(32);
        static String PH64 = generatePlaceholder(64);
    }
}