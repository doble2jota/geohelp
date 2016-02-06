package com.example.javier.geohelp.Activities.Domain;

import android.util.Log;

import com.example.javier.geohelp.Activities.Entities.UserEntity;
import com.example.javier.geohelp.Activities.Interactors.Events.CreateUserEvent;
import com.example.javier.geohelp.Activities.Interactors.Events.UserEvent;
import com.example.javier.geohelp.Activities.Utils.GeoHelpConstans;
import com.example.javier.geohelp.Activities.Utils.LogUtil;
import com.example.javier.geohelp.Activities.Utils.SharedPref;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

import de.greenrobot.event.EventBus;

/**
 * Created by javier on 24/01/2016.
 */
public class LoginDomain {
    public final static String LOGOUT="LOGOUT_USER";

    private String URL_FIREBASE = GeoHelpConstans.URL_FIREBASE;
    private boolean responseCreation = false;
    private boolean responseLogin= false;

    Firebase firebase = new Firebase(URL_FIREBASE);


    public boolean createUser(final UserEntity userEntity){

        firebase.createUser(userEntity.getEmailUser(), userEntity.getPass(), new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                LogUtil.d("", "Successfully created user account with uid: " + result.get("uid"));
                userEntity.setUserUID(result.get("uid").toString());
                manageRegisterUser(userEntity);
                CreateUserEvent createUserEvent = new CreateUserEvent();
                createUserEvent.setTAG("");
                EventBus.getDefault().post(createUserEvent);
                saveUserPersistence(userEntity);
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

        firebase.authWithPassword(userEntity.getEmailUser(), userEntity.getPass(), new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                LogUtil.d("", "User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                LogUtil.d("UID", "" + authData.getUid().toString());
                manageRegisterUser(userEntity);
                UserEvent userEvent = new UserEvent();
                userEvent.setTAG("");
                EventBus.getDefault().post(userEvent);
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


    public boolean logoutUser(){
        SharedPref sharedPref = new SharedPref();
        sharedPref.preparePreferences(sharedPref.USER_DATA);

        if(sharedPref.existElement(GeoHelpConstans.USER_MAIL_PREFS)){
            sharedPref.removeAllPreferences();
            UserEvent userEvent = new UserEvent();
            userEvent.setTAG(LOGOUT);
            EventBus.getDefault().post(userEvent);
            return true;
        }else return false;
    }

    public boolean checkUserLogin(){
        SharedPref sharedPref = new SharedPref();
        sharedPref.preparePreferences(sharedPref.USER_DATA);
        if(sharedPref.existElement(GeoHelpConstans.USER_MAIL_PREFS)){
            UserEvent userEvent = new UserEvent();
            userEvent.setTAG("");
            EventBus.getDefault().post(userEvent);
            return true;
        }else return false;
    }

    private void manageRegisterUser(UserEntity userEntity){
        SharedPref sharedPref = new SharedPref();
        sharedPref.preparePreferences(sharedPref.USER_DATA);
        sharedPref.saveElement(GeoHelpConstans.USER_MAIL_PREFS, userEntity.getEmailUser());
        sharedPref.saveElement(GeoHelpConstans.PASS_PREFS, userEntity.getPass());
        sharedPref.saveElement(GeoHelpConstans.USER_UID, userEntity.getUserUID());
        sharedPref.commitPreferences();
    }


    private void saveUserPersistence(UserEntity userEntity){
        firebase = firebase.child("users").child(userEntity.getUserUID().toString());
        firebase.setValue(userEntity);
    }
}
