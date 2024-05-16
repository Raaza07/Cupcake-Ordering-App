package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateProductActivity extends AppCompatActivity {


    private Button updateProductBtn, deleteProductBtn;
    private DBHandler dbHandler;

    private EditText  update_pro_id, update_pro_name, update_pro_price, update_pro_qty,update_pro_cat_id;

    String Original_product_id, Original_product_Name, Original_product_Price, Original_product_Qty,Original_product_Cat_Id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        update_pro_id=findViewById(R.id.Update_Pro_Id);
        update_pro_name=findViewById(R.id.Update_Pro_Name);
        update_pro_price=findViewById(R.id.Update_Pro_price);
        update_pro_qty=findViewById(R.id.Update_Pro_Qty);
        update_pro_cat_id=findViewById(R.id.Update_Pro_Cat_Id);
        updateProductBtn=findViewById(R.id.idBtnUpdatProduct);
        deleteProductBtn=findViewById(R.id.idBtnDelete);


        // on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateProductActivity.this);


        // on below lines we are getting data which
        // we passed in our adapter class.
        Original_product_id = getIntent().getStringExtra("P_Id");
        Original_product_Name = getIntent().getStringExtra("P_Name");
        Original_product_Price = getIntent().getStringExtra("P_Price");
        Original_product_Qty = getIntent().getStringExtra("P_Qty");
        Original_product_Cat_Id = getIntent().getStringExtra("P_Cat_Name");

        // setting data to edit text
        // of our update activity.
        update_pro_id.setText(Original_product_id);
        update_pro_name.setText(Original_product_Name);
        update_pro_price.setText(Original_product_Price);
        update_pro_qty.setText(Original_product_Qty);
        update_pro_cat_id.setText(Original_product_Cat_Id);


        updateProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update order
                // method and passing all our edit text values.
                dbHandler.updateProduct(Original_product_id,update_pro_id.getText().toString(), update_pro_name.getText().toString(), update_pro_price.getText().toString(), update_pro_qty.getText().toString(), update_pro_cat_id.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateProductActivity.this, "Product Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateProductActivity.this, Admin_Activity.class);
                startActivity(i);
            }
        });


        // adding on click listener for delete button to delete our Product.
        deleteProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our Product.
                dbHandler.deleteProduct(Original_product_id);

                Toast.makeText(UpdateProductActivity.this, "Deleted the Product", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateProductActivity.this, Admin_Activity.class);
                startActivity(i);
            }
        });



    }
}