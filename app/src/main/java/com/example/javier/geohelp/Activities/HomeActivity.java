package com.example.javier.geohelp.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // previously visible view
        final ImageView myView = (ImageView) findViewById(R.id.edit_my_profile);

        final ImageView myView2 = (ImageView) findViewById(R.id.img_my_profile);
        myView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //http://stackoverflow.com/questions/21954515/animations-appear-rotate-and-disappear
                Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);
                Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);

                if(myView.getVisibility()==View.INVISIBLE) {

                    myView.startAnimation(slideUp);
                    myView.setVisibility(View.VISIBLE);
                }
                else {
                    myView.startAnimation(slideDown);
                    myView.setVisibility(View.INVISIBLE);
                }
            }
        });


    /*    Firebase ref = new Firebase(GeoHelpConstans.URL_FIREBASE);
        Firebase alanRef = ref.child("users").child("alanisawesome");
        UserEntity alan = new UserEntity("Alan Turing", "19122");
        alanRef.setValue(alan);*/

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });*/

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
