package com.example.javier.geohelp.Activities.Interactors.Events;

/**
 * Created by javier on 31/01/2016.
 */
public class CreateUserEvent extends BaseEvent {

    private String TAG;
    private boolean recoverinSucceded;

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
}