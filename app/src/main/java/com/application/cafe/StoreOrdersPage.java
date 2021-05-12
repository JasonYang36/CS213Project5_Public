package com.application.cafe;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The StoreOrdersPage class is the controller for activity_store_orders_page.fxml. The user can select from a list of previous order numbers, which will then display the details of that order.
 * The user can also remove the selected order. Extends AppCompatActivity and implements AdapterView.OnItemSelectedListener.
 * @author Steven Li, Jason Yang
 */
public class StoreOrdersPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static Resources strings;
    private static ArrayList<Order> storeOrdersList;
    private static ArrayList<Integer> storeOrderNumbers;
    private static int selectedOrderNum;
    private static Spinner orderNumber;
    private static TextView theOrder;
    private static DecimalFormat decFormat = new DecimalFormat("###,###,###,##0.00");
    ArrayAdapter<Integer> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders_page);

        strings = getResources();

        /*
        //Check if getIntent() != null
        currStoreOrders = (StoreOrders)getIntent().getSerializableExtra("theStoreOrder");
         */

        storeOrdersList = MainActivity.theStoreOrders.getOrders();
        if(storeOrdersList == null || storeOrdersList.size() == 0){
            Toast.makeText(getApplicationContext(), strings.getString(R.string.no_orders), Toast.LENGTH_LONG).show();
        }
        else {
            //Initialize UI variables
            theOrder = findViewById(R.id.theOrder);
            theOrder.setMovementMethod(new ScrollingMovementMethod());
            orderNumber = findViewById(R.id.orderNumber);
            storeOrderNumbers = new ArrayList<Integer>();

            //Initialize order numbers spinner
            for (Order order : storeOrdersList) {
                storeOrderNumbers.add(order.getOrderNumber());
            }

            adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, storeOrderNumbers);
            orderNumber.setAdapter(adapter);

            orderNumber.setOnItemSelectedListener(this);
        }
    }

    /**
     * Removes current order from the store orders list
     * @param view View object notifying when the cancel order button is clicked.
     */
    public void removeOrder(View view){
        for(Order order : storeOrdersList){
            if (order.getOrderNumber() == selectedOrderNum){
                theOrder.setText("");
                storeOrdersList.remove(order);

                //Update order numbers spinner
                storeOrderNumbers = new ArrayList<Integer>();
                for (Order anOrder : storeOrdersList) {
                    storeOrderNumbers.add(anOrder.getOrderNumber());
                }
                adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, storeOrderNumbers);
                orderNumber.setAdapter(adapter);
                break;
            }
        }
    }

    /**
     * Updates textview with details of the selected order, including subtotal, tax, and total.
     * @param parent AdapterView object
     * @param view View object notifying when an item has been selected.
     * @param position index of spinner element selected
     * @param id id of spinner element that has been modified
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        if(parent.getId() == R.id.orderNumber){
            theOrder.setText("");
            selectedOrderNum = Integer.parseInt(parent.getItemAtPosition(position).toString());
            for(Order order : storeOrdersList){
                if (order.getOrderNumber() == selectedOrderNum){
                    ArrayList<MenuItem> printOrder = order.getItems();
                    for(MenuItem menuItem : printOrder){
                        theOrder.append(menuItem.toString() + "\n");
                    }
                    //TODO: Add to strings.xml file
                    theOrder.append(strings.getString(R.string.subtotal_with_dollar) + decFormat.format(order.getSubtotal()) + "\n");
                    theOrder.append(strings.getString(R.string.tax_with_dollar) + decFormat.format(order.getTax()) + "\n");
                    theOrder.append(strings.getString(R.string.total_with_dollar) + decFormat.format(order.getSubtotal()+order.getTax()) + "\n");
                }
            }
        }
    }

    /**
     * Required override method onNothingSelected. Does nothing.
     * @param parent AdatperView object
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent){}
}
