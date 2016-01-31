package com.example.javier.geohelp.Activities.Interactors.Events;

/**
 * Created by javier on 23/01/2016.
 */
public class BaseEvent {

    public BaseEvent() {
        super();
    }

    public BaseEvent(Exception exception) {
        this.exception = exception;
    }

    protected Exception exception;

    public boolean hasError() {
        return exception != null;
    }
}

