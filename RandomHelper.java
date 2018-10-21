package se.iths.sandra;

import java.util.Random;

/**
 * A class that helps getting randombased chanses and numbers.
 */
public class RandomHelper {
    private static Random random = new Random();

    /**
     *Implements the nextDouble() from class Random that returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator's sequence.
     * @returns value true if the double value distributed by the Randomclass is lower than 0.9, else false. True is therefore produced with (approximately) 90% probability.
     */
    public static boolean getBigChance(){
        return (random.nextDouble()<0.9);
    }

    /**
     * Implements the nextBoolean from the Random-Class.
     * @return true or false.The values true and false are produced with (approximately) equal probability.
     */
    public static boolean get50Chance(){
        return random.nextBoolean();
    }

    /**
     * Implements the getInt from the Random-Class, and returns a random number between two specific numbers.
     * @param lowervalue -the lowest number to return
     * @param uppervalue- the highest number to return.
     * @return a randomly chosen number between the lowervalue and uppervalue- parameters.
     */
    public static int getInt(int lowervalue, int uppervalue){
        return (random.nextInt(uppervalue-lowervalue) + lowervalue);
    }
}
