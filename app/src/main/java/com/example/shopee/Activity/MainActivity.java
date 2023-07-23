package com.example.shopee.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.shopee.R;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btnDN,btnDK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDN = findViewById(R.id.btn_dn);
        btnDK = findViewById(R.id.btn_dky);
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idn = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(idn);
            }
        });
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idk = new Intent(getApplicationContext(),DangKyActivity.class);
                startActivity(idk);
            }
        });
    }
}