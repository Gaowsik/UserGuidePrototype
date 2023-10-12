package com.example.userguideprototype.Utils;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.MainTitle;
import com.example.userguideprototype.models.SubTitle;
import com.example.userguideprototype.models.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class Utils {



    public static List<MainTitle> generateSampleMainTitleList() {
        List<MainTitle> mainTitleList = new ArrayList<>();

        // Sample main titles with sub-items
        MainTitle mainTitle1 = new MainTitle("Main Title 1", generateSampleSubTitles(3,1));
        MainTitle mainTitle2 = new MainTitle("Main Title 2", generateSampleSubTitles(2,5));
        MainTitle mainTitle3 = new MainTitle("Main Title 3", generateSampleSubTitles(4,10));

        mainTitleList.add(mainTitle1);
        mainTitleList.add(mainTitle2);
        mainTitleList.add(mainTitle3);

        return mainTitleList;
    }

    private static List<SubTitle> generateSampleSubTitles(int count,int startingValue) {
        List<SubTitle> subTitles = new ArrayList<>();
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.a, "Video 1 Title","jijl"));
        videoItems.add(new VideoItem(R.raw.b, "Video 2 Title","sfs"));
        for (int i = startingValue; i <= count+startingValue; i++) {
            String subTitle = "Sub Title " + i;
            SubTitle subTitledata = new SubTitle(subTitle,videoItems);
            subTitles.add(subTitledata);
        }
        return subTitles;
    }

    // Static function to retrieve all subtitle lists from a list of MainTitle objects
/*    public static List<List<String>> getAllSubTitleLists(List<MainTitle> mainTitleList) {
        List<List<String>> allSubTitleLists = new ArrayList<>();
        for (MainTitle mainTitle : mainTitleList) {
            allSubTitleLists.add(mainTitle.getSubTitleList());
        }
        return allSubTitleLists;
    }*/


}
