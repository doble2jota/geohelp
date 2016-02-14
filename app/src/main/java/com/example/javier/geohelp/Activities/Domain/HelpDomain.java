package com.example.javier.geohelp.Activities.Domain;

import com.example.javier.geohelp.Activities.Entities.HelpEntity;
import com.example.javier.geohelp.Activities.Interactors.Events.ListHelpEvent;
import com.example.javier.geohelp.Activities.Utils.GeoHelpConstans;
import com.example.javier.geohelp.R;
import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

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

    public boolean refreshList () {

        ListHelpEvent listHelpEvent = new ListHelpEvent();
        listHelpEvent.setTAG("");
        listHelpEvent.setHelpEntityList(poblateList());
        EventBus.getDefault().post(listHelpEvent);
        return true;

    }


    private List<HelpEntity> poblateList(){
        List<HelpEntity> listHelp= new ArrayList<HelpEntity>();
        HelpEntity helpEntity= new HelpEntity();
        helpEntity.setNombre("prueba1");
        helpEntity.setCategory("categoria 1");
        helpEntity.setIdImagen(R.drawable.ic_profile);
        listHelp.add(helpEntity);
        HelpEntity helpEntity2= new HelpEntity();
        helpEntity2.setNombre("prueba2");
        helpEntity2.setCategory("categoria2 ");
        helpEntity2.setIdImagen(R.drawable.ic_profile);
        listHelp.add(helpEntity2);

        return listHelp;
    }
}
