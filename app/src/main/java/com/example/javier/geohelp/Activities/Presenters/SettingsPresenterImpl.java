package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.Domain.LoginDomain;
import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;
import com.example.javier.geohelp.Activities.Interactors.Events.UserEvent;
import com.example.javier.geohelp.Activities.Interactors.LogoutInteractor;
import com.example.javier.geohelp.Activities.SettingsView;

/**
 * Created by javier on 06/02/2016.
 */
public class SettingsPresenterImpl  extends PresenterImpl implements Presenter, SettingPresenter {

    private SettingsView settingsView;


    public SettingsPresenterImpl(SettingsView settingsView){
        this.settingsView=settingsView;
    }

    public void logoutUser(){
        new LogoutInteractor().execute();
    }
    @Override
    public void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent) {

    }

    public void onEventMainThread(UserEvent userEvent){
        if(userEvent.getTAG().equals(LoginDomain.LOGOUT)){

            settingsView.logoutUser();
        }
    }
}
