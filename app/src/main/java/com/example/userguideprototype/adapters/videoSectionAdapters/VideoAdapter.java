package com.example.userguideprototype.adapters.videoSectionAdapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.SubTitle;
import com.example.userguideprototype.models.VideoItem;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_section_video_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoItem videoItem = videoItems.get(position);
        holder.descriptionTextView.setText(videoItem.getDescription());
        // Initialize ExoPlayer for this item
        holder.initializePlayer(videoItem.getVideoResId());
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private PlayerView playerView;

        private TextView descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerView = itemView.findViewById(R.id.playerView);
            descriptionTextView = itemView.findViewById(R.id.text_description);
        }

        public void initializePlayer(int videoResId) {
            player = new ExoPlayer.Builder(itemView.getContext()).build();
            playerView.setPlayer(player);

            // Create a resource URI for the video
            Uri videoUri = Uri.parse("android.resource://" + itemView.getContext().getPackageName() + "/" + videoResId);

            MediaItem mediaItem = MediaItem.fromUri(videoUri);
            player.setMediaItem(mediaItem);
            player.prepare();
            player.setPlayWhenReady(true);
        }

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