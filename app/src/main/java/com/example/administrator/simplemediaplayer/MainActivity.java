package com.example.administrator.simplemediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private static final String TAG="SimpleMediaPlayer";
    private String mPath;
    private VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        Uri uri=intent.getData();
        if(uri!=null){
            mPath=uri.getPath();
            if(intent.getType().contains("audio")){
                mMediaPlayer =new MediaPlayer();
                try {
                    mMediaPlayer.setDataSource(mPath);
                    mMediaPlayer.prepare();
                    mMediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(intent.getType().contains("video")){
                mVideoView =new VideoView(this);
                mVideoView.setVideoURI(uri);
                mVideoView.setMediaController(new MediaController(this));
                mVideoView.start();
                setContentView(mVideoView);
            }
        }
    }
}
