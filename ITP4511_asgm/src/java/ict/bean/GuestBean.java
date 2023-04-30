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

    // Default constructor
    public GuestBean() {
        
    }

    // Constructor with all fields
    public GuestBean(int id, String name, String email, String bookingId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bookingId = bookingId;
    }

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
}