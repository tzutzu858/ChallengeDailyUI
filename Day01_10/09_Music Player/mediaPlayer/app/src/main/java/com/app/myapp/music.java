package com.app.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class music extends AppCompatActivity {
        ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Animation fadein= AnimationUtils.loadAnimation(music.this,R.anim.fade_in);
        imageView=findViewById(R.id.imageView);
        imageView.setAnimation(fadein);

        Thread timer= new Thread()

        {
            @Override
            public void run() {
                super.run();

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally
                {   overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_out);
                    //overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_in);
                    startActivity(new Intent(music.this,MainActivity.class));
                    finish();

                }


            }
        };
        timer.start();


    }

}
