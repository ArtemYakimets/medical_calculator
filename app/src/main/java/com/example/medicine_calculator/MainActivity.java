package com.example.medicine_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton bt_IMT;
    private ImageButton bt_KA;
    private ImageButton bt_Rastvor;
    private ImageButton bt_Kurenie;
    private ImageButton bt_Stela;
    private ImageButton bt_Voda;
    private ImageButton bt_kal;
    private ImageButton bt_dav;
    private Button bt_info;
    private final String kek =  "kek";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_IMT=(ImageButton)findViewById(R.id.IMT);
        bt_KA=(ImageButton)findViewById(R.id.KA);
        bt_Rastvor=(ImageButton)findViewById(R.id.Rastvor);
        bt_Kurenie=(ImageButton)findViewById(R.id.Kurenie);
        bt_Stela=(ImageButton)findViewById(R.id.Stela);
        bt_Voda=(ImageButton)findViewById(R.id.Voda);
        bt_kal=(ImageButton)findViewById(R.id.kal);
        bt_dav=(ImageButton)findViewById(R.id.dav);
        bt_info=(Button)findViewById(R.id.info);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.IMT:
                        Intent intent = new Intent(MainActivity.this, IMT.class);
                        startActivity(intent);
                        break;
                    case R.id.KA:
                        Intent intent2 = new Intent(MainActivity.this, KA.class);
                        startActivity(intent2);
                        break;
                    case R.id.Rastvor:
                        Intent intent3 = new Intent(MainActivity.this, rasstvor.class);
                        startActivity(intent3);
                        break;
                    case R.id.Kurenie:
                        Intent intent4 = new Intent(MainActivity.this, kurenie.class);
                        startActivity(intent4);
                        break;
                    case R.id.Stela:
                        Intent intent5 = new Intent(MainActivity.this, stela.class);
                        startActivity(intent5);
                        break;
                    case R.id.Voda:
                        Intent intent6 = new Intent(MainActivity.this, voda.class);
                        startActivity(intent6);
                        break;
                    case R.id.kal:
                        Intent intent7 = new Intent(MainActivity.this, kal.class);
                        startActivity(intent7);
                        break;
                    case R.id.dav:
                        Intent intent8 = new Intent(MainActivity.this, dav.class);
                        startActivity(intent8);
                        break;
                    case R.id.info:
                        Intent intent9 = new Intent(MainActivity.this, info.class);
                        startActivity(intent9);
                        break;
                }
            }
        };
        bt_IMT.setOnClickListener(listener);
        bt_KA.setOnClickListener(listener);
        bt_Rastvor.setOnClickListener(listener);
        bt_Kurenie.setOnClickListener(listener);
        bt_Stela.setOnClickListener(listener);
        bt_Voda.setOnClickListener(listener);
        bt_kal.setOnClickListener(listener);
        bt_dav.setOnClickListener(listener);
        bt_info.setOnClickListener(listener);
    }

}