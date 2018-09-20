package com.example.seiya.dentalclinic.client;

public class Services {

    Services(int imageid, String servicetype, String setappoint){
            this.setImageid(imageid);
            this.setServicetype(servicetype);
            this.setSetappoint(setappoint);

    }
    private int imageid;
    private String servicetype,setappoint;

    public int getImageid() {
        return imageid;
    }

    private void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public String getSetappoint() {
        return setappoint;
    }

    public void setSetappoint(String setappoint) {
        this.setappoint = setappoint;
    }
}
