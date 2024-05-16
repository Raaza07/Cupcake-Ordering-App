package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateOrderActivity extends AppCompatActivity {

    private Button updateOrderBtn, deleteOrderBtn;
    private DBHandler dbHandler;

    private EditText  update_order_user_id, update_order_pro_id, update_order_pro_qty;

    String Original_User_id, Original_product_id, Original_product_qty;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_order);


        update_order_user_id=findViewById(R.id.Update_UId);
        update_order_pro_id=findViewById(R.id.Update_PID);
        update_order_pro_qty=findViewById(R.id.Update_PQTY);
        updateOrderBtn=findViewById(R.id.idBtnUpdactOrder);
        deleteOrderBtn=findViewById(R.id.idBtnDeleteOrder);

        // on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateOrderActivity.this);


        // on below lines we are getting data which
        // we passed in our adapter class.
        Original_User_id = getIntent().getStringExtra("User_Id");
        Original_product_id = getIntent().getStringExtra("product_id");
        Original_product_qty = getIntent().getStringExtra("product_qty");


        // setting data to edit text
        // of our update activity.
        update_order_user_id.setText(Original_User_id);
        update_order_pro_id.setText(Original_product_id);
        update_order_pro_qty.setText(Original_product_qty);


        updateOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update Order
                // method and passing all our edit text values.
                dbHandler.updateOrder(Original_User_id,update_order_user_id.getText().toString(), update_order_pro_id.getText().toString(), update_order_pro_qty.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateOrderActivity.this, "Order Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateOrderActivity.this, User_Activity.class);
                startActivity(i);
            }
        });


        // adding on click listener for delete button to delete our Order.
        deleteOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our Product.
                dbHandler.deleteOrder(Original_User_id);

                Toast.makeText(UpdateOrderActivity.this, "Deleted the Order", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateOrderActivity.this, User_Activity.class);
                startActivity(i);
            }
        });

    }


}