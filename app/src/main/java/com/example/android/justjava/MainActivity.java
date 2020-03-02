package com.example.android.justjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    public int quantity = 0;
    public int totalPrice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {

        int pricePerCup = 5;

        if (hasWhippedCream) {
            pricePerCup += 1;
        }

        if (hasChocolate) {
            pricePerCup += 2;
        }

        totalPrice = pricePerCup * quantity;
        return totalPrice;
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    public boolean whippedCreamCheckBox(){
        CheckBox hasWhippedCream = (CheckBox) findViewById(R.id.whippedcream_checkbox);
        return hasWhippedCream.isChecked();
    }

    public boolean chocolateCheckBox() {
        CheckBox hasChocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        return hasChocolate.isChecked();
    }

    public String enterName() {
        EditText userInput = (EditText) findViewById(R.id.name_view);
        return userInput.getText().toString();
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String userName = enterName();
        boolean hasWhippedCream = whippedCreamCheckBox();
        boolean hasChocolate = chocolateCheckBox();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate, userName));

    }

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String userName) {
        String message = "Name: " + userName;
        message = message + "\nAdd Whipped Cream: " + hasWhippedCream;
        message = message + "\nAdd Chocolate: " + hasChocolate;
        message = message + "\nQuantity: " + quantity;
        message = message + "\nPrice: $" + price;
        message = message + "\nThank You!";
        return message;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}
