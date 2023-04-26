/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

/**
 *
 * @author qwer1
 */
public class GuestBean {

    private int id;
    private String name;
    private String email;
    private String bookingId;
    
    public GuestBean(int id, String name, String email, String booking_id){
        this.id = id;
        this.name = name;
        this.email = email;
        this.bookingId = booking_id;
    }

    // Default constructor
    public GuestBean() {

    }

    // Constructor with all fields

    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setbooking_id(String booking_id) {
        this.bookingId = booking_id;
    }

    public int getid() {
        return id;
    }

    public String getemail() {
        return email;
    }

    public String getbooking_id() {
        return bookingId;
    }

    public String toString() {
        return "GuestBean{id=" + id + ",name=" + name + ",email=" + email + ",booking_id=" + bookingId + "}";
    }
}
