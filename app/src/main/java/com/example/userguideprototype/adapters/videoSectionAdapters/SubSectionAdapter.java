package com.example.userguideprototype.adapters.videoSectionAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.cutomRecyclerView.VideoPlayerRecyclerView;
import com.example.userguideprototype.models.SubTitle;
import com.example.userguideprototype.models.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class SubSectionAdapter extends RecyclerView.Adapter<SubSectionAdapter.SubSectionViewHolder> {
    private List<SubTitle> subTitles;

    public SubSectionAdapter() {
        subTitles = new ArrayList<>();
    }

    public void setSubTitles(List<SubTitle> subTitles) {
        this.subTitles = subTitles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SubSectionAdapter.SubSectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_section_detail, parent, false);
        return new SubSectionAdapter.SubSectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubSectionAdapter.SubSectionViewHolder holder, int position) {
        final SubTitle currentItem = subTitles.get(position);
        if (currentItem != null) {
            holder.subTitleTextView.setText(currentItem.getSubTitle());
            holder.recyclerViewVideoData.setMediaObjects(currentItem.getvideoItemList());
            holder.videoAdapter.setVideoAdapterItems(currentItem.getvideoItemList());
        }

    }

    @Override
    public int getItemCount() {
        return subTitles.size();
    }

    public class SubSectionViewHolder extends RecyclerView.ViewHolder {
        private TextView subTitleTextView;
        private VideoPlayerRecyclerView recyclerViewVideoData;
        private VideoAdapter videoAdapter;


        public SubSectionViewHolder(View itemView) {
            super(itemView);
            subTitleTextView = itemView.findViewById(R.id.section_title);
            recyclerViewVideoData = itemView.findViewById(R.id.recyclerView_video_data);
            videoAdapter = new VideoAdapter();
            recyclerViewVideoData.setAdapter(videoAdapter);
            recyclerViewVideoData.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        }
    }
}
