package learning.demo.entities;

import java.util.Date;

import org.apache.tomcat.jni.Time;

public class Property {
    private int id;
    private String address;
    private Date created_at;
    private Date updated_at;
    private int owner_id;



    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreated_at() {
        return this.created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return this.updated_at;
    }
    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getOwner_id() {
        return this.owner_id;
    }
    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
}