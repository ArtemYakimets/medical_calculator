package com.example.medicine_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class kurenie extends AppCompatActivity {

    double n;
    double y;
    double k;
    EditText nText;
    EditText yText;
    EditText kText;
    Button bt;
    TextView txt;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurenie);

        nText = (EditText) findViewById(R.id.n);
        yText = (EditText) findViewById(R.id.y);
        bt = (Button) findViewById(R.id.go4);
        txt = (TextView) findViewById(R.id.result4);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KurenieThread kurenieThread = new KurenieThread();
                kurenieThread.start();
            }
        }; bt.setOnClickListener(listener);
    }
    private class KurenieThread extends Thread {
        @Override
        public void run() {
            if (nText.getText().toString().trim().length() == 0) {
                n = 0;
            } else {
                n = Double.parseDouble(nText.getText().toString());
            }
            if (yText.getText().toString().trim().length() == 0) {
                y = 0;
            } else {
                y = Double.parseDouble(yText.getText().toString());
            }
            if (n == 0 || y == 0) {
                TextView result = (TextView) findViewById(R.id.result4);
                result.setText("Не может быть введен 0!");
            } else {
                k = (n * y)/20;
                k *= 100;
                int okr = (int)Math.round(k);
                float res = (float) okr/100;

                TextView result = (TextView) findViewById(R.id.result4);
                result.setText(String.valueOf(res) + " ");
            }
        }
    }
}