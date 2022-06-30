package com.alimuntung.a10119260sensormaps;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alimuntung.a10119260sensormaps.Presenter.AppActivity;
// Ikbar Laudza Alviansyah
// IF-7
// 10119260
public class MainActivity extends AppCompatActivity {
    private int waktu_loading=4000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent home=new Intent(MainActivity.this, AppActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}