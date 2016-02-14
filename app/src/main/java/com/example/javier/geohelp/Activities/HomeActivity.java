package com.example.javier.geohelp.Activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.javier.geohelp.Activities.Presenters.HomePresenter;
import com.example.javier.geohelp.Activities.Presenters.HomePresenterImpl;
import com.example.javier.geohelp.R;
import com.firebase.client.Firebase;

public class HomeActivity extends AbstractActivity<HomePresenter> implements HomeView, View.OnClickListener {
    private String FIREBASE_URL = "https://amber-torch-3957.firebaseio.com/";
    private String FIREBASE_USERNAME = "username";
    private String FIREBASE_PASS = "pass";
    private RelativeLayout layout_settings;
    private RelativeLayout layout_help_someone;
    private RelativeLayout layout_help_me;

    Firebase firebase;
    Firebase firebase1;
    ImageView myView;
    ImageView myView2;
    Animation slideUp ;
    Animation slideDown;
    private HomePresenterImpl homePresenter;


    @Override
    protected HomePresenter createPresenter() {
        this.homePresenter = new HomePresenterImpl(this);
        return this.homePresenter;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.setTextToolbar(R.string.title_home, R.color.GeoHelp_primary);

        slideUp = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);
        slideDown = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);

        layout_help_someone=(RelativeLayout)findViewById(R.id.layout_help_someone);
        layout_help_me = (RelativeLayout) findViewById(R.id.layout_help_me);
        layout_settings= (RelativeLayout)findViewById(R.id.layout_settings);
        myView= (ImageView)findViewById(R.id.edit_my_profile);
        myView2= (ImageView)findViewById(R.id.img_my_profile);

        layout_help_someone.setOnClickListener(this);
        layout_settings.setOnClickListener(this);
        layout_help_me.setOnClickListener(this);
        myView.setOnClickListener(this);
        myView2.setOnClickListener(this);


/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });*/

    }
    private void manageClickAnimation(){
        if (myView.getVisibility() == View.INVISIBLE) {
            myView.startAnimation(slideUp);
            myView.setVisibility(View.VISIBLE);
        } else {
            myView.startAnimation(slideDown);
            myView.setVisibility(View.INVISIBLE);
        }
    }

    private void goToActivity(Class<?> className){
        startActivity(new Intent(this, className));

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_my_profile:
                break;

            case R.id.img_my_profile:
                manageClickAnimation();
                break;
            case R.id.layout_help_someone:
                goToActivity(HelpSomeoneActivity.class);
                break;
            case R.id.layout_settings:
                goToActivity(SettingsActivity.class);
                break;
            case R.id.layout_help_me:
                goToActivity(NeedHelpActivity.class);
            default:
                break;
        }
    }
    @Override
    public void onPause(){
        super.onPause();
    }
    @Override
    public void onResume(){
        super.onResume();
    }

}
