package com.example.userguideprototype;

import static com.example.userguideprototype.Utils.Utils.generateMainData;
import static com.example.userguideprototype.Utils.Utils.generateSampleMainTitleList;
import static com.example.userguideprototype.Utils.Utils.generateTitleData;
import static com.example.userguideprototype.models.MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.userguideprototype.adapters.DetailSection.MainAdapter;
import com.example.userguideprototype.adapters.MainTitleAdapter;
import com.example.userguideprototype.adapters.SubTitleAdapter;
import com.example.userguideprototype.adapters.TitleViewTypeAdapter;
import com.example.userguideprototype.models.MainData;

public class MainActivity extends AppCompatActivity implements SubTitleAdapter.OnSubTitleItemClickListener,TitleViewTypeAdapter.OnSubTitleItemViewTypeClickListener{
    private MainTitleAdapter titleAdapter;

    private TitleViewTypeAdapter titleViewTypeAdapter;
    private RecyclerView recyclerViewTitles;

    private MainAdapter mainAdapter;

    private RecyclerView mainRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        inializeVariables();
        setUpRecyclerView();
        setUpMainRecyclerView();

    }


    private void inializeVariables() {
        recyclerViewTitles = findViewById(R.id.recycler_view_titles);
        mainRecyclerView = findViewById(R.id.recyclerView_content);
        titleViewTypeAdapter = new TitleViewTypeAdapter(generateTitleData(),this);
        mainAdapter = new MainAdapter(this,mainRecyclerView);
    }

/*    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewTitles.setLayoutManager(layoutManager);
        recyclerViewTitles.setAdapter(titleAdapter);
        titleAdapter.setDataList(generateSampleMainTitleList());

    }*/

    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewTitles.setLayoutManager(layoutManager);
        recyclerViewTitles.setAdapter(titleViewTypeAdapter);
       // titleAdapter.setDataList(generateSampleMainTitleList());

    }

    private void setUpMainRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerView.setAdapter(mainAdapter);


        // Add an OnScrollListener to your RecyclerView
        mainRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                // Check if the VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW is fully visible
                int firstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();

                if (firstVisibleItemPosition != RecyclerView.NO_POSITION) {
                    // Get the item at the firstVisibleItemPosition
                    MainData item = mainAdapter.mainTitles.get(firstVisibleItemPosition);

                    if (item.getViewType() == VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW) {
                        // Your VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW is fully visible, call your method here
                    //    Log.d("videoFlow", "playVideo when the item is fully visible at position " + firstVisibleItemPosition);
                      //  mainAdapter.playVideo(firstVisibleItemPosition);
                    }
                }
            }
        });

        mainAdapter.setData(generateMainData());

    }


    @Override
    public void onSubTitleItemClick(String subTitle) {
        Log.d("MainActi","subtitle "+subTitle);
        mainAdapter.navigateToSubTitle(subTitle);
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
        mainAdapter.navigateToSubTitle(subTitle);
    }
}