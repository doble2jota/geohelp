package com.example.javier.geohelp.Activities.Presenters;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by javier on 23/01/2016.
 */
public interface Presenter {

    void onCreate(Bundle bundle);
    void setActivity(Activity activity);
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
    void onEventMainThread();
    void finishActivity();
    Activity getActivity();
    void hideProgress();
}