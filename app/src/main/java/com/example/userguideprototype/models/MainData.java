package com.example.userguideprototype.models;

import java.util.List;

public class MainData {
    public static final int VIEW_TYPE_MAIN_TITLE =1;
    public static final int VIEW_TYPE_SUBTITLE=2;
    public static final int VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW = 3;

    private final int viewType;
    private String title;
    private List<VideoItem> videoItemList;

    public MainData(int viewType, String title) {
        this.viewType = viewType;
        this.title = title;
    }

    public MainData(int viewType, List<VideoItem> videoItemList) {
        this.viewType = viewType;
        this.videoItemList = videoItemList;
    }

    public int getViewType() {
        return viewType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<VideoItem> getVideoItemList() {
        return videoItemList;
    }

    public void setVideoItemList(List<VideoItem> videoItemList) {
        this.videoItemList = videoItemList;
    }
}
