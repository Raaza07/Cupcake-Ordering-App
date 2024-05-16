package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewOrderActivity extends AppCompatActivity {


    private ArrayList<OrderModel> OrderModelArrayList;
    private DBHandler dbHandler;
    private com.example.myapplication50.OrderRvAdapter OrderRvAdapter;
    private RecyclerView OrderRV;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        // initializing our all variables.
        OrderModelArrayList = new ArrayList<OrderModel>();
        dbHandler = new DBHandler(ViewOrderActivity.this);

        // getting our course array
        // list from db handler class.
        OrderModelArrayList = dbHandler.readOrder();

        // on below line passing our array list to our adapter class.
        OrderRvAdapter = new OrderRvAdapter(OrderModelArrayList, ViewOrderActivity.this);
        OrderRV = findViewById(R.id.idRVOrder );

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewOrderActivity.this, RecyclerView.VERTICAL, false);
        OrderRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        OrderRV.setAdapter(OrderRvAdapter);

    }
}