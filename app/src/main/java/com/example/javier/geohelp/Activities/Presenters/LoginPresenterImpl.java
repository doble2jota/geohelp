package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.Entities.UserEntity;
import com.example.javier.geohelp.Activities.Interactors.CheckUserLoginInteractor;
import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;
import com.example.javier.geohelp.Activities.Interactors.Events.HomeEvent;
import com.example.javier.geohelp.Activities.Interactors.Events.UserEvent;
import com.example.javier.geohelp.Activities.Interactors.LoginUserInteractor;
import com.example.javier.geohelp.Activities.LoginView;
import com.example.javier.geohelp.Activities.Utils.LogUtil;

/**
 * Created by javier on 30/01/2016.
 */
public class LoginPresenterImpl extends PresenterImpl implements Presenter,LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl( LoginView loginView){
        this.loginView=loginView;
    }

    public void loginUser(UserEntity userEntity){
        new LoginUserInteractor(userEntity).execute();
    }


    public void checkUserLogin(){
        new CheckUserLoginInteractor().execute();
    }

    public void onEventMainThread(HomeEvent homeEvent){

    }

    @Override
    public void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent) {

    }

    public void onEventMainThread(UserEvent createUserEvent){
        LogUtil.d("ENTRO", "Entro");
        loginView.startActivy();
        loginView.finishActivy();
    }

}
