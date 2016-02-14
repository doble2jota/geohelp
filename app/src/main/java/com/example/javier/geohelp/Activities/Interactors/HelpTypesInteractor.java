package com.example.javier.geohelp.Activities.Interactors;

import com.example.javier.geohelp.Activities.Domain.HelpTypeDomain;
import com.example.javier.geohelp.Activities.Entities.HelpEntity;

/**
 * Created by raquel on 14/02/2016.
 */
public class HelpTypesInteractor  extends AbstractInteractor {



    @Override
    public void runOnBackground() {
        HelpTypeDomain helpTypeDomain = new HelpTypeDomain();
        helpTypeDomain.getHelpTypes();

    }
}
