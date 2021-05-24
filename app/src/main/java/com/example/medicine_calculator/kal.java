package com.example.medicine_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class kal extends AppCompatActivity {

    Button bt;
    TextView txt;
    double w;
    double h;
    double ye;
    double x;
    EditText wText;
    EditText hText;
    EditText yeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kal);

        wText = (EditText) findViewById(R.id.w);
        yeText = (EditText) findViewById(R.id.ye);
        hText = (EditText) findViewById(R.id.h);
        bt = (Button) findViewById(R.id.go7);
        txt = (TextView) findViewById(R.id.result7);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KalThread kalThread = new KalThread();
                kalThread.start();
            }
        }; bt.setOnClickListener(listener);
    }
    private class KalThread extends Thread {
        @Override
        public void run() {
            if (wText.getText().toString().trim().length() == 0) {
                w = 0;
            } else {
                w = Double.parseDouble(wText.getText().toString());
            }
            if (yeText.getText().toString().trim().length() == 0) {
                ye = 0;
            } else {
                ye = Double.parseDouble(yeText.getText().toString());
            }
            if (hText.getText().toString().trim().length() == 0) {
                h = 0;
            } else {
                h = Double.parseDouble(hText.getText().toString());
            }
            if (h == 0 || ye == 0 || w == 0) {
                TextView result = (TextView) findViewById(R.id.result7);
                result.setText("Не может быть введен 0!");
            } else {
                x = (10*w)+(6.25*h)-(5*ye);
                x *= 100;
                int okr = (int)Math.round(x);
                float res = (float)okr/100;

                TextView result = (TextView) findViewById(R.id.result7);
                result.setText(String.valueOf(res) + "калорий");
            }
            if (h == 0 || ye == 0 || w == 0) {
                TextView result = (TextView) findViewById(R.id.result7);
                result.setText("Не может быть введен 0!");
            } else {
                x = (10*w)+(6.25*h)-(5*ye);
                x *= 100;
                int okr = (int)Math.round(x);
                float res = (float)okr/100;

                TextView result = (TextView) findViewById(R.id.result7);
                result.setText(String.valueOf(res) + "калорий");
            }
        }
    }
}