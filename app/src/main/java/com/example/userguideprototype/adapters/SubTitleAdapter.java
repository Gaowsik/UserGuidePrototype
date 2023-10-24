package com.example.userguideprototype.adapters;

import android.graphics.Color;
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

public class SubTitleAdapter extends RecyclerView.Adapter<SubTitleAdapter.SubTitleViewHolder> {

    public interface OnSubTitleItemClickListener {
        void onSubTitleItemClick(String subTitle);
    }

    private List<SubTitle> subTitles;

    private int selectedItemPosition = -1;
    int lastSelectedPosition = -1;

    public void setSelectedItemPosition(int position) {
        selectedItemPosition = position;
        notifyDataSetChanged();
    }

    private OnSubTitleItemClickListener itemClickListener;

    public SubTitleAdapter(OnSubTitleItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        subTitles = new ArrayList<>();
    }

    public void setSelectedSubtitle(String subtitle){
        notifyDataSetChanged();
    }

    public void setSubTitles(List<SubTitle> subTitles) {
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
        final SubTitle currentItem = subTitles.get(position);
        if (currentItem != null) {
            holder.subTitleTextView.setText(currentItem.getSubTitle());
            if (selectedItemPosition == position) {
                // Change the background color to a different color when selected
                holder.subTitleTextView.setBackgroundResource(R.drawable.bg_title_on_click);
            } else {
                // Change the background back to normal state
                holder.subTitleTextView.setBackgroundColor(Color.TRANSPARENT);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onSubTitleItemClick(currentItem.getSubTitle());
                    }
                  //  lastSelectedPosition = selectedItemPosition;
                 //   selectedItemPosition = holder.getAdapterPosition();
                   // notifyDataSetChanged();
                    setSelectedItemPosition(position);
                }
            });

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
            subTitleTextView = itemView.findViewById(R.id.text_sub_title_nested);
            // Set the selector drawable as the background
            subTitleTextView.setBackgroundResource(R.drawable.bg_title_on_click);
        }


    }

    public boolean doesSubTitleExist(List<SubTitle> subTitles, SubTitle subTitleToFind) {
        for (SubTitle subTitle : subTitles) {
            if (subTitle.equals(subTitleToFind)) {
                return true; // SubTitle exists in the list
            }
        }
        return false; // SubTitle does not exist in the list
    }
}
