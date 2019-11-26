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

public class NafsuMakanActivity extends AppCompatActivity {

    Button nextNafsuMakanBtn;
    private RadioGroup nafsuMakanRg;
    private RadioButton nafsuMakanRb, normalNafsuRb, menurunRb;
    private int muntah, mual, nyeriTekan, skalaNyeri, nyeriPerut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nafsu_makan);
        muntah = getIntent().getExtras().getInt("muntah");
        mual = getIntent().getExtras().getInt("mual");
        nyeriTekan = getIntent().getExtras().getInt("nyeri tekan");
        skalaNyeri = getIntent().getExtras().getInt("skala nyeri");
        nyeriPerut = getIntent().getExtras().getInt("nyeri perut");
        nafsuMakanRg = (RadioGroup)findViewById(R.id.nafsuMakanRg);
        nextNafsuMakanBtn = (Button)findViewById(R.id.nextNafsuBtn);
        nextNafsuMakanBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = nafsuMakanRg.getCheckedRadioButtonId();
                nafsuMakanRb = (RadioButton)findViewById(selectedId);
                normalNafsuRb = (RadioButton)findViewById(R.id.normalNafsuRb);
                normalNafsuRb.setId(0);
                menurunRb = (RadioButton)findViewById(R.id.menurunRb);
                menurunRb.setId(1);
                Intent inaf = new Intent(getApplicationContext(), BabActivity.class);
                inaf.putExtra("nafsu makan", Integer.valueOf(nafsuMakanRb.getId()));
                inaf.putExtra("muntah", muntah);
                inaf.putExtra("mual", mual);
                inaf.putExtra("nyeri tekan", nyeriTekan);
                inaf.putExtra("skala nyeri", skalaNyeri);
                inaf.putExtra("nyeri perut", nyeriPerut);
                Log.d("hasil nafsu makan",String.valueOf(nafsuMakanRb.getId()));
                Log.d("hasil muntah",String.valueOf(muntah));
                Log.d("hasil mual",String.valueOf(mual));
                Log.d("hasil nyeri tekan", String.valueOf(nyeriTekan));
                Log.d("hasil skala", String.valueOf(skalaNyeri));
                Log.d("hasil nyeri perut",String.valueOf(nyeriPerut));
                startActivity(inaf);
            }
        });
    }
}
