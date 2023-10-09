package com.example.userguideprototype.adapters.videoSectionAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.adapters.SubTitleAdapter;
import com.example.userguideprototype.models.MainTitle;

import java.util.ArrayList;
import java.util.List;

public class MainSectionAdapter extends RecyclerView.Adapter<MainSectionAdapter.MainSectionViewHolder> {
    private List<MainTitle> mainTitleList;

    public MainSectionAdapter() {
        mainTitleList = new ArrayList<>();
    }

    public void setDataList(List<MainTitle> mainTitleList) {
        this.mainTitleList.addAll(mainTitleList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainSectionAdapter.MainSectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_section, parent, false);
        return new MainSectionAdapter.MainSectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainSectionAdapter.MainSectionViewHolder holder, int position) {
        final MainTitle currentItem = (MainTitle) mainTitleList.get(position);

        holder.titleTextView.setText(currentItem.getTitle());
        MainTitle mainTitle = mainTitleList.get(position);
        holder.subSectionAdapter.setSubTitles(mainTitle.getSubTitleList());

    }

    @Override
    public int getItemCount() {
        return mainTitleList.size();
    }
    // Constructor and onCreateViewHolder, onBindViewHolder methods

    public class MainSectionViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private RecyclerView subItemRecyclerView;
        private SubSectionAdapter subSectionAdapter;

        public MainSectionViewHolder(View itemView) {
            super(itemView);
            subSectionAdapter = new SubSectionAdapter();
            titleTextView = itemView.findViewById(R.id.section_title);
            subItemRecyclerView = itemView.findViewById(R.id.recyclerview_video_content);
            subItemRecyclerView.setAdapter(subSectionAdapter);
            subItemRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));

        }
    }
}
