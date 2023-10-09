package com.example.userguideprototype;

import static com.example.userguideprototype.Utils.Utils.generateSampleMainTitleList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.userguideprototype.adapters.TitleAdapters.MainTitleAdapter;
import com.example.userguideprototype.adapters.videoSectionAdapters.MainSectionAdapter;

public class MainActivity extends AppCompatActivity {
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

    }


    private void inializeVariables() {
        recyclerView = findViewById(R.id.recycler_item);
        subItemRecyclerView = findViewById(R.id.recyclerView_content);
        adapter = new MainTitleAdapter();
        mainSectionAdapter = new MainSectionAdapter();
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


}