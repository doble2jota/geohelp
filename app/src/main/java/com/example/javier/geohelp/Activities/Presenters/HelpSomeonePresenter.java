package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;

/**
 * Created by javier on 13/02/2016.
 */
public interface HelpSomeonePresenter extends Presenter {

    void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent);

}
