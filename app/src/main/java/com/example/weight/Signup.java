package com.example.weight;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Signup extends AppCompatActivity {
    EditText e1,e2,e3;
    Button buttonsignup;

    TextView t1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        t1 = findViewById(R.id.t1);
        buttonsignup = findViewById(R.id.buttonsignup);
        DBHelper dbHelper = new DBHelper(this);


        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user  = e1.getText().toString().trim();
                String pass = e2.getText().toString().trim();
                String repass = e3.getText().toString().trim();
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(buttonsignup.getWindowToken(), 0);


                if(user.equals("") || pass.equals("") || repass.equals(""))
                {
                    Toast.makeText(Signup.this, "Please fill up the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(repass))
                    {
                        Boolean checkuser = dbHelper.checkusername(user);
                        if(checkuser==false)
                        {
                            Boolean insert = dbHelper.insertData(user,pass);
                            if(insert==true)
                            {
                                Toast.makeText(Signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(),login.class);
                                startActivity(i);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(Signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Signup.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(Signup.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
            }
        });



    }
}