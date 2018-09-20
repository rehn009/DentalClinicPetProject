package com.example.seiya.dentalclinic.client;

public class ServicesDetails {

    private String servicetayp,description;
    private int servethumbnail;


    public ServicesDetails(){
    }


    ServicesDetails(String servicetayp, String description, int servethumbnail) {
        this.servicetayp = servicetayp;
        this.description = description;
        this.servethumbnail = servethumbnail;
    }

    public String getServicetayp() {
        return servicetayp;
    }

    public void setServicetayp(String servicetayp) {
        this.servicetayp = servicetayp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getServethumbnail() {
        return servethumbnail;
    }

    public void setServethumbnail(int servethumbnail) {
        this.servethumbnail = servethumbnail;
    }
}
