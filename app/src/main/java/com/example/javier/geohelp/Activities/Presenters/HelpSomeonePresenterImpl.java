package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.Entities.HelpEntity;
import com.example.javier.geohelp.Activities.HelpSomeoneView;
import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;
import com.example.javier.geohelp.Activities.Interactors.Events.ListHelpEvent;
import com.example.javier.geohelp.Activities.Interactors.refreshListInteractor;

import java.util.List;

/**
 * Created by javier on 13/02/2016.
 */
public class HelpSomeonePresenterImpl extends PresenterImpl implements Presenter,HelpSomeonePresenter{

    private HelpSomeoneView helpSomeoneView;

    public HelpSomeonePresenterImpl() {
    }


    public void refreshItems(){
        new refreshListInteractor().execute();
    }

    @Override
    public void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent) {

    }
    public void onEventMainThread(ListHelpEvent ListHelpEvent){
       List <HelpEntity> helpEntities= ListHelpEvent.getHelpEntityList();
       helpSomeoneView.getListEvent(helpEntities);
    }

    public void setView(HelpSomeoneView view) {
        this.helpSomeoneView = view;
    }
}
