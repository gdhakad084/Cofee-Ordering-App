package com.android.example.javaapp;

import android.util.*;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 0;
    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {

        quantity = quantity + 1;
        display(quantity);

    }
    private int pricereturn(){
        int price = 10;
        return quantity*price;

    }
    public void decrement(View view) {

        quantity = quantity - 1 ;
        display(quantity);
          }
    boolean has;
    public void getid(View view){
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        has = whippedCreamCheckBox.isChecked();
    }
    boolean has1;
    public void getid1(View view){
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_choclate_checkbox);
        has1 = whippedCreamCheckBox.isChecked();
    }
    public void submitOrder(View view) {

        EditText nameEnter = (EditText) findViewById(R.id.name_field);
        String name = nameEnter.getText().toString();
        String message = createOrderSummary(has,has1,name) ;
        display(quantity);
        //displayPrice(quantity * 5);
     displayMessage(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
  private String createOrderSummary(boolean addwhipped,boolean xyz,String name1){

      String name2 = name1;
      int total = pricereturn();
      if (addwhipped){
         total = total +1*quantity;
      }
      if (xyz){

         total = total +2*quantity ;
      }
      String message = "Name : "+name2 +"\n\n" +"Quantity : " +quantity+"\n\n"+ "Total Amount : " + total + "\n\n"+" whipped cream : "+addwhipped+"\n\n chocalate : "+xyz+"\n" +
              "\nThank You "+name2;
      return message;
  }

    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }
    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);

    }
}