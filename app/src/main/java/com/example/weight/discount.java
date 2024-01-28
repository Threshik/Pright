package com.example.weight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;

public class discount extends AppCompatActivity {
    Button cal;
    TextInputEditText  e1,e2;
    TextView t1, t2;
    CardView cardView;
    ImageView back3;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        cal = findViewById(R.id.cal2);
        e1 = findViewById(R.id.ed1);
        e2 = findViewById(R.id.ed2);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        cardView = findViewById(R.id.cardv);
        back3 = findViewById(R.id.back3);


        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(discount.this,MainActivity.class);
                startActivity(i2);
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cp = e1.getText().toString().trim();
                String discount = e2.getText().toString().trim();
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(cal.getWindowToken(), 0);

                if (cp.isEmpty()) {
                    Toast.makeText(discount.this, "Please fill fp the value", Toast.LENGTH_SHORT).show();
                } else if (discount.isEmpty()) {
                    Toast.makeText(discount.this, "Please fill up the value", Toast.LENGTH_SHORT).show();
                } else {
                    cardView.setVisibility(View.VISIBLE);
                    int w1 = Integer.parseInt(cp);
                    int w2 = Integer.parseInt(discount);
                    double w4=100;
                    double w3 = (w1-(w1*(w2/w4)));
                    /*int result2 = (int) w1*result1;
                    int result3 = (int) w1-result2;*/
                    NumberFormat nm = NumberFormat.getNumberInstance();
                    String finalresult = nm.format(w3);
                    /*String finalresult =Double.valueOf(w3).toString();*/
                    t1.setText(finalresult);

                    double w5 = w1-w3;
                    NumberFormat nm1 = NumberFormat.getNumberInstance();
                    String finalresult1 = nm1.format(w5);
                    /*String finalresult1 =  new Double(w5).toString();*/
                    t2.setText(finalresult1);


                }
            }
        });

    }
}