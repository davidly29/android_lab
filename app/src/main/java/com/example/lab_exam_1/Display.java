package com.example.lab_exam_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends AppCompatActivity {
    TextView textViewEmail;
    TextView textViewFee;
    TextView textViewDebug;
    Button buttonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewFee = (TextView) findViewById(R.id.textViewFee);

        textViewDebug = (TextView) findViewById(R.id.textViewDebug);

        buttonPay = (Button) findViewById(R.id.buttonPay);

        Intent intent = getIntent();
        String email = "Email: " + intent.getStringExtra("Email");
        textViewEmail.setText(email);

        final String duration = intent.getStringExtra("Duration");
        int durationTime = Integer.parseInt(duration);
        double fee = 0;


        if (durationTime <= 5) {
            fee = durationTime * 100;
        }

        if (durationTime > 5) {
            fee = (durationTime * 100) * 0.8;
        }
        textViewFee.setText("Fee: " + Double.toString(fee));

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.start();
            }


        });
    }
        CountDownTimer count = new CountDownTimer(10000, 1000){
        @Override
        public void onTick(long millisUntilFinished) {
            textViewDebug.setText("Fees will be paid in: " + millisUntilFinished / 1000);
        }

        @Override
        public void onFinish() {
            Toast.makeText(Display.this, "Fees are Paid :) ", Toast.LENGTH_LONG).show();
        }
    };
}
