package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminOrder_Search extends AppCompatActivity {

    private EditText ordersearch_user_id,ordersearch_product_id,ordersearch_product_qty;
    private Button order_search;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order_search);


        ordersearch_product_id=findViewById(R.id.o_Product_id);
        ordersearch_user_id=findViewById(R.id.o_user_id);
        ordersearch_product_qty=findViewById(R.id.o_Qty);
        order_search=findViewById(R.id.btn_o_SearchOrder);

        dbHandler = new DBHandler(AdminOrder_Search.this);


        order_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Oid=ordersearch_product_id.getText().toString();

                ArrayList<Order> OrderList = dbHandler.SearchOrder(Oid);

                if (OrderList.size()!=0)
                {
                    Order order =OrderList.get(0);
                    ordersearch_user_id.setText(order.getOrderUserId());
                    ordersearch_product_qty.setText((String.valueOf(order.getOrderProduct_qty())));

                    Toast.makeText(getApplicationContext(), "order found", Toast.LENGTH_LONG).show();


                }
                else {
                    Toast.makeText(getApplicationContext(), "no Product found", Toast.LENGTH_LONG).show();
                }
            }

        });



    }
}