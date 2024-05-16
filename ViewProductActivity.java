package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewProductActivity extends AppCompatActivity {

    private ArrayList<ProductModel> productModelArrayList;
    private DBHandler dbHandler;
    private ProductRvAdapter ProductRvAdapter;
    private RecyclerView ProductRV;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);

        // initializing our all variables.
        productModelArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewProductActivity.this);

        // getting our course array
        // list from db handler class.
        productModelArrayList = dbHandler.readProduct();

        // on below line passing our array list to our adapter class.
        ProductRvAdapter = new ProductRvAdapter(productModelArrayList, ViewProductActivity.this);
        ProductRV = findViewById(R.id.idRVProduct);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewProductActivity.this, RecyclerView.VERTICAL, false);
        ProductRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        ProductRV.setAdapter(ProductRvAdapter);



    }
}