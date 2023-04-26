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

public class GuestBean_1 implements Serializable {
     private int id ;
    private String name;
    private String email;
    private String booking_id;
    
    public GuestBean_1(int id, String name, String email, String booking_id){
        this.id = id;
        this.name = name;
        this.email = email;
        this.booking_id = booking_id;
    }

    public GuestBean_1() {
   
    }
    
    
    
    public void setid(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setemail(String email){
        this.email = email;
    }
    
    public void setbooking_id(String booking_id){
        this.booking_id = booking_id;
    }
    
    public int getid(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getemail(){
        return email;
    }
    
    public String getbooking_id(){
        return booking_id;
    }
    
    public String toString(){
        return "GuestBean{id=" + id + ",name=" + name + ",email=" + email + ",booking_id=" + booking_id + "}";
    }
    
}