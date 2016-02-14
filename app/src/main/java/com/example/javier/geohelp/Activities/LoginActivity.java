package com.example.javier.geohelp.Activities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.javier.geohelp.Activities.Components.EmailEditText;
import com.example.javier.geohelp.Activities.Entities.UserEntity;
import com.example.javier.geohelp.Activities.Presenters.LoginPresenter;
import com.example.javier.geohelp.Activities.Presenters.LoginPresenterImpl;
import com.example.javier.geohelp.R;
import com.firebase.client.Firebase;

/**
 * Created by javier on 30/01/2016.
 */
public class LoginActivity extends AbstractActivity<LoginPresenter> implements LoginView,View.OnClickListener{

    private EditText username;
    private EditText pass;
    private TextView createUser;
    private Button loginUser;
    private EmailEditText emailEditText;

    private LoginPresenterImpl loginPresenter;

    @Override
    protected LoginPresenter createPresenter() {
        this.loginPresenter = new LoginPresenterImpl(this);
        return this.loginPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        Firebase.setAndroidContext(this);

        loginPresenter.checkUserLogin();

        username = (EditText) findViewById(R.id.user_name);
        pass = (EditText) findViewById(R.id.password);
        createUser = (TextView) findViewById(R.id.create_user);
        loginUser = (Button) findViewById(R.id.login_user);
        (emailEditText=(EmailEditText)findViewById(R.id.correo_parent)).init();

        createUser.setOnClickListener(this);
        loginUser.setOnClickListener(this);

    }



    @Override
    public void startActivy() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void finishActivy() {
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_user){
            v.setOnClickListener(null);
            int colorFrom = getResources().getColor(R.color.GeoHelp_primary_dark);
            int colorTo = getResources().getColor(R.color.GeoHelp_primary_light);
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            ValueAnimator textAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorTo, colorFrom);
            colorAnimation.setDuration(250); // milliseconds
            textAnimation.setDuration(250);
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    loginUser.setBackgroundColor((int) animator.getAnimatedValue());
                }

            });
            textAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    loginUser.setTextColor((int) animator.getAnimatedValue());
                }

            });
            loginUser.setText("Entrando...");
            colorAnimation.start();
            textAnimation.start();
            UserEntity userEntity = new UserEntity(username.getText().toString(),pass.getText().toString());
            loginPresenter.loginUser(userEntity);

        }else if(v.getId() == R.id.create_user){
            goToActivityCreateUser();
        }
    }

    public void goToActivityCreateUser(){
        Intent intent = new Intent(this,CreateUserActivity.class);
        startActivity(intent);
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
