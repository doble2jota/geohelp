package com.example.javier.geohelp.Activities.Interactors;

import com.example.javier.geohelp.Activities.Domain.HelpDomain;
import com.example.javier.geohelp.Activities.Entities.HelpEntity;

/**
 * Created by raquel on 14/02/2016.
 */
public class HelpInteractor  extends AbstractInteractor {

    private HelpEntity helpEntity;

    public HelpInteractor(HelpEntity helpEntity) {
        this.helpEntity = helpEntity;
    }

    @Override
    public void runOnBackground() {
        HelpDomain helpDomain = new HelpDomain();
        helpDomain.createHelp(helpEntity);
    }
}
