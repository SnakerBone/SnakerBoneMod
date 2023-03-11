package snaker.snakerbone.utility;

import net.minecraft.util.Mth;

import java.math.BigInteger;

/**
 * Created by SnakerBone on 14/02/2023
 **/
public class Maths {

    /**
     * Rotates object towards specified angle
     **/
    public static float rotateTowards(float pos1, float pos2) {
        float angle = (float) Mth.atan2(pos1, pos2);
        return -(angle * (180 / (float) Math.PI));
    }

    public static double rotateTowards(double pos1, double pos2) {
        double angle = Mth.atan2(pos1, pos2);
        return -(angle * (180 / Math.PI));
    }

    /**
     * Rotates object away from specified angle
     **/
    public static float rotateAway(float pos1, float pos2) {
        float angle = (float) Mth.atan2(pos1, pos2);
        return (angle * (180 / (float) Math.PI));
    }

    public static double rotateAway(double pos1, double pos2) {
        double angle = Mth.atan2(pos1, pos2);
        return (angle * (180 / Math.PI));
    }

    /**
     * Generates a factorial
     **/
    public static BigInteger factorial(int value) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = value; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static BigInteger factorial(long value) {
        BigInteger factorial = BigInteger.ONE;
        for (long i = value; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    /**
     * Generates an <a href="https://math.stackexchange.com/questions/60578/what-is-the-term-for-a-factorial-type-operation-but-with-summation-instead-of-p#comment5674000_60578">additorial</a>
     **/
    public static BigInteger additorial(int value) {
        BigInteger additorial = BigInteger.ONE;
        for (int i = value; i > 0; i--) {
            additorial = additorial.add(BigInteger.valueOf(i));
        }
        return additorial;
    }

    public static BigInteger additorial(long value) {
        BigInteger additorial = BigInteger.ONE;
        for (long i = value; i > 0; i--) {
            additorial = additorial.add(BigInteger.valueOf(i));
        }
        return additorial;
    }
}