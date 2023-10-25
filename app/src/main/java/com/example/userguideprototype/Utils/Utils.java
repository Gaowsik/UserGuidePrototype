package com.example.userguideprototype.Utils;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.VideoDetailModel;
import com.example.userguideprototype.models.TitleModel;
import com.example.userguideprototype.models.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class Utils
{
    public static List<VideoDetailModel> generateMainData(){
        List<VideoDetailModel> mainData = new ArrayList<>();
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.a, "Video 1 Title","jijl"));
        videoItems.add(new VideoItem(R.raw.b, "Video 2 Title","sfs"));

        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_MAIN_TITLE,"Main Title 1"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 1"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 2"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 3"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 4"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_MAIN_TITLE,"Main Title 2"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 5"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 6"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 7"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_MAIN_TITLE,"Main Title 3"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 10"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 11"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 12"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 13"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE,"Sub Title 14"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW,videoItems));

        return mainData;
    }


    public static List<TitleModel> generateTitleData(){
        List<TitleModel> mainData = new ArrayList<>();
        mainData.add(new TitleModel(TitleModel.MAIN_TITLE,"Main Title 1"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 1"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 2"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 3"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 4"));
        mainData.add(new TitleModel(TitleModel.MAIN_TITLE,"Main Title 2"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 5"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 6"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 7"));
        mainData.add(new TitleModel(TitleModel.MAIN_TITLE,"Main Title 3"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 10"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 11"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 12"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 13"));;
        mainData.add(new TitleModel(TitleModel.SUB_TITLE,"Sub Title 14"));
        return mainData;
    }



}
