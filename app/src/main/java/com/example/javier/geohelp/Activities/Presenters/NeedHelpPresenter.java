package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;

/**
 * Created by raquel on 13/02/2016.
 */
public interface NeedHelpPresenter extends Presenter{

    void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent);
}
