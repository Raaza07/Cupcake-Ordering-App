package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Vector;

public class Admin_Activity extends AppCompatActivity {

    private EditText product_id,product_name,product_parice,product_qty;
    private Spinner product_spinner;
    private Button add_product,move_cat,view_product,p_search,Btn_view_order,Serach_order;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        product_id=findViewById(R.id.Product_id);
        product_name=findViewById(R.id.Product_Name);
        product_parice=findViewById(R.id.Product_Price);
        product_qty=findViewById(R.id.Product_Qty);
        product_spinner=findViewById(R.id.Product_Spinner);
        add_product=findViewById(R.id.Product_Add_Button);
        move_cat=findViewById(R.id.Category_move);
        view_product=findViewById(R.id.all_products);
        p_search=findViewById(R.id.search_product_btn);
        Btn_view_order=findViewById(R.id.Btn_view_order);
        Btn_view_order=findViewById(R.id.Btn_view_order);
        Serach_order=findViewById(R.id.Btn_Search_order);


        dbHandler = new DBHandler(Admin_Activity.this);

        Vector<String> vecCategory=dbHandler.getCategory_Name();

        ArrayAdapter ad=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,vecCategory);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        product_spinner.setAdapter(ad);



        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String p_id = product_id.getText().toString();
                String p_name = product_name.getText().toString();
                String p_parice = product_parice.getText().toString();
                String p_qty = product_qty.getText().toString();
                String CategoryId=dbHandler.getCategory_Id(product_spinner.getSelectedItem().toString());


                // validating if the text fields are empty or not.
                if (p_id.isEmpty() && p_name.isEmpty() && p_parice.isEmpty() && p_qty.isEmpty()) {
                    Toast.makeText(Admin_Activity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.

               dbHandler.addNewProduct(p_id,p_name,p_parice,p_qty,CategoryId);

                // after adding the data we are displaying a toast message.
                Toast.makeText(Admin_Activity.this, "Product has been added.", Toast.LENGTH_SHORT).show();

                product_id.setText("");
                product_name.setText("");
                product_parice.setText("");
                product_qty.setText("");






            }
        });

        move_cat.setOnClickListener(new View.OnClickListener() {
         @Override
          public void onClick(View v) {

             Intent intent = new Intent(Admin_Activity.this,Category_Activity.class);
             startActivity(intent);

          }
         });

        view_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Activity.this,ViewProductActivity.class);
                startActivity(intent);
            }
        });
        p_search.setOnClickListener(new View.OnClickListener() {
           @Override
        public void onClick(View v) {
               Intent intent = new Intent(Admin_Activity.this,Admin_Pro_Search.class);
               startActivity(intent);
        }
        });

        Btn_view_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Activity.this,ViewOrderActivity.class);
                startActivity(intent);
            }
        });


        Serach_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Activity.this,AdminOrder_Search.class);
                startActivity(intent);
            }
        });
    }
}