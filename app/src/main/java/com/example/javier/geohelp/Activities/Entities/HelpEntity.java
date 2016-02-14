package com.example.javier.geohelp.Activities.Entities;

/**
 * Created by raquel on 13/02/2016.
 */

import java.util.List;

/**
 * Entidad que modela las ayudas de la base de datos
 */
public class HelpEntity {




    List<HelpEntity> help;
    private int id;
    private String idUser;
    private String name;
    private String description;
    private String category;
    private long aLat;
    private long aLong;
    private String dateCreation;
    private int idImage;
    private int state;


    public HelpEntity() {
    }

    public HelpEntity(int id, String idUser, String name, String descripción, String category, long aLat, long aLong) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.description = descripción;
        this.category = category;
        this.aLat = aLat;
        this.aLong = aLong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public long getaLat() {
        return aLat;
    }

    public void setaLat(long aLat) {
        this.aLat = aLat;
    }

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public List<HelpEntity> getHelp() {
        return help;
    }

    public void setHelp(List<HelpEntity> help) {
        this.help = help;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}


