package snaker.snakerbone.utility;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.SnakerBone;

/**
 * Created by SnakerBone on 14/02/2023
 **/
public class SnakerBoneResourceLocation extends ResourceLocation {
    public SnakerBoneResourceLocation(String path) {
        super(SnakerBone.MODID, path);
    }
}
