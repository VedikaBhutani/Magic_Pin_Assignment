package com.androidwave.exoplayer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.androidwave.exoplayer.adapter.VideoRecyclerViewAdapter;
import com.androidwave.exoplayer.model.VideoInfo;
import com.androidwave.exoplayer.ui.ExoPlayerVideoRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewFeed)
    ExoPlayerVideoRecyclerView recyclerViewFeed;

    private List<VideoInfo> videoInfoList = new ArrayList<>();
    private VideoRecyclerViewAdapter mAdapter;
    private boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prepareVideoList();
        recyclerViewFeed.setVideoInfoList(videoInfoList);
        mAdapter = new VideoRecyclerViewAdapter(videoInfoList);
        recyclerViewFeed.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        recyclerViewFeed.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFeed.setAdapter(mAdapter);

        if (firstTime) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    recyclerViewFeed.playVideo();
                }
            });
            firstTime = false;
        }

    }

    private void prepareVideoList() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setId(1);
        videoInfo.setTitle("Google drops $10bn battle for Pentagon data contract");
        videoInfo.setCoverUrl("https://ichef.bbci.co.uk/news/320/cpsprodpb/AAA7/production/_103778634_cloud.jpg");
        videoInfo.setUrl("https://androidwave.com/media/androidwave-video-1.mp4");

        VideoInfo videoInfo2 = new VideoInfo();
        videoInfo2.setId(2);
        videoInfo2.setTitle("Google drops $10bn battle for Pentagon data contract");
        videoInfo2.setCoverUrl("https://ichef.bbci.co.uk/news/320/cpsprodpb/AAA7/production/_103778634_cloud.jpg");
        videoInfo2.setUrl("https://androidwave.com/media/androidwave-video-2.mp4");

        VideoInfo videoInfo3 = new VideoInfo();
        videoInfo3.setId(3);
        videoInfo3.setTitle("Google drops $10bn battle for Pentagon data contract");
        videoInfo3.setCoverUrl("https://ichef.bbci.co.uk/news/320/cpsprodpb/AAA7/production/_103778634_cloud.jpg");
        videoInfo3.setUrl("https://androidwave.com/media/androidwave-video-3.mp4");

        VideoInfo videoInfo4 = new VideoInfo();
        videoInfo4.setId(4);
        videoInfo4.setTitle("Google drops $10bn battle for Pentagon data contract");
        videoInfo4.setCoverUrl("https://ichef.bbci.co.uk/news/320/cpsprodpb/AAA7/production/_103778634_cloud.jpg");
        videoInfo4.setUrl("https://androidwave.com/media/androidwave-video-6.mp4");

        VideoInfo videoInfo5 = new VideoInfo();
        videoInfo5.setId(5);
        videoInfo5.setTitle("Google drops $10bn battle for Pentagon data contract");
        videoInfo5.setCoverUrl("https://ichef.bbci.co.uk/news/320/cpsprodpb/AAA7/production/_103778634_cloud.jpg");
        videoInfo5.setUrl("https://androidwave.com/media/androidwave-video-5.mp4");
        videoInfoList.add(videoInfo);
        videoInfoList.add(videoInfo2);
        videoInfoList.add(videoInfo3);
        videoInfoList.add(videoInfo4);
        videoInfoList.add(videoInfo5);
        videoInfoList.add(videoInfo);
        videoInfoList.add(videoInfo2);
        videoInfoList.add(videoInfo3);
        videoInfoList.add(videoInfo4);
        videoInfoList.add(videoInfo5);

    }

    @Override
    protected void onPause() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                recyclerViewFeed.onPausePlayer();
            }
        });
        super.onPause();
    }

    @Override
    protected void onResume() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                recyclerViewFeed.onRestartPlayer();
            }
        });
        super.onResume();
    }
}
