package com.example.userguideprototype.adapters.TitleAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.MainTitle;

import java.util.ArrayList;
import java.util.List;

public class MainTitleAdapter extends RecyclerView.Adapter<MainTitleAdapter.MainTitleViewHolder> {
    private List<MainTitle> mainTitleList;

    public MainTitleAdapter() {
       mainTitleList = new ArrayList<>();
    }

    public void setDataList(List<MainTitle> mainTitleList) {
        this.mainTitleList.addAll(mainTitleList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainTitleAdapter.MainTitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_main_title, parent, false);
        return new MainTitleAdapter.MainTitleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainTitleViewHolder holder, int position) {
        final MainTitle currentItem = (MainTitle) mainTitleList.get(position);

        holder.titleTextView.setText(currentItem.getTitle());

        if (currentItem.isExpanded()) {
            holder.subItemRecyclerView.setVisibility(View.VISIBLE);
        } else {
            holder.subItemRecyclerView.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return mainTitleList.size();
    }
    // Constructor and onCreateViewHolder, onBindViewHolder methods

    public class MainTitleViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private RecyclerView subItemRecyclerView;
        private SubTitleAdapter subTitleAdapter;

        public MainTitleViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.main_title);
            subItemRecyclerView = itemView.findViewById(R.id.sub_item_recycler_view);
            // Initialize subItemRecyclerView and set its layout manager
            subItemRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            // Initialize subTitleAdapter and set it on subItemRecyclerView
            subTitleAdapter = new SubTitleAdapter();
            subItemRecyclerView.setAdapter(subTitleAdapter);

            // Handle clicks on the main title to toggle sub-items visibility
            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        MainTitle mainTitle = mainTitleList.get(position);
                        mainTitle.setExpanded(!mainTitle.isExpanded());
                        subTitleAdapter.setSubTitles(mainTitle.getSubTitleList());
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
