package com.example.javier.geohelp.Activities.Interactors;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.javier.geohelp.Activities.Utils.GeoHelpApplication;
import com.example.javier.geohelp.Activities.async.CancelableExecutor;
import com.example.javier.geohelp.Activities.async.Executor;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.concurrent.Future;

/**
 * Created by javier on 24/01/2016.
 */public abstract class AbstractInteractor extends Job implements Runnable {

    public static final int DEFAULT_PRIORITY = 10;

    private boolean connectionNeeded = true;

    public AbstractInteractor() {
        super(new Params(DEFAULT_PRIORITY));
//    super(new Params(DEFAULT_PRIORITY).requireNetwork());
    }

    public abstract void runOnBackground();

    public void execute(){
        Executor.execute(this);
    }

    public void executeWithJobQueue(){
        ((GeoHelpApplication)getContext()).getJobManager().addJob(this);
    }

    public Future executeCancelableThread(){
        return CancelableExecutor.execute(this);
    }

    @Override
    public void onRun() throws Throwable {
        launch();
    }

    @Override
    public void run() {
        launch();
    }

    public void launch() {
        runOnBackground();
    }

    public boolean checkConnection(Context context) {
        ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;

    }

    @Override
    public void onAdded() {
    }

    public Context getContext() {
        return getContext();
    }

    @Override
    protected void onCancel() {
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }

}
