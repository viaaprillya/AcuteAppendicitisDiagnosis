package com.example.ucan.acuteappendicitisdiagnosis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper2 extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "history_pasien.db";
        private static final String DATABASE_TABLE = "data_pasien";
        private static final int DATABASE_VERSION = 1;
        public DatabaseHelper2(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            // TODO Auto-generated constructor stub
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            String sql = "CREATE TABLE data_pasien(ID INTEGER primary key AUTOINCREMENT NOT NULL,  nyeri INTEGER null , skala_nyeri INTEGER null, mual INTEGER null, muntah INTEGER null,nafsu_makan INTEGER null,bab INTEGER null,panas INTEGER null, sesak INTEGER null, nyeri_tekan INTEGER null, leukosit INTEGER null, diagnosis_dokter INTEGER null, diagnosis_aplikasi INTEGER null);";
            Log.d("Data", "onCreate: " + sql);
            db.execSQL(sql);
        }
        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            // TODO Auto-generated method stub
        }

        public void insertData(int nyeri, int skala_nyeri, int mual, int muntah, int nafsu_makan, int bab, int panas, int sesak, int nyeri_tekan, int leukosit, int diagnosis_dokter, int diagnosis_aplikasi){
            //Get the Data Repository in write mode
            SQLiteDatabase db = this.getWritableDatabase();
            //Create a new map of values, where column names are the keys
            ContentValues cValues = new ContentValues();
            cValues.put("nyeri", nyeri);
            cValues.put("skala_nyeri", skala_nyeri);
            cValues.put("mual", mual);
            cValues.put("muntah", muntah);
            cValues.put("nafsu_makan", nafsu_makan);
            cValues.put("bab", bab);
            cValues.put("panas", panas);
            cValues.put("sesak", sesak);
            cValues.put("nyeri_tekan", nyeri_tekan);
            cValues.put("leukosit", leukosit);
            cValues.put("diagnosis_dokter", diagnosis_dokter);
            cValues.put("diagnosis_aplikasi", diagnosis_aplikasi);

            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(DATABASE_TABLE,null, cValues);
            db.close();
        }

        // Get data Details
        public ArrayList<HashMap<String, String>> getData(){
            SQLiteDatabase db = this.getWritableDatabase();
            ArrayList<HashMap<String, String>> dataList = new ArrayList<>();
            String query = "SELECT * FROM data_pasien ";
            Cursor cursor = db.rawQuery(query,null);
            while (cursor.moveToNext()){
                HashMap<String,String> data = new HashMap<>();
                data.put("ID",cursor.getString(0));
                data.put("nyeri",cursor.getString(1));
                data.put("skala_nyeri",cursor.getString(2));
                data.put("mual",cursor.getString(3));
                data.put("muntah",cursor.getString(4));
                data.put("nafsu_makan",cursor.getString(5));
                data.put("bab",cursor.getString(6));
                data.put("panas",cursor.getString(7));
                data.put("sesak",cursor.getString(8));
                data.put("nyeri_tekan",cursor.getString(9));
                data.put("leukosit",cursor.getString(10));
                data.put("diagnosis_dokter",cursor.getString(11));
                data.put("diagnosis_aplikasi",cursor.getString(12));
                dataList.add(data);
            }
            return  dataList;
        }
    }

