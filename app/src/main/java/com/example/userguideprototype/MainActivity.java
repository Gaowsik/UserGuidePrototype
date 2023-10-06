package com.example.userguideprototype;

import static com.example.userguideprototype.Utils.Utils.generateSampleMainTitleList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.userguideprototype.adapters.MainTitleAdapter;

public class MainActivity extends AppCompatActivity {
    private MainTitleAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        inializeVariables();
        setUpRecyclerView();

    }


    private void inializeVariables() {
        recyclerView = findViewById(R.id.recycler_item);
        adapter = new MainTitleAdapter();
    }

    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setDataList(generateSampleMainTitleList());

    }


}