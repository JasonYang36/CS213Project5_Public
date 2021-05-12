package com.application.cafe;

/**
 * The Customizable interface specifies the add and remove functions present in various other classes in the application. It is used to add/remove orders, menu items,
 * and add ins to coffee.
 * @author Steven Li, Jason Yang
 *
 */
public interface Customizable {
    /**
     * Abstract method for add
     * @param obj the object being added
     * @return boolean
     */
    boolean add(Object obj);
    /**
     * Abstract method for remove
     * @param obj the object being removed
     * @return boolean
     */
    boolean remove(Object obj);
}
