package snaker.snakerbone.utility;

import net.minecraft.util.Mth;

import java.math.BigInteger;

import static snaker.snakerbone.SnakerBone.LOGGER;

/**
 * Created by SnakerBone on 14/02/2023
 **/
public class SnakerBoneMath {

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
    public static int factorial(int value) {

        if (value > 12) {

            LOGGER.warn("Result of sum over max value for type int. Returning that instead: " + Integer.MAX_VALUE);

            return Integer.MAX_VALUE;

        } else if (value <= 0) {

            return 1;

        } else {

            return (value * factorial(value - 1));

        }
    }

    public static long factorial(long value) {

        if (value > 20) {

            LOGGER.warn("Result of sum over max value for type long. Returning that instead: " + Long.MAX_VALUE);

            return Long.MAX_VALUE;

        } else if (value <= 0) {

            return 1;

        } else {

            return (value * factorial(value - 1));

        }
    }

    public static float factorial(float value) {

        if (value > 10) {

            LOGGER.warn("Result of sum over max value for type float. Returning that instead: " + Float.MAX_VALUE);

            return Float.MAX_VALUE;

        } else if (value <= 0) {

            return 1;

        } else {

            return (value * factorial(value - 1));

        }
    }

    public static double factorial(double value) {

        if (value > 18) {

            LOGGER.warn("Result of sum over max value for type double. Returning that instead: " + Double.MAX_VALUE);

            return Double.MAX_VALUE;

        } else if (value <= 0) {

            return 1;

        } else {

            return (value * factorial(value - 1));

        }
    }

    /**
     * Generates a factorial as BigInteger
     **/
    public static BigInteger largeFactorial(int value) {

        BigInteger factorial = BigInteger.ONE;

        for (int i = value; i > 0; i--) {

            factorial = factorial.multiply(BigInteger.valueOf(i));

        }

        return factorial;
    }

    public static BigInteger largeFactorial(long value) {

        BigInteger factorial = BigInteger.ONE;

        for (long i = value; i > 0; i--) {

            factorial = factorial.multiply(BigInteger.valueOf(i));

        }

        return factorial;
    }
}