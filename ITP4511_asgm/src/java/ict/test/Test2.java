/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;
import ict.bean.venuesBean;
import ict.db.VenueDB;
/**
 *
 * @author user
 */
public class Test2 {
    public static void main(String[] args){
//        String url = "jdbc:mysql://219.79.70.66:3306/ITP4511_asgm";
//        String username = "lamsam";
//        String password = "Testdb123456#";
        String url = "jdbc:mysql://localhost:3306/ITP4511_asgm";
        String username = "root";
        String password = "";     
        VenueDB custDB = new VenueDB(url, username, password);
        venuesBean cbList = custDB.queryVenueByID("1");
        System.out.println("ID: " + cbList.getId() );
        System.out.println("Name: " + cbList.getName() );
//        System.out.println("Tel: " + cbList.getTel() );
//        System.out.println("Age: " + cbList.getAge() );
	
    }
}
