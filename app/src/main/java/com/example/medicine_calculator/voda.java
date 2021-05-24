package com.example.medicine_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class voda extends AppCompatActivity {

    double ves3;
    double t;
    double i;
    EditText ves3Text;
    EditText tText;
    Button bt;
    TextView txt;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voda);

        tText = (EditText) findViewById(R.id.t);
        ves3Text = (EditText) findViewById(R.id.ves3);
        bt = (Button) findViewById(R.id.go6);
        txt = (TextView) findViewById(R.id.result6);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VodaThread vodaThread = new VodaThread();
                vodaThread.start();
            }
        }; bt.setOnClickListener(listener);
    }
    private class VodaThread extends Thread {
        @Override
        public void run() {
            if (tText.getText().toString().trim().length() == 0) {
                t = 0;
            } else {
                t = Double.parseDouble(tText.getText().toString());
            }
            if (ves3Text.getText().toString().trim().length() == 0) {
                ves3 = 0;
            } else {
                ves3 = Double.parseDouble(ves3Text.getText().toString());
            }
            if (t == 0 || ves3 == 0) {
                TextView result = (TextView) findViewById(R.id.result6);
                result.setText("Не может быть введен 0!");
            } else {
                i = (ves3 * 0.03) + (t * 0.5);
                i *= 100;
                int okr = (int)Math.round(i);
                float res = (float) okr/100;

                TextView result = (TextView) findViewById(R.id.result6);
                result.setText(String.valueOf(res) + "л");
            }
        }
    }
}