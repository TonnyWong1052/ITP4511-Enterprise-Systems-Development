/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;
import ict.bean.venuesBean;
import java.io.IOException;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public ArrayList<venuesBean> queryCustByID(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        venuesBean cb = null;
        
        ArrayList<venuesBean> cbList = null;
                
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM venues WHERE id=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            
            ResultSet rs = pStmnt.executeQuery();
            cbList = new ArrayList();
            
            while(rs.next()){
                cb = new venuesBean();
                cb.setId(rs.getInt(1));
                cb.setName(rs.getString(2));
                cb.setType(rs.getString(3));
                cb.setCapacity(rs.getInt(4));
                cb.setLocation(rs.getString(5));
                cb.setDescription(rs.getString(6));
                cb.setPersonInCharge(rs.getString(7));
                cb.setHourlyRate(rs.getInt(8));
                cb.setActive(rs.getString(9));
                cb.setImage(rs.getBytes(10));
                cbList.add(cb);
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
        
        return cbList;
    }
    
    public ArrayList<venuesBean> queryCust(){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        venuesBean cb = null;
        
        ArrayList<venuesBean> cbList = null;
                
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM venues";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            ResultSet rs = pStmnt.executeQuery();
            cbList = new ArrayList();
            
            while(rs.next()){
                cb = new venuesBean();
                cb.setId(rs.getInt(1));
                cb.setName(rs.getString(2));
                cb.setType(rs.getString(3));
                cb.setCapacity(rs.getInt(4));
                cb.setLocation(rs.getString(5));
                cb.setDescription(rs.getString(6));
                cb.setPersonInCharge(rs.getString(7));
                cb.setHourlyRate(rs.getInt(8));
                cb.setActive(rs.getString(9));
                cb.setImage(rs.getBytes(10));
                cbList.add(cb);
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
        
        return cbList;
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
                cb.setHourlyRate(rs.getInt(8));
                cb.setActive(rs.getString(9));
//                cb.setImage(rs.getBytes(10));
                Blob imageBlob = rs.getBlob(10);
                if (imageBlob != null) {
                    cb.setImage(imageBlob.getBytes(1, (int) imageBlob.length()));
                } else {
                    cb.setImage(null);
                }
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
    
    public venuesBean queryVenue(){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        venuesBean cb = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM venues";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
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
                cb.setHourlyRate(rs.getInt(8));
                cb.setActive(rs.getString(9));
                Blob imageBlob = rs.getBlob(10);
                if (imageBlob != null) {
                    cb.setImage(imageBlob.getBytes(1, (int) imageBlob.length()));
                } else {
                    cb.setImage(null);
                }
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
    
        
    public boolean editRecord(venuesBean cb){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "UPDATE venues SET "
                    + " id=?, name=?, type=?, capacity=?, location=?, description=?, person_in_charge=?, hourly_rate=?, is_active=?, image=? WHERE id=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, cb.getId());
            pStmnt.setString(2, cb.getName());
            pStmnt.setString(3, cb.getType());
            pStmnt.setInt(4, cb.getCapacity());
            pStmnt.setString(5, cb.getLocation());
            pStmnt.setString(6, cb.getDescription());
            pStmnt.setString(7, cb.getPersonInCharge());
            pStmnt.setInt(8, cb.getHourlyRate());
            pStmnt.setString(9, cb.getIsActive());
            pStmnt.setBytes(10, cb.getImage());
            
            
            pStmnt.setInt(11, cb.getId());
            
            pStmnt.executeUpdate();
            
            int count = pStmnt.getUpdateCount();
            System.out.println(count);
            if(count>0)
                isSuccess = true;
                        
            pStmnt.close();
            cnnct.close();
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
            System.out.println(ex.getMessage());
        } catch(IOException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return isSuccess;
    }
    
    public int createRecord(venuesBean cb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        int generatedId = -1;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO venues (name, type, capacity, location, description, person_in_charge, hourly_rate, is_active, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement, PreparedStatement.RETURN_GENERATED_KEYS);
            pStmnt.setString(1, cb.getName());
            pStmnt.setString(2, cb.getType());
            pStmnt.setInt(3, cb.getCapacity());
            pStmnt.setString(4, cb.getLocation());
            pStmnt.setString(5, cb.getDescription());
            pStmnt.setString(6, cb.getPersonInCharge());
            pStmnt.setInt(7, cb.getHourlyRate());
            pStmnt.setString(8, cb.getIsActive());
            pStmnt.setBytes(9, cb.getImage());
            
            pStmnt.executeUpdate();

            ResultSet rs = pStmnt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
        
//            int count = pStmnt.getUpdateCount();
//            System.out.println(count);
//            if (count > 0)
//                isSuccess = true;

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
//            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
//            System.out.println(ex.getMessage());
        }
        return generatedId;
    }
}
