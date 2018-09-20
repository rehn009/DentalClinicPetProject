package com.example.seiya.dentalclinic.model;

public class Client {

    private int id;

    private String lastname,firstname,midname,contactnum, email;

    public Client(int id, String lastname, String firstname, String midname, String contactnum, String email) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.midname = midname;
        this.contactnum = contactnum;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMidname() {
        return midname;
    }

    public String getContactnum() {
        return contactnum;
    }

    public String getEmail() {
        return email;
    }
}
