package learning.demo.entities;

import java.util.Date;

import org.apache.tomcat.jni.Time;

public class User {
    private int id;
    private String name;
    private String contact_no;
    private Date created_at;
    private Date updated_at;



    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContact_no() {
        return this.contact_no;
    }
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
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
}