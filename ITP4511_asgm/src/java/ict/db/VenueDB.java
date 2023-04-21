/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;
import ict.bean.venuesBean;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class VenueDB {
    private String url = "";
    private String username = "";
    private String password = "";
    
    public VenueDB(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    public Connection getConnection() throws SQLException, IOException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        return DriverManager.getConnection(url, username, password);
    }
    public venuesBean queryVenueByID(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        venuesBean cb = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM venues WHERE id=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            
            ResultSet rs = null;
            
            rs = pStmnt.executeQuery();
            
            if(rs.next()){
                cb = new venuesBean();
                cb.setId(rs.getInt(1));
                cb.setName(rs.getString(2));
                cb.setType(rs.getString(3));
                cb.setCapacity(rs.getInt(4));
                cb.setLocation(rs.getString(5));
                cb.setDescription(rs.getString(6));
                cb.setPersonInCharge(rs.getString(7));
                cb.setBookingFee(rs.getString(8));
                cb.setHourlyRate(rs.getString(9));
                cb.setActive(rs.getString(10));
                cb.setImage(rs.getBytes(11));
            }
            pStmnt.close();
            cnnct.close();
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }
        
        return cb;
    }
}
