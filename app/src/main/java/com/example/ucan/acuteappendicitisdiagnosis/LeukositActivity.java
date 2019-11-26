package com.example.ucan.acuteappendicitisdiagnosis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LeukositActivity extends AppCompatActivity {

    Button nextLeukositBtn;
    private RadioGroup leukositRg;
    private RadioButton leukositRb, normalRb, abnormalRb;
    private int sesak, panas, bab, nafsuMakan, muntah, mual, nyeriTekan, skalaNyeri, nyeriPerut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leukosit);
        sesak = getIntent().getExtras().getInt("sesak");
        panas = getIntent().getExtras().getInt("panas");
        bab = getIntent().getExtras().getInt("Gangguan BAB");
        nafsuMakan = getIntent().getExtras().getInt("nafsu makan");
        muntah = getIntent().getExtras().getInt("muntah");
        mual = getIntent().getExtras().getInt("mual");
        nyeriTekan = getIntent().getExtras().getInt("nyeri tekan");
        skalaNyeri = getIntent().getExtras().getInt("skala nyeri");
        nyeriPerut = getIntent().getExtras().getInt("nyeri perut");
        leukositRg = (RadioGroup)findViewById(R.id.leukositRg);
        nextLeukositBtn = (Button)findViewById(R.id.nextLeukositBtn);
        nextLeukositBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = leukositRg.getCheckedRadioButtonId();
                leukositRb = (RadioButton)findViewById(selectedId);
                normalRb = (RadioButton)findViewById(R.id.normalRb);
                normalRb.setId(0);
                abnormalRb = (RadioButton)findViewById(R.id.abnormalRb);
                abnormalRb.setId(1);
                Intent il = new Intent(getApplicationContext(), DiagnosaDokter.class);
                il.putExtra("leukosit", Integer.valueOf(leukositRb.getId()));
                il.putExtra("sesak", sesak);
                il.putExtra("panas", panas);
                il.putExtra("Gangguan BAB", bab);
                il.putExtra("nafsu makan", nafsuMakan);
                il.putExtra("muntah", muntah);
                il.putExtra("mual", mual);
                il.putExtra("nyeri tekan", nyeriTekan);
                il.putExtra("skala nyeri", skalaNyeri);
                il.putExtra("nyeri perut", nyeriPerut);
                Log.d("hasil leukosit",String.valueOf(leukositRb.getId()));
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
