package com.example.javier.geohelp.Activities.Interactors;

import com.example.javier.geohelp.Activities.Domain.LoginDomain;
import com.example.javier.geohelp.Activities.Entities.UserEntity;

/**
 * Created by javier on 30/01/2016.
 */
public class CreateUserInteractor extends AbstractInteractor{

    UserEntity userEntity;

    public CreateUserInteractor(UserEntity userEntity) {
        this.userEntity = userEntity;
    }



    @Override
    public void runOnBackground() {
        LoginDomain loginDomain = new LoginDomain();
        loginDomain.createUser(userEntity);
    }
}
