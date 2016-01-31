package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.HomeView;
import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;

/**
 * Created by javier on 23/01/2016.
 */
public class HomePresenterImpl extends PresenterImpl implements Presenter,HomePresenter {

    private HomeView homeView;

    public HomePresenterImpl(HomeView homeView){
        this.homeView=homeView;
    }

    @Override
    public void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent) {

    }
}
