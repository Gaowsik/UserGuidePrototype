package com.example.userguideprototype.adapters.DetailSection;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.customView.VideoPlayerRecyclerView;
import com.example.userguideprototype.models.VideoDetailModel;
import com.example.userguideprototype.models.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class VideoDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_MAIN_TITLE = 0;
    private static final int VIEW_TYPE_SUBTITLE = 1;
    private static final int VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW = 2;

    private boolean hasNotifiedDataSetChanged = false;


    private final Context context;
    public List<VideoDetailModel> mainTitles; // List of items, where Object can be MainTitle, Subtitle, or List<ImageData>

    private RecyclerView mainRecyclerView;

    public VideoDetailAdapter(Context context, RecyclerView mainRecyclerView) {
        this.context = context;
        mainTitles = new ArrayList<>();
        this.mainRecyclerView = mainRecyclerView;
    }

    public void setData(List<VideoDetailModel> mainTitle) {
        this.mainTitles = mainTitle;
    }

    @Override
    public int getItemCount() {

        return mainTitles.size();
    }

    @Override
    public int getItemViewType(int position) {
        int viewtype = mainTitles.get(position).getViewType();

        switch (viewtype) {
            case 1:
                return VIEW_TYPE_MAIN_TITLE;
            case 2:
                return VIEW_TYPE_SUBTITLE;
            case 3:
                return VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;

        switch (viewType) {
            case VIEW_TYPE_MAIN_TITLE:
                view = inflater.inflate(R.layout.item_top_title, parent, false);
                return new MainTitleViewHolder(view);
            case VIEW_TYPE_SUBTITLE:
                view = inflater.inflate(R.layout.item_secondary_titles, parent, false);
                return new SubtitleViewHolder(view);
            case VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW:
                view = inflater.inflate(R.layout.item_video_data, parent, false);
                return new ImageRecyclerViewViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VideoDetailModel item = mainTitles.get(position);
        holder.setIsRecyclable(false);
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MAIN_TITLE:
                //((MainTitleViewHolder) holder).bindMainTitle(item);
                ((MainTitleViewHolder) holder).mainTitleTextView.setText(item.getTitle());
                break;
            case VIEW_TYPE_SUBTITLE:
                //((SubtitleViewHolder) holder).bindSubtitle(item);
                ((SubtitleViewHolder) holder).subtitleTextView.setText(item.getTitle());

                break;
            case VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW:
                hasNotifiedDataSetChanged = false;
                //((ImageRecyclerViewViewHolder) holder).playFromStart();
                ((ImageRecyclerViewViewHolder) holder).bindImageDataList(item);
                break;
        }
    }

    static class MainTitleViewHolder extends RecyclerView.ViewHolder {
        private TextView mainTitleTextView;

        MainTitleViewHolder(@NonNull View itemView) {
            super(itemView);
            mainTitleTextView = itemView.findViewById(R.id.text_main_title);
        }

        void bindMainTitle(VideoDetailModel mainTitle) {
            mainTitleTextView.setText(mainTitle.getTitle());
        }
    }

    static class SubtitleViewHolder extends RecyclerView.ViewHolder {
        private TextView subtitleTextView;

        SubtitleViewHolder(@NonNull View itemView) {
            super(itemView);
            subtitleTextView = itemView.findViewById(R.id.text_sub_title);
        }

        void bindSubtitle(VideoDetailModel subtitle) {
            subtitleTextView.setText(subtitle.getTitle());
        }
    }

    static class ImageRecyclerViewViewHolder extends RecyclerView.ViewHolder {

        private VideoAdapter videoAdapter;
        private VideoPlayerRecyclerView imageRecyclerView;


        ImageRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageRecyclerView = itemView.findViewById(R.id.recycler_video_item);
            videoAdapter = new VideoAdapter(); // You'll need to create this adapter for your images.
            imageRecyclerView.setAdapter(videoAdapter);
            imageRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        }

        void bindImageDataList(VideoDetailModel videoDataList) {
            videoAdapter.setVideoAdapterItems(videoDataList.getVideoItemList());
            imageRecyclerView.setMediaObjects((ArrayList<VideoItem>) videoDataList.getVideoItemList());
        }

        void releaseResource() {
            imageRecyclerView.releasePlayer();
        }

        void playFromStart(){
            imageRecyclerView.playFromStart();
        }
    }

    public void navigateToSubTitle(String subTitleName) {
        for (VideoDetailModel mainTitle : mainTitles) {
            if (mainTitle.getTitle() != null && mainTitle.getTitle().equals(subTitleName)) {
                int mainTitlePosition = mainTitles.indexOf(mainTitle);

                // Scroll to the MainTitle item with the LinearLayoutManager
                LinearLayoutManager layoutManager = (LinearLayoutManager) mainRecyclerView.getLayoutManager();
                layoutManager.scrollToPositionWithOffset(mainTitlePosition, 0); // You can adjust the offset as needed
                return; // Break out of the loop once found
            }
        }
    }

/*    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);

        if (holder instanceof ImageRecyclerViewViewHolder) {
            // Handle resource cleanup specific to your ImageRecyclerViewViewHolder here
            ((ImageRecyclerViewViewHolder) holder).releaseResource();
            Log.d("videoFlow","Player is released");
        }
    }*/

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);

        if (holder.getItemViewType() == VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW) {
            // Handle resource cleanup specific to your ImageRecyclerViewViewHolder here
            ((ImageRecyclerViewViewHolder) holder).releaseResource();
            Log.d("videoFlow", "Player is released : hasNotifiedDataSetChanged" + hasNotifiedDataSetChanged);
            if (!hasNotifiedDataSetChanged) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        notifyDataSetChanged();
                        hasNotifiedDataSetChanged= true;
                    }
                }, 1000);
            }
        }
    }

    public void playVideo(int number) {
/*        imageRecyclerView.resetVideoView();
        imageRecyclerView.playVideo(number);*/
    }


}