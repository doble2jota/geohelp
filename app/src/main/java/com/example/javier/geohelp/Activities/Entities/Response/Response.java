package com.example.javier.geohelp.Activities.Entities.Response;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by javier on 23/01/2016.
 */
public abstract class Response<E> {

    private String errorText;
    private Integer result;
    private Integer rowNumber;
    private Integer totalRowNumber;
    private E object;
    private List<E> list;

    public abstract String getGsonName();

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getTotalRowNumber() {
        return totalRowNumber;
    }

    public void setTotalRowNumber(Integer totalRowNumber) {
        this.totalRowNumber = totalRowNumber;
    }

    public abstract Type getGenericList();
}
