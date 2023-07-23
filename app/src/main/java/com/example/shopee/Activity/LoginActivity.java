package com.example.shopee.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.shopee.R;
import com.google.firebase.ktx.Firebase;

public class LoginActivity extends AppCompatActivity {
    EditText edtTentk,edtPass;
    AppCompatButton btnDN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnDN = findViewById(R.id.nutDn);
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TrangChuActivity.class);
                startActivity(i);
            }
        });
    }
}