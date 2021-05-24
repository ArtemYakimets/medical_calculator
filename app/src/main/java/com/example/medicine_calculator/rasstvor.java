package com.example.medicine_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class rasstvor extends AppCompatActivity {

    double kol1;
    double kol2;
    double per1;
    double per2;
    EditText kol1Text;
    EditText kol2Text;
    EditText per1Text;
    EditText per2Text;
    Button bt;
    TextView txt;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasstvor);

        kol1Text = (EditText) findViewById(R.id.kol1);
        per1Text = (EditText) findViewById(R.id.per1);
        per2Text = (EditText) findViewById(R.id.per2);
        bt = (Button) findViewById(R.id.go3);
        txt = (TextView) findViewById(R.id.result2);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RastvorThread rastvorThread = new RastvorThread();
                rastvorThread.start();
            }
        }; bt.setOnClickListener(listener);
    }
    private class RastvorThread extends Thread {
        @Override
        public void run() {
            if (kol1Text.getText().toString().trim().length() == 0) {
                kol1 = 0;
            } else {
                kol1 = Double.parseDouble(kol1Text.getText().toString());
            }
            if (per1Text.getText().toString().trim().length() == 0) {
                per1 = 0;
            } else {
                per1 = Double.parseDouble(per1Text.getText().toString());
            }
            if (per2Text.getText().toString().trim().length() == 0) {
                per2 = 0;
            } else {
                per2 = Double.parseDouble(per2Text.getText().toString());
            }
            if (kol1 == 0 || per1 == 0 || per2 == 0) {
                TextView result = (TextView) findViewById(R.id.result2);
                result.setText("Не может быть введен 0!");
            } else {
                double kol2 = (kol1 * per2) / per1;
                double i = kol1 - kol2;
                i *= 100;
                int okr = (int)Math.round(i);
                float res = (float) okr/100;

                TextView result = (TextView) findViewById(R.id.result2);
                result.setText(String.valueOf(res) + "мг");
            }
        }
    }
}