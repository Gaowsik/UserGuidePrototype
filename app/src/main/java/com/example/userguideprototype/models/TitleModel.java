package com.example.userguideprototype.models;

public class TitleModel {
    public static final int MAIN_TITLE = 0;
    public static final int SUB_TITLE = 1;


    private int type; // Type of item (MAIN_TITLE or SUBTITLE)
    private boolean visible; // Flag to determine if the item is visible
    private String title; // Main title text


    public TitleModel(int type, String title) {
        this.type = type;
        this.title = title;
        // Initialize subtitle to an empty string
        this.visible = true; // By default, items are visible
    }

    // Getter and setter methods for type, visibility, title, and subtitle

    public boolean isHidden() {
        return !visible; // Subtitles are hidden when the visibility flag is false
    }

    public void toggleVisibility() {
        visible = !visible; // Toggle the visibility flag
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
