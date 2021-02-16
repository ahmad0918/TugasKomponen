package com.example.belajarkomponen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BeratBadanIdealActivity extends AppCompatActivity {
    private TextView edtBB, edtTinggi, txtHasil, txtStatus;
    private Button btnMenghitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat_badan_ideal);

        final Spinner spin = findViewById(R.id.spin);

        edtBB = findViewById(R.id.edtBB);
        edtTinggi = findViewById(R.id.edtTinggi);
        btnMenghitung = findViewById(R.id.btnMenghitung);
        txtHasil = findViewById(R.id.txtHasil);
        txtStatus = findViewById(R.id.txtStatus);

        List<String> DaftarSekolah = new ArrayList<>();
        DaftarSekolah.add("SDN BuahBatu 09 Bandung");
        DaftarSekolah.add("SMPN 18 Bandung");
        DaftarSekolah.add("SMK AL-FALAH NAGREG");

        ArrayAdapter<String> adapter = new ArrayAdapter<>( this, android.R.layout.simple_spinner_dropdown_item, DaftarSekolah);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        btnMenghitung.setOnClickListener(view -> {
            Float berat = Float.parseFloat(edtBB.getText().toString());
            Float tinggibadan = Float.parseFloat(edtTinggi.getText().toString());
            Float hasil;

            tinggibadan = tinggibadan / 100;
            hasil = berat / (tinggibadan*tinggibadan);
            String menghitung = "BMI    :" + hasil.toString();
            String status = "Status Berat Badan : ";
            if (hasil < 18.5)
            {status = status + "Kekurangan berat badan";}
            else if (hasil >= 18.5 && hasil < 24.9)
            {status = status + "Normal (ideal)";}
            else if (hasil >= 25 && hasil < 29.9)
            {status = status + "Kelebihan berat badan";}
            else if (hasil > 30)
            {status = status + "Kegemukan (Obesitas";}

            txtHasil.setText((menghitung));
            txtStatus.setText(status);
        });
    }
}