package com.example.javier.geohelp.Activities.Interactors;

import com.example.javier.geohelp.Activities.Domain.HelpDomain;

/**
 * Created by javier on 14/02/2016.
 */
public class refreshListInteractor extends AbstractInteractor{

    public refreshListInteractor(){

    }

    @Override
    public void runOnBackground() {

        HelpDomain helpDomain = new HelpDomain();
        helpDomain.refreshList();
    }

}
