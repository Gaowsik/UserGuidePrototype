package com.example.userguideprototype;

import static com.example.userguideprototype.Utils.Utils.generateMainData;
import static com.example.userguideprototype.Utils.Utils.generateSampleMainTitleList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.userguideprototype.adapters.DetailSection.MainAdapter;
import com.example.userguideprototype.adapters.MainTitleAdapter;
import com.example.userguideprototype.adapters.SubTitleAdapter;

public class MainActivity extends AppCompatActivity implements SubTitleAdapter.OnSubTitleItemClickListener{
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
        adapter = new MainTitleAdapter(this);
        mainAdapter = new MainAdapter(this,mainRecyclerView);
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


    @Override
    public void onSubTitleItemClick(String subTitle) {
        Log.d("MainActi","subtitle "+subTitle);
        mainAdapter.navigateToSubTitle(subTitle);
    }
}