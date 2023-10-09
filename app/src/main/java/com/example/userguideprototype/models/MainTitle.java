package com.example.userguideprototype.models;

import java.util.List;

public class MainTitle {

    private String title;
    private List<SubTitle> subTitleList;
    private boolean isExpanded;

    public MainTitle(String title, List<SubTitle> subTitleList) {
        this.title = title;
        this.subTitleList = subTitleList;
        this.isExpanded = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubTitle> getSubTitleList() {
        return subTitleList;
    }

    public void setSubTitleList(List<SubTitle> subTitleList) {
        this.subTitleList = subTitleList;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }


}
