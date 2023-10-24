package com.example.userguideprototype.Utils;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.MainData;
import com.example.userguideprototype.models.MainTitle;
import com.example.userguideprototype.models.MyItem;
import com.example.userguideprototype.models.SubTitle;
import com.example.userguideprototype.models.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class Utils
{

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


    public static List<MainData> generateMainData(){
        List<MainData> mainData = new ArrayList<>();
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.a, "Video 1 Title","jijl"));
        videoItems.add(new VideoItem(R.raw.b, "Video 2 Title","sfs"));

        mainData.add(new MainData(MainData.VIEW_TYPE_MAIN_TITLE,"Main Title 1"));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 1"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 2"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 3"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 4"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_MAIN_TITLE,"Main Title 2"));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 5"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 6"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 7"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_MAIN_TITLE,"Main Title 3"));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 10"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 11"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 12"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 13"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new MainData(MainData.VIEW_TYPE_SUBTITLE,"Sub Title 14"));
        mainData.add(new MainData(MainData.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));

        return mainData;
    }


    public static List<MyItem> generateTitleData(){
        List<MyItem> mainData = new ArrayList<>();
        mainData.add(new MyItem(MyItem.MAIN_TITLE,"Main Title 1"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 1"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 2"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 3"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 4"));
        mainData.add(new MyItem(MyItem.MAIN_TITLE,"Main Title 2"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 5"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 6"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 7"));
        mainData.add(new MyItem(MyItem.MAIN_TITLE,"Main Title 3"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 10"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 11"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 12"));
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 13"));;
        mainData.add(new MyItem(MyItem.SUB_TITLE,"Sub Title 14"));
        return mainData;
    }



}
