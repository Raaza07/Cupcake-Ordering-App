package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity {

    private EditText R_username,R_password,R_con_pass;
    private Spinner spinner;
    private Button Register;
    private DBHandler dbHandler ;
    String UserType[]={"Admin","User"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHandler=new DBHandler(Register_Activity.this);

        setContentView(R.layout.activity_register);
        R_username=findViewById(R.id.Reg_user_id);
        R_password=findViewById(R.id.Reg_user_password);
        R_con_pass=findViewById(R.id.Reg_user_con_pass);
        spinner=findViewById(R.id.spinner);
        Register=findViewById(R.id.Register);

        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_spinner_item,UserType);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(R_username.getText().toString().isEmpty()||
                        R_password.getText().toString().isEmpty()||
                        R_con_pass.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),
                            "Fields can't be blank",Toast.LENGTH_LONG).show();
                }
                else if (R_password.getText().toString().length()<3)
                {
                    Toast.makeText(getApplicationContext(),
                            "Password must have more than 3 characters",
                            Toast.LENGTH_LONG).show();

                }
                else if (!R_password.getText().toString().equals(R_con_pass.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),
                            "Password and confirm password should match",Toast.LENGTH_LONG).show();
                }
                else {

                    String userId=R_username.getText().toString();
                    String user_password=R_password.getText().toString();
                    String UserType = spinner.getSelectedItem().toString();

                    dbHandler.addNewUser(userId, user_password, UserType);

                    Toast.makeText(Register_Activity.this, "New User Created.", Toast.LENGTH_SHORT).show();

                    R_username.setText("");
                    R_password.setText("");
                    R_con_pass.setText("");


                }




            }
        });


    }
}