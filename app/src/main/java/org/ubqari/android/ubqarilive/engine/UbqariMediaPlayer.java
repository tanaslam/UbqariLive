package org.ubqari.android.ubqarilive.engine;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.IOException;

/**
 * Created by Tanny on 06/07/2014.
 */
@EBean(scope = EBean.Scope.Singleton)
public class UbqariMediaPlayer {

    private static final String TAG = UbqariMediaPlayer.class.getSimpleName();
    private static final String URI_SOURCE_RTSP = "rtsp://184.72.239.149/vod/mp4";
    private static final String URI_SOURCE_MP4 = "http://download.wavetlan.com/SVV/Media/HTTP/H264/Talkinghead_Media/H264_test1_Talkinghead_mp4_480x360.mp4";
    private static final String URI_SOURCE_HLS = "";
    @RootContext
    Context context;

    MediaPlayer mediaPlayer;

    @AfterInject
    void setupBean() {
        mediaPlayer = new MediaPlayer();
        setLiveDataSource();
    }

    public void play() {

        if(mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
            }
        });

        mediaPlayer.prepareAsync();
    }

    public void setLiveDataSource() {
        setDataSource(URI_SOURCE_MP4);
    }

    public void setOnDemandDataSource(String uri) {
        setDataSource(uri);
    }

    private void setDataSource(String uri) {
        try {
            mediaPlayer.setDataSource(context, Uri.parse(uri));
        } catch (IOException e) {
            Log.e(TAG, "Unable to set data source: " + e.getLocalizedMessage());
        }
    }

    public void mute() {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }

    public void setPlaybackCompleteListener(MediaPlayer.OnCompletionListener listener) {
        mediaPlayer.setOnCompletionListener(listener);
    }

    public void reset() {
        if(mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }
}
