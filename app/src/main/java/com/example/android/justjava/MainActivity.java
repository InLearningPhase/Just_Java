package com.example.android.justjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    public int quantity = 0;
    public int totalPrice = 0;
    public int pricePerCup = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int calculatePrice() {
        totalPrice = quantity * pricePerCup;
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

    public boolean checkButton(){
        CheckBox hasWhippedCream = (CheckBox) findViewById(R.id.checkbox_view);
        return hasWhippedCream.isChecked();
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        boolean hasWhippedCream = checkButton();
        if (hasWhippedCream) { pricePerCup = 10; }
        else { pricePerCup = 5; }
        int price = calculatePrice();
        displayMessage(createOrderSummary(price, hasWhippedCream));

    }

    private String createOrderSummary(int price, boolean hasWhippedCream) {
        String message = "Name:Spoider mon";
        message = message + "\nAdd Whipped Cream: " + hasWhippedCream;
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
