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

public class BabActivity extends AppCompatActivity {

    Button nextBabBtn;
    private RadioGroup babRadioGroup;
    private RadioButton babRb, normalBabRb, sembelitRb, mencretRb;
    private int nafsuMakan, muntah, mual, nyeriTekan, skalaNyeri, nyeriPerut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab);
        nafsuMakan = getIntent().getExtras().getInt("nafsu makan");
        muntah = getIntent().getExtras().getInt("muntah");
        mual = getIntent().getExtras().getInt("mual");
        nyeriTekan = getIntent().getExtras().getInt("nyeri tekan");
        skalaNyeri = getIntent().getExtras().getInt("skala nyeri");
        nyeriPerut = getIntent().getExtras().getInt("nyeri perut");
        babRadioGroup = (RadioGroup)findViewById(R.id.babRadioGroup);
        nextBabBtn = (Button)findViewById(R.id.nextBabBtn);
        nextBabBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = babRadioGroup.getCheckedRadioButtonId();
                babRb = (RadioButton)findViewById(selectedId);
                normalBabRb = (RadioButton)findViewById(R.id.normalBabRb);
                normalBabRb.setId(2);
                sembelitRb = (RadioButton)findViewById(R.id.sembelitRb);
                sembelitRb.setId(1);
                mencretRb = (RadioButton)findViewById(R.id.mencretRb);
                mencretRb.setId(0);
                Intent ib = new Intent(getApplicationContext(), PanasActivity.class);
                ib.putExtra("Gangguan BAB", Integer.valueOf(babRb.getId()));
                ib.putExtra("nafsu makan", nafsuMakan);
                ib.putExtra("muntah", muntah);
                ib.putExtra("mual", mual);
                ib.putExtra("nyeri tekan", nyeriTekan);
                ib.putExtra("skala nyeri", skalaNyeri);
                ib.putExtra("nyeri perut", nyeriPerut);
                Log.d("hasil BAB",String.valueOf(babRb.getId()));
                Log.d("hasil nafsu makan",String.valueOf(nafsuMakan));
                Log.d("hasil muntah",String.valueOf(muntah));
                Log.d("hasil mual",String.valueOf(mual));
                Log.d("hasil nyeri tekan", String.valueOf(nyeriTekan));
                Log.d("hasil skala", String.valueOf(skalaNyeri));
                Log.d("hasil nyeri perut",String.valueOf(nyeriPerut));
                startActivity(ib);
            }
        });
    }
}
