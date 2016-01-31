package com.example.javier.geohelp.Activities.Interactors.Events;

/**
 * Created by javier on 23/01/2016.
 */
public class HomeEvent extends BaseEvent{
    public static final String EVENT_SEARCH_COMPANY_TAG = "SEARCH_COMPANY";
    public static final String EVENT_UPDATE_COMPANY_TAG = "UPDATE_COMPANY";

    private String TAG;

    public HomeEvent(){
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }
}
