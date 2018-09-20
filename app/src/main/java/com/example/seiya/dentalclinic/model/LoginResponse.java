package com.example.seiya.dentalclinic.model;

public class LoginResponse {

    private boolean error;
    private String message;
    private Client client;

    public LoginResponse(boolean error, String message, Client client) {
        this.error = error;
        this.message = message;
        this.client = client;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Client getClient() {
        return client;
    }
}
