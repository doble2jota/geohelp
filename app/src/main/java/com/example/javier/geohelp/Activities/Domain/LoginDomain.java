package com.example.javier.geohelp.Activities.Domain;

import android.util.Log;

import com.example.javier.geohelp.Activities.Entities.UserEntity;
import com.example.javier.geohelp.Activities.Interactors.Events.UserEvent;
import com.example.javier.geohelp.Activities.Utils.EventBusUtil;
import com.example.javier.geohelp.Activities.Utils.GeoHelpConstans;
import com.example.javier.geohelp.Activities.Utils.LogUtil;
import com.example.javier.geohelp.Activities.Utils.SharedPref;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by javier on 24/01/2016.
 */
public class LoginDomain {

    private String URL_FIREBASE = GeoHelpConstans.URL_FIREBASE;
    private boolean responseCreation = false;
    private boolean responseLogin= false;

    Firebase firebase = new Firebase(URL_FIREBASE);


    public boolean createUser(final UserEntity userEntity){

        firebase.createUser(userEntity.getUserName(), userEntity.getPassName(), new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                LogUtil.d("", "Successfully created user account with uid: " + result.get("uid"));
                userEntity.setUserUID(result.get("uid").toString());
                manageRegisterUser(userEntity);
                UserEvent userEvent = new UserEvent();
                userEvent.setTAG("");
                EventBusUtil.postSticky(userEvent);
                responseCreation = true;
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                responseCreation = false;
                Log.d("", "ERROR DIME CUAL " + firebaseError.getDetails());
            }
        });


        return responseCreation;
    }
    public  boolean loginUser(final UserEntity userEntity){

        firebase.authWithPassword(userEntity.getUserName(), userEntity.getPassName(), new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                LogUtil.d("", "User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                LogUtil.d("UID",""+ authData.getUid().toString());
                manageRegisterUser(userEntity);
                UserEvent userEvent = new UserEvent();
                userEvent.setTAG("");
                EventBusUtil.postSticky(userEvent);
                responseLogin = true;
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                LogUtil.d("", "Successfully created user account with uid: " + firebaseError.getDetails());
                responseLogin = false;
            }
        });
        return responseLogin;
    }

    public boolean checkUserLogin(){
       SharedPref sharedPref = new SharedPref();
        sharedPref.preparePreferences();
        if(sharedPref.existElement(GeoHelpConstans.USER_MAIL_PREFS)){
            UserEvent userEvent = new UserEvent();
            userEvent.setTAG("");
            EventBusUtil.postSticky(userEvent);
            return true;
        }else return false;
    }

    private void manageRegisterUser(UserEntity userEntity){

        SharedPref sharedPref = new SharedPref();
        sharedPref.preparePreferences();
        sharedPref.saveElement(GeoHelpConstans.USER_MAIL_PREFS, userEntity.getUserName());
        sharedPref.saveElement(GeoHelpConstans.PASS_PREFS, userEntity.getPassName());
        sharedPref.saveElement(GeoHelpConstans.USER_UID, userEntity.getUserUID());

        sharedPref.commitPreferences();
    }

}
