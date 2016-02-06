package com.example.javier.geohelp.Activities.Interactors;

import com.example.javier.geohelp.Activities.Domain.LoginDomain;

/**
 * Created by javier on 06/02/2016.
 */
public class LogoutInteractor extends AbstractInteractor{

    public void LoginInteractor(){
    }

    @Override
    public void runOnBackground() {
        LoginDomain loginDomain = new LoginDomain();
        loginDomain.logoutUser();
    }
}
