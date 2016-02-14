package com.example.javier.geohelp.Activities.Domain;

import com.example.javier.geohelp.Activities.Entities.HelpTypeEntity;
import com.example.javier.geohelp.Activities.Interactors.Events.HelpTypeEvent;
import com.example.javier.geohelp.Activities.Utils.GeoHelpConstans;
import com.example.javier.geohelp.Activities.Utils.LogUtil;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by raquel on 14/02/2016.
 */
public class HelpTypeDomain {

    private String URL_FIREBASE = GeoHelpConstans.URL_FIREBASE;
    private String HELP_TYPES = GeoHelpConstans.HELP_TYPE;

    Firebase firebase = new Firebase(URL_FIREBASE);
    List<HelpTypeEntity> helpTypesList ;

    public List<HelpTypeEntity> getHelpTypes() {

        helpTypesList = new ArrayList<HelpTypeEntity>();
        firebase = firebase.child(HELP_TYPES);

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    HelpTypeEntity helpType = postSnapshot.getValue(HelpTypeEntity.class);
                    LogUtil.d("[HelTypeDomain]", helpType.getName() + " - " + helpType.getId());
                    helpTypesList.add(helpType);
                }
                HelpTypeEvent helpTypeEvent = new HelpTypeEvent();
                helpTypeEvent.setTAG("");
                helpTypeEvent.setHelpTypeEntityList(helpTypesList);
                EventBus.getDefault().post(helpTypeEvent);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                LogUtil.d("[HelTypeDomain]", firebaseError.getMessage());
            }
        });


        LogUtil.d("[HelTypeDomain]", helpTypesList.size() + "");
        return helpTypesList;
    }
}
