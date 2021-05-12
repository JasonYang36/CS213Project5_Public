package com.application.cafe;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The coffee class is a subclass of MenuItem, representing the coffee object that a customer can order. Contains an arraylist of addIn enums that
 * can be added. Coffee can calculate the pricing based off the add ins, size, and quantity the user gives.
 * @author Steven Li, Jason Yang
 *
 */

public class Coffee extends MenuItem implements Customizable{
    private static final int SHORT = 1;
    private static final int TALL = 2;
    private static final int GRANDE = 3;
    private static final int VENTI = 4;

    private static final double BLACK_COFFEE_PRICE = 1.99;
    private static final double ADD_IN_PRICE = 0.2;
    private static final double SIZE_PRICE = 0.5;

    private ArrayList<addIn> addIns;
    private int size;

    /**
     * Constructor for a coffee object. Requires user to choose the size and quantity they want. Initial addIns array is empty.
     * @param size the coffee size
     * @param quantity the number of coffees
     */
    public Coffee(String size, int quantity){ //needs to take in quantity and checks string
        super(quantity);
        this.addIns = new ArrayList<addIn>();
        this.size = SHORT;
        if(size.equals("Tall") == true) {
            this.size = TALL;
        }
        else if(size.equals("Grande") == true) {
            this.size = GRANDE;
        }
        else if(size.equals("Venti") == true) {
            this.size = VENTI;
        }
    }

    /**
     * Adds a addIn to the addIn array of the current Coffee object. Checks to make sure that a addIn object is passed to the function.
     * @return boolean
     */
    @Override
    public boolean add(Object obj) { //adds an addIn
        if(obj instanceof addIn) {
            addIns.add((addIn)obj);
            Collections.sort(addIns);
            return true;
        }
        return false;
    }

    /**
     * Removes an addIn from the the addIn array of the current Coffee object. Checks that a addIn object is passed to the funciton as an argument.
     * @return boolean
     */
    @Override
    public boolean remove(Object obj) {//removes an addIn
        if(obj instanceof addIn) {
            addIns.remove((addIn)obj);
            Collections.sort(addIns);
            return true;
        }
        return false;
    }

    /**
     * Calculates the price of the current coffee object. Base price is $1.99, add ins are $0.20 each, and each size increase costs $0.50.
     */
    @Override
    public void itemPrice() {
        DecimalFormat format = new DecimalFormat("###,###,###,##0.00");
        int numAddIns = addIns.size();
        double finalPrice = BLACK_COFFEE_PRICE + (ADD_IN_PRICE * numAddIns) + (size-1)*SIZE_PRICE;
        menuItemPrice = Double.parseDouble(format.format(finalPrice * quantity));
    }

    /**
     * Returns a string representation of the current coffee object including size, coffee type, add ins, and quantity.
     * @return String representing coffee object
     */
    @Override
    public String toString() { //size, coffee type, quantity
        String sizeString = "N/A size";
        if(size == SHORT) {
            sizeString = "Short";
        }
        else if(size == TALL) {
            sizeString = "Tall";
        }
        else if(size == GRANDE) {
            sizeString = "Grande";
        }
        else if(size == VENTI) {
            sizeString = "Venti";
        }
        String finalString = sizeString;
        if(addIns.size() == 0) {
            finalString += " Black Coffee";
        }
        else{
            String addInList = "(";
            for(int i = 0; i < addIns.size(); i++) {
                addInList += addIns.get(i).toString();
                if(i != addIns.size()-1) {
                    addInList += ", ";
                }
            }
            addInList += ")";
            finalString += " Coffee" + addInList;
        }
        return finalString + super.toString();
    }

    /**
     * Checks if a given object is an instance of the Coffee class and if its size/addIns are the same
     * @param obj to compare
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {//checks if size and addins are the same between two coffees
        if(obj instanceof Coffee) {
            Coffee tempCoffee = (Coffee) obj;

            if(size != tempCoffee.size) return false;
            if(!addIns.equals(tempCoffee.addIns)) return false;

            return super.equals(tempCoffee);
        }
        else return false;
    }
}
