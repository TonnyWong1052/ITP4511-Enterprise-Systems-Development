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
public class VenueBean implements Serializable {
    private String id ;
    private String name;
    private String type;
    private int capacity;
    private String location;
    private String description;
    private String person_in_charge;
    private int hourly_rate ;
    private int is_active;
    
    public VenueBean(){
    
    }
    
    public VenueBean(String id, String name, String type, int capacity, String location, String description, String person_in_charge, int hourly_rate, int is_active){
        this.id = id;
        this.name=name;
        this.type=type;
        this.capacity=capacity;
        this.location=location;
        this.description=description;
        this.person_in_charge=person_in_charge;
        this.hourly_rate=hourly_rate;
        this.is_active=is_active;
    }
    
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
       return name;
    }    
    
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }
    
    public void setCapacity(int capacity ){
        this.capacity = capacity;
    }
    public int getCapacity(){
        return capacity;
    }
    
    public void setLocation(String location ){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }
    
    public void setDescription(String description ){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    
    public void setPersonInCharge(String person_in_charge ){
        this.person_in_charge = person_in_charge;
    }
    public String getPersonInCharge(){
        return person_in_charge;
    }
    
    public void setHourlyRate(int hourly_rate ){
        this.hourly_rate = hourly_rate;
    }
    public int getHourlyRate(){
        return hourly_rate;
    }
    
    public void setIsActive(int is_active ){
        this.is_active = is_active;
    }
    public int getIsActive(){
        return is_active;
    }
    
    public String toString(){
        //( String id, String name, String type,int capacity, String location, String description, String personInCharge, int hourlyRate, int isActive){
        return "VenueBean{id="+ id +",name="+ name +", type="+ type +", capacity="+capacity+", location="+location+", description="+description+", personInCharge="+person_in_charge+",hourlyRate="+hourly_rate+", isActive="+is_active+"}";
    }


}