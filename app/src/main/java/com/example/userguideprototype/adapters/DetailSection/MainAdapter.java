package com.example.userguideprototype.adapters.DetailSection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.MainData;
import com.example.userguideprototype.models.MainTitle;
import com.example.userguideprototype.models.SubTitle;
import com.example.userguideprototype.models.VideoItem;
import com.google.android.exoplayer2.text.Subtitle;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_MAIN_TITLE = 0;
    private static final int VIEW_TYPE_SUBTITLE = 1;
    private static final int VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW = 2;

    private final Context context;
    private List<MainData> mainTitles; // List of items, where Object can be MainTitle, Subtitle, or List<ImageData>

    private RecyclerView mainRecyclerView;

    public MainAdapter(Context context,RecyclerView mainRecyclerView) {
        this.context = context;
        mainTitles = new ArrayList<>();
        this.mainRecyclerView = mainRecyclerView;
    }

    public void setData(List<MainData> mainTitle) {
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
        MainData item = mainTitles.get(position);

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

        void bindMainTitle(MainData mainTitle) {
            mainTitleTextView.setText(mainTitle.getTitle());
        }
    }

    static class SubtitleViewHolder extends RecyclerView.ViewHolder {
        private TextView subtitleTextView;

        SubtitleViewHolder(@NonNull View itemView) {
            super(itemView);
            subtitleTextView = itemView.findViewById(R.id.text_sub_title);
        }

        void bindSubtitle(MainData subtitle) {
            subtitleTextView.setText(subtitle.getTitle());
        }
    }

    static class ImageRecyclerViewViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView imageRecyclerView;
        private VideoAdapter videoAdapter;

        ImageRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageRecyclerView = itemView.findViewById(R.id.recycler_video_item);
            videoAdapter = new VideoAdapter(); // You'll need to create this adapter for your images.
            imageRecyclerView.setAdapter(videoAdapter);
            imageRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        }

        void bindImageDataList(MainData videoDataList) {
            videoAdapter.setVideoAdapterItems(videoDataList.getVideoItemList());
        }
    }

    public void navigateToSubTitle(String subTitleName) {
        for (MainData mainTitle : mainTitles) {
            if (mainTitle.getTitle() != null && mainTitle.getTitle().equals(subTitleName)) {
                int mainTitlePosition = mainTitles.indexOf(mainTitle);

                // Scroll to the MainTitle item with the LinearLayoutManager
                LinearLayoutManager layoutManager = (LinearLayoutManager) mainRecyclerView.getLayoutManager();
                layoutManager.scrollToPositionWithOffset(mainTitlePosition, 0); // You can adjust the offset as needed
                return; // Break out of the loop once found
            }
        }
    }
}