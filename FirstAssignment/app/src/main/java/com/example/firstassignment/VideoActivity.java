package com.example.firstassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {
    VideoView video;
    ListView listView;
    ArrayList<String> videoList;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video = findViewById(R.id.videoView);
        listView=findViewById(R.id.listView1);
        videoList=new ArrayList<String>();
        videoList.add("video1");
        videoList.add("video2");

        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,videoList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video1));
                        break;
                    case 1:
                        video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video2));
                        break;
                    default:
                        break;

                }
                video.setMediaController(new MediaController(VideoActivity.this));
                video.requestFocus();
                video.start();
            }
        });
    }
}