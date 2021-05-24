package com.example.medicine_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class stela extends AppCompatActivity {

    double ves2;
    double rost2;
    double s;
    EditText ves2Text;
    EditText rost2Text;
    Button bt;
    TextView txt;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stela);

        rost2Text = (EditText) findViewById(R.id.rost2);
        ves2Text = (EditText) findViewById(R.id.ves2);
        bt = (Button) findViewById(R.id.go5);
        txt = (TextView) findViewById(R.id.result5);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StelaThread stelaThread = new StelaThread();
                stelaThread.start();
            }
        }; bt.setOnClickListener(listener);
    }
    private class StelaThread extends Thread {
        @Override
        public void run() {
            if (rost2Text.getText().toString().trim().length() == 0) {
                rost2 = 0;
            } else {
                rost2 = Double.parseDouble(rost2Text.getText().toString());
            }
            if (ves2Text.getText().toString().trim().length() == 0) {
                ves2 = 0;
            } else {
                ves2 = Double.parseDouble(ves2Text.getText().toString());
            }
            if (rost2 == 0 || ves2 == 0) {
                TextView result = (TextView) findViewById(R.id.result5);
                result.setText("Не может быть введен 0!");
            } else {
                s = Math.sqrt(ves2 * (rost2/3600));
                s *= 100;
                int okr = (int)Math.round(s);
                float res = (float) okr/100;

                TextView result = (TextView) findViewById(R.id.result5);
                result.setText(String.valueOf(res) + " ");
            }
        }
    }
}
