package learning.demo.entities;

import java.util.Date;

import org.apache.tomcat.jni.Time;

public class Payment {
    private int id;
    private boolean status;
    private int amount;
    private Date created_at;
    private Date updated_at;
    private int booking_id;



    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean getStatus() {
        return this.status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getAmount() {
        return this.amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
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

    public int getBooking_id() {
        return this.booking_id;
    }
    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

}