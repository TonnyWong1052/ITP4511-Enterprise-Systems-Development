/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.io.Serializable;

/**
 *
 * @author qwer1
 */
public class AnalysisBean implements Serializable  {
    private int totalBookings;
    private double bookingRatePercentage;
    private double monthlyIncome;
    private String venueId;
    private String date;
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public String getVenueId(){
        return venueId;
    }
    
    public void setVenueId(String venueId){
        this.venueId =  venueId;
    }

    public int getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(int totalBookings) {
        this.totalBookings = totalBookings;
    }

    public double getBookingRatePercentage() {
        return bookingRatePercentage;
    }

    public void setBookingRatePercentage(double bookingRatePercentage) {
        this.bookingRatePercentage = bookingRatePercentage;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
}