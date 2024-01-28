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

public class login extends AppCompatActivity {

    EditText eEmailAddress,editTextTextPassword2;
    Button buttonsignup;
    TextView t2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eEmailAddress = findViewById(R.id.eEmailAddress);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        t2 = findViewById(R.id.t2);
        buttonsignup = findViewById(R.id.buttonsignup);
        DBHelper dbHelper = new DBHelper(this);


        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = eEmailAddress.getText().toString().trim();
                String pass = editTextTextPassword2.getText().toString().trim();
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(buttonsignup.getWindowToken(), 0);
                if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(login.this, "Please fill up the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuserpass = dbHelper.checkusernamepassword(user,pass);
                    if(checkuserpass==true)
                    {
                        Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i2 = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i2);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, Signup.class);
                startActivity(intent);
                finish();
            }
        });


    }
}