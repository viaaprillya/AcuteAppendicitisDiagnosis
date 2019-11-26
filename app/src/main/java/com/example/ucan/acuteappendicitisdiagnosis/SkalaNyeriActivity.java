package com.example.ucan.acuteappendicitisdiagnosis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Objects;

public class SkalaNyeriActivity extends AppCompatActivity {

    Button nextSkalaButton;
    //private RadioGroup skalaRadioGroup;
    //private RadioButton skalaNyeriRb, skala0Rb, skala1Rb, skala2Rb, skala3Rb, skala4Rb, skala5Rb, skala6Rb, skala7Rb, skala8Rb, skala9Rb;
    private int nyeriPerut;
   // private static String hasilskala="";
    private SeekBar skalaSeekBar;
    private TextView tv;
    int seekBarProgres = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skala_nyeri);
        skalaSeekBar = (SeekBar)findViewById(R.id.skalaSeekBar);
        tv = (TextView)findViewById(R.id.tv);
        nyeriPerut = Objects.requireNonNull(getIntent().getExtras()).getInt("nyeri perut");
        skalaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seekBarProgres=progress;
                tv.setText(String.valueOf(seekBarProgres));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        nextSkalaButton = (Button)findViewById(R.id.nextSkalaBtn);
        nextSkalaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is = new Intent(getApplicationContext(), NyeriTekanActivity.class);
                is.putExtra("skala nyeri", Integer.valueOf(seekBarProgres));
                is.putExtra("nyeri perut", Integer.valueOf(nyeriPerut));
                Log.d("hasil skala",String.valueOf(seekBarProgres));
//                Log.d("hasil nyeri perut",String.valueOf(nyeriPerut));
                startActivity(is);
            }
        });

//        skalaRadioGroup = (RadioGroup)findViewById(R.id.skalaRadiogroup);
//        nextSkalaButton = (Button)findViewById(R.id.nextSkalaBtn);
//        nextSkalaButton.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceType")
//            @Override
//            public void onClick(View v) {
//                int selectedId = skalaRadioGroup.getCheckedRadioButtonId();
//                skalaNyeriRb = (RadioButton)findViewById(selectedId);
//                hasilskala = String.valueOf(skalaNyeriRb.getText());
//                Log.d("hasil skala",hasilskala);
//                skala0Rb = (RadioButton)findViewById(R.id.skala0Rb);
//                skala0Rb.setId(0);
//                skala1Rb = (RadioButton)findViewById(R.id.skala1Rb);
//                skala1Rb.setId(1);
//                skala2Rb = (RadioButton)findViewById(R.id.skala2Rb);
//                skala2Rb.setId(2);
//                skala3Rb = (RadioButton)findViewById(R.id.skala3Rb);
//                skala3Rb.setId(3);
//                skala4Rb = (RadioButton)findViewById(R.id.skala4Rb);
//                skala4Rb.setId(4);
//                skala5Rb = (RadioButton)findViewById(R.id.skala5Rb);
//                skala5Rb.setId(5);
//                skala6Rb = (RadioButton)findViewById(R.id.skala6Rb);
//                skala6Rb.setId(6);
//                skala7Rb = (RadioButton)findViewById(R.id.skala7Rb);
//                skala7Rb.setId(7);
//                skala8Rb = (RadioButton)findViewById(R.id.skala8Rb);
//                skala8Rb.setId(8);
//                skala9Rb = (RadioButton)findViewById(R.id.skala9Rb);
//                skala9Rb.setId(9);
//                Intent is = new Intent(getApplicationContext(), NyeriTekanActivity.class);
////                is.putExtra("skala nyeri", skalaNyeriRb.getId());
//                is.putExtra("Bagian Nyeri Perut", nyeriPerut);
//
//                startActivity(is);
//            }
//        });
    }
}
