package com.application.cafe;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * The CurrentOrder class acts as the controller for the stage that allows the user to access and change their current order. Users can utilize
 * the remove function to remove items from their order and send it to the store orders once satisfied.
 * @author Steven Li, Jason Yang
 *
 */
public class CurrentOrder extends AppCompatActivity implements AdapterView.OnItemClickListener{


    private ArrayAdapter<MenuItem> adapter;

    private Resources strings;
    private TextView subtotal;
    private TextView salesTax;
    private TextView total;

    private ListView itemList;

    /**
     * Updates the taxes and price totals being displayed on the text fields of the stage. Recalculates all of them before doing so.
     */
    private void updateNumbers(){
        salesTax.setText(strings.getString(R.string.empty));
        subtotal.setText(strings.getString(R.string.empty));
        total.setText(strings.getString(R.string.empty));

        DecimalFormat format = new DecimalFormat("$###,###,###,##0.00");
        MainActivity.theCurrentOrder.orderPriceCalculate();

        salesTax.append(format.format(MainActivity.theCurrentOrder.getTax()));
        subtotal.append(format.format(MainActivity.theCurrentOrder.getSubtotal()));
        total.append(format.format(MainActivity.theCurrentOrder.getTax() + MainActivity.theCurrentOrder.getSubtotal()));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);

        strings = getResources();

        itemList = findViewById(R.id.itemList);
        adapter = new ArrayAdapter<MenuItem>(this, android.R.layout.simple_list_item_1, MainActivity.theCurrentOrder.getItems());
        itemList.setAdapter(adapter);
        itemList.setOnItemClickListener(this);

        subtotal = findViewById(R.id.subtotal);
        salesTax = findViewById(R.id.salesTax);
        total = findViewById(R.id.total);
        updateNumbers();


    }

    /**
     * Listener for when an item is selected by the user on the list view. Gives the user the option to remove the item from the list. If yes
     * is selected, it is deleted from the list view and the order. Prices are then updated
     * @param parent AdapterView object where selection happened
     * @param view represents the list view
     * @param position of the item selected
     * @param id of the item slected
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(strings.getString(R.string.remove_query)).setTitle(strings.getString(R.string.remove));
        alert.setPositiveButton(strings.getString(R.string.YES), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MenuItem selectedItem = MainActivity.theCurrentOrder.getItems().get(position);
                MainActivity.theCurrentOrder.remove(selectedItem);
                adapter.notifyDataSetChanged();

                updateNumbers();

                Toast.makeText(getApplicationContext(), "Item Removed", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton(strings.getString(R.string.NO), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    /**
     * Sends the order with the current menu items to the store orders. Updates the text fields and clears the list view before doing so. Won't add
     * empty orders.
     * @param view representing the order button
     */
    public void placeOrder(View view) {
        if(MainActivity.theCurrentOrder.getItems().size() == 0){
            Toast.makeText(getApplicationContext(), "Please add items first.", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getApplicationContext(), "Order Placed.", Toast.LENGTH_SHORT).show();


        MainActivity.theStoreOrders.add(MainActivity.theCurrentOrder);
        MainActivity.theCurrentOrder = new Order();
        finish();
    }
}