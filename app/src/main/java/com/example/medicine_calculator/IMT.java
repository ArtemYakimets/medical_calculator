package com.example.medicine_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IMT extends AppCompatActivity {

    private static final String LOG_TAG = "Main activity";
    Button bt;
    TextView txt;
    String s = "";
    double rost;
    double ves;
    double vozrast;
    EditText rostText;
    EditText vesText;
    EditText vozrastText;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_m_t);

        rostText = (EditText) findViewById(R.id.rost);
        vesText = (EditText) findViewById(R.id.ves);
        vozrastText = (EditText) findViewById(R.id.vozrast);
        bt = (Button) findViewById(R.id.go);
        txt = (TextView) findViewById(R.id.result);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMTThread imtThread = new IMTThread();
                imtThread.start();
            }
        }; bt.setOnClickListener(listener);
    }
    private class IMTThread extends Thread {
        @Override
        public void run() {
            Log.d(LOG_TAG, "Приступаю к расчёту");
            if (rostText.getText().toString().trim().length() == 0) {
                rost = 0;
                Log.d(LOG_TAG, "Принял переменную рост");
            }
            else {
                rost = Double.parseDouble(rostText.getText().toString());
                Log.d(LOG_TAG, "Принял переменную рост");
            }
            if (vesText.getText().toString().trim().length() == 0) {
                ves = 0;
                Log.d(LOG_TAG, "Принял переменную вес");
            }
            else {
                ves = Double.parseDouble(vesText.getText().toString());
                Log.d(LOG_TAG, "Принял переменную вес");
            }
            if (vozrastText.getText().toString().trim().length() == 0) {
                vozrast = 0;
                Log.d(LOG_TAG, "Принял переменную рост");
            }
            else {
                vozrast = Double.parseDouble(vozrastText.getText().toString());
                Log.d(LOG_TAG, "Принял переменную рост");
            }
            if (rost == 0 || ves == 0 || vozrast == 0) {
                TextView result = (TextView) findViewById(R.id.result);
                result.setText("Не может быть введен 0!");
            } else {
                double i = ves/((rost/100)*(rost/100));
                i *= 100;
                int okr = (int)Math.round(i);
                float res = (float) okr/100;
                Log.d(LOG_TAG, "Произвел вычисления");
                TextView result = (TextView) findViewById(R.id.result);
                result.setText(String.valueOf(res));
            }
            }
        }
    }