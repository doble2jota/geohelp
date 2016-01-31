package com.example.javier.geohelp.Activities.Utils;

import android.util.Log;

/**
 * Created by javier on 30/01/2016.
 */
public class LogUtil {

   public static boolean printMesages=true;

    public static void d(String s1,String s2){
        if (printMesages){
            Log.d(s1,s2);
        }
    }
}
