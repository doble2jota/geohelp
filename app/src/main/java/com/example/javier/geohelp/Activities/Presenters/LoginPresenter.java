package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;

/**
 * Created by javier on 30/01/2016.
 */
public interface LoginPresenter  extends Presenter {
    void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent);
}
