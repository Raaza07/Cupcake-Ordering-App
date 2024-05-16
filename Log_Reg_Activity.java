package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Log_Reg_Activity extends AppCompatActivity {

    private EditText username,password;
    private Button btn_login,btn_create_account;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg);


username=findViewById(R.id.UserId);
password=findViewById(R.id.UserPassword);
btn_login=findViewById(R.id.btn_login);
btn_create_account=findViewById(R.id.btn_new_account);

dbHandler = new DBHandler(Log_Reg_Activity.this);


btn_create_account.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Log_Reg_Activity.this,Register_Activity.class);
        startActivity(intent);
    }
});






btn_login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        ArrayList<UserClass> userDetails =
                dbHandler.ValidLogin(username.getText().toString(),
                        password.getText().toString());

        if (userDetails.size() != 0) {
            UserClass user = userDetails.get(0);
            String UserType = user.getUserType();//Admin

            Toast.makeText(getApplicationContext(), "User found" +
                    UserType, Toast.LENGTH_LONG).show();

            if (UserType.equals("Admin")) {
                Intent intentRegister =
                        new Intent(Log_Reg_Activity.this, Admin_Activity.class);
                startActivity(intentRegister);
            } else {
                Intent intentRegister = new Intent(Log_Reg_Activity.this, User_Activity.class);
                startActivity(intentRegister);
            }
        }
        else

        {
            Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_LONG).show();
        }




    }
});







    }
}