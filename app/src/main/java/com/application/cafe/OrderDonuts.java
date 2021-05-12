package com.application.cafe;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * The OrderDonuts class is the controller for activity_order_donuts.xml.  The user can add up to 9 donuts to the current order from a predetermined list.
 * Extends AppCompatActivity and implements AdapterView.OnItemSelectedListener.
 * @author Steven Li, Jason Yang
 */
public class OrderDonuts extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static final double DONUT_PRICE = 1.39;

    private static Resources strings;
    private static Spinner donutType, donutQuantity;
    private static TextView donutSubtotal;
    private static String[] donutTypes;
    private static String currDonutType;
    private static Integer currDonutQuantity;
    private static Integer[] quantities = new Integer[]{Price.getQuantityOne(), Price.getQuantityTwo(), Price.getQuantityThree(), Price.getQuantityFour(), Price.getQuantityFive(), Price.getQuantitySix(), Price.getQuantitySeven(), Price.getQuantityEight(), Price.getQuantityNine()};
    private static DecimalFormat decFormat = new DecimalFormat("###,###,###,##0.00");
    //private static Order currOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_donuts);

        //Initialize variables
        strings = getResources();
        donutTypes = strings.getStringArray(R.array.donut_types);
        donutType = findViewById(R.id.donutType);
        donutQuantity = findViewById(R.id.donutQuantity);
        donutSubtotal = findViewById(R.id.donutSubtotal);

        //Initialize donutQuantities spinner
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, quantities);
        donutQuantity.setAdapter(adapter);

        currDonutType = donutTypes[0];
        currDonutQuantity = quantities[0];

        //On Item Selected
        donutType.setOnItemSelectedListener(this);
        donutQuantity.setOnItemSelectedListener(this);

        /*
        //Check if getIntent() != null
        currOrder = (Order)getIntent().getSerializableExtra("theCurrentOrder");
         */
    }

    /**
     * Adds selected donut flavor and quantity to the current order.
     * @param view View object notifying when the order donut button is clicked.
     */
    public void orderDonut(View view) {
        Donut donutToAdd = new Donut(currDonutType, currDonutQuantity);
        donutToAdd.itemPrice();

        MainActivity.theCurrentOrder.add(donutToAdd);

        Toast.makeText(getApplicationContext(), strings.getString(R.string.donut_ordered), Toast.LENGTH_SHORT).show();

        /*
        Intent returnIntent = new Intent();
        returnIntent.putExtra("newCurrentOrder", currOrder);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
         */
    }

    /**
     * Private helper method that calculates the subtotal of the selected donut and quantity.
     */
    private void calculateSubtotal(){
        donutSubtotal.setText(strings.getString(R.string.dollar_sign) + decFormat.format(DONUT_PRICE * currDonutQuantity));
    }

    /**
     * Updates subtotal based on newly selected donut flavor and/or quantity.
     * @param parent AdapterView object
     * @param view View object notifying when an item has been selected.
     * @param position index of spinner element selected
     * @param id id of spinner element that has been modified
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        if(parent.getId() == R.id.donutType){
            currDonutType = parent.getItemAtPosition(position).toString();
        }
        else if(parent.getId() == R.id.donutQuantity){
            currDonutQuantity = Integer.parseInt(parent.getItemAtPosition(position).toString());
        }

        calculateSubtotal();
    }

    /**
     * Required override method onNothingSelected. Does nothing.
     * @param parent AdatperView object
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent){}
}