package com.example.ucan.acuteappendicitisdiagnosis;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        DatabaseHelper2 db = new DatabaseHelper2(this);

        ArrayList<HashMap<String, String>> dataList = db.getData();
        ListView lv = (ListView) findViewById(R.id.data_list);
        ListAdapter adapter = new SimpleAdapter(History.this, dataList, R.layout.list_row,new String[]{"ID","nyeri","skala_nyeri","mual","muntah","nafsu_makan","bab","panas","sesak","nyeri_tekan","leukosit","diagnosis_dokter","diagnosis_aplikasi"}, new int[]{R.id.idPasien, R.id.nyeriPerut, R.id.Skala, R.id.Mual, R.id.Muntah, R.id.nafsuMakan,R.id.BAB,R.id.Panas,R.id.Sesak,R.id.nyeriTekan,R.id.Leukosit,R.id.diagnosaRS,R.id.diagnosaAPK});
        lv.setAdapter(adapter);

        SQLiteDatabase dbhelper = db.getWritableDatabase();
        Cursor cursor = dbhelper.rawQuery("SELECT diagnosis_dokter,diagnosis_aplikasi FROM data_pasien",null);
        double benar =0;
        double total =0;
        while (cursor.moveToNext()){
            total = total+1;
            System.out.println((cursor.getInt(0)));
            System.out.println((cursor.getInt(1)));
            if((cursor.getInt(0))==(cursor.getInt(1))){
                benar = benar+1;
            }
        }
        System.out.println("total = "+total);
        System.out.println("benar = "+benar);
        double akurasi = (benar/total) * 100;
        System.out.println(akurasi+"%");

        TextView tv = findViewById(R.id.akurasi);
        tv.setText("Akurasi = "+akurasi+"%");
    }
}
