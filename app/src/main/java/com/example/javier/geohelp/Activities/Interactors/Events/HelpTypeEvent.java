package com.example.javier.geohelp.Activities.Interactors.Events;

import com.example.javier.geohelp.Activities.Entities.HelpTypeEntity;

import java.util.List;

/**
 * Created by raquel on 14/02/2016.
 */
public class HelpTypeEvent extends BaseEvent{

    private String TAG;
    private List<HelpTypeEntity> helpTypeEntityList;

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }


    public List<HelpTypeEntity> getHelpTypeEntityList() {
        return helpTypeEntityList;
    }

    public void setHelpTypeEntityList(List<HelpTypeEntity> helpTypeEntityList) {
        this.helpTypeEntityList = helpTypeEntityList;
    }


}
