package com.example.belajarkomponen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class PemilihanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemilihan);

        Button btnMenghitung = findViewById(R.id.btnMenghitung);
        Button btnKonversi = findViewById(R.id.btnKonversi);

        btnMenghitung.setOnClickListener(view -> {
            Intent intent = new Intent(PemilihanActivity.this,BeratBadanIdealActivity.class);
            startActivity(intent);
        });

        btnKonversi.setOnClickListener(view -> {
            Intent intent = new Intent(PemilihanActivity.this,KonversiSuhuActicity.class);
            startActivity(intent);
        });
    }
}