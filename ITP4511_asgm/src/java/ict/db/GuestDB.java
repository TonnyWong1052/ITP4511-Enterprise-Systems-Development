/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.GuestBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author qwer1
 */
public class GuestDB {
    private String url = "";
    private String username = "";
    private String password = "";

    public GuestDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return DriverManager.getConnection(url, username, password);
    }
    
    public ArrayList<GuestBean> queryCustByID(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        GuestBean bb = null;

        ArrayList<GuestBean> bbList = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM guests WHERE booking_id=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);

            ResultSet rs = pStmnt.executeQuery();
            bbList = new ArrayList();

            while (rs.next()) {
                bb = new GuestBean();
                bb.setId(rs.getInt(1));
                bb.setName(rs.getString(2));
                bb.setEmail(rs.getString(3));
                bbList.add(bb);
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

        return bbList;
    }
}
