package snaker.snakerbone.util;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 14/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SnakerBonePolicy {

    /**
     * Customizable warning suppression
     **/
    public static class WarningSuppression {

        public static final String CUSTOM_SET = "";
        public static final String[] CUSTOM_SET_ARRAY = {};
        public static final String ALL = "all";
        public static final String BOXING = "boxing";
        public static final String UNUSED = "unused";
        public static final String CAST = "cast";
        public static final String CONSTANT_CONDITIONS = "ConstantConditions";
        public static final String DEPRECATION = "deprecation";
        public static final String RESTRICTION = "restriction";
        public static final String DEP_ANN = "dep-ann";
        public static final String FALLTHROUGH = "fallthrough";
        public static final String FINALLY = "finally";
        public static final String HIDING = "hiding";
        public static final String INCOMPLETE_SWITCH = "incomplete-switch";
        public static final String NLS = "nls";
        public static final String NULL = "null";
        public static final String SERIAL = "serial";
        public static final String STATIC_ACCESS = "static-access";
        public static final String SYNTHETIC_ACCESS = "synthetic-access";
        public static final String UNCHECKED = "unchecked";
        public static final String UNQUALIFIED_FIELD_ACCESS = "unqualified-field-access";
        public static final String JAVADOC = "javadoc";
        public static final String RAWTYPES = "rawtypes";
        public static final String RESOURCE = "resource";
        public static final String SUPER = "super";
        public static final String SYNC_OVERRIDE = "sync-override";
    }
}
