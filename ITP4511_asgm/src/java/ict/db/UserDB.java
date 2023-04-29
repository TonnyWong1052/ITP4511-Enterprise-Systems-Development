/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.UserBean;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author qwer1
 */
public class UserDB {
    private String url = "";
    private String username = "";
    private String password = "";
    
    public UserDB(String url, String username, String password){
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
    
    public ArrayList<UserBean> queryUserByID(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        UserBean userBean = null;

        ArrayList<UserBean> userList = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM users WHERE id=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);

            ResultSet rs = pStmnt.executeQuery();
            userList = new ArrayList<>();

            while (rs.next()) {
                userBean = new UserBean();
                userBean.setId(rs.getInt("id"));
                userBean.setName(rs.getString("name"));
                userBean.setPhone(rs.getInt("Phone"));
                userBean.setEmail(rs.getString("email"));
                userBean.setPassword(rs.getString("password"));
                userBean.setRole(rs.getString("role"));
                userBean.setStatus(rs.getString("status"));
                userList.add(userBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return userList;
    }
    
    public ArrayList<UserBean> queryUser() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        UserBean userBean = null;

        ArrayList<UserBean> userList = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM users";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            ResultSet rs = pStmnt.executeQuery();
            userList = new ArrayList<>();

            while (rs.next()) {
                userBean = new UserBean();
                userBean.setId(rs.getInt("id"));
                userBean.setName(rs.getString("name"));
                userBean.setPhone(rs.getInt("Phone"));
                userBean.setEmail(rs.getString("email"));
                userBean.setPassword(rs.getString("password"));
                userBean.setRole(rs.getString("role"));
                userBean.setStatus(rs.getString("status"));
                userList.add(userBean);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return userList;
    }
    
    public int createRecord(UserBean userBean) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        int generatedId = -1;

        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO users (name, phone, email, password, role, status) VALUES (?, ?, ?, ?, ?, ?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement, PreparedStatement.RETURN_GENERATED_KEYS);
            pStmnt.setString(1, userBean.getName());
            pStmnt.setInt(2, userBean.getPhone());
            pStmnt.setString(3, userBean.getEmail());
            pStmnt.setString(4, userBean.getPassword());
            pStmnt.setString(5, userBean.getRole());
            pStmnt.setString(6, userBean.getStatus());

            pStmnt.executeUpdate();

            ResultSet rs = pStmnt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return generatedId;
    }
    
    public boolean editRecord(UserBean userBean) throws SQLException {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;

        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE users SET name = ?, phone = ?, email = ?, password = ?, role = ?, status = ? WHERE id = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, userBean.getName());
            pStmnt.setInt(2, userBean.getPhone());
            pStmnt.setString(3, userBean.getEmail());
            pStmnt.setString(4, userBean.getPassword());
            pStmnt.setString(5, userBean.getRole());
            pStmnt.setString(6, userBean.getStatus());
            pStmnt.setInt(7, userBean.getId());

            pStmnt.executeUpdate();

            int count = pStmnt.getUpdateCount();
            System.out.println(count);
            if (count > 0)
                isSuccess = true;

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
        while (ex != null) {
            ex.printStackTrace();
            ex = ex.getNextException();
        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return isSuccess;
    }
    
    public boolean deleteRecord(String id) throws SQLException {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;

        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM users WHERE id = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);

            pStmnt.executeUpdate();

            int count = pStmnt.getUpdateCount();
            System.out.println(count);
            if (count > 0)
                isSuccess = true;

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return isSuccess;
    }
}
