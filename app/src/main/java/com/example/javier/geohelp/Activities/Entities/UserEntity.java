package com.example.javier.geohelp.Activities.Entities;

/**
 * Created by javier on 30/01/2016.
 */
public class UserEntity {

    public UserEntity(String userName, String pass) {
        this.emailUser = userName;
        this.pass = pass;

    }
    public UserEntity() {
    }
    private String emailUser;
    private String pass;
    private String firstName;
    private String lastName;
    private String userUID;

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }


    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
