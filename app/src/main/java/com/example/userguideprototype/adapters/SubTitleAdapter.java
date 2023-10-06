package com.example.userguideprototype.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;

import java.util.ArrayList;
import java.util.List;

public class SubTitleAdapter extends RecyclerView.Adapter<SubTitleAdapter.SubTitleViewHolder> {
    private List<String> subTitles;

    public SubTitleAdapter() {
        subTitles = new ArrayList<>();
    }

    public void setSubTitles(List<String> subTitles) {
        this.subTitles = subTitles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SubTitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_sub_titiles, parent, false);
        return new SubTitleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubTitleViewHolder holder, int position) {
        final String currentItem = subTitles.get(position);
        if (currentItem != null) {
            holder.subTitleTextView.setText(currentItem);
        }

    }

    @Override
    public int getItemCount() {
        return subTitles.size();
    }

    public class SubTitleViewHolder extends RecyclerView.ViewHolder {
        private TextView subTitleTextView;

        public SubTitleViewHolder(View itemView) {
            super(itemView);
            subTitleTextView = itemView.findViewById(R.id.sub_title);
        }
    }
}
