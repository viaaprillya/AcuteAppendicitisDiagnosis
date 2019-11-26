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

public class NyeriPerutActivity extends AppCompatActivity {

    Button nextNyeriPerutBtn;
    private RadioGroup nyeriPerutRg;
    private RadioButton nyeriPerutRb ,kananBawahRb, bagLainRb, tidakNyeriRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyeri_perut);
        nyeriPerutRg = (RadioGroup)findViewById(R.id.nyeriPerutRg);
        nextNyeriPerutBtn = (Button)findViewById(R.id.nextNyeriPerutBtn);
        nextNyeriPerutBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = nyeriPerutRg.getCheckedRadioButtonId();
                nyeriPerutRb = (RadioButton)findViewById(selectedId);
                kananBawahRb = (RadioButton)findViewById(R.id.kananBawahRb);
                kananBawahRb.setId(2);
                bagLainRb = (RadioButton)findViewById(R.id.bagLainRb);
                bagLainRb.setId(1);
                tidakNyeriRb = (RadioButton)findViewById(R.id.tidakNyeriRb);
                tidakNyeriRb.setId(0);
                Intent inp = new Intent(getApplicationContext(), SkalaNyeriActivity.class);
//                inp.putExtra("nyeri Perut", nyeriPerutRb.getId());
                inp.putExtra("nyeri perut", Integer.valueOf(nyeriPerutRb.getId()));
                Log.d("hasil nyeri perut",String.valueOf(nyeriPerutRb.getId()));
                startActivity(inp);
            }
        });
    }
}
