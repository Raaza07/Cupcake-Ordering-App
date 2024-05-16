package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User_Activity extends AppCompatActivity {

    EditText user_id,product_id,product_qty;
    Button btn_add_order,btn_view_order,btn_search_product,btn_View_Product;

    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        user_id=findViewById(R.id.Order_User_Id);
        product_id=findViewById(R.id.Order_Product_Id);
        product_qty=findViewById(R.id.Order_Product_Qty);
        btn_add_order=findViewById(R.id.Btn_Add_Order);
        btn_view_order=findViewById(R.id.Btn_View_Order);
        btn_search_product=findViewById(R.id.Btn_Search_Product);
        btn_View_Product=findViewById(R.id.btn_view_product);

        dbHandler = new DBHandler(User_Activity.this);

        btn_add_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u_id=user_id.getText().toString();
                String p_id=product_id.getText().toString();
                String p_qty=product_qty.getText().toString();

                // validating if the text fields are empty or not.
                if (u_id.isEmpty() && p_id.isEmpty() && p_qty.isEmpty()) {
                    Toast.makeText(User_Activity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.

                dbHandler.addNewOrder(u_id,p_id,p_qty);

                // after adding the data we are displaying a toast message.
                Toast.makeText(User_Activity.this, "Order has been added.", Toast.LENGTH_SHORT).show();

                user_id.setText("");
                product_id.setText("");
                product_qty.setText("");




            }
        });


        btn_view_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(User_Activity.this,ViewOrderActivity.class);
                startActivity(intent);
            }
        });

        btn_search_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(User_Activity.this,SearchProductActivity.class);
                startActivity(intent);
            }
        });

        btn_View_Product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(User_Activity.this,ViewProductActivity.class);
                startActivity(intent);
            }
        });



    }
}