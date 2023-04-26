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
public class CustomerBean implements Serializable{
    private String CustId;
    private String Name;
    private String Tel;
    private int Age;
    
    public CustomerBean(){
    
    }
    
    public CustomerBean(String CustId, String Name, String Tel, int Age){
        this.CustId = CustId;
        this.Name = Name;
        this.Tel = Tel;
        this.Age = Age;
    }
    
    public String getCustId(){
        return CustId;
    }
    
    public String getName(){
        return Name;
    }
    
    public String getTel(){
        return Tel;
    }
    
    public int getAge(){
        return Age;
    }
    
    public void setCustId(String CustId){
        this.CustId = CustId;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    
    public void setTel(String Tel){
        this.Tel = Tel;
    }
    
    public void setAge(int Age){
        this.Age = Age;
    }
    
    public String toString(){
        return "CustomerBean{custid=" + CustId + ",name=" + Name + ",tel=" + Tel + ",age=" + Age + "}";
    }
}
