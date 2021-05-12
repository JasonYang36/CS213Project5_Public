package com.application.cafe;
/**
 * The price class holds constant variables that are used in other classes. These include possible quantities and the tax which are used to calculate prices.
 * @author Steven Li, Jason Yang
 *
 */
public class Price {
    private static final int QUANTITY_ONE = 1;
    private static final int QUANTITY_TWO = 2;
    private static final int QUANTITY_THREE = 3;
    private static final int QUANTITY_FOUR = 4;
    private static final int QUANTITY_FIVE = 5;
    private static final int QUANTITY_SIX = 6;
    private static final int QUANTITY_SEVEN = 7;
    private static final int QUANTITY_EIGHT = 8;
    private static final int QUANTITY_NINE = 9;

    private static final int NOT_FOUND = -1;

    private static final double TAX = 0.06625;

    /**
     * Returns 1
     * @return QUANTITY_ONE
     */
    public static int getQuantityOne() {
        return QUANTITY_ONE;
    }

    /**
     * Returns 2
     * @return QUANTITY_TWO
     */
    public static int getQuantityTwo() {
        return QUANTITY_TWO;
    }

    /**
     * Returns 3
     * @return QUANTITY_THREE
     */
    public static int getQuantityThree() {
        return QUANTITY_THREE;
    }

    /**
     * Returns 4
     * @return QUANTITY_FOUR
     */
    public static int getQuantityFour() {
        return QUANTITY_FOUR;
    }

    /**
     * Returns 5
     * @return QUANTITY_FIVE
     */
    public static int getQuantityFive() {
        return QUANTITY_FIVE;
    }

    /**
     * Returns 6
     * @return QUANTIY_SIX
     */
    public static int getQuantitySix() {
        return QUANTITY_SIX;
    }

    /**
     * Returns 7
     * @return QUANTITY_SEVEN
     */
    public static int getQuantitySeven() {
        return QUANTITY_SEVEN;
    }

    /**
     * Returns 8
     * @return QUANTITY_EIGHT
     */
    public static int getQuantityEight() {
        return QUANTITY_EIGHT;
    }

    /**
     * Returns 9
     * @return QUANTITY_NINE
     */
    public static int getQuantityNine() {
        return QUANTITY_NINE;
    }

    /**
     * Returns -1
     * @return NOT_FOUND
     */
    public static int getNotFound() {
        return NOT_FOUND;
    }

    /**
     * Returns the tax rate
     * @return TAX
     */
    public static double getTax() {
        return TAX;
    }


}
