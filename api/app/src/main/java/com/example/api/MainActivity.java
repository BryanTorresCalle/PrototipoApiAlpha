package com.example.api;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Animation from, fromTop;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        from = AnimationUtils.loadAnimation(this, R.anim.from);
        logo = (ImageView) findViewById(R.id.imgLogo);
        logo.setAnimation(from);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,one.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
