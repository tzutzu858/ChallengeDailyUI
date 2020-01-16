package com.app.myapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity
                    implements  MediaPlayer.OnPreparedListener,
                                MediaPlayer.OnErrorListener,
                                 MediaPlayer.OnCompletionListener {
    VideoView videoView;
    SeekBar seekBar;
    AudioBarChart audioBarChart;
    private ImageButton mBtnMediaPlayPause,
                        mBtnMediaStop,
                        mBtnMediaGoto;

    private ToggleButton mBtnMediaRepeat;
    private AnimationDrawable scanAnimation;

    private EditText mEdtMediaGoto;

    // 程式使用的MediaPlayer物件
    private MediaPlayer mMediaPlayer = null;

    // 用來記錄是否MediaPlayer物件需要執行prepareAsync()
    private Boolean mbIsInitialised = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);
        seekBar=findViewById(R.id.seekBar);
        audioBarChart=findViewById(R.id.studioBar);

        mBtnMediaPlayPause = findViewById(R.id.btnMediaPlayPause);
        mBtnMediaStop = findViewById(R.id.btnMediaStop);
        mBtnMediaRepeat = findViewById(R.id.btnMediaRepeat);
        mBtnMediaGoto = findViewById(R.id.btnMediaGoto);
        mEdtMediaGoto = findViewById(R.id.edtMediaGoto);

        mBtnMediaPlayPause.setOnClickListener(btnMediaPlayPauseOnClick);
        mBtnMediaStop.setOnClickListener(btnMediaStopOnClick);
        mBtnMediaRepeat.setOnClickListener(btnMediaRepeatOnClick);
        mBtnMediaGoto.setOnClickListener(btnMediaGotoOnClick);

        scanAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.seekbar_anim);
        seekBar.setThumb(scanAnimation);



    }



    @Override
    protected void onResume() {
        super.onResume();

        mMediaPlayer = new MediaPlayer();
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ocean);

        Uri uri2 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hd0223);
        videoView.setVideoURI(uri2);


        try {
            mMediaPlayer.setDataSource(this, uri);

        }

        catch (Exception e) {
            Toast.makeText(MainActivity.this, "指定的音樂檔錯誤！", Toast.LENGTH_LONG)
                    .show();
        }

        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnErrorListener(this);
        mMediaPlayer.setOnCompletionListener(this);

        videoView.setOnCompletionListener(this);
        videoView.setOnErrorListener(this);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();

        mMediaPlayer.release();
        mMediaPlayer = null;


    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mBtnMediaPlayPause.setImageResource(android.R.drawable.ic_media_play);
        videoView.pause();

    }




    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        mediaPlayer.release();
        mediaPlayer= null;

        Toast.makeText(MainActivity.this, "發生錯誤，停止播放", Toast.LENGTH_LONG)
                .show();

        return true;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo(0);
        mediaPlayer.start();



        Toast.makeText(MainActivity.this, "開始播放", Toast.LENGTH_LONG)
                .show();
        scanAnimation.start();
        audioBarChart.setVisibility(VISIBLE);
        seekBar.setMax(mMediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {
                    mMediaPlayer.seekTo(progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mMediaPlayer.getCurrentPosition());
            }
        },50, 500);




    }



    private View.OnClickListener btnMediaPlayPauseOnClick = new View.OnClickListener() {


        @Override
        public void onClick(View v) {

            if (mMediaPlayer.isPlaying()) {

                mBtnMediaPlayPause.setImageResource(android.R.drawable.ic_media_play);
                mMediaPlayer.pause();
                videoView.pause();
                scanAnimation.stop();


            }
            else {
                mBtnMediaPlayPause.setImageResource(android.R.drawable.ic_media_pause);

                if (mbIsInitialised) {
                    mMediaPlayer.prepareAsync();
                    mbIsInitialised = false;
                }
                else

                    mMediaPlayer.start();
                    videoView.setVisibility(VISIBLE);
                    videoView.start();
                    scanAnimation.start();

            }
        }
    };

    private View.OnClickListener btnMediaStopOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mMediaPlayer.stop();
            videoView.pause();
            scanAnimation.stop();

            // 停止播放後必須再執行 prepareAsync()
            // 或 prepare() 才能重新播放。
            mbIsInitialised = true;
            mBtnMediaPlayPause.setImageResource(android.R.drawable.ic_media_play);
        }
    };

    private View.OnClickListener btnMediaRepeatOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (((ToggleButton)v).isChecked())
                mMediaPlayer.setLooping(true);
            else
                mMediaPlayer.setLooping(false);
        }
    };

    private View.OnClickListener btnMediaGotoOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            if (mEdtMediaGoto.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this,
                        "請先輸入要播放的位置（以秒為單位）",
                        Toast.LENGTH_LONG)
                        .show();
                return;
            }

            int seconds = Integer.parseInt(mEdtMediaGoto.getText().toString());
            mMediaPlayer.seekTo(seconds * 1000); // 以毫秒（千分之一秒）為單位



        }
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

    }
}
