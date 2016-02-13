package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.HelpSomeoneView;
import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;

/**
 * Created by javier on 13/02/2016.
 */
public class HelpSomeonePresenterImpl extends PresenterImpl implements Presenter,HelpSomeonePresenter{

    private HelpSomeoneView helpSomeoneView;

    public HelpSomeonePresenterImpl(HelpSomeoneView helpSomeoneView) {
        this.helpSomeoneView = helpSomeoneView;
    }

    @Override
    public void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent) {

    }
}
