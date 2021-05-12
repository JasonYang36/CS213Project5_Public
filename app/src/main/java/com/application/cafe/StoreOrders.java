package com.application.cafe;


import java.util.ArrayList;

/**
 * The StoreOrders class represents the orders that have been ordered. A StoreOrders object holds an ArrayList of added Orders.
 * @author Steven Li, Jason Yang
 */
public class StoreOrders implements Customizable{
    private ArrayList<Order> orders = new ArrayList<Order>();

    /**
     * Default constructor to create a StoreOrders object.
     */
    public StoreOrders() {

    }

    /**
     * Getter method to get the ArrayList of orders.
     * @return the ArrayList of orders
     */
    public ArrayList<Order> getOrders(){
        return orders;
    }

    /**
     * Adds an order to the ArrayList of orders
     * @param obj the order being added
     * @return true if successful, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            orders.add((Order)obj);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Removes an order from the ArrayList of orders
     * @param obj the order being removed
     * @return true if successful, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Order){
            return orders.remove(obj);
        }
        return false;
    }
}

