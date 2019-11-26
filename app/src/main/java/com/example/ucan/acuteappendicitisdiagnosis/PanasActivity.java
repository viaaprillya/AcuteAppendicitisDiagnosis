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

public class PanasActivity extends AppCompatActivity {

    Button nextPanasButton;
    private RadioGroup panasRadioGroup;
    private RadioButton panasRb, yaPanasRb, tdkPanasRb;
    private int bab, nafsuMakan, muntah, mual, nyeriTekan, skalaNyeri, nyeriPerut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panas);
        bab = getIntent().getExtras().getInt("Gangguan BAB");
        nafsuMakan = getIntent().getExtras().getInt("nafsu makan");
        muntah = getIntent().getExtras().getInt("muntah");
        mual = getIntent().getExtras().getInt("mual");
        nyeriTekan = getIntent().getExtras().getInt("nyeri tekan");
        skalaNyeri = getIntent().getExtras().getInt("skala nyeri");
        nyeriPerut = getIntent().getExtras().getInt("nyeri perut");
        panasRadioGroup = (RadioGroup)findViewById(R.id.panasRadioGroup);
        nextPanasButton = (Button)findViewById(R.id.nextPanasBtn);
        nextPanasButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = panasRadioGroup.getCheckedRadioButtonId();
                panasRb = (RadioButton)findViewById(selectedId);
                yaPanasRb = (RadioButton)findViewById(R.id.yaPanasRb);
                yaPanasRb.setId(1);
                tdkPanasRb = (RadioButton)findViewById(R.id.tdkPanasRb);
                tdkPanasRb.setId(0);
                Intent ip = new Intent(getApplicationContext(), SesakActivity.class);
                ip.putExtra("panas", Integer.valueOf(panasRb.getId()));
                ip.putExtra("Gangguan BAB", bab);
                ip.putExtra("nafsu makan", nafsuMakan);
                ip.putExtra("muntah", muntah);
                ip.putExtra("mual", mual);
                ip.putExtra("nyeri tekan", nyeriTekan);
                ip.putExtra("skala nyeri", skalaNyeri);
                ip.putExtra("nyeri perut", nyeriPerut);
                Log.d("hasil panas",String.valueOf(panasRb.getId()));
                Log.d("hasil BAB",String.valueOf(bab));
                Log.d("hasil nafsu makan",String.valueOf(nafsuMakan));
                Log.d("hasil muntah",String.valueOf(muntah));
                Log.d("hasil mual",String.valueOf(mual));
                Log.d("hasil nyeri tekan", String.valueOf(nyeriTekan));
                Log.d("hasil skala", String.valueOf(skalaNyeri));
                Log.d("hasil nyeri perut",String.valueOf(nyeriPerut));
                startActivity(ip);
            }
        });
    }
}
