///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ict.db;
//
//import ict.bean.CustomerBean;
//import java.io.IOException;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
///**
// *
// * @author user
// */
//public class CustomerDB {
//    private String url = "";
//    private String username = "";
//    private String password = "";
//    
//    public CustomerDB(String url, String username, String password){
//        this.url = url;
//        this.username = username;
//        this.password = password;
//    }
//    
//    public Connection getConnection() throws SQLException, IOException{
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        }catch (ClassNotFoundException ex){
//            ex.printStackTrace();
//        }
//        
//        return DriverManager.getConnection(url, username, password);
//    }
//    
//    public void createCustTable(){
//        Statement stmnt = null;
//        Connection cnnct = null;
//        try{
//            cnnct = getConnection();
//            stmnt = cnnct.createStatement();
//            String sql
//                    = "CREATE TABLE IF NOT EXISTS customer ("
//                    + "custId varchar(5) NOT NULL,"
//                    + "name varchar(25) NOT NULL,"
//                    + "tel varchar(10) NOT NULL,"
//                    + "age int(11) NOT NULL,"
//                    + "PRIMARY KEY (custId)"
//                    + ")";
//                    stmnt.execute(sql);
//                    stmnt.close();
//                    cnnct.close();
//        }catch(SQLException ex){
//            while(ex!=null){
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//    }
//    
//    public boolean addRecord(String CustId, String Name, String Tel, int Age){
//        Connection connct = null;
//        PreparedStatement pStmnt = null;
//        boolean isSuccess = false;
//        try{
//            connct = getConnection();
//            String preQueryStatement = "INSERT INTO CUSTOMER VALUES (?,?,?,?)";
//            pStmnt = connct.prepareStatement(preQueryStatement);
//            pStmnt.setString(1, CustId);
//            pStmnt.setString(2, Name);
//            pStmnt.setString(3, Tel);
//            pStmnt.setInt(4, Age);
//            int rowCount = pStmnt.executeUpdate();
//            if(rowCount >= 1){
//                isSuccess = true;
//            }
//            pStmnt.close();
//            connct.close();            
//        }catch(SQLException ex){
//            return isSuccess;
//            
//        } catch(IOException ex){
//            return isSuccess;
//        }
//        return isSuccess;
//    }
//    
//    public CustomerBean queryCustByID(String id){
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        CustomerBean cb = null;
//        try{
//            cnnct = getConnection();
//            String preQueryStatement = "SELECT * FROM CUSTOMER WHERE CUSTID=?";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            pStmnt.setString(1, id);
//            
//            ResultSet rs = null;
//            
//            rs = pStmnt.executeQuery();
//            
//            if(rs.next()){
//                cb = new CustomerBean();
//                cb.setCustId(rs.getString(1));
//                cb.setName(rs.getString(2));
//                cb.setTel(rs.getString(3));
//                cb.setAge(rs.getInt(4));
//            }
//            pStmnt.close();
//            cnnct.close();
//        }catch(SQLException ex){
//            while(ex != null){
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//        
//        return cb;
//    }
//    
//    public ArrayList<CustomerBean> queryCustByName(String name){
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        CustomerBean cb = null;
//        
//        ArrayList<CustomerBean> cbList = null;
//                
//        try{
//            cnnct = getConnection();
//            String preQueryStatement = "SELECT * FROM CUSTOMER WHERE name=?";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            pStmnt.setString(1, name);
//            
//            ResultSet rs = pStmnt.executeQuery();
//            cbList = new ArrayList();
//            
//            while(rs.next()){
//                cb = new CustomerBean();
//                cb.setCustId(rs.getString(1));
//                cb.setName(rs.getString(2));
//                cb.setTel(rs.getString(3));
//                cb.setAge(rs.getInt(4));
//                cbList.add(cb);
//            }
//            pStmnt.close();
//            cnnct.close();
//        }catch(SQLException ex){
//            while(ex != null){
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//        
//        return cbList;
//    }
//    
//    public ArrayList<CustomerBean> queryCustByTel(String Tel){
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        CustomerBean cb = null;
//        
//        ArrayList<CustomerBean> cbList = null;
//                
//        try{
//            cnnct = getConnection();
//            String preQueryStatement = "SELECT * FROM CUSTOMER WHERE name=?";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            pStmnt.setString(1, Tel);
//            
//            ResultSet rs = pStmnt.executeQuery();
//            cbList = new ArrayList();
//            
//            while(rs.next()){
//                cb = new CustomerBean();
//                cb.setCustId(rs.getString(1));
//                cb.setName(rs.getString(2));
//                cb.setTel(rs.getString(3));
//                cb.setAge(rs.getInt(4));
//                cbList.add(cb);
//            }
//            pStmnt.close();
//            cnnct.close();
//        }catch(SQLException ex){
//            while(ex != null){
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//        
//        return cbList;
//    }
//    
//    public ArrayList<CustomerBean> queryCust(){
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        CustomerBean cb = null;
//        
//        ArrayList<CustomerBean> cbList = null;
//                
//        try{
//            cnnct = getConnection();
//            String preQueryStatement = "SELECT * FROM CUSTOMER";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            
//            ResultSet rs = pStmnt.executeQuery();
//            cbList = new ArrayList();
//            
//            while(rs.next()){
//                cb = new CustomerBean();
//                cb.setCustId(rs.getString(1));
//                cb.setName(rs.getString(2));
//                cb.setTel(rs.getString(3));
//                cb.setAge(rs.getInt(4));
//                cbList.add(cb);
//            }
//            pStmnt.close();
//            cnnct.close();
//        }catch(SQLException ex){
//            while(ex != null){
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//        
//        return cbList;
//    }
//    
//    public boolean delRecord(String custId){
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        boolean isSuccess = false;
//        try{
//            cnnct = getConnection();
//            String preQueryStatement = "DELETE FROM CUSTOMER WHERE custId=?";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            pStmnt.setString(1, custId);
//            
//            pStmnt.execute();
//            
//            int count = pStmnt.getUpdateCount();
//            if(count>0)
//                isSuccess = true;
//                        
//            pStmnt.close();
//            cnnct.close();
//        }catch(SQLException ex){
//            while(ex != null){
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//        return isSuccess;
//    }
//    
//    public boolean editRecord(CustomerBean cb){
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        boolean isSuccess = false;
//        try{
//            cnnct = getConnection();
//            String preQueryStatement = "UPDATE CUSTOMER SET "
//                    + " name=?, tel=?, age=? WHERE custId=?";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            pStmnt.setString(1, cb.getName());
//            pStmnt.setString(2, cb.getTel());
//            pStmnt.setInt(3, cb.getAge());
//            pStmnt.setString(4, cb.getCustId());
//            
//            pStmnt.executeUpdate();
//            
//            int count = pStmnt.getUpdateCount();
//            if(count>0)
//                isSuccess = true;
//                        
//            pStmnt.close();
//            cnnct.close();
//        }catch(SQLException ex){
//            while(ex != null){
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//        return isSuccess;
//    }
//    
//    public void dropCustTable(){
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        try{
//            cnnct = getConnection();
//            String preQueryStatement = "drop table CUSTOMER";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            
//            pStmnt.execute();
//                        
//            pStmnt.close();
//            cnnct.close();
//        }catch(SQLException ex){
//            while(ex != null){
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//    }
//    
//    public void createDB(){
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        try{
//            cnnct = getConnection();
//            String preQueryStatement = "CREATE DATABASE itp4512_db;";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            
//            pStmnt.execute();
//                        
//            pStmnt.close();
//            cnnct.close();
//        }catch(SQLException ex){
//            while(ex != null){
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//    }
//    
//}
