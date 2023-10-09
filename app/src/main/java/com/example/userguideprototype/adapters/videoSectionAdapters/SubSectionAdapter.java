package com.example.userguideprototype.adapters.videoSectionAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.SubTitle;

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
    public void onBindViewHolder(@NonNull SubSectionAdapter.SubSectionViewHolder  holder, int position) {
        final SubTitle currentItem = subTitles.get(position);
        if (currentItem != null) {
            holder.subTitleTextView.setText(currentItem.getSubTitle());
            
        }

    }

    @Override
    public int getItemCount() {
        return subTitles.size();
    }

    public class SubSectionViewHolder extends RecyclerView.ViewHolder {
        private TextView subTitleTextView;


        public SubSectionViewHolder(View itemView) {
            super(itemView);
            subTitleTextView = itemView.findViewById(R.id.section_title);
        }
    }
}
