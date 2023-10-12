package com.example.userguideprototype;

import static com.example.userguideprototype.Utils.Utils.generateMainData;
import static com.example.userguideprototype.Utils.Utils.generateSampleMainTitleList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.userguideprototype.adapters.DetailSection.MainAdapter;
import com.example.userguideprototype.adapters.MainTitleAdapter;

public class MainActivity extends AppCompatActivity {
    private MainTitleAdapter adapter;
    private RecyclerView recyclerView;

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
        recyclerView = findViewById(R.id.recycler_item);
        mainRecyclerView = findViewById(R.id.recyclerView_content);
        adapter = new MainTitleAdapter();
        mainAdapter = new MainAdapter(this);
    }

    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setDataList(generateSampleMainTitleList());

    }

    private void setUpMainRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerView.setAdapter(mainAdapter);
        mainAdapter.setData(generateMainData());

    }


}