/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;
import java.io.Serializable;
/**
 *
 * @author user
 */
public class venuesBean implements Serializable {
    private int id;
    private String name;
    private String type;
    private int capacity;
    private String location;
    private String description;
    private String personInCharge;
    private int hourlyRate;
    private String isActive;
    private byte[] image;
    
    public venuesBean() {
        this.id = 0;
        this.name = "";
        this.type = "";
        this.capacity = 0;
        this.location = "";
        this.description = "";
        this.personInCharge = "";
        this.hourlyRate = 0;
        this.isActive = "";
        this.image = new byte[0];
    }
    
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setActive(String isActive) {
        this.isActive = isActive;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
