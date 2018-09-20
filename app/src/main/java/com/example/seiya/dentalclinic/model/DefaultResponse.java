package com.example.seiya.dentalclinic.model;

public class DefaultResponse {

    private boolean error;

    private String mesage;


    public DefaultResponse(boolean error, String mesage) {
        this.error = error;
        this.mesage = mesage;
    }

    public boolean isError() {
        return error;
    }

    public String getMesage() {
        return mesage;
    }
}
