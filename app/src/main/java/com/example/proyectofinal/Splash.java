package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    MediaPlayer repr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        repr = new MediaPlayer();
        repr = MediaPlayer.create(this,R.raw.soninicio);
        repr.setLooping(false);
        repr.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, AuthMenu.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}