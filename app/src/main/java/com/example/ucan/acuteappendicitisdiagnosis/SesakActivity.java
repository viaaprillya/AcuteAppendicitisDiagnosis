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

public class SesakActivity extends AppCompatActivity {

    Button nextSesakbutton;
    private RadioGroup sesakRadiogroup;
    private RadioButton sesakRb, yaSesakRb, tdkSesakRb;
    private int panas, bab, nafsuMakan, muntah, mual, nyeriTekan, skalaNyeri, nyeriPerut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesak);
        panas = getIntent().getExtras().getInt("panas");
        bab = getIntent().getExtras().getInt("Gangguan BAB");
        nafsuMakan = getIntent().getExtras().getInt("nafsu makan");
        muntah = getIntent().getExtras().getInt("muntah");
        mual = getIntent().getExtras().getInt("mual");
        nyeriTekan = getIntent().getExtras().getInt("nyeri tekan");
        skalaNyeri = getIntent().getExtras().getInt("skala nyeri");
        nyeriPerut = getIntent().getExtras().getInt("nyeri perut");
        sesakRadiogroup = (RadioGroup)findViewById(R.id.sesakRadioGroup);
        nextSesakbutton = (Button)findViewById(R.id.nextSesakBtn);
        nextSesakbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = sesakRadiogroup.getCheckedRadioButtonId();
                sesakRb = (RadioButton)findViewById(selectedId);
                yaSesakRb = (RadioButton)findViewById(R.id.yaSesakRb);
                yaSesakRb.setId(1);
                tdkSesakRb = (RadioButton)findViewById(R.id.tdkSesakRb);
                tdkSesakRb.setId(0);
                Intent is = new Intent(getApplicationContext(), LeukositActivity.class);
                is.putExtra("sesak", Integer.valueOf(sesakRb.getId()));
                is.putExtra("panas", Integer.valueOf(panas));
                is.putExtra("Gangguan BAB", bab);
                is.putExtra("nafsu makan", nafsuMakan);
                is.putExtra("muntah", muntah);
                is.putExtra("mual", mual);
                is.putExtra("nyeri tekan", nyeriTekan);
                is.putExtra("skala nyeri", skalaNyeri);
                is.putExtra("nyeri perut", nyeriPerut);
                Log.d("hasil sesak",String.valueOf(sesakRb.getId()));
                Log.d("hasil panas",String.valueOf(panas));
                Log.d("hasil BAB",String.valueOf(bab));
                Log.d("hasil nafsu makan",String.valueOf(nafsuMakan));
                Log.d("hasil muntah",String.valueOf(muntah));
                Log.d("hasil mual",String.valueOf(mual));
                Log.d("hasil nyeri tekan", String.valueOf(nyeriTekan));
                Log.d("hasil skala", String.valueOf(skalaNyeri));
                Log.d("hasil nyeri perut",String.valueOf(nyeriPerut));
                startActivity(is);
            }
        });
    }
}
