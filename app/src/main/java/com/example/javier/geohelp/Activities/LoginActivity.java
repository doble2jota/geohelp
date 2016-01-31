package com.example.javier.geohelp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    private Button createUser;
    private Button loginUser;

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
        createUser = (Button) findViewById(R.id.create_user);
        loginUser = (Button) findViewById(R.id.login_user);
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
                UserEntity userEntity = new UserEntity(username.getText().toString(),pass.getText().toString());
                loginPresenter.loginUser(userEntity);
        }else if(v.getId() == R.id.create_user){
            UserEntity userEntity = new UserEntity(username.getText().toString(),pass.getText().toString());
            loginPresenter.createUser(userEntity);
        }
    }
}
