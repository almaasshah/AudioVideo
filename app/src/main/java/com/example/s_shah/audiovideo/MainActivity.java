package com.example.s_shah.audiovideo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView myVideoView;
    private Button play_btn;
    private MediaController mediaController;
    private Button playmusicbtn;
    private Button stopmusicbtn;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideoView = findViewById(R.id.myVideoView);
        play_btn = findViewById(R.id.play_btn);
        playmusicbtn = findViewById(R.id.playmusicbtn);
        stopmusicbtn = findViewById(R.id.stopmusicbtn);
        seekBar = findViewById(R.id.seekBar);

       play_btn.setOnClickListener(MainActivity.this);
       playmusicbtn.setOnClickListener(MainActivity.this);
       stopmusicbtn.setOnClickListener(MainActivity.this);


       mediaController = new MediaController(MainActivity.this);
       mediaPlayer = MediaPlayer.create(this,R.raw.heartbeat);
       audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

       int maximumVolumeOfUserDevice = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
       int currentVolumeOfUserDevice = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

       seekBar.setMax(maximumVolumeOfUserDevice);
       seekBar.setProgress(currentVolumeOfUserDevice);

       seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });


    }

    @Override
    public void onClick(View buttonView) {

        switch (buttonView.getId()){
            case R.id.play_btn:
                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.phlexlabs);
                myVideoView.setVideoURI(videoUri);
                myVideoView.setMediaController(mediaController);
                mediaController.setAnchorView(myVideoView);
                myVideoView.start();
                break;
            case R.id.playmusicbtn:
                mediaPlayer.start();

                break;
            case R.id.stopmusicbtn:
                mediaPlayer.stop();
                break;
        }




    }
}
