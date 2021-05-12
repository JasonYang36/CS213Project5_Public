package com.application.cafe;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * The MainActivity acts as the controller where the user can interact with the main menu area of the program. Allows the user to access the order pages
 * for donuts and coffee, as well as viewing the current order lists they've built.
 *
 * @author Steven Li, Jason Yang
 *
 */
public class MainActivity extends AppCompatActivity {

    public static Order theCurrentOrder = new Order();
    public static StoreOrders theStoreOrders = new StoreOrders();

    /**
     * Initializes the main activity and its layout
     * @param savedInstanceState containing passed Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * Loads the activity for the coffee ordering stage when the user clicks the coffee button.
     * @param view representing coffee button
     */
    public void orderCoffee(View view) {
        Intent intent = new Intent(this, OrderCoffee.class);
        startActivity(intent);
    }

    /**
     * Loads the activity for the donut ordering stage when the user clicks the donut button.
     * @param view the object representing clicking of the order donuts button
     */
    public void orderDonuts(View view) {
        Intent intent = new Intent(this, OrderDonuts.class);
        //intent.putExtra("theCurrentOrder", theCurrentOrder);
        startActivity(intent);
    }

    /**
     * Loads the activity that displays the store orders by the user.
     * @param view the object representing clicking of the store orders button.
     */
    public void storeOrdersPage(View view) {
        Intent intent = new Intent(this, StoreOrdersPage.class);
        //intent.putExtra("theStoreOrder", theStoreOrders);
        startActivity(intent);
    }

    /**
     * Loads the activity that displays the current order of the user.
     * @param view representing when user presses the button to view orders
     */
    public void orders(View view) {
        Intent intent = new Intent(this, CurrentOrder.class);
        startActivity(intent);
    }

}