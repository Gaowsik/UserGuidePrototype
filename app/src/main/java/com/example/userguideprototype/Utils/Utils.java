package com.example.userguideprototype.Utils;

import com.example.userguideprototype.R;
import com.example.userguideprototype.models.VideoDetailModel;
import com.example.userguideprototype.models.TitleModel;
import com.example.userguideprototype.models.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<VideoDetailModel> generateMainData() {
        List<VideoDetailModel> mainData = new ArrayList<>();


        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_MAIN_TITLE, "Introduction to Dashboard"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE, "Dashboard Overview"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW, getDashBoardOverViewVideoItems()));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE, "Areas"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW, getAreasVideoItems()));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE, "Modes"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW, getModelsVideoItems()));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE, "Presets"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW, getPresetsVideoItems()));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE, "Quick Action"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW, getQuickActionVideoItems()));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_MAIN_TITLE, "Creating an Area"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE, "Setting up Area Config"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW, getSettingUpAreaVideoItems()));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE, "Area Image Config"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW, getAreaImageConfigVideoItems()));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE, "Control Appliance"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW, getControlApplianceVideoItems()));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_MAIN_TITLE, "Modes"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE, "Create Mode"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW, getCreateModeVideoItems()));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_MAIN_TITLE, "Presets"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_SUBTITLE, "Create Preset"));
        mainData.add(new VideoDetailModel(VideoDetailModel.VIEW_TYPE_HORIZONTAL_IMAGE_RECYCLERVIEW, getPresetVideoItems()));


        return mainData;
    }


    public static List<TitleModel> generateTitleData() {
        List<TitleModel> mainData = new ArrayList<>();
        mainData.add(new TitleModel(TitleModel.MAIN_TITLE, "Introduction to Dashboard"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE, "Dashboard Overview"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE, "Areas"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE, "Modes"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE, "Presets"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE, "Quick Action"));
        mainData.add(new TitleModel(TitleModel.MAIN_TITLE, "Creating an Area"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE, "Setting up Area Config"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE, "Area Image Config"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE, "Control Appliance"));
        mainData.add(new TitleModel(TitleModel.MAIN_TITLE, "Modes"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE, "Create Mode"));
        mainData.add(new TitleModel(TitleModel.MAIN_TITLE, "Presets"));
        mainData.add(new TitleModel(TitleModel.SUB_TITLE, "Create Preset"));
        return mainData;
    }

    static List<VideoItem> getDashBoardOverViewVideoItems() {

        List<VideoItem> videoItemsDashBoardOverView = new ArrayList<>();
        videoItemsDashBoardOverView.add(new VideoItem(R.raw.introductiontodashboard_dashboardoverview_dashboardskeleton, "1", "The dashboard is the central hub for managing the assigned home or enterprise. It displays the overall status of the assigned areas and provides access to different functionalities such as areas, modes, presets, and quick actions."));
        videoItemsDashBoardOverView.add(new VideoItem(R.raw.introductiontodashboard_dashboardoverview_tempspotlight, "2", "The temperature display shows the high and low temperatures, which can be configured by the user in the Area Setup. This feature provides an overall view of the temperature status in the assigned home."));
        videoItemsDashBoardOverView.add(new VideoItem(R.raw.introductiontodashboard_dashboardoverview_areasspotlight, "3", "The \"Areas\" feature displays every assigned room, section, or area in the home. This feature provides a comprehensive overview of the status of each assigned area and allows the user to access and manage each one individually."));
        videoItemsDashBoardOverView.add(new VideoItem(R.raw.introductiontodashboard_dashboardoverview_modesspotlight, "4", "The Modes feature provides a convenient and efficient way to automate and simplify activities in the home or enterprise."));
        videoItemsDashBoardOverView.add(new VideoItem(R.raw.introductiontodashboard_dashboardoverview_presetsspotlight, "5", "A preset is a pre-configured set of conditions and outputs that can be easily executed to perform a specific task or function."));
        videoItemsDashBoardOverView.add(new VideoItem(R.raw.introductiontodashboard_dashboardoverview_quickactionspotlight, "6", "\"Quick Actions\" offers quick access to frequently used actions, moods, or presets."));
        videoItemsDashBoardOverView.add(new VideoItem(R.raw.introductiontodashboard_dashboardoverview_sidepanel, "7", "The \"Side Panel\" is a control panel that can be accessed in landscape mode on a phone or tablet by swiping from the left. The side panel provides quick access to various management and control options for the home or enterprise, allowing the user to easily discover new devices, create new areas, manage remote devices, and manage devices in general."));
        return videoItemsDashBoardOverView;
    }

    static List<VideoItem> getAreasVideoItems() {
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.introductiontodashboard_areas_areasone, "1", "The \"Areas\" feature provides a comprehensive overview of each assigned area in the home or enterprise. Each area is displayed as a tile, containing information about the area's motion detection, temperature, active devices, and cooling/heating status. The motion detection information allows the user to monitor the activity in each area and ensure that the environment is secure. The temperature display provides real-time information about the area's temperature, allowing the user to make adjustments as needed. The active devices information displays which devices are currently active and functioning in the area. The cooling/heating indication provides an at-a-glance view of the area's temperature control status, allowing the user to quickly determine if the area is being cooled or heated. The \"Areas\" feature provides a convenient and intuitive way to monitor and manage each assigned area in the home or enterprise."));
        videoItems.add(new VideoItem(R.raw.introductiontodashboard_areas_areastwo, "2", "The \"Areas\" feature provides a comprehensive overview of each assigned area in the home or enterprise. Each area is displayed as a tile, containing information about the area's motion detection, temperature, active devices, and cooling/heating status. The motion detection information allows the user to monitor the activity in each area and ensure that the environment is secure. The temperature display provides real-time information about the area's temperature, allowing the user to make adjustments as needed. The active devices information displays which devices are currently active and functioning in the area. The cooling/heating indication provides an at-a-glance view of the area's temperature control status, allowing the user to quickly determine if the area is being cooled or heated. The \"Areas\" feature provides a convenient and intuitive way to monitor and manage each assigned area in the home or enterprise."));
        return videoItems;
    }

    static List<VideoItem> getModelsVideoItems() {
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.introductiontodashboard_modes, "1", "The \"Modes\" feature allows the user to create unlimited custom modes, such as \"Movie Mode\", \"Reading Mode\", or \"Christmas Mode\". These modes enable the user to assign multiple devices to carry out a specific function with just one tap. For example, in \"Movie Mode\", the lights can be turned off/dimmed, the smart blinds can be closed, the air conditioner can be adjusted to the user's comfort level and the projector, audio system, and TV can be switched on. This feature provides a convenient way to automate and simplify various activities in the home or enterprise."));
        return videoItems;

    }

    static List<VideoItem> getPresetsVideoItems() {
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.introductiontodashboard_presets, "1", "Presets are a pre-configured set of conditions, inputs, and outputs that determine when and how certain actions are triggered in a system. For example, a preset can be created to automatically turn on lights when motion is detected or to set a certain temperature for a room at a specific time. By using presets, it is possible to automate various tasks and make the user's life easier and more convenient."));
        return videoItems;
    }

    static List<VideoItem> getQuickActionVideoItems() {
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.introductiontodashboard_quick_action, "1", "The \"Quick Actions\" feature displays the user's most frequent selections of individual actions, moods, or presets for easy access. This feature provides a quick and convenient way for the user to access and execute common tasks or activities without having to navigate through multiple menus or screens. The quick actions feature can be customized to meet the specific needs of the user and can be updated as the user's habits or preferences change over time."));
        return videoItems;
    }

    static List<VideoItem> getSettingUpAreaVideoItems() {
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.creatinganarea_settingupareaconfigfirst, "1", "Setting up an \"Area Configuration\" involves creating a custom configuration for a specific room or section in your home or enterprise. This includes entering the area name, setting a preferred temperature range, assigning a floor number, and adding a photo of the area. The grid setting can also be adjusted to better accommodate the number of devices in the room. Occupancy status and auto room navigation can also be set up in the area configuration to determine if there is an active presence in the room and controlling devices as the user walks into the room with a tablet or phone. The area configuration can be modified at any time to update the area name or temperature range."));
        videoItems.add(new VideoItem(R.raw.creatinganarea_settingupareaconfigsecond, "2", "Setting up an \"Area Configuration\" involves creating a custom configuration for a specific room or section in your home or enterprise. This includes entering the area name, setting a preferred temperature range, assigning a floor number, and adding a photo of the area. The grid setting can also be adjusted to better accommodate the number of devices in the room. Occupancy status and auto room navigation can also be set up in the area configuration to determine if there is an active presence in the room and controlling devices as the user walks into the room with a tablet or phone. The area configuration can be modified at any time to update the area name or temperature range."));
        videoItems.add(new VideoItem(R.raw.creatinganarea_settingupareaconfigthree, "3", "Setting up an \"Area Configuration\" involves creating a custom configuration for a specific room or section in your home or enterprise. This includes entering the area name, setting a preferred temperature range, assigning a floor number, and adding a photo of the area. The grid setting can also be adjusted to better accommodate the number of devices in the room. Occupancy status and auto room navigation can also be set up in the area configuration to determine if there is an active presence in the room and controlling devices as the user walks into the room with a tablet or phone. The area configuration can be modified at any time to update the area name or temperature range."));
        return videoItems;
    }


    static List<VideoItem> getAreaImageConfigVideoItems() {
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.creatinganarea_areaimageconfigone, "1", "Area Image Configuration allows you to assign devices in an area and control their actions through gestures. You can select a picture of the area, identify the devices and assign them a shape that best suits their form. You can then set up node actions and gestures to switch the device on or off. Feedback mode allows you to see the status of your devices and visually identify if they are on or off through shape and color coding. This configuration process helps you manage your devices efficiently."));
        videoItems.add(new VideoItem(R.raw.creatinganarea_areaimageconfig_area_image_configtwo, "1", "Area Image Configuration allows you to assign devices in an area and control their actions through gestures. You can select a picture of the area, identify the devices and assign them a shape that best suits their form. You can then set up node actions and gestures to switch the device on or off. Feedback mode allows you to see the status of your devices and visually identify if they are on or off through shape and color coding. This configuration process helps you manage your devices efficiently."));
        videoItems.add(new VideoItem(R.raw.creatinganarea_areaimageconfig_areaimageconfigthree, "1", "Area Image Configuration allows you to assign devices in an area and control their actions through gestures. You can select a picture of the area, identify the devices and assign them a shape that best suits their form. You can then set up node actions and gestures to switch the device on or off. Feedback mode allows you to see the status of your devices and visually identify if they are on or off through shape and color coding. This configuration process helps you manage your devices efficiently."));
        return videoItems;

    }


    static List<VideoItem> getControlApplianceVideoItems() {
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.createanarea_controlappliance_control_applianceone, "1", "With these features, you can easily control and turn on and off their appliances by simply tapping on the image in the app."));
        videoItems.add(new VideoItem(R.raw.createanarea_controlappliance_control_appliancetwo, "2", "With these features, you can easily control and turn on and off their appliances by simply tapping on the image in the app."));
        return videoItems;
    }

    static List<VideoItem> getCreateModeVideoItems() {
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.createmodeone, "1", "Creating a mode allows the user to set up different moods or scenarios for their assigned home/enterprise. The user can assign multiple devices to perform specific functions within one tap. For example, creating a \"Movie Mode\" could turn off/dim lights, close smart blinds, adjust the air conditioner, turn on the projector, audio system, and TV all in one action. The user can create unlimited modes to fit their specific needs."));
        videoItems.add(new VideoItem(R.raw.createmodetwo, "2", "Creating a mode allows the user to set up different moods or scenarios for their assigned home/enterprise. The user can assign multiple devices to perform specific functions within one tap. For example, creating a \"Movie Mode\" could turn off/dim lights, close smart blinds, adjust the air conditioner, turn on the projector, audio system, and TV all in one action. The user can create unlimited modes to fit their specific needs."));
        return videoItems;
    }

    static List<VideoItem> getPresetVideoItems() {
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.raw.createpresetone, "1", "Creating a preset typically involves specifying conditions, inputs, and outputs, and configuring these components to perform a specific task or set of tasks automatically. For example, a motion based lights preset might turn on a set of lights in response to a trigger event, such as occupancy or a specific time of day."));
        videoItems.add(new VideoItem(R.raw.createpresetstwo, "2", "Creating a preset typically involves specifying conditions, inputs, and outputs, and configuring these components to perform a specific task or set of tasks automatically. For example, a motion based lights preset might turn on a set of lights in response to a trigger event, such as occupancy or a specific time of day."));
        videoItems.add(new VideoItem(R.raw.createpresetsthree, "3", "Creating a preset typically involves specifying conditions, inputs, and outputs, and configuring these components to perform a specific task or set of tasks automatically. For example, a motion based lights preset might turn on a set of lights in response to a trigger event, such as occupancy or a specific time of day."));
        return videoItems;
    }

}
