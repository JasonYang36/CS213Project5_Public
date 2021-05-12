package com.application.cafe;



/**
 * The menu item class serves as the parent class to the possible food items that the customer can order via the main menu. It holds the price and quantity of
 * said items, including both coffee and donuts.
 * @author Steven Li, Jason Yang
 *
 */
public class MenuItem{

    protected double menuItemPrice;
    protected int quantity;

    /**
     * Return the price of the current menu item
     * @return double representing the price
     */
    public double getMenuItemPrice() {
        return menuItemPrice;
    }

    /**
     * Creates the menu item object. Requires user to input the quantity of the object they are ordering. Initializes the price as 0
     * to be calculated later.
     * @param quantity the quantity of the MenuItem
     */
    public MenuItem(int quantity) {
        this.menuItemPrice = 0;
        this.quantity = quantity;
    }

    /**
     * Abstract method to be overrided
     */
    public void itemPrice() {
    }

    /**
     * Returns the quantity of the current menu item in (quantity) format
     * @return String representation of the object
     */
    @Override
    public String toString() {
        return "(" + quantity + ")";
    }

    /**
     * Checks if a given object is equal to the current menu item. Only checks if it is an instance of MenuItem class.
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MenuItem) {
            MenuItem tempMenuItem = (MenuItem) obj;
            return super.equals(tempMenuItem);
        }
        else return false;
    }
}
