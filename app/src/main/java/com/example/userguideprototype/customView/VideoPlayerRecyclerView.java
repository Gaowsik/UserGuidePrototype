package com.example.userguideprototype.customView;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.adapters.DetailSection.VideoAdapter;
import com.example.userguideprototype.models.VideoItem;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Util;


import java.util.ArrayList;

public class VideoPlayerRecyclerView extends RecyclerView {

    private static final String TAG = "VideoPlayerRecyclerView";


    // ui
    private ImageView thumbnail, volumeControl;
    private ProgressBar progressBar;
    private View viewHolderParent;
    private FrameLayout frameLayout;
    private PlayerView videoSurfaceView;
    private SimpleExoPlayer videoPlayer;

    // vars
    private ArrayList<VideoItem> mediaObjects = new ArrayList<>();
    private int videoSurfaceDefaultHeight = 0;
    private int screenDefaultHeight = 0;
    private Context context;
    private int playPosition = -1;
    private boolean isVideoViewAdded=false;
    private boolean isAtLastItem;
    private int currentVideo;


    public VideoPlayerRecyclerView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public VideoPlayerRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public void init(Context context) {
        isVideoViewAdded = false;
        this.context = context.getApplicationContext();
        Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        videoSurfaceDefaultHeight = point.x;
        screenDefaultHeight = point.y;

        videoSurfaceView = new PlayerView(this.context);
        videoSurfaceView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM);

        // 2. Create the player
        videoPlayer = ExoPlayerFactory.newSimpleInstance(context);
        // Bind the player to the view.
        videoSurfaceView.setUseController(false);
        videoSurfaceView.setPlayer(videoPlayer);
        Log.d("videoFlow", "init is called");



        addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Log.d(TAG, "onScrollStateChanged: called.");
                    if (thumbnail != null) { // show the old thumbnail
                        thumbnail.setVisibility(VISIBLE);
                    }
                    Log.d("videoFlow", "playVideo from horizonatal change");
                    playVideo(currentVideo);


                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (playPosition == -1)
                {
                    playVideo(0);
                }
            }
        });

        addOnChildAttachStateChangeListener(new OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }


            @Override
            public void onChildViewDetachedFromWindow(View view) {
                //when the view is removed(video view which was playing before the current one) this method will be triggered
                if (viewHolderParent != null && viewHolderParent.equals(view)) {
                    resetVideoView();
                }

            }
        });

        videoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, @Nullable Object manifest, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                switch (playbackState) {

                    case Player.STATE_BUFFERING:
                        Log.e(TAG, "onPlayerStateChanged: Buffering video.");
                        if (progressBar != null) {
                            progressBar.setVisibility(VISIBLE);
                        }

                        break;
                    case Player.STATE_ENDED:
                        Log.d(TAG, "onPlayerStateChanged: Video ended.");
                        videoPlayer.seekTo(0);//play the video again
                        break;
                    case Player.STATE_IDLE:

                        break;
                    case Player.STATE_READY:
                        //when the video is ready to play after the buffering
                        Log.e(TAG, "onPlayerStateChanged: Ready to play.");
                        if (progressBar != null) {
                            progressBar.setVisibility(GONE);
                            Log.d("videoFlow","progress bar is gone");
                        }
                        Log.d("videoFlow","isVideoViewAdded"+isVideoViewAdded);
                        if (!isVideoViewAdded) {
                            addVideoView();
                            Log.d("videoFlow", "View has been resetted");
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity(int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekProcessed() {

            }
        });
    }

    public void playVideo(int number) {

        int targetPosition;

        int visiblePosition = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();

// Check if a valid position is found
        if (visiblePosition != RecyclerView.NO_POSITION) {
            targetPosition = visiblePosition;
        } else {
            // Handle the case when no item is visible (e.g., the RecyclerView is empty or not properly initialized)
            // You can set a default or fallback position as needed.
            targetPosition = -1; // Default to the first item or adjust accordingly.
        }

        Log.d(TAG, "playVideo: target position: " + targetPosition);
        Log.d("videoFlow", "playVideo: target position: " + targetPosition);
        Log.d("videoFlow", "playVideo: play position: " + playPosition);
        Log.d("videoFlow", "playVideo: currentVideo: " + currentVideo);

        // video is already playing so return
        if (targetPosition == playPosition) {
            Log.d("videoFlow", "Video is alredy playing");
            return;
        }

        // currentVideo = number;


        // set the position of the list-item that is to be played
        playPosition = targetPosition;
        if (videoSurfaceView == null) {
            return;
        }

        // remove any old surface views from previously playing videos
        videoSurfaceView.setVisibility(INVISIBLE);
        removeVideoView(videoSurfaceView);

        int currentPosition = targetPosition - ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();

        View child = getChildAt(currentPosition);
        if (child == null) {
            return;
        }

        VideoAdapter.VideoViewHolder holder = (VideoAdapter.VideoViewHolder) child.getTag();
        if (holder == null) {
            playPosition = -1;
            return;
        }
        thumbnail = holder.thumbnail;
        progressBar = holder.progressBar;
        viewHolderParent = holder.itemView;
        frameLayout = holder.itemView.findViewById(R.id.media_container);

        videoSurfaceView.setPlayer(videoPlayer);

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(
                context, Util.getUserAgent(context, "RecyclerView VideoPlayer"));
        int mediaUrl = mediaObjects.get(targetPosition).getVideoResId();
        // Uri videoUri = Uri.parse("android.resource://" + context.getPackageName() + "/" + mediaUrl);
        Uri videoUri = RawResourceDataSource.buildRawResourceUri(mediaUrl);
        MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(videoUri);
        videoPlayer.prepare(videoSource);
        videoPlayer.setPlayWhenReady(true);
        Log.d("videoFlow", "Video is played");
    }


    /**
     * Returns the visible region of the video surface on the screen.
     * if some is cut off, it will return less than the @videoSurfaceDefaultHeight
     *
     * @param playPosition
     * @return
     */
    private int getVisibleVideoSurfaceHeight(int playPosition) {
        int at = playPosition - ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        Log.d(TAG, "getVisibleVideoSurfaceHeight: at: " + at);

        View child = getChildAt(at);
        if (child == null) {
            return 0;
        }

        int[] location = new int[2];
        child.getLocationInWindow(location);

        if (location[1] < 0) {
            return location[1] + videoSurfaceDefaultHeight;
        } else {
            return screenDefaultHeight - location[1];
        }
    }


    // Remove the old player
    private void removeVideoView(PlayerView videoView) {
        ViewGroup parent = (ViewGroup) videoView.getParent();
        if (parent == null) {
            return;
        }

        int index = parent.indexOfChild(videoView);
        if (index >= 0) {
            parent.removeViewAt(index);
            isVideoViewAdded = false;
            Log.d("videoFlow", "View has been removed"+index);
//            viewHolderParent.setOnClickListener(null);
        }

    }

    private void addVideoView() {
        Log.d("videoFlow", "View has been added");
        frameLayout.addView(videoSurfaceView);
        isVideoViewAdded = true;
        videoSurfaceView.requestFocus();
        videoSurfaceView.setVisibility(VISIBLE);
        videoSurfaceView.setAlpha(1);
        thumbnail.setVisibility(GONE);
    }

    public void resetVideoView() {
        Log.d("videoFlow", "View has been resetted");
        if (isVideoViewAdded) {
            removeVideoView(videoSurfaceView);
            playPosition = -1;
            videoSurfaceView.setVisibility(INVISIBLE);
            thumbnail.setVisibility(VISIBLE);
        }
    }


    public void releasePlayer() {

        if (videoPlayer != null) {
            videoPlayer.release();
            videoPlayer = null;
        }
        Log.d("videoFlow","Player is released");

    //    viewHolderParent = null;
    }


    public void setMediaObjects(ArrayList<VideoItem> mediaObjects) {
        this.mediaObjects = mediaObjects;
    }

    // Implement a method to check if a view is fully visible
/*    private boolean isFullyVisible(View view) {
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        int visibleHeight = rect.bottom - rect.top;
        int viewHeight = view.getHeight();
        return visibleHeight == viewHeight;
    }*/

    // Pause the player and seek to the start position
    public void pauseAndSeekToStart() {
        if (videoPlayer != null) {
            videoPlayer.setPlayWhenReady(false);
            videoPlayer.seekTo(0);
        }
    }

    // Resume playback from the start position
   public void playFromStart() {
        if (videoPlayer != null) {
            videoPlayer.setPlayWhenReady(true);
            videoPlayer.seekTo(0);
        }
    }


    private boolean isFullyVisible(View view) {
        Rect itemRect = new Rect();
        view.getGlobalVisibleRect(itemRect);

        Rect recyclerRect = new Rect();
        getGlobalVisibleRect(recyclerRect);

        return itemRect.intersect(recyclerRect);
    }
}