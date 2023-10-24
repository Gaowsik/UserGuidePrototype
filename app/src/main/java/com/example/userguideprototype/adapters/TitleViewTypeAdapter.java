package com.example.userguideprototype.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.MyItem;

import java.util.List;

public class TitleViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnSubTitleItemViewTypeClickListener {
        void onSubTitleViewTypeItemClick(String subTitle);
    }

    private List<MyItem> items;

    private OnSubTitleItemViewTypeClickListener itemClickListener;

    private int selectedSubtitleItemPosition = -1;

    public TitleViewTypeAdapter(List<MyItem> items, OnSubTitleItemViewTypeClickListener itemClickListener) {
        this.items = items;
        this.itemClickListener = itemClickListener;

    }

    public void setSelectedItemPosition(int position) {
        selectedSubtitleItemPosition = position;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        RecyclerView.ViewHolder viewHolder;

        if (viewType == MyItem.MAIN_TITLE) {
            view = inflater.inflate(R.layout.item_viewtype_main_title, parent, false);
            viewHolder = new MainTitleViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.item_viewtype_sub_title, parent, false);
            viewHolder = new SubtitleViewHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyItem item = items.get(position);

        if (holder instanceof MainTitleViewHolder) {
            MainTitleViewHolder titleHolder = (MainTitleViewHolder) holder;
            // Bind main title data
            titleHolder.textMainTitle.setText(item.getTitle());

            // Set an OnClickListener to toggle subtitle visibility
            titleHolder.imageExpandIcon.setOnClickListener(v -> {
                item.toggleVisibility(); // Update the visibility flag for subtitles
                notifyDataSetChanged(); // Refresh the view
            });
        } else if (holder instanceof SubtitleViewHolder) {


            SubtitleViewHolder subtitleHolder = (SubtitleViewHolder) holder;
            // Bind subtitle data
            subtitleHolder.textSubTitle.setText(item.getTitle());

            if (selectedSubtitleItemPosition == position) {
                // Change the background color to a different color when selected
                ((SubtitleViewHolder) holder).textSubTitle.setBackgroundResource(R.drawable.bg_title_on_click);
            } else {
                // Change the background back to normal state
                ((SubtitleViewHolder) holder).textSubTitle.setBackgroundColor(Color.TRANSPARENT);
            }

            subtitleHolder.textSubTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    itemClickListener.onSubTitleViewTypeItemClick(item.getTitle());
                    setSelectedItemPosition(position);

                }
            });

            // Set visibility based on the flag
            if (item.isHidden()) {
                subtitleHolder.textSubTitle.setVisibility(View.GONE);
            } else {
                subtitleHolder.textSubTitle.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }


}

class MainTitleViewHolder extends RecyclerView.ViewHolder {
    TextView textMainTitle;
    ImageView imageExpandIcon;

    ConstraintLayout layout;

    MainTitleViewHolder(@NonNull View itemView) {
        super(itemView);
        textMainTitle = itemView.findViewById(R.id.text_main_title_heading_viewtype);
        imageExpandIcon = itemView.findViewById(R.id.image_expand_icon);
        layout = itemView.findViewById(R.id.constraint_main_title_container_viewtype);
    }
}

class SubtitleViewHolder extends RecyclerView.ViewHolder {

    TextView textSubTitle;

    SubtitleViewHolder(@NonNull View itemView) {
        super(itemView);
        textSubTitle = itemView.findViewById(R.id.text_sub_title_nested_viewtype);
    }
}