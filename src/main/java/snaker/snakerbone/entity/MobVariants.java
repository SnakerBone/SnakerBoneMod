package snaker.snakerbone.entity;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by SnakerBone on 8/03/2023
 **/
public class MobVariants {
    public enum Cosmo {
        PURPLE(0),
        RED(1),
        GREEN(2),
        BLUE(3),
        YELLOW(4),
        PINK(5),
        ALPHA(6);

        private static final Cosmo[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(Cosmo::getId)).toArray(Cosmo[]::new);
        private final int id;

        Cosmo(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static Cosmo byId(int id) {
            return BY_ID[id % BY_ID.length];
        }
    }
}
