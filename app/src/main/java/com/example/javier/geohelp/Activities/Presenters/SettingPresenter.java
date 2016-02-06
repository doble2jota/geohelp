package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;
import com.example.javier.geohelp.Activities.Interactors.Events.UserEvent;

/**
 * Created by javier on 06/02/2016.
 */
public interface SettingPresenter extends Presenter {

    void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent);

    void onEventMainThread(UserEvent userEvent);
}
