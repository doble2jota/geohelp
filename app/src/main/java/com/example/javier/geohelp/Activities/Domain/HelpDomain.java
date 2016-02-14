package com.example.javier.geohelp.Activities.Domain;

import com.example.javier.geohelp.Activities.Entities.HelpEntity;
import com.example.javier.geohelp.Activities.Utils.GeoHelpConstans;
import com.firebase.client.Firebase;

/**
 * Created by raquel on 13/02/2016.
 */
public class HelpDomain {

    private String URL_FIREBASE = GeoHelpConstans.URL_FIREBASE;
    private boolean responseCreation = false;
    private boolean responseLogin= false;

    Firebase firebase = new Firebase(URL_FIREBASE);

    public boolean createHelp(HelpEntity helpEntity) {

        try {
            firebase = firebase.child("helps").child(Integer.toString(helpEntity.getId()));
            firebase.setValue(helpEntity);
            return true;
        }catch (Exception ex) {
            return false;
        }

    }
}
