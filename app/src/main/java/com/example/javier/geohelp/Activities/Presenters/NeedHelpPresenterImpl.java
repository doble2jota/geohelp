package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.Entities.HelpEntity;
import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;
import com.example.javier.geohelp.Activities.Interactors.Events.HelpTypeEvent;
import com.example.javier.geohelp.Activities.Interactors.HelpInteractor;
import com.example.javier.geohelp.Activities.Interactors.HelpTypesInteractor;
import com.example.javier.geohelp.Activities.NeedHelpView;
import com.example.javier.geohelp.Activities.Utils.LogUtil;

/**
 * Created by raquel on 13/02/2016.
 */
public class NeedHelpPresenterImpl extends PresenterImpl implements Presenter, NeedHelpPresenter {

    private NeedHelpView needHelpView;

    public NeedHelpPresenterImpl( NeedHelpView needHelpView){
        this.needHelpView=needHelpView;
    }

    @Override
    public void createHelp(String name, String description, String category, String latString, String longString) {
        //TODO cambiar la manera de crear la entidad, no le pasamos todos los parametros;
        HelpEntity helpEntity = new HelpEntity();
        helpEntity.setNombre(name);
        helpEntity.setDescripción(description);
        helpEntity.setCategory(category);
        new HelpInteractor(helpEntity).execute();
    }


    @Override
    public void getHelpTypeEntityList() {
        new HelpTypesInteractor().execute();
    }

    @Override
    public void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent) {

    }


    public void onEventMainThread(HelpTypeEvent helpTypeEvent){
        needHelpView.setHelpTypes(helpTypeEvent.getHelpTypeEntityList());
        needHelpView.populateHepTypesSpinner();
    }


}
