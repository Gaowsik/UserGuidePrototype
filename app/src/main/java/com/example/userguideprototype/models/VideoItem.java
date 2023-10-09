package com.example.userguideprototype.models;

public class VideoItem {
    private int videoResId;
    private String title;

    private String description;

    public VideoItem(int videoResId, String title, String description) {
        this.videoResId = videoResId;
        this.title = title;
        this.description = description;
    }

    public void setVideoResId(int videoResId) {
        this.videoResId = videoResId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getVideoResId() {
        return videoResId;
    }

    public String getTitle() {
        return title;
    }
}
