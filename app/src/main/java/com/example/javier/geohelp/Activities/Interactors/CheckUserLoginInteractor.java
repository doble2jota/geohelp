package com.example.javier.geohelp.Activities.Interactors;

import com.example.javier.geohelp.Activities.Domain.LoginDomain;

/**
 * Created by javier on 30/01/2016.
 */
public class CheckUserLoginInteractor  extends AbstractInteractor {


    public CheckUserLoginInteractor() {
    }

    @Override
    public void runOnBackground() {
        LoginDomain loginDomain = new LoginDomain();
        loginDomain.checkUserLogin();
    }
}