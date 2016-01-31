package com.example.javier.geohelp.Activities.Entities;

/**
 * Created by javier on 30/01/2016.
 */
public class ResponseBundle {
    private Integer result;
    private Object object;
    private Object extras;

    public ResponseBundle(Integer result, Object object) {
        this.result = result;
        this.object = object;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getExtras() {
        return extras;
    }

    public void setExtras(Object extras) {
        this.extras = extras;
    }
}
