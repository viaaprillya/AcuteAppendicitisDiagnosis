package com.example.ucan.acuteappendicitisdiagnosis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    Button diagnosa, info, tentangAplikasi,Tree,Rule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        diagnosa = (Button) findViewById(R.id.diagnosaButton);
        info = (Button) findViewById(R.id.infoButton);
        tentangAplikasi = (Button) findViewById(R.id.tentangAplikasiBtn);
        Tree = findViewById(R.id.Treebtn);
        Rule = findViewById(R.id.Rulebtn);

        diagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent id = new Intent(getApplicationContext(), NyeriPerutActivity.class);
                startActivity(id);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(ii);
            }
        });

        tentangAplikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), TentangAplikasiActivity.class);
                startActivity(it);
            }
        });

        Tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), Tree.class);
                startActivity(it);
            }
        });

       Rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), Rule.class);
                startActivity(it);
            }
        });

    }

}
