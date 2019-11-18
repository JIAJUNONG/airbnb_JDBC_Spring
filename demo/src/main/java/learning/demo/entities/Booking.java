package learning.demo.entities;

import java.util.Date;

import org.apache.tomcat.jni.Time;

public class Booking {
    private int id;
    private int price;
    private Date booking_date;
    private Date check_in;
    private Date check_out;
    private Date created_at;
    private Date updated_at;
    private int user_id;
    private int property_id;



    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public Date getBooking_date() {
        return this.booking_date;
    }
    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public Date getCheck_in() {
        return this.check_in;
    }
    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return this.check_out;
    }
    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
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

    public int getUser_id() {
        return this.user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProperty_id() {
        return this.property_id;
    }
    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }
}