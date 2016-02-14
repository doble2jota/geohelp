package com.example.javier.geohelp.Activities.Domain;

import com.example.javier.geohelp.Activities.Entities.HelpEntity;
import com.example.javier.geohelp.Activities.Interactors.Events.ListHelpEvent;
import com.example.javier.geohelp.Activities.Utils.GeoHelpConstans;
import com.example.javier.geohelp.Activities.Utils.LogUtil;
import com.example.javier.geohelp.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

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

    public boolean createHelp(final HelpEntity helpEntity) {

        try {
            //Buscamos el maximo identificado en firebase
            firebase = firebase.child(GeoHelpConstans.HELPS);
            Query queryRef = firebase.orderByKey().limitToLast(1);
            queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getChildrenCount() == 0) {
                        LogUtil.d("[HelTypeDomain]", "MAX ID: " + 1);
                        helpEntity.setId(1);
                        firebase.child(Integer.toString(helpEntity.getId())).setValue(helpEntity);
                    }
                    else {
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            HelpEntity maxHelp = postSnapshot.getValue(HelpEntity.class);
                            LogUtil.d("[HelTypeDomain]", "MAX ID: " + maxHelp.getId());
                            helpEntity.setId(maxHelp.getId()+1);
                            firebase.child(Integer.toString(helpEntity.getId())).setValue(helpEntity);
                        }
                    }

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    LogUtil.e("[HelpDomain:createHelp]", firebaseError.getMessage());
                    //TODO mostrar error, devolver

                }
            });


            return false;
        }catch (Exception ex) {
            return false;
        }

    }

    public boolean refreshList () {

        final List<HelpEntity> listHelpEntity= new ArrayList<>();
        try {
            //Buscamos el maximo identificado en firebase
            firebase = firebase.child(GeoHelpConstans.HELPS);
            Query queryRef = firebase.orderByKey();
            queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        listHelpEntity.add(postSnapshot.getValue(HelpEntity.class));
                    }
                    ListHelpEvent listHelpEvent = new ListHelpEvent();
                    listHelpEvent.setTAG("");
                    listHelpEvent.setHelpEntityList(listHelpEntity);
                    EventBus.getDefault().post(listHelpEvent);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    LogUtil.e("[HelpDomain:refreshList]", firebaseError.getMessage());
                }
            });


            return false;
        }catch (Exception ex) {
            return false;
        }



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
