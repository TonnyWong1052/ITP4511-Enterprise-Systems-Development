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
public class CartBean {
    private String Id;
    private String custId;
    private String venueId;
    
public CartBean() {    
   
    }
    
public CartBean( String Id, String custId, String venueId ) {    
    this.Id=Id;
    this.custId=custId;
    this.venueId=venueId;
    }


public void setId(String Id){
    this.Id =Id;
}

public String getId(){
return Id; 
}

public void setcustId(String custId){
    this.custId =custId;
}

public String getcustId(){
return custId; 
}

public void setvenueId(String venueId){
    this.venueId =venueId;
}

public String getvenueId(){
return venueId; 
}

  public String toString(){
        return "CartBean{id="+ Id +",customer="+ custId +", venue id="+ venueId +"}";
    }

}
