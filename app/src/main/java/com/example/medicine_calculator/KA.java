package com.example.medicine_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class KA extends AppCompatActivity {
    Switch switchPol;
    boolean flag;
    Button bt;
    TextView txt;
    double r;
    double mn;
    double krep;
    double m;
    EditText mnText;
    EditText krepText;
    EditText mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k);

        mnText = (EditText) findViewById(R.id.mn);
        krepText = (EditText) findViewById(R.id.krep);
        mText = (EditText) findViewById(R.id.m);
        bt = (Button) findViewById(R.id.go2);
        txt = (TextView) findViewById(R.id.result3);
        switchPol = (Switch) findViewById(R.id.switch1);
        switchPol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flag = isChecked;

            }

        });
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KAThread kaThread = new KAThread();
                kaThread.start();
            }
        }; bt.setOnClickListener(listener);
    }
    private class KAThread extends Thread {
        @Override
        public void run() {
            if (mnText.getText().toString().trim().length() == 0) {
                mn = 0;
            } else {
                mn = Double.parseDouble(mnText.getText().toString());
            }
            if (krepText.getText().toString().trim().length() == 0) {
                krep = 0;
            } else {
                krep = Double.parseDouble(krepText.getText().toString());
            }
            if (mText.getText().toString().trim().length() == 0) {
                m = 0;
            } else {
                m = Double.parseDouble(mText.getText().toString());
                if (mn == 0 || krep == 0 || m == 0) {
                    TextView result = (TextView) findViewById(R.id.result3);
                    result.setText("Не может быть введен 0!");
                } else {
                    if (flag == true) {
                        r = 0.6;
                    } else {
                        r = 0.7;
                    }
                    double a = (mn / 1000) * krep * 0.789 * 10;
                    double c = a / (m * r);
                    c *= 100;
                    int okr = (int) Math.round(c);
                    float res = (float) okr / 100;
                    TextView result = (TextView) findViewById(R.id.result3);
                    result.setText(String.valueOf(res) + "‰");
                }
            }
        }
    }
}