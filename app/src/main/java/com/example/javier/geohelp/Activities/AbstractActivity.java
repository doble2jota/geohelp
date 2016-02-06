package com.example.javier.geohelp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.javier.geohelp.Activities.Components.GeoHelpTextView;
import com.example.javier.geohelp.Activities.Presenters.Presenter;
import com.example.javier.geohelp.R;

/**
 *
 *
 * Created by javier on 23/01/2016.
 *
 *
 */

public abstract class AbstractActivity<P extends Presenter> extends AppCompatActivity {

    private P presenter;

    protected P getPresenter() {
        return presenter;
    }

    protected abstract P createPresenter();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = createPresenter();
        presenter.setActivity(this);
        presenter.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    //  @Override
//    public void onRequestPermissionRestul(int requesCode, String permission[],int[] grantResult){
//        super.onRequestPermissionsresult(requesCode,permission,grantResult);
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();
        if (id==android.R.id.home){
            return onActivityCanceled();
        }
        return  super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keycode, KeyEvent event){
        if(keycode == KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){
            return onActivityCanceled();
        }
        return super.onKeyDown(keycode, event);
    }


    public boolean onActivityCanceled(){
        finish();
        //aqui va la animacion;
        return true;
    }
    public void setTextToolbar(int title,int background){

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(background));
        setSupportActionBar(toolbar);
       getSupportActionBar().setHomeButtonEnabled(true);
   //     getSupportActionBar().setDisplayHomeAsUpEnabled(true); nos pone la flecha y cierra la actividad descomentar cuando se vaya a usar

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.titleview, null);

        GeoHelpTextView toolbarTitle= (GeoHelpTextView)v.findViewById(R.id.title);
        toolbarTitle.setText(getString(title));
        this.getSupportActionBar().setCustomView(v);
    }
}

