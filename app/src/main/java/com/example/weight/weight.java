package com.example.weight;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class weight extends AppCompatActivity {
    Button cal;
    ImageView back1;
    TextInputEditText e1, e2;
    TextView t1, t2;
    CardView cardView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        cal = findViewById(R.id.cal);
        e1 = findViewById(R.id.ed1);
        e2 = findViewById(R.id.ed2);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        cardView = findViewById(R.id.cardv);
        back1 = findViewById(R.id.back1);


        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fp = e1.getText().toString().trim();
                String up = e2.getText().toString().trim();

                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(cal.getWindowToken(), 0);

                if (fp.isEmpty()) {
                    Toast.makeText(weight.this, "Please fill up the value", Toast.LENGTH_SHORT).show();
                } else if (up.isEmpty()) {
                    Toast.makeText(weight.this, "Please fill up the value", Toast.LENGTH_SHORT).show();
                } else {
                    cardView.setVisibility(View.VISIBLE);
                    int w1 = Integer.parseInt(fp);
                    int w2 = Integer.parseInt(up);

                    double result2 = (double) w2 / w1;
                    result2 = result2 * 1000;
                    NumberFormat nm = NumberFormat.getNumberInstance();
                    String finalresult = nm.format(result2);
                    t1.setText(finalresult);

                    double result1 = (double) w2 / w1;
                    NumberFormat nm1 = NumberFormat.getNumberInstance();
                    String finalresult1 =  nm1.format(result1);
                    t2.setText(finalresult1);


                }
            }
        });
    }
}