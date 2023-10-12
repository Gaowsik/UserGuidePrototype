package com.example.userguideprototype;

import static com.example.userguideprototype.Utils.Utils.generateSampleMainTitleList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.userguideprototype.adapters.TitleAdapters.MainTitleAdapter;
import com.example.userguideprototype.adapters.TitleAdapters.SubTitleAdapter;
import com.example.userguideprototype.adapters.videoSectionAdapters.MainSectionAdapter;
import com.example.userguideprototype.models.MainTitle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SubTitleAdapter.OnSubTitleItemClickListener {
    private MainTitleAdapter adapter;

    private MainSectionAdapter mainSectionAdapter;
    private RecyclerView recyclerView;
    private RecyclerView subItemRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {
        inializeVariables();
        setUpRecyclerView();
        setUpSubItemRecyclerView();
        addRecyclerViewListener();

    }


    private void inializeVariables() {
        recyclerView = findViewById(R.id.recycler_item);
        subItemRecyclerView = findViewById(R.id.recyclerView_content);
        adapter = new MainTitleAdapter(this);
        mainSectionAdapter = new MainSectionAdapter(subItemRecyclerView);
    }

    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setDataList(generateSampleMainTitleList());

    }

    private void setUpSubItemRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        subItemRecyclerView.setLayoutManager(layoutManager);
        subItemRecyclerView.setAdapter(mainSectionAdapter);
        mainSectionAdapter.setDataList(generateSampleMainTitleList());

    }

    private void addRecyclerViewListener() {
/*       recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                // Detect the item that was clicked in the left RecyclerView
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if (childView != null) {
                    int position = rv.getChildAdapterPosition(childView);

                    // Determine the corresponding section or position in the right RecyclerView
                    int rightRecyclerViewPosition = position;

                    // Scroll the right RecyclerView to the specific section or position
                    LinearLayoutManager layoutManager = (LinearLayoutManager) subItemRecyclerView.getLayoutManager();
                    if (layoutManager != null) {
                        layoutManager.scrollToPosition(rightRecyclerViewPosition);
                    }
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });*/
    }


    @Override
    public void onSubTitleItemClick(String subTitle) {

        Log.d("MainActi","Subtitle clicked"+subTitle);
        //mainSectionAdapter.navigateToSubTitle(subTitle);
        mainSectionAdapter.navigateToSubTitle(subTitle);


    }
}