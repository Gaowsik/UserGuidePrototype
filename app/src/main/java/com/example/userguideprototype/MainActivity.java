package com.example.userguideprototype;

import static com.example.userguideprototype.Utils.Utils.generateMainData;
import static com.example.userguideprototype.Utils.Utils.generateTitleData;
import static com.example.userguideprototype.models.VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.userguideprototype.adapters.DetailSection.VideoDetailAdapter;
import com.example.userguideprototype.adapters.titleSection.TitleViewTypeAdapter;
import com.example.userguideprototype.models.VideoDetailModel;

public class MainActivity extends AppCompatActivity implements TitleViewTypeAdapter.OnSubTitleItemViewTypeClickListener {

    private TitleViewTypeAdapter titleViewTypeAdapter;
    private RecyclerView recyclerViewTitles;

    private VideoDetailAdapter videoDetailAdapter;

    private RecyclerView recylerViewVideoDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        inializeVariables();
        setUpTitleRecyclerView();
        setUpVideoRecyclerView();

    }


    private void inializeVariables() {
        recyclerViewTitles = findViewById(R.id.recycler_view_titles);
        recylerViewVideoDetails = findViewById(R.id.recyclerView_content);
        titleViewTypeAdapter = new TitleViewTypeAdapter(generateTitleData(), this);
        videoDetailAdapter = new VideoDetailAdapter(this, recylerViewVideoDetails);
    }

    private void setUpTitleRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewTitles.setLayoutManager(layoutManager);
        recyclerViewTitles.setAdapter(titleViewTypeAdapter);
        // titleAdapter.setDataList(generateSampleMainTitleList());

    }

    private void setUpVideoRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recylerViewVideoDetails.setLayoutManager(layoutManager);
        recylerViewVideoDetails.setAdapter(videoDetailAdapter);


        // Add an OnScrollListener to your RecyclerView
        recylerViewVideoDetails.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                // Check if the VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW is fully visible
                int firstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();

                if (firstVisibleItemPosition != RecyclerView.NO_POSITION) {
                    // Get the item at the firstVisibleItemPosition
                    VideoDetailModel item = videoDetailAdapter.mainTitles.get(firstVisibleItemPosition);

                    if (item.getViewType() == VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW) {
                  //     videoDetailAdapter.notifyDataSetChanged();
                        // Your VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW is fully visible, call your method here
                        //    Log.d("videoFlow", "playVideo when the item is fully visible at position " + firstVisibleItemPosition);
                    }
                }
            }
        });

        videoDetailAdapter.setData(generateMainData());

    }


    public boolean isFullyVisible(View itemView, RecyclerView recyclerView) {
        int[] itemLocation = new int[2];
        int[] recyclerLocation = new int[2];

        itemView.getLocationOnScreen(itemLocation);
        recyclerView.getLocationOnScreen(recyclerLocation);

        int itemTop = itemLocation[1];
        int itemBottom = itemTop + itemView.getHeight();

        int recyclerTop = recyclerLocation[1];
        int recyclerBottom = recyclerTop + recyclerView.getHeight();

        return itemTop >= recyclerTop && itemBottom <= recyclerBottom;
    }


    @Override
    public void onSubTitleViewTypeItemClick(String subTitle) {
        videoDetailAdapter.navigateToSubTitle(subTitle);
    }
}