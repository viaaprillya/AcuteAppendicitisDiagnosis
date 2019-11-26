package com.example.ucan.acuteappendicitisdiagnosis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DiagnosaDokter extends AppCompatActivity {

    Button nextDiagnosaBtn;
    private RadioGroup diagnosaDokterRg;
    private RadioButton rbDiagnosa ,yaAppendisitisAkut, tidakAppendisitisAkut;
    private int sesak, panas, bab, nafsuMakan, muntah, mual, nyeriTekan, skalaNyeri, nyeriPerut, leukosit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa_dokter);
        sesak = getIntent().getExtras().getInt("sesak");
        panas = getIntent().getExtras().getInt("panas");
        bab = getIntent().getExtras().getInt("Gangguan BAB");
        nafsuMakan = getIntent().getExtras().getInt("nafsu makan");
        muntah = getIntent().getExtras().getInt("muntah");
        mual = getIntent().getExtras().getInt("mual");
        nyeriTekan = getIntent().getExtras().getInt("nyeri tekan");
        skalaNyeri = getIntent().getExtras().getInt("skala nyeri");
        nyeriPerut = getIntent().getExtras().getInt("nyeri perut");
        leukosit = getIntent().getExtras().getInt("leukosit");
        diagnosaDokterRg = (RadioGroup)findViewById(R.id.diagnosaDokterRg);
        nextDiagnosaBtn = (Button)findViewById(R.id.nextDiagnosaBtn);
        nextDiagnosaBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = diagnosaDokterRg.getCheckedRadioButtonId();
                rbDiagnosa = (RadioButton)findViewById(selectedId);
                yaAppendisitisAkut = (RadioButton)findViewById(R.id.yaAppendisitisAkut);
                yaAppendisitisAkut.setId(1);
                tidakAppendisitisAkut = (RadioButton)findViewById(R.id.tidakAppendisitisAkut);
                tidakAppendisitisAkut.setId(0);
                Intent il = new Intent(getApplicationContext(), HasilActivity.class);
                il.putExtra("sesak", sesak);
                il.putExtra("panas", panas);
                il.putExtra("Gangguan BAB", bab);
                il.putExtra("nafsu makan", nafsuMakan);
                il.putExtra("muntah", muntah);
                il.putExtra("mual", mual);
                il.putExtra("nyeri tekan", nyeriTekan);
                il.putExtra("skala nyeri", skalaNyeri);
                il.putExtra("nyeri perut", nyeriPerut);
                il.putExtra("leukosit", leukosit);
                il.putExtra("diagnosaDokter", Integer.valueOf(rbDiagnosa.getId()));
                Log.d("hasil diagnosaDokter",String.valueOf(rbDiagnosa.getId()));
                Log.d("hasil leukosit",String.valueOf(leukosit));
                Log.d("hasil sesak",String.valueOf(sesak));
                Log.d("hasil panas",String.valueOf(panas));
                Log.d("hasil BAB",String.valueOf(bab));
                Log.d("hasil nafsu makan",String.valueOf(nafsuMakan));
                Log.d("hasil muntah",String.valueOf(muntah));
                Log.d("hasil mual",String.valueOf(mual));
                Log.d("hasil nyeri tekan", String.valueOf(nyeriTekan));
                Log.d("hasil skala", String.valueOf(skalaNyeri));
                Log.d("hasil nyeri perut",String.valueOf(nyeriPerut));
                startActivity(il);
            }
        });
    }
}
