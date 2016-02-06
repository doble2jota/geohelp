package com.example.javier.geohelp.Activities.Presenters;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import de.greenrobot.event.EventBus;

/**
 * Created by javier on 23/01/2016.
 */
public class PresenterImpl implements Presenter {
    private Activity activity;

    @Override
    public void onCreate(Bundle bundle) {
        EventBus.getDefault().register(this);
    }

    @Override
    public void setActivity(Activity activity) {
        this.activity=activity;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {
        if(EventBus.getDefault().isRegistered(this))return;
        EventBus.getDefault().register(this);
        Log.d("LifeCycle","onResume");
    }

    @Override
    public void onPause() {
        if(EventBus.getDefault().isRegistered(this))
        EventBus.getDefault().unregister(this);
        Log.d("LifeCycle","onPause");
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onEventMainThread() {

    }

    @Override
    public void finishActivity() {

    }

    @Override
    public Activity getActivity() {
        return activity;
    }

    @Override
    public void hideProgress() {

    }
}
