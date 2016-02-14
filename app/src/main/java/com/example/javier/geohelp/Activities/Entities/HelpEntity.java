package com.example.javier.geohelp.Activities.Entities;

/**
 * Created by raquel on 13/02/2016.
 */

/**
 * Entidad que modela las ayudas de la base de datos
 */
public class HelpEntity {

    private int id;
    private String idUser;
    private String nombre;
    private String descripción;
    private int tipo;
    private long aLat;
    private long aLong;


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
}


