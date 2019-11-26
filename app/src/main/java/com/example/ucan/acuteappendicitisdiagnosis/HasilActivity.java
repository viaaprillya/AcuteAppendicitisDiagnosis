package com.example.ucan.acuteappendicitisdiagnosis;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

public class HasilActivity extends AppCompatActivity {

    Button hasilButton,historyBtn,homeBtn;
    DatabaseHelper2 db = new DatabaseHelper2(this);
    private int akurasi,bab, panas, leukosit, mual, muntah, nafsuMakan, nyeriPerut, nyeriTekan, sesak, skalaNyeri,diagnosaDokter, diagnosisAplikasi=0;
    private static ImageView sakitImageview;
    private static ImageView tdkSakitimageview;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        diagnosaDokter = Objects.requireNonNull(getIntent().getExtras()).getInt("diagnosaDokter");
        leukosit = Objects.requireNonNull(getIntent().getExtras()).getInt("leukosit");
        nyeriPerut = getIntent().getExtras().getInt("nyeri perut");
        skalaNyeri = getIntent().getExtras().getInt("skala nyeri");
        nyeriTekan = getIntent().getExtras().getInt("nyeri tekan");
        mual = getIntent().getExtras().getInt("mual");
        muntah = getIntent().getExtras().getInt("muntah");
        nafsuMakan = getIntent().getExtras().getInt("nafsu makan");
        bab = getIntent().getExtras().getInt("Gangguan BAB");
        panas = getIntent().getExtras().getInt("panas");
        sesak = getIntent().getExtras().getInt("sesak");

        hasilButton = (Button)findViewById(R.id.hasilButton);
        historyBtn = (Button)findViewById(R.id.historyBtn);
        homeBtn=findViewById(R.id.homeBtn);
        sakitImageview = (ImageView)findViewById(R.id.sakitImageView);
        tdkSakitimageview = (ImageView) findViewById(R.id. tdkSakitImageView);



        hasilButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View view){
                if (nyeriPerut == 0){
                   tdkSakitimageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 0;
                }
                else if (nyeriPerut == 2){
                    if (skalaNyeri == 1){
                        tdkSakitimageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 0;
                    }
                    else if (skalaNyeri == 3){
                        if (nyeriTekan == 1) {
                            sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                        }
                        else if (nyeriTekan == 0) {
                            tdkSakitimageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 0;
                        }}
                    else if (skalaNyeri == 4){
                        sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                    }
                    else if (skalaNyeri == 5){
                        if (mual == 0)
                        {
                            tdkSakitimageview.setVisibility(View.VISIBLE);  diagnosisAplikasi = 0;
                        }
                        else if (mual == 1){
                            if (nafsuMakan == 1){
                                tdkSakitimageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 0;
                            }
                            else if (nafsuMakan == 0){
                                sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                            }}}
                    else if (skalaNyeri == 6){
                        if (bab == 0){
                            tdkSakitimageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 0;
                        }
                        else if (bab == 1){
                            sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                        }

                        else if (bab == 2){
                            if (mual == 0){
                                tdkSakitimageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 0;
                            }
                            else if (mual == 1){
                                if (nyeriTekan == 0){
                                    sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                                }
                                else if (nyeriTekan ==1){
                                    if (leukosit == 1){
                                        sakitImageview.setVisibility(View.VISIBLE);
                                    }
                                    else if (leukosit == 0){
                                        if (muntah == 0){
                                            sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                                        }
                                        else if (muntah == 1){
                                            sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if (skalaNyeri == 7){
                        sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                    }
                    else if (skalaNyeri == 8){
                        if (panas == 1){
                            sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                        }
                        else if (panas == 0){
                            if (mual == 1){
                                sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                            }
                            else if (mual == 0){
                                tdkSakitimageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 0;
                            }
                        }
                    }
                    else if (skalaNyeri == 9){
                        sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                    }}
                else if (nyeriPerut == 1){
                    if (skalaNyeri == 2){
                        tdkSakitimageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 0;
                    }
                    else if (skalaNyeri == 3){
                        tdkSakitimageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 0;
                    }
                    else if (skalaNyeri == 4){
                        if (sesak == 1){
                            tdkSakitimageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 0;
                        }
                        else if (sesak == 0){
                            sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                        }
                    }
                    else if (skalaNyeri == 5){
                        sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                    }
                    else if (skalaNyeri == 6){
                        sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                    }
                    else if (skalaNyeri == 7){
                        sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                    }
                    else if (skalaNyeri == 8){
                        sakitImageview.setVisibility(View.VISIBLE); diagnosisAplikasi = 1;
                    }
                }

                Log.d("hasil diagnosaDokter",String.valueOf(diagnosaDokter));
                Log.d("hasil leukosit",String.valueOf(leukosit));
                Log.d("hasil sesak",String.valueOf(sesak));
                Log.d("hasil panas",String.valueOf(panas));
                Log.d("hasil BAB",String.valueOf(bab));
                Log.d("hasil nafsu makan",String.valueOf(nafsuMakan));
                Log.d("hasil muntah",String.valueOf(muntah));
                Log.d("hasil mual",String.valueOf(mual));
                Log.d("hasil nyeri tekan", String.valueOf(nyeriTekan));
                Log.d("hasil skala", String.valueOf(skalaNyeri));
                Log.d("hasil nyeri perut",String.valueOf(nyeriPerut));
                Log.d("hasil nyeri perut",String.valueOf(nyeriPerut));
                Log.d("hasil diagnosisAplikasi",String.valueOf(diagnosisAplikasi));

                db.insertData(nyeriPerut, skalaNyeri, mual, muntah, nafsuMakan, bab, panas, sesak, nyeriTekan, leukosit, diagnosaDokter, diagnosisAplikasi);
                Toast.makeText(getApplicationContext(), "Data Inserted Successfully",Toast.LENGTH_SHORT).show();





            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ih = new Intent(getApplicationContext(),History.class);
                startActivity(ih);
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ih = new Intent(getApplicationContext(),SplashScreenActivity.class);
                startActivity(ih);
            }
        });



    }
}
