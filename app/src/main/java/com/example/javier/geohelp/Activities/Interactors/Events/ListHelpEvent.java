package com.example.javier.geohelp.Activities.Interactors.Events;

import com.example.javier.geohelp.Activities.Entities.HelpEntity;

import java.util.List;

/**
 * Created by javier on 14/02/2016.
 */
public class ListHelpEvent extends BaseEvent {

    private String TAG;
    private boolean recoverinSucceded;
    public List<HelpEntity> helpEntityList;

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public boolean isRecoverinSucceded() {
        return recoverinSucceded;
    }

    public void setRecoverinSucceded(boolean recoverinSucceded) {
        this.recoverinSucceded = recoverinSucceded;
    }

    public List<HelpEntity> getHelpEntityList() {
        return helpEntityList;
    }

    public void setHelpEntityList(List<HelpEntity> helpEntityList) {
        this.helpEntityList = helpEntityList;
    }
}