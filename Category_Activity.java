package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Category_Activity extends AppCompatActivity {

    EditText EditTextCategoryId,EditTextCategoryname;
    Button ButtonRegisterNewCategory;
    private DBHandler dbHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        EditTextCategoryId=(EditText)findViewById(R.id.CategoryId);
        EditTextCategoryname=(EditText)findViewById(R.id.CategoryName);
        ButtonRegisterNewCategory=(Button)findViewById(R.id.RegisterNewCategory);

        dbHandler = new DBHandler(Category_Activity.this);

        ButtonRegisterNewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String id = EditTextCategoryId.getText().toString();
                String name = EditTextCategoryname.getText().toString();

                dbHandler.addnewcat(id,name);

                Toast.makeText(Category_Activity.this, "CATEGORY has been added.", Toast.LENGTH_SHORT).show();



            }
        });

    }
}