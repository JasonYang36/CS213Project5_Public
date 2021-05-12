package com.application.cafe;


import java.util.ArrayList;

/**
 * The Order class represents an order.  An Order holds an array of MenuItems and also keeps track of the subtotal, tax, and total of the order.
 * A unique order number is assigned when an Order object is created.
 * @author Steven Li, Jason Yang
 */
public class Order implements Customizable{
    private ArrayList<MenuItem> order = new ArrayList<MenuItem>();
    private double tax;
    private double subtotal;
    private int orderNumber;
    private static int currentOrderNumber = 1;

    /**
     * Getter method to get an Order's order number.
     * @return the order's order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Getter method to get an Order's tax price.
     * @return the tax price
     */
    public double getTax() {
        return tax;
    }

    /**
     * Getter method to get an Order's subtotal price.
     * @return the subtotal price
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Getter method to get an Order's items.
     * @return the ArrayList of MenuItems
     */
    public ArrayList<MenuItem> getItems(){
        return order;
    }

    /**
     * Default constructor for an order, which initializes tax, subtotal, and assigns a unique order number.
     */
    public Order() {
        this.tax = 0;
        this.subtotal = 0;
        this.orderNumber = currentOrderNumber;
        currentOrderNumber++;
    }

    /**
     * Calculates the subtotal price and tax price of the order.
     */
    public void orderPriceCalculate() {
        double tempSubTotal = 0;
        for(MenuItem item : order){
            tempSubTotal += item.getMenuItemPrice();
        }
        subtotal = tempSubTotal;
        tax = tempSubTotal * Price.getTax();
    }

    /**
     * Adds a MenuItem to the ArrayList in an Order.
     * @param obj the MenuItem being added to the order.
     * @return true if item was added successfully, false otherwise.
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof MenuItem){
            if(obj instanceof Coffee){
                order.add((Coffee)obj);
                return true;
            }
            else if(obj instanceof Donut){
                order.add((Donut)obj);
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    /**
     * Removes a MenuItem from the ArrayList in an Order.
     * @param obj the MenuItem being removed from the Order.
     * @return true if the item was succesfully removed, false otherwise.
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof MenuItem){
            return order.remove(obj);
        }
        return false;
    }
}
