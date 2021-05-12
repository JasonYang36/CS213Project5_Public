package com.application.cafe;



/**
 * The Donut class is a subclass of MenuItem, representing the Donut object that a customer can order. Contains a type of donut and flavor.
 * @author Steven Li, Jason Yang
 */

public class Donut extends MenuItem{
    private static final double DONUT_PRICE = 1.39;
    private String flavor;

    /**
     * Constructor to make a Donut object.  Takes in the flavor, and the amount of donuts.
     * @param flavor flavor of donut
     * @param quantity number of donuts
     */
    public Donut(String flavor, int quantity) {
        super(quantity);
        this.flavor = flavor;
    }

    /**
     * Getter method to get the menu item price of a Donut.
     * @return the menuItemPrice
     */
    public double getItemPrice(){
        return menuItemPrice;
    }

    /**
     * Sets the correct menuItemPrice value depending on the number of donuts
     */
    @Override
    public void itemPrice() {
        menuItemPrice = DONUT_PRICE * quantity;
    }

    /**
     * Override Object toString method to display the flavor of the donut and the number of donuts
     * @return String containing the flavor and number of donuts in that order.
     */
    @Override
    public String toString() {
        String finalString = flavor + " Donut";
        return finalString + super.toString();
    }

    /**
     * Override Object equals method to compare this Donut with the given Donut.
     * @param obj the Donut you are comparing
     * @return true if the given Donut has the same flavor and quantity as this Donut
     */
    @Override
    public boolean equals(Object obj) {//compares flavor and type of donut
        if(obj instanceof Donut) {
            Donut tempDonut = (Donut) obj;

            if(!flavor.equals(tempDonut.flavor)) return false;
            if(quantity != tempDonut.quantity) return false;

            return super.equals(tempDonut);
        }
        else return false;
    }
}
