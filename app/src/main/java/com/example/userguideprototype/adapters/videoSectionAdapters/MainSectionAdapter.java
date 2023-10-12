package com.example.userguideprototype.adapters.videoSectionAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.MainTitle;
import com.example.userguideprototype.models.SubTitle;

import java.util.ArrayList;
import java.util.List;

public class MainSectionAdapter extends RecyclerView.Adapter<MainSectionAdapter.MainSectionViewHolder> {
    private List<MainTitle> mainTitleList;

    private RecyclerView mainRecyclerView;
    public MainSectionAdapter(RecyclerView mainRecyclerView) {
        mainTitleList = new ArrayList<>();
        this.mainRecyclerView = mainRecyclerView;
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

    public void navigateToSubTitle(String subTitleName) {
        for (MainTitle mainTitle : mainTitleList) {
            for (SubTitle subTitle : mainTitle.getSubTitleList()) {
                if (subTitle.getSubTitle().equals(subTitleName)) {
                    int mainTitlePosition = mainTitleList.indexOf(mainTitle);
                    int subTitlePosition = mainTitle.getSubTitleList().indexOf(subTitle);

                    // First, scroll the main RecyclerView to the MainTitle item
                    mainRecyclerView.scrollToPosition(mainTitlePosition);

                    // Then, scroll the sub-item RecyclerView within the MainTitle
                    MainSectionViewHolder mainViewHolder = (MainSectionViewHolder) mainRecyclerView
                            .findViewHolderForAdapterPosition(mainTitlePosition);
                    if (mainViewHolder != null) {
                        mainViewHolder.subItemRecyclerView.scrollToPosition(subTitlePosition);
                    }

                    return; // Break out of the loop once found
                }
            }
        }
    }
}

