package com.example.weight;

import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class rate extends AppCompatActivity {
  TextInputEditText e1,e2;
  Button cal1;
  TextView t1,t3;
  Spinner sp2;
  String[] scale;
  String select;
  LinearLayout l1,l2;

  CardView cardView;

  ImageView back2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        e1 = findViewById(R.id.ed1);
        e2 = findViewById(R.id.ed2);
        t1 = findViewById(R.id.t1);
        t3 = findViewById(R.id.t3);
        cal1 = findViewById(R.id.cal);
        sp2 = findViewById(R.id.sp2);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        cardView = findViewById(R.id.card_visible);
        back2 = findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(rate.this,MainActivity.class);
                startActivity(i);
            }
        });

        scale = getResources().getStringArray(R.array.Weight);
        ArrayAdapter arrayAdapter = new ArrayAdapter(rate.this,android.R.layout.simple_spinner_item,scale);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(arrayAdapter);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select = sp2.getSelectedItem().toString();
                Toast.makeText(rate.this, "You selected "+ select, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fw = e1.getText().toString().trim();
                String uw = e2.getText().toString().trim();
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(cal1.getWindowToken(), 0);

                if (fw.isEmpty()) {
                    Toast.makeText(rate.this, "Please fill fp the value", Toast.LENGTH_SHORT).show();
                } else if (uw.isEmpty()) {
                    Toast.makeText(rate.this, "Please fill up the value", Toast.LENGTH_SHORT).show();
                } else {
                    int w1 = Integer.parseInt(fw);
                    int w2 = Integer.parseInt(uw);
                    if(select.equals("G"))
                    {
                        cardView.setVisibility(View.VISIBLE);
                        l2.setVisibility(View.GONE);
                        l1.setVisibility(View.VISIBLE);
                        double w4 = w1*w2;
                        double result2 = (double) w4/1000;
                        String finalresult = new Double(result2).toString();
                        t1.setText(finalresult);

                    } else if (select.equals("KG")) {
                        cardView.setVisibility(View.VISIBLE);
                        l2.setVisibility(View.VISIBLE);
                        l1.setVisibility(View.GONE);
                        double w3 = w2*1000;
                        double result1 = (double) ((w3*w1)/1000);
                        String finalresult = new Double(result1).toString();
                        t3.setText(finalresult);

                    }

                }
            }
        });



    }
}