package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Admin_Pro_Search extends AppCompatActivity {

    EditText EditTextProductId,EditProductName,EditTextPrice,EditTextCategory,EditTextQuantity;

    Button ButtonSearchProduct;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pro_search);

        EditTextProductId=(EditText) findViewById(R.id.txt_I_ProductId);
        EditProductName=(EditText) findViewById(R.id.txt_I_ProductName);
        EditTextPrice=(EditText) findViewById(R.id.txt_I_Price);
        EditTextQuantity=(EditText) findViewById(R.id.txt_I_Qty);
        EditTextCategory=(EditText) findViewById(R.id.txt_I_Category);
        ButtonSearchProduct=(Button) findViewById(R.id.btn_I_SearchProduct);


        dbHandler = new DBHandler(Admin_Pro_Search.this);

        ButtonSearchProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pid=EditTextProductId.getText().toString();
                ArrayList<ProductClass> productList = dbHandler.SearchProduct(pid);
                if (productList.size()!=0)
                {
                    ProductClass product =productList.get(0);
                    EditProductName.setText(product.getProductName());
                    EditTextPrice.setText((String.valueOf(product.getPrice())));
                    EditTextQuantity.setText((String.valueOf(product.getQuantity())));
                    EditTextCategory.setText(product.getCategoryId());
                    Toast.makeText(getApplicationContext(), "Product found", Toast.LENGTH_LONG).show();


                }
                else {
                    Toast.makeText(getApplicationContext(), "no Product found", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}