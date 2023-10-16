package com.example.userguideprototype.adapters.DetailSection;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.VideoItem;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private List<VideoItem> videoItems;
    private ExoPlayer player;

    public VideoAdapter() {
        videoItems = new ArrayList<>();
    }

    public void setVideoAdapterItems(List<VideoItem> videoItems) {

        this.videoItems.addAll(videoItems);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_section_detail, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.itemView.setTag(holder);
        VideoItem videoItem = videoItems.get(position);
        holder.descriptionTextView.setText(videoItem.getDescription());
        // Initialize ExoPlayer for this item
        // holder.initializePlayer(videoItem.getVideoResId());
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        //  private PlayerView playerView;
        FrameLayout media_container;
        public ProgressBar progressBar;
        View parent;
        private TextView descriptionTextView;
        public ImageView thumbnail;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            //     playerView = itemView.findViewById(R.id.playerView);
            parent = itemView;
            media_container = itemView.findViewById(R.id.media_container);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            progressBar = itemView.findViewById(R.id.progressBar);
            descriptionTextView = itemView.findViewById(R.id.text_video_description);
        }

 /*       public void initializePlayer(int videoResId) {
            player = new ExoPlayer.Builder(itemView.getContext()).build();
            playerView.setUseController(false);
          //  player.setRepeatMode(Player.REPEAT_MODE_ALL);
            playerView.setPlayer(player);


            // Create a resource URI for the video
            Uri videoUri = Uri.parse("android.resource://" + itemView.getContext().getPackageName() + "/" + videoResId);

            MediaItem mediaItem = MediaItem.fromUri(videoUri);
            player.setMediaItem(mediaItem);
            player.prepare();
            player.setPlayWhenReady(true);
        }*/

/*        public void initializePlayerForStreaming(String videoUrl) {
            player = new ExoPlayer.Builder(itemView.getContext()).build();
            playerView.setPlayer(player);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            player.setMediaItem(mediaItem);
            player.prepare();
            player.setPlayWhenReady(true);
        }*/
    }
}