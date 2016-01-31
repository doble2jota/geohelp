package com.example.javier.geohelp.Activities.Entities;

import com.example.javier.geohelp.Activities.Entities.Response.Response;

import java.lang.reflect.Type;

/**
 * Created by javier on 23/01/2016.
 */
public class ServerErrorEntity extends Response {

    private String code;
    private String text;
    private String fieldId ="";

    public ServerErrorEntity(){

    }

    public ServerErrorEntity(String code, String fieldId, String text){
        this.code = code;
        this.fieldId = fieldId;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getGsonName() {
        return "errorList";
    }

    @Override
    public Type getGenericList() {
        return null;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }
}
