package snaker.snakerbone.utility;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.SnakerBone;

/**
 * Created by SnakerBone on 14/02/2023
 **/
public class SnakerBoneResourceLocation extends ResourceLocation {
    public static SnakerBoneResourceLocation TRANSPARENT_TEX_LOCATION = new SnakerBoneResourceLocation("textures/model/transparent.png");
    public static SnakerBoneResourceLocation BLACK_TEX_LOCATION = new SnakerBoneResourceLocation("textures/model/black.png");
    public static SnakerBoneResourceLocation WHITE_TEX_LOCATION = new SnakerBoneResourceLocation("textures/model/white.png");
    public static SnakerBoneResourceLocation BLOCK_GEO_LOCATION = new SnakerBoneResourceLocation("geo/block.geo.json");
    public static SnakerBoneResourceLocation DUMMY_GEO_LOCATION = new SnakerBoneResourceLocation("geo/dummy.geo.json");
    public static SnakerBoneResourceLocation DUMMY_ANIM_LOCATION = new SnakerBoneResourceLocation("animations/dummy.animation.json");

    public SnakerBoneResourceLocation(String path) {
        super(SnakerBone.MODID, path);
    }
}
