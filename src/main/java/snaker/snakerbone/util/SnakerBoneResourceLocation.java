package snaker.snakerbone.util;

import net.minecraft.resources.ResourceLocation;
import snaker.snakerbone.SnakerBone;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 14/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SnakerBoneResourceLocation extends ResourceLocation {
    public SnakerBoneResourceLocation(String path) {

        super(SnakerBone.MODID, path);

    }
}
