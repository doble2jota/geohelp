package com.example.javier.geohelp.Activities.Entities;

/**
 * Created by javier on 30/01/2016.
 */
public class UserEntity {

    public UserEntity(String userName, String passName) {
        this.userName = userName;
        this.passName = passName;

    }

    private String userName;
    private String passName;
    private String userUID;

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }
}
