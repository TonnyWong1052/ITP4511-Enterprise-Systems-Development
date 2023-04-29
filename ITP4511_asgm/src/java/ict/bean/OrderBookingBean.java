/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author qwer1
 */
public class OrderBookingBean implements Serializable {
    private int orderID;
    private int userID;
    private String userName;
    private ArrayList<BookingBean> bookingList;

    // Default constructor
    public OrderBookingBean() {
        bookingList = new ArrayList<>();
    }

    // Getters and setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderId) {
        this.orderID = orderId;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<BookingBean> getBookingList() {
        return bookingList;
    }

    public void setBookingList(ArrayList<BookingBean> bookingList) {
        this.bookingList = bookingList;
    }

    // Add a BookingBean to the bookingList
    public void addBooking(BookingBean booking) {
        this.bookingList.add(booking);
    }
}
