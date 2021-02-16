package com.example.belajarkomponen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class KonversiSuhuActicity extends AppCompatActivity {


    private Spinner spinAsal, spinTujuan;
    private TextView edtIntupan, txtKonversi;
    private Button btnHitungKonversi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi_suhu_acticity);

        spinAsal = findViewById(R.id.spinAsal);
        spinTujuan = findViewById(R.id.spinTujuan);

        txtKonversi = findViewById(R.id.txtKonversi);

        edtIntupan = findViewById(R.id.edtInputan);


        btnHitungKonversi = findViewById(R.id.btnHk);

        List<String> asal = new ArrayList<>();
        asal.add("Fahrenheit");
        asal.add("Celcius");
        asal.add("Kelvin");

        List<String> tujuan = new ArrayList<>();
        tujuan.add("Fahrenheit");
        tujuan.add("Celcius");
        tujuan.add("Kelvin");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,asal);
        spinAsal.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,tujuan);
        spinTujuan.setAdapter(adapter1);

        btnHitungKonversi.setOnClickListener(view -> {

            Float inpSuhu = Float.parseFloat(edtIntupan.getText().toString());
            double hasilSuhu = 0;
            String asalSuhu = spinAsal.getSelectedItem().toString();
            String tujuanSuhu = spinTujuan.getSelectedItem().toString();
            if (asalSuhu == tujuanSuhu)
            {hasilSuhu = inpSuhu;}
            else if (asalSuhu == "Fahrenheit" && tujuanSuhu == "Celcius")
            {hasilSuhu = (inpSuhu - 32) / (1.8);}
            else if (asalSuhu == "Fahrenheit" && tujuanSuhu == "Kelvin")
            {hasilSuhu = (inpSuhu - 32) * 5 / 9 + 273.15;}
            else if (asalSuhu == "Celcius" && tujuanSuhu == "Fahrenheit")
            {hasilSuhu = (inpSuhu * 1.8) + 32;}
            else if (asalSuhu == "Celcius" && tujuanSuhu == "Kelvin")
            {hasilSuhu = inpSuhu + 273.15;}
            else if (asalSuhu == "Kelvin" && tujuanSuhu == "Fahrenheit")
            {hasilSuhu = (inpSuhu - 273.15) * 9 / 5 + 32;}
            else if (asalSuhu == "Kelvin" && tujuanSuhu == "Celcius")
            {hasilSuhu = inpSuhu - 273.15;}

            txtKonversi.setText(String.valueOf(hasilSuhu));
            txtKonversi.setEnabled(false);
        });
    }
}