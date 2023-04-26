/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.DB;
import ict.bean.BookingBean;
import ict.bean.VenueBean;
import ict.bean.CartBean;
import ict.bean.GuestBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.NativeJava.type;
import static jdk.nashorn.internal.runtime.Debug.id;
/**
 *
 * @author qwer1
 */
public class CustomerDB {
    
    private String url="";
    private String username ="";
    private String password ="";

   public CustomerDB() {
         url = "jdbc:mysql://localhost:3306/itp4511_asgm";
         username = "root";
         password = "";
    }

//        public CustomerDB(String url, String username , String password){
//        this.url=url;
//        this.username=username;
//        this.password= password;
//    }
    
    
    public Connection getConnection() throws SQLException, IOException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        return DriverManager.getConnection(url,username,password);
    }
    
    public void createCustTable(){
        Statement stmnt=null;
        Connection cnnct= null;
        
        try{
            cnnct=getConnection();
            stmnt=cnnct.createStatement();
            String sql= "CREATE TABLE IF NOT EXISTS customer ("+
                        "custId varchar(5) NOT NULL,"+
                        "email varchar(25) NOT NULL,"+
                        "username varchar(25) NOT NULL,"+
                        "phone int(12) NOT NULL,"+
                        "password varchar(25) NOT NULL,"+
                        "age int(11) NOT NULL,"+
                        "PRIMARY KEY (custId)"+
                        ")";
            stmnt.execute(sql);
            stmnt.close();
            cnnct.close();
                        
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex= ex.getNextException();
            }
            
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    
    public void createCartTable(){
        Statement stmnt=null;
        Connection cnnct= null;
        try{
            cnnct=getConnection();
            stmnt=cnnct.createStatement();
            String sql= "CREATE TABLE IF NOT EXISTS customercart ("+
                        "Id varchar(5) NOT NULL,"+
                        "custId varchar(5) NOT NULL,"+
                        "venueId varchar(11) NOT NULL,"+
                        "PRIMARY KEY (Id)"+
                        ")";
            stmnt.execute(sql);
            stmnt.close();
            cnnct.close();
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex= ex.getNextException();
            }    
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    
    
    
    public boolean addRecord(String custId, String email, String username, int phone, String password,int age ){
        Connection cnnct = null;
        PreparedStatement pStmnt= null;
        boolean isSuccess=false;
        
        try{
            cnnct=getConnection();
            String preQueryStatment="INSERT INTO customer VALUES (?,?,?,?,?,?)";
            pStmnt= cnnct.prepareStatement(preQueryStatment);
            pStmnt.setString(1,custId);
            pStmnt.setString(2,email);
            pStmnt.setString(3,username);
            pStmnt.setInt(4, phone);
            pStmnt.setString(5, password);
            pStmnt.setInt(6, age);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount>=1){
                isSuccess=true;
            }
            pStmnt.close();
            cnnct.close();
        }catch (SQLException ex){
            while(ex!= null){
                ex.printStackTrace();
                ex=ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace( );
        }
        
        return isSuccess;
    }

    public boolean createbooking(int id, String userid, String venue_id, String date, String start_time, String end_time, String Amount){
        Connection cnnct = null;
        PreparedStatement pStmnt= null;
        boolean isSuccess=false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        try{
            cnnct=getConnection();
            String preQueryStatment="INSERT INTO bookings VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pStmnt= cnnct.prepareStatement(preQueryStatment);
            pStmnt.setInt(1,id);
            pStmnt.setString(2,userid);
            pStmnt.setString(3,venue_id);
            pStmnt.setString(4, date);
            pStmnt.setString(5, start_time);
            pStmnt.setString(6, end_time);
            pStmnt.setString(7, "Pending");
            pStmnt.setString(8, "Unpaid");
            pStmnt.setString(9, "2023-04-20 20:13:09");
            pStmnt.setString(10, "2023-04-20 20:13:09");
            pStmnt.setString(11, "Null");
            pStmnt.setString(12, "Null");
            pStmnt.setString(13, dtf.format(now));
            pStmnt.setString(14, dtf.format(now));
            pStmnt.setString(15, "null");
            pStmnt.setString(16, Amount);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount>=1){
                isSuccess=true;
            }
            pStmnt.close();
            cnnct.close();
        }catch (SQLException ex){
            while(ex!= null){
                ex.printStackTrace();
                ex=ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace( );
        }
        
        return isSuccess;
    }
    
     public boolean createguest(int id, String name, String email, int bookingid){
        Connection cnnct = null;
        PreparedStatement pStmnt= null;
        boolean isSuccess=false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        try{
            cnnct=getConnection();
            String preQueryStatment="INSERT INTO guests VALUES (?,?,?,?)";
            pStmnt= cnnct.prepareStatement(preQueryStatment);
            pStmnt.setInt(1,id);
            pStmnt.setString(2,name);
            pStmnt.setString(3,email);
            pStmnt.setInt(4,bookingid);
            
            int rowCount = pStmnt.executeUpdate();
            if (rowCount>=1){
                isSuccess=true;
            }
            pStmnt.close();
            cnnct.close();
        }catch (SQLException ex){
            while(ex!= null){
                ex.printStackTrace();
                ex=ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace( );
        }
        return isSuccess;
    }
    
    public boolean addtocart(String Id, String custId, String venueId){
        Connection cnnct = null;
        PreparedStatement pStmnt= null;
        boolean isSuccess=false;
        try{
            cnnct=getConnection();
            String preQueryStatment="INSERT INTO customercart VALUES (?,?,?)";
            pStmnt= cnnct.prepareStatement(preQueryStatment);
            pStmnt.setString(1, Id);
            pStmnt.setString(2,custId);
             pStmnt.setString(3,venueId);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount>=1){
                isSuccess=true;
            }
            pStmnt.close();
            cnnct.close();
        }catch (SQLException ex){
            while(ex!= null){
                ex.printStackTrace();
                ex=ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace( );
        }
        return isSuccess;
    }
    
    
    
    
    public ArrayList<VenueBean> queryVenue(){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        VenueBean cb=null;
        
        ArrayList<VenueBean> cbList = null;
        
          try {
            cnnct=getConnection();
            String preQueryStatement = "SELECT * FROM venues";
            pStmnt= cnnct.prepareStatement(preQueryStatement);
            
            ResultSet rs = pStmnt.executeQuery();
            cbList = new ArrayList();

            while (rs.next()) {
                cb = new VenueBean();
                cb.setId(rs.getString(1));
                cb.setName(rs.getString(2));
                cb.setType(rs.getString(3));
                cb.setCapacity(rs.getInt(4));
                cb.setLocation(rs.getString(5));
                cb.setDescription(rs.getString(6));
                cb.setPersonInCharge(rs.getString(7));
                cb.setHourlyRate(rs.getInt(8));
                cb.setIsActive(rs.getInt(9));
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
    
    
    
    public ArrayList<VenueBean> queryVenueWhere(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        VenueBean cb=null;
        
        ArrayList<VenueBean> cbList = null;
        
          try {
            cnnct=getConnection();
            String preQueryStatement = "SELECT * FROM venues WHERE id IN (?)";
            pStmnt= cnnct.prepareStatement(preQueryStatement);
          pStmnt.setString(1, id);
            
            ResultSet rs = pStmnt.executeQuery();
            cbList = new ArrayList();

            while (rs.next()) {
                cb = new VenueBean();
                cb.setId(rs.getString(1));
                cb.setName(rs.getString(2));
                cb.setType(rs.getString(3));
                cb.setCapacity(rs.getInt(4));
                cb.setLocation(rs.getString(5));
                cb.setDescription(rs.getString(6));
                cb.setPersonInCharge(rs.getString(7));
                cb.setHourlyRate(rs.getInt(8));
                cb.setIsActive(rs.getInt(9));
                cbList.add(cb);
            }
            pStmnt.close();
            cnnct.close();
            
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
    
    public ArrayList<GuestBean> queryguest(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        GuestBean cb=null;
        
        ArrayList<GuestBean> cbList = null;
        
          try {
            cnnct=getConnection();
            String preQueryStatement = "SELECT * FROM guests WHERE booking_id IN (?)";
            pStmnt= cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            
            ResultSet rs = pStmnt.executeQuery();
            cbList = new ArrayList();

            while (rs.next()) {
                cb = new GuestBean();
                cb.setid(rs.getInt(1));
                cb.setName(rs.getString(2));
                cb.setemail(rs.getString(3));
                cb.setbooking_id(rs.getString(4));
                cbList.add(cb);
            }
            pStmnt.close();
            cnnct.close();
            
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
    
     public ArrayList<BookingBean> querybooking(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        BookingBean cb=null;
        
        ArrayList<BookingBean> cbList = null;
        
          try {
            cnnct=getConnection();
            String preQueryStatement = "SELECT * FROM bookings WHERE user_id=?";
            pStmnt= cnnct.prepareStatement(preQueryStatement);
          pStmnt.setString(1, id);
            
            ResultSet rs = pStmnt.executeQuery();
            cbList = new ArrayList();

            while (rs.next()) {
                cb = new BookingBean();
                cb.setId(rs.getInt(1));
                cb.setUserId(rs.getInt(2));
                cb.setVenueId(rs.getInt(3));
                cb.setDate(rs.getDate(4));
                cb.setStartTime(rs.getTime(5));
                cb.setEndTime(rs.getTime(6));
                cb.setBookingStatus(rs.getString(7));
                cb.setPaymentStatus(rs.getString(8));
                cb.setCheckInTime(rs.getTimestamp(9));
                cb.setCheckOutTime(rs.getTimestamp(10));
                cb.setMemberRemarks(rs.getString(11));
                cb.setStaffRemarks(rs.getString(12));
                cb.setCreatedAt(rs.getTimestamp(13));
                cb.setUpdatedAt(rs.getTimestamp(14));
                cb.setVenueComment(rs.getString(15));
                cb.setAmount(rs.getInt(16));      
                cbList.add(cb);
            }
            pStmnt.close();
            cnnct.close();
            
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

     
     public ArrayList<BookingBean> querybookingByID(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        BookingBean cb=null;
        
        ArrayList<BookingBean> cbList = null;
        
          try {
            cnnct=getConnection();
            String preQueryStatement = "SELECT * FROM bookings WHERE id=?";
            pStmnt= cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            
            ResultSet rs = pStmnt.executeQuery();
            cbList = new ArrayList();

            while (rs.next()) {
                cb = new BookingBean();
                cb.setId(rs.getInt(1));
                cb.setUserId(rs.getInt(2));
                cb.setVenueId(rs.getInt(3));
                cb.setDate(rs.getDate(4));
                cb.setStartTime(rs.getTime(5));
                cb.setEndTime(rs.getTime(6));
                cb.setBookingStatus(rs.getString(7));
                cb.setPaymentStatus(rs.getString(8));
                cb.setCheckInTime(rs.getTimestamp(9));
                cb.setCheckOutTime(rs.getTimestamp(10));
                cb.setMemberRemarks(rs.getString(11));
                cb.setStaffRemarks(rs.getString(12));
                cb.setCreatedAt(rs.getTimestamp(13));
                cb.setUpdatedAt(rs.getTimestamp(14));
                cb.setVenueComment(rs.getString(15));
                cb.setAmount(rs.getInt(16));      
                cbList.add(cb);
            }
            pStmnt.close();
            cnnct.close();
            
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
     
     
    
    public ArrayList<VenueBean> queryCartVenue(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        VenueBean cb=null;
        
        ArrayList<VenueBean> cbList = null;
        
          try {
            cnnct=getConnection();
            String preQueryStatement = "SELECT * FROM venues INNER JOIN customercart ON venues.id=customercart.venueId WHERE customercart.custId=?";
            pStmnt= cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            
            ResultSet rs = pStmnt.executeQuery();
            cbList = new ArrayList();

            while (rs.next()) {
                cb = new VenueBean();
                cb.setId(rs.getString(1));
                cb.setName(rs.getString(2));
                cb.setType(rs.getString(3));
                cb.setCapacity(rs.getInt(4));
                cb.setLocation(rs.getString(5));
                cb.setDescription(rs.getString(6));
                cb.setPersonInCharge(rs.getString(7));
                cb.setHourlyRate(rs.getInt(8));
                cb.setIsActive(rs.getInt(9));
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
    
    

    
    
      public ArrayList<CartBean> queryCustCart(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        CartBean cb=null;
        
        
        ArrayList<CartBean> cbList = null;
        
          try {
            cnnct=getConnection();
            String preQueryStatement = "SELECT * FROM customercart WHERE custId=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);

            ResultSet rs = pStmnt.executeQuery();
            cbList = new ArrayList();
            
            while (rs.next()) {
                cb = new CartBean();
                cb.setId(rs.getString(1));
                cb.setcustId(rs.getString(2));
                cb.setvenueId(rs.getString(3));  
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
    
    public boolean delcart(String custid, String venueId){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
    try{
        cnnct = getConnection();
            String preQueryStatement = "DELETE FROM customercart WHERE custId=?  AND venueId=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, custid);
            pStmnt.setString(2, venueId);
            pStmnt.execute();
            
            System.out.println("" + custid +"," + venueId);
            System.out.println(preQueryStatement);
            
            int count = pStmnt.getUpdateCount();
            if(count>0)
                isSuccess = true;
                        
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
        return isSuccess;
}  
    
    public boolean delbooking(int id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
    try{
        cnnct = getConnection();
            String preQueryStatement = "DELETE FROM bookings WHERE id=?  ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, id);
            pStmnt.execute();
            
            System.out.println(preQueryStatement);
            
            int count = pStmnt.getUpdateCount();
            if(count>0)
                isSuccess = true;
                        
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
        return isSuccess;
}  

//    public ArrayList<BookingBean> querybooking() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
} 
//     public ArrayList<CustomerBean> queryCust() {
//        ArrayList<CustomerBean> customerBeans = new ArrayList<>();
//        CustomerBean cb = null;
//        Connection con = null;
//        PreparedStatement statement = null;
//
//        try {
//            con = getConnection();
//            String query = "SELECT * FROM CUSTOMER";
//            statement = con.prepareStatement(query);
//
//            ResultSet rs = null;
//            rs = statement.executeQuery();
//
//            while (rs.next()) {
//                cb = new CustomerBean();
//                cb.setCustId(rs.getString("custId"));
//                cb.setCustName(rs.getString("name"));
//                cb.setCustTel(rs.getString("tel"));
//                cb.setCustAge(rs.getInt("age"));
//                customerBeans.add(cb);
//            }
//            statement.close();
//            con.close();
//        } catch (SQLException | IOException e) {
//            throw new RuntimeException(e);
//        }
//        return customerBeans;
//    }
    

