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

public class MualActivity extends AppCompatActivity {

    Button nextMualButton;
    private RadioGroup mualRadioGroup;
    private RadioButton mualRb, yaMualRb, tdkMualRb;
    int nyeriTekan, skalaNyeri, nyeriPerut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mual);
        nyeriTekan = getIntent().getExtras().getInt("nyeri tekan");
        skalaNyeri = getIntent().getExtras().getInt("skala nyeri");
        nyeriPerut = getIntent().getExtras().getInt("nyeri perut");
        mualRadioGroup = (RadioGroup)findViewById(R.id.mualRadioGroup);
        nextMualButton = (Button)findViewById(R.id.nextMualBtn);
        nextMualButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = mualRadioGroup.getCheckedRadioButtonId();
                mualRb = (RadioButton)findViewById(selectedId);
                yaMualRb = (RadioButton)findViewById(R.id.yaMualRb);
                yaMualRb.setId(1);
                tdkMualRb = (RadioButton)findViewById(R.id.tdkMualRb);
                tdkMualRb.setId(0);
                Intent im = new Intent(getApplicationContext(), MuntahActivity.class);
                im.putExtra("mual", Integer.valueOf(mualRb.getId()));
                im.putExtra("nyeri tekan", nyeriTekan);
                im.putExtra("skala nyeri", skalaNyeri);
                im.putExtra("nyeri perut", nyeriPerut);
                Log.d("hasil mual",String.valueOf(mualRb.getId()));
                Log.d("hasil nyeri tekan", String.valueOf(nyeriTekan));
                Log.d("hasil skala", String.valueOf(skalaNyeri));
                Log.d("hasil nyeri perut",String.valueOf(nyeriPerut));
                startActivity(im);
            }
        });
    }
}
