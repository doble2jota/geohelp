package com.example.javier.geohelp.Activities;

import android.widget.RelativeLayout;

import com.example.javier.geohelp.Activities.Entities.HelpTypeEntity;

import java.util.List;

/**
 * Created by raquel on 13/02/2016.
 */
public interface NeedHelpView {

    void startActivy();
    void finishActivy();
    void setHelpTypes(List<HelpTypeEntity> helpTypeEntityList);
    void populateHepTypesSpinner();

}
