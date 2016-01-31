package com.example.javier.geohelp.Activities.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by javier on 30/01/2016.
 */
public class SharedPref {

    Context context ;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public void preparePreferences(){

        context = GeoHelpApplication.get().getApplicationContext();
        prefs = context.getSharedPreferences("myPref", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }


    public void saveElement(String key,String value){
        editor.putString(key, value);
    }

    public void loadElement(String key, String value){
        String correo = prefs.getString(key, value);
    }

    public void commitPreferences(){
        editor.commit();
    }

    public boolean existElement(String key){
        return prefs.contains(key);
    }

}
