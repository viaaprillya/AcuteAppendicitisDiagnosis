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

public class MuntahActivity extends AppCompatActivity {

    Button nextMuntahBtn;
    private RadioGroup muntahRadioGroup;
    private RadioButton muntahRb, yaMuntahRb, tdkMuntahRb;
    private int mual, nyeriTekan, skalaNyeri, nyeriPerut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muntah);
        mual = getIntent().getExtras().getInt("mual");
        nyeriTekan = getIntent().getExtras().getInt("nyeri tekan");
        skalaNyeri = getIntent().getExtras().getInt("skala nyeri");
        nyeriPerut = getIntent().getExtras().getInt("nyeri perut");
        muntahRadioGroup = (RadioGroup)findViewById(R.id.muntahRadiogroup);
        nextMuntahBtn = (Button)findViewById(R.id.nextMuntahBtn);
        nextMuntahBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = muntahRadioGroup.getCheckedRadioButtonId();
                muntahRb = (RadioButton)findViewById(selectedId);
                yaMuntahRb = (RadioButton)findViewById(R.id.yaMuntahRb);
                yaMuntahRb.setId(1);
                tdkMuntahRb = (RadioButton)findViewById(R.id.tdkMuntahRb);
                tdkMuntahRb.setId(0);
                Intent imun = new Intent(getApplicationContext(), NafsuMakanActivity.class);
                imun.putExtra("muntah", Integer.valueOf(muntahRb.getId()));
                imun.putExtra("mual", mual);
                imun.putExtra("nyeri tekan", nyeriTekan);
                imun.putExtra("skala nyeri", skalaNyeri);
                imun.putExtra("nyeri perut", nyeriPerut);
                Log.d("hasil muntah",String.valueOf(muntahRb.getId()));
                Log.d("hasil mual",String.valueOf(mual));
                Log.d("hasil nyeri tekan", String.valueOf(nyeriTekan));
                Log.d("hasil skala", String.valueOf(skalaNyeri));
                Log.d("hasil nyeri perut",String.valueOf(nyeriPerut));
                startActivity(imun);
            }
        });
    }
}
