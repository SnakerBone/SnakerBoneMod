package snaker.snakerbone.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class SnakerBoneCommonConfig {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec configSpec;
    public static final ForgeConfigSpec.BooleanValue playerVulnerableInCreative;


    static {

        builder.push("common");

        playerVulnerableInCreative = builder.comment("Should mobs target the player when in creative mode (default: true)").define("playerVulnerableInCreative", true);

        builder.pop();

        configSpec = builder.build();

    }
}
