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
    private String nombre;
    private String descripción;
    private int tipo;
    private String category;
    private long aLat;
    private long aLong;
    private String dateCreation;
    private int idImagen;


    public HelpEntity() {
    }

    public HelpEntity(int id, String idUser, String nombre, String descripción, int tipo, long aLat, long aLong) {
        this.id = id;
        this.idUser = idUser;
        this.nombre = nombre;
        this.descripción = descripción;
        this.tipo = tipo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}


