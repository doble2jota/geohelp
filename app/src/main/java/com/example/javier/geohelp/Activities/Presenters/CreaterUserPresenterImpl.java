package com.example.javier.geohelp.Activities.Presenters;

import com.example.javier.geohelp.Activities.Entities.UserEntity;
import com.example.javier.geohelp.Activities.Interactors.CreateUserInteractor;
import com.example.javier.geohelp.Activities.Interactors.Events.CreateUserEvent;
import com.example.javier.geohelp.Activities.Interactors.Events.GenericServerErrorEvent;
import com.example.javier.geohelp.Activities.LoginView;

/**
 * Created by javier on 31/01/2016.
 */
public class CreaterUserPresenterImpl extends PresenterImpl implements Presenter,CreaterUserPresenter{

    private LoginView loginView;
    public CreaterUserPresenterImpl( LoginView loginView){
        this.loginView=loginView;
    }
    public void createUser(UserEntity userEntity){
        new CreateUserInteractor(userEntity).execute();
    }

    @Override
    public void onEventMainThread(GenericServerErrorEvent genericServerErrorEvent) {

    }

    public void onEventMainThread(CreateUserEvent createUserEvent){
        loginView.startActivy();
        loginView.finishActivy();
    }
}
