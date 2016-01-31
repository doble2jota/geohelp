package com.example.javier.geohelp.Activities.Interactors.Events;

import com.example.javier.geohelp.Activities.Entities.ServerErrorEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javier on 23/01/2016.
 */
public class GenericServerErrorEvent extends BaseEvent {

    private List<ServerErrorEntity> errorList;

    public GenericServerErrorEvent() {
        this.errorList = new ArrayList<ServerErrorEntity>();
    }

    public void add(ServerErrorEntity serverErrorEntity){
        this.errorList.add(serverErrorEntity);
    }

    public List<ServerErrorEntity> getErrorList() {
        return errorList;
    }

    public int size(){
        return errorList.size();
    }
}
