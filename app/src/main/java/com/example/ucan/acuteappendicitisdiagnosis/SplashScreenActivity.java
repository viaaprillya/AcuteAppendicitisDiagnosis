package com.example.ucan.acuteappendicitisdiagnosis;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainMenu = new Intent(SplashScreenActivity.this, MainMenuActivity.class);
                startActivity(mainMenu);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
