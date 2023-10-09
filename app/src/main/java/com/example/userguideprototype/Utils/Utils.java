package com.example.userguideprototype.Utils;

import com.example.userguideprototype.models.MainTitle;

import java.util.ArrayList;
import java.util.List;

public class Utils
{

    public static List<MainTitle> generateSampleMainTitleList() {
        List<MainTitle> mainTitleList = new ArrayList<>();

        // Sample main titles with sub-items
        MainTitle mainTitle1 = new MainTitle("Main Title 1", generateSampleSubTitles(3));
        MainTitle mainTitle2 = new MainTitle("Main Title 2", generateSampleSubTitles(2));
        MainTitle mainTitle3 = new MainTitle("Main Title 3", generateSampleSubTitles(4));

        mainTitleList.add(mainTitle1);
        mainTitleList.add(mainTitle2);
        mainTitleList.add(mainTitle3);

        return mainTitleList;
    }

    private static List<String> generateSampleSubTitles(int count) {
        List<String> subTitles = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            String subTitle ="Sub Title "+i;
            subTitles.add(subTitle);
        }
        return subTitles;
    }

    // Static function to retrieve all subtitle lists from a list of MainTitle objects
    public static List<List<String>> getAllSubTitleLists(List<MainTitle> mainTitleList) {
        List<List<String>> allSubTitleLists = new ArrayList<>();
        for (MainTitle mainTitle : mainTitleList) {
            allSubTitleLists.add(mainTitle.getSubTitleList());
        }
        return allSubTitleLists;
    }


}
