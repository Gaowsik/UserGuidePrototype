package com.example.userguideprototype.models;

import java.util.List;

public class SubTitle {
    String subTitle;
    private List<VideoItem> videoItemList;

    public SubTitle(String subTitle, List<VideoItem> videoItemList) {
        this.subTitle = subTitle;
        this.videoItemList = videoItemList;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public List<VideoItem> getvideoItemList() {
        return videoItemList;
    }

    public void setvideoItemList(List<VideoItem> videoItemList) {
        this.videoItemList = videoItemList;
    }


}