package com.example.userguideprototype.adapters.TitleAdapters;

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
    private OnSubTitleItemClickListener itemClickListener;

    public SubTitleAdapter(OnSubTitleItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        subTitles = new ArrayList<>();
    }

    public void setSubTitles(List<SubTitle> subTitles) {
        this.subTitles = subTitles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SubTitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_section_titiles, parent, false);
        return new SubTitleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubTitleViewHolder holder, int position) {
        final SubTitle currentItem = subTitles.get(position);
        if (currentItem != null) {
            holder.subTitleTextView.setText(currentItem.getSubTitle());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onSubTitleItemClick(currentItem.getSubTitle());
                    }
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
            subTitleTextView = itemView.findViewById(R.id.sub_title);
        }
    }
}
