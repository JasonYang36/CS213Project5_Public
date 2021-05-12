package com.application.cafe;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * The Order Coffee activity serves as the controller class for the ordering coffee stage. It allows the user to design a coffee object of their
 * preference by adding add ins, size, and quantity. The price is calculated internally with each change and displayed in the text views of the stage.
 * @author Steven Li, Jason Yang
 *
 */
public class OrderCoffee extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static Resources strings;
    private CheckBox cream;
    private CheckBox syrup;
    private CheckBox caramel;
    private CheckBox milk;
    private CheckBox whippedCream;

    private Spinner quantitySpinner;
    private Spinner sizeSpinner;
    private TextView priceView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_coffee);
        priceView = findViewById(R.id.priceView);

        strings = getResources();

        String[] sizes = strings.getStringArray(R.array.coffee_sizes);
        sizeSpinner = (Spinner)findViewById(R.id.sizeSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizes);
        sizeSpinner.setAdapter(adapter);
        sizeSpinner.setOnItemSelectedListener(this);

        Integer[] quantities = new Integer[]{Price.getQuantityOne(),Price.getQuantityTwo(),Price.getQuantityThree(),Price.getQuantityFour(),Price.getQuantityFive()};
        quantitySpinner = (Spinner)findViewById(R.id.quantitySpinner);
        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, quantities);
        quantitySpinner.setAdapter(adapter2);
        quantitySpinner.setOnItemSelectedListener(this);

        cream = (CheckBox)findViewById(R.id.cream);
        syrup = (CheckBox)findViewById(R.id.syrup);
        caramel = (CheckBox)findViewById(R.id.caramel);
        milk = (CheckBox)findViewById(R.id.milk);
        whippedCream = (CheckBox)findViewById(R.id.whippedCream);
    }

    /**
     * Creates a coffee with the currently selected options that the user has inputted through the check boxes and combo boxes.
     * @return Coffee that is created
     */
    private Coffee makeCoffee(){
        Coffee tempCoffee = new Coffee(sizeSpinner.getSelectedItem().toString(), (Integer)quantitySpinner.getSelectedItem());
        if(caramel.isChecked() == true){
            tempCoffee.add(addIn.CARAMEL);
        }
        if(syrup.isChecked() == true){
            tempCoffee.add(addIn.SYRUP);
        }
        if(milk.isChecked() == true){
            tempCoffee.add(addIn.MILK);
        }
        if(cream.isChecked() == true){
            tempCoffee.add(addIn.CREAM);
        }
        if(whippedCream.isChecked() == true){
            tempCoffee.add(addIn.WHIPPED_CREAM);
        }
        return tempCoffee;
    }

    /**
     * Updates the price being displayed in the price text field. Requires the user to have already selected a size and quantity.
     */
    private void changePrice(){
        if(quantitySpinner.isSelected() == false || sizeSpinner.isSelected() == false ){
            priceView.setText(strings.getString(R.string.empty));
            Coffee newCoffee = makeCoffee();
            newCoffee.itemPrice();
            priceView.append(strings.getString(R.string.dollar_sign) + newCoffee.getMenuItemPrice());
        }
    }

    /**
     * Listener for when a check box is selected, updates the prices displated
     * @param view
     */
    public void updatePrice(View view) {
        changePrice();
    }

    /**
     * Listener for when a spinner item is selected. Calls the changePrice method to update the prices displayed
     * @param parent AdapterView object where selection happened
     * @param view representing the spinner
     * @param position of option selected
     * @param id of item selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        changePrice();
    }

    /**
     * Empty listener method.
     * @param parent AdapaterVieww where selection happened
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /**
     * Creates a coffee object based off the current options that are selected and adds it to the order.
     * @param view represented when user presses the place order button
     */
    public void placeOrder(View view) {
        Coffee newCoffee = makeCoffee();
        newCoffee.itemPrice();
        if(MainActivity.theCurrentOrder.add(newCoffee) == true) {
            Toast.makeText(getApplicationContext(), "Order Added: " + newCoffee.toString(), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }

}
