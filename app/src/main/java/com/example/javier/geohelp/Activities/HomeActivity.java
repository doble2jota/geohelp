package com.example.javier.geohelp.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.javier.geohelp.Activities.Presenters.HomePresenter;
import com.example.javier.geohelp.Activities.Presenters.HomePresenterImpl;
import com.example.javier.geohelp.R;
import com.firebase.client.Firebase;

public class HomeActivity extends AbstractActivity<HomePresenter> implements HomeView {
    private String FIREBASE_URL = "https://amber-torch-3957.firebaseio.com/";
    private String FIREBASE_USERNAME = "username";
    private String FIREBASE_PASS = "pass";

    Firebase firebase;
    Firebase firebase1;

    private HomePresenterImpl homePresenter;


    @Override
    protected HomePresenter createPresenter() {
        this.homePresenter = new HomePresenterImpl(this);
        return this.homePresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    /*    Firebase ref = new Firebase(GeoHelpConstans.URL_FIREBASE);
        Firebase alanRef = ref.child("users").child("alanisawesome");
        UserEntity alan = new UserEntity("Alan Turing", "19122");
        alanRef.setValue(alan);*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        super.setTextToolbar(R.string.title_home, R.color.background_floating_material_dark);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
