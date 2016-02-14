package com.example.javier.geohelp.Activities;

import com.example.javier.geohelp.Activities.Entities.HelpEntity;
import com.example.javier.geohelp.Activities.Presenters.HelpSomeonePresenterImpl;

import java.util.List;

/**
 * Created by javier on 13/02/2016.
 */
public interface HelpSomeoneView {

    HelpSomeonePresenterImpl getPresenter();
    void getListEvent(List<HelpEntity> helpEntityList);

}
