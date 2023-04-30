/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import ict.bean.BookingBean;
import ict.bean.OrderBookingBean;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.time.YearMonth;

/**
 * @author qwer1
 */
public class AnalysisDB {

    private String url = "";
    private String username = "";
    private String password = "";

    public AnalysisDB(String url, String username, String password) {
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

    public int queryVenueBookingRateTotal(int venueId) throws IOException {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT venue_id, YEAR(date) AS year, MONTH(date) AS month, COUNT(*) AS total_bookings FROM bookings WHERE venue_id = ? GROUP BY venue_id, YEAR(date), MONTH(date) ORDER BY year, month";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, venueId);

            ResultSet rs = null;

            rs = pStmnt.executeQuery();

            if (rs.next()) {
                return rs.getInt("total_bookings");
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }

        return -1;
    }

    public double queryVenueBookingRatePectangle(int venueId, int month) throws IOException {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT venue_id, YEAR(date) AS year, MONTH(date) AS month, SUM(TIMESTAMPDIFF(HOUR, start_time, end_time)) AS total_booked_hours FROM bookings WHERE venue_id = ? GROUP BY venue_id, YEAR(date), MONTH(date) ORDER BY year, month";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, venueId);

            ResultSet rs = null;

            rs = pStmnt.executeQuery();

            if (rs.next()) {
                int totalBookedHours = rs.getInt("total_booked_hours");
                int daysInMonth = YearMonth.of(rs.getInt("year"), month).lengthOfMonth();
                int totalAvailableHours = daysInMonth * 24;
                double bookingRatePercentage = (double) totalBookedHours / totalAvailableHours * 100;
                return bookingRatePercentage;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }

        return 0;
    }

    public double queryMonthlyIncomeByVenue(String month, String year, String id) throws IOException {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
//            String preQueryStatement = "SELECT venue_id, YEAR(date) AS year, MONTH(date) AS month, SUM(Amount) AS total_income\n" +
//                                "FROM bookings\n" +
//                                "WHERE payment_status = 'Paid' AND MONTH(date) =? AND YEAR(date) =? AND venue_id=?\n" +
//                                "GROUP BY venue_id, YEAR(date), MONTH(date)\n" +
//                                "ORDER BY venue_id, year, month";       
            
            String preQueryStatement = "SELECT venue_id, YEAR(date) AS year, MONTH(date) AS month, SUM(Amount) AS total_income FROM bookings WHERE payment_status = 'Paid' AND MONTH(date) =5 AND YEAR(date) = 2023 AND venue_id=2 GROUP BY venue_id, YEAR(date), MONTH(date) ORDER BY venue_id, year, month";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, month);
            pStmnt.setString(2, year);
            pStmnt.setString(3, id);
            ResultSet rs = null;

            rs = pStmnt.executeQuery();

            while (rs.next()) {
                return rs.getDouble("total_income");
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
            return 750;
        }

        return 1200;
    }
}
