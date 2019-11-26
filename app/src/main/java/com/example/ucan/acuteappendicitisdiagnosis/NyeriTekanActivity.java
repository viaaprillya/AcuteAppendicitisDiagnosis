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

public class NyeriTekanActivity extends AppCompatActivity {

    Button nextNyeriTekanBtn;
    private RadioGroup nyeriTekanRg;
    private RadioButton nyeriTekanRb, yaNyeriRb, tdkNyeriRb;
    int skalaNyeri, nyeriPerut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyeri_tekan);
        nyeriPerut = getIntent().getExtras().getInt("nyeri perut");
        skalaNyeri = getIntent().getExtras().getInt("skala nyeri");
        nyeriTekanRg = (RadioGroup)findViewById(R.id.nyeriTekanRg);
        nextNyeriTekanBtn = (Button)findViewById(R.id.nextNyeriTekanBtn);
        nextNyeriTekanBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = nyeriTekanRg.getCheckedRadioButtonId();
                nyeriTekanRb = (RadioButton)findViewById(selectedId);
                yaNyeriRb = (RadioButton)findViewById(R.id.yaNyeriRb);
                yaNyeriRb.setId(1);
                tdkNyeriRb = (RadioButton)findViewById(R.id.tdkNyeriRb);
                tdkNyeriRb.setId(0);
                Intent it = new Intent(getApplicationContext(), MualActivity.class);
                it.putExtra("nyeri tekan", Integer.valueOf(nyeriTekanRb.getId()));
                it.putExtra("nyeri perut", nyeriPerut);
                it.putExtra("skala nyeri", skalaNyeri);
                Log.d("hasil skala",String.valueOf(skalaNyeri));
                Log.d("hasil nyeri tekan",String.valueOf(nyeriTekanRb.getId()));
                startActivity(it);
            }
        });
    }
}
