package com.example.javier.geohelp.Activities.Utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.multidex.MultiDex;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.orm.SugarApp;
import com.path.android.jobqueue.JobManager;

/**
 * Created by javier on 24/01/2016.
 */
public class GeoHelpApplication extends SugarApp{

    public static boolean isQueueWorking = false;
    public static boolean isTicketsQueueWorking = false;
    public static boolean isCustomersQueueWorking = false;

    public static boolean isMyCall = false;

    private static Context instance;
    private static int displayWidth;
    private static int displayHeight;
    private static JobManager jobManager;
    private static Context context;
    public static LocationManager locationManager;


    public static int getDisplayWidth() {
        return displayWidth;
    }

    public static int getDisplayHeight() {
        return displayHeight;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //static context to use when application context needed
        instance = this;
        getScreenSize();
        configureJobManager();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    private void configureJobManager() {

    }

    private void getScreenSize(){

        WindowManager windowManager = (WindowManager) instance.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        displayWidth = size.x;
        displayHeight = size.y;

    }
    public static  void clearJobManager(){
        jobManager.clear();
    }
    public static JobManager getJobManager() {
        return jobManager;
    }

    public static Context get() {
        return instance;
    }

    public static void setForTests(Context context) {
        instance = context;
    }

    public static void createDatabaseIfNeeded(){
        // Hay que hacerlo en primer hilo. Si se usan threads se producen errores en versiones antíguas
//        Customer.findById(Customer.class, (long) 1);
//        IssuedInvoice.findById(IssuedInvoice.class, (long) 1);
//        TicketsDb.findById(TicketsDb.class, (long) 1);
    }

    public static boolean hasConnection() {
        Context context = get();
        ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }

    public static void startQueue(){
        if (!GeoHelpApplication.isQueueWorking) {
        }
    }

    public static int dpToPx(int dp) {
        DisplayMetrics displayMetrics = get().getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    public int pxToDp(int px) {
        DisplayMetrics displayMetrics = get().getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }

    public static int getThemeAttributeDimensionSize(int attr) {
        TypedArray a = null;
        try{
            a = context.getTheme().obtainStyledAttributes(new int[] { attr });
            return a.getDimensionPixelSize(0, 0);
        }finally{
            if(a != null){
                a.recycle();
            }
        }
    }
}
