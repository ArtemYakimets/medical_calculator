package com.example.medicine_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class dav extends AppCompatActivity {

    Button bt;
    TextView txt;
    double s;
    double d;
    double x;
    EditText sText;
    EditText dText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dav);

        dText = (EditText) findViewById(R.id.s);
        sText = (EditText) findViewById(R.id.s);
        bt = (Button) findViewById(R.id.go8);
        txt = (TextView) findViewById(R.id.result8);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DavThread davThread = new DavThread();
                davThread.start();
            }
        }; bt.setOnClickListener(listener);
    }
    private class DavThread extends Thread {
        @Override
        public void run() {
            if (sText.getText().toString().trim().length() == 0) {
                s = 0;
            } else {
                s = Double.parseDouble(sText.getText().toString());
            }
            if (dText.getText().toString().trim().length() == 0) {
                d = 0;
            } else {
                d = Double.parseDouble(dText.getText().toString());
            }
            if (d == 0 || s == 0) {
                TextView result = (TextView) findViewById(R.id.result8);
                result.setText("Не может быть введен 0!");
            } else {
                x = (0.3*s)+(0.6*d);
                x *= 100;
                int okr = (int)Math.round(x);
                float res = (float)okr/100;

                TextView result = (TextView) findViewById(R.id.result8);
                result.setText(String.valueOf(res) + " ");
            }
        }
    }
}