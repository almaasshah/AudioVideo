package com.example.s_shah.audiovideo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView myVideoView;
    private Button play_btn;
    private MediaController mediaController;
    private Button playmusicbtn;
    private Button stopmusicbtn;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideoView = findViewById(R.id.myVideoView);
        play_btn = findViewById(R.id.play_btn);
        playmusicbtn = findViewById(R.id.playmusicbtn);
        stopmusicbtn = findViewById(R.id.stopmusicbtn);


       play_btn.setOnClickListener(MainActivity.this);
       playmusicbtn.setOnClickListener(MainActivity.this);
       stopmusicbtn.setOnClickListener(MainActivity.this);

       mediaController = new MediaController(MainActivity.this);
       mediaPlayer = MediaPlayer.create(this,R.raw.heartbeat);

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
