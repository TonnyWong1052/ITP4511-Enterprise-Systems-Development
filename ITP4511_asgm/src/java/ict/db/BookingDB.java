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

/**
 *
 * @author qwer1
 */
public class BookingDB {

    private String url = "";
    private String username = "";
    private String password = "";

    public BookingDB(String url, String username, String password) {
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

    public int createRecord(BookingBean booking) throws IOException {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        int generatedId = -1;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO bookings (user_id, venue_id, date, start_time, end_time, booking_status, payment_status, check_in_time, check_out_time, member_remarks, staff_remarks, created_at, updated_at, venue_comment, Amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement, PreparedStatement.RETURN_GENERATED_KEYS);
            pStmnt.setInt(1, booking.getUserId());
            pStmnt.setInt(2, booking.getVenueId());
            pStmnt.setDate(3, booking.getDate());
            pStmnt.setTime(4, booking.getStartTime());
            pStmnt.setTime(5, booking.getEndTime());
            pStmnt.setString(6, booking.getBookingStatus());
            pStmnt.setString(7, booking.getPaymentStatus());
            pStmnt.setTimestamp(8, booking.getCheckInTime());
            pStmnt.setTimestamp(9, booking.getCheckOutTime());
            pStmnt.setString(10, booking.getMemberRemarks());
            pStmnt.setString(11, booking.getStaffRemarks());
            pStmnt.setTimestamp(12, booking.getCreatedAt());
            pStmnt.setTimestamp(13, booking.getUpdatedAt());
            pStmnt.setString(14, booking.getVenueComment());
            pStmnt.setInt(15, booking.getAmount());
            pStmnt.executeUpdate();

            ResultSet rs = pStmnt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
//            System.out.println(ex.getMessage());
        }
        return generatedId;
    }

    // Method for editing an existing BookingBean record
    public boolean editRecord(BookingBean booking) throws SQLException {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE bookings SET user_id = ?, venue_id = ?, date = ?, start_time = ?, end_time = ?, booking_status = ?, payment_status = ?, check_in_time = ?, check_out_time = ?, member_remarks = ?, staff_remarks = ?, updated_at = ?, venue_comment = ?, Amount = ? WHERE id = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, booking.getUserId());
            pStmnt.setInt(2, booking.getVenueId());
            pStmnt.setDate(3, booking.getDate());
            pStmnt.setTime(4, booking.getStartTime());
            pStmnt.setTime(5, booking.getEndTime());
            pStmnt.setString(6, booking.getBookingStatus());
            pStmnt.setString(7, booking.getPaymentStatus());
            pStmnt.setTimestamp(8, booking.getCheckInTime());
            pStmnt.setTimestamp(9, booking.getCheckOutTime());
            pStmnt.setString(10, booking.getMemberRemarks());
            pStmnt.setString(11, booking.getStaffRemarks());
            pStmnt.setTimestamp(12, booking.getUpdatedAt());
            pStmnt.setString(13, booking.getVenueComment());
            pStmnt.setInt(14, booking.getAmount());
            pStmnt.setInt(15, booking.getId());

            pStmnt.executeUpdate();

            int count = pStmnt.getUpdateCount();
            System.out.println(count);
            if (count > 0) {
                isSuccess = true;
            }

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

    public ArrayList<BookingBean> queryCustByID(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        BookingBean bb = null;

        ArrayList<BookingBean> bbList = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM bookings WHERE id=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);

            ResultSet rs = pStmnt.executeQuery();
            bbList = new ArrayList();

            while (rs.next()) {
                bb = new BookingBean();
                bb.setId(rs.getInt(1));
                bb.setUserId(rs.getInt(2));
                bb.setVenueId(rs.getInt(3));
                bb.setDate(rs.getDate(4));
                bb.setStartTime(rs.getTime(5));
                bb.setEndTime(rs.getTime(6));
                bb.setBookingStatus(rs.getString(7));
                bb.setPaymentStatus(rs.getString(8));
                bb.setCheckInTime(rs.getTimestamp(9));
                bb.setCheckOutTime(rs.getTimestamp(10));
                bb.setMemberRemarks(rs.getString(11));
                bb.setStaffRemarks(rs.getString(12));
                bb.setCreatedAt(rs.getTimestamp(13));
                bb.setUpdatedAt(rs.getTimestamp(14));
                bb.setVenueComment(rs.getString(15));
                bb.setAmount(rs.getInt(16));

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

    public ArrayList<BookingBean> queryCust() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        BookingBean bb = null;

        ArrayList<BookingBean> bbList = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM bookings";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            ResultSet rs = pStmnt.executeQuery();
            bbList = new ArrayList();

            while (rs.next()) {
                bb = new BookingBean();
                bb.setId(rs.getInt(1));
                bb.setUserId(rs.getInt(2));
                bb.setVenueId(rs.getInt(3));
                bb.setDate(rs.getDate(4));
                bb.setStartTime(rs.getTime(5));
                bb.setEndTime(rs.getTime(6));
                bb.setBookingStatus(rs.getString(7));
                bb.setPaymentStatus(rs.getString(8));
                bb.setCheckInTime(rs.getTimestamp(9));
                bb.setCheckOutTime(rs.getTimestamp(10));
                bb.setMemberRemarks(rs.getString(11));
                bb.setStaffRemarks(rs.getString(12));
                bb.setCreatedAt(rs.getTimestamp(13));
                bb.setUpdatedAt(rs.getTimestamp(14));
                bb.setVenueComment(rs.getString(15));
                bb.setAmount(rs.getInt(16));
                bbList.add(bb);
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        }
        return bbList;
    }

    public ArrayList<BookingBean> queryCustByIDv2(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        BookingBean bb = null;

        ArrayList<BookingBean> bbList = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT id, user_id, venue_id, date, start_time, end_time, booking_status, payment_status, check_in_time, check_out_time, member_remarks, staff_remarks, created_at, updated_at, venue_comment, Amount, COUNT(id) AS total_item, SUM(Amount) AS Total_Amount FROM bookings WHERE id=? GROUP BY id";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);

            ResultSet rs = pStmnt.executeQuery();
            bbList = new ArrayList();

            while (rs.next()) {
                bb = new BookingBean();
                bb.setId(rs.getInt(1));
                bb.setUserId(rs.getInt(2));
                bb.setVenueId(rs.getInt(3));
                bb.setDate(rs.getDate(4));
                bb.setStartTime(rs.getTime(5));
                bb.setEndTime(rs.getTime(6));
                bb.setBookingStatus(rs.getString(7));
                bb.setPaymentStatus(rs.getString(8));
                bb.setCheckInTime(rs.getTimestamp(9));
                bb.setCheckOutTime(rs.getTimestamp(10));
                bb.setMemberRemarks(rs.getString(11));
                bb.setStaffRemarks(rs.getString(12));
                bb.setCreatedAt(rs.getTimestamp(13));
                bb.setUpdatedAt(rs.getTimestamp(14));
                bb.setVenueComment(rs.getString(15));
                bb.setAmount(rs.getInt(16));
                bb.setTotal_item(rs.getInt(17));
                bb.setTotalAmount(rs.getInt(18));
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

    public ArrayList<BookingBean> queryCustv2() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        BookingBean bb = null;

        ArrayList<BookingBean> bbList = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT id, user_id, venue_id, date, start_time, end_time, booking_status, payment_status, check_in_time, check_out_time, member_remarks, staff_remarks, created_at, updated_at, venue_comment, Amount, COUNT(`id`) AS `total_item`, SUM(`Amount`) AS Total_Amount FROM bookings GROUP BY `id`";
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            ResultSet rs = pStmnt.executeQuery();
            bbList = new ArrayList();

            while (rs.next()) {

                bb = new BookingBean();
                bb.setId(rs.getInt(1));
                bb.setUserId(rs.getInt(2));
                bb.setVenueId(rs.getInt(3));
                bb.setDate(rs.getDate(4));
                bb.setStartTime(rs.getTime(5));
                bb.setEndTime(rs.getTime(6));
                bb.setBookingStatus(rs.getString(7));
                bb.setPaymentStatus(rs.getString(8));
                bb.setCheckInTime(rs.getTimestamp(9));
                bb.setCheckOutTime(rs.getTimestamp(10));
                bb.setMemberRemarks(rs.getString(11));
                bb.setStaffRemarks(rs.getString(12));
                bb.setCreatedAt(rs.getTimestamp(13));
                bb.setUpdatedAt(rs.getTimestamp(14));
                bb.setVenueComment(rs.getString(15));
                bb.setAmount(rs.getInt(16));
                bb.setTotal_item(rs.getInt(17));
                bb.setTotalAmount(rs.getInt(18));
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

    public OrderBookingBean queryCustOrderBooking(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        BookingBean bb = null;

        OrderBookingBean obb = new OrderBookingBean();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT id, user_id, venue_id, date, start_time, end_time, booking_status, payment_status, check_in_time, check_out_time, member_remarks, staff_remarks, created_at, updated_at, venue_comment, Amount FROM bookings WHERE `id`=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);

            ResultSet rs = pStmnt.executeQuery();

            while (rs.next()) {
                obb.setOrderID(rs.getInt(1));
                obb.setUserID(rs.getInt(2));
                bb = new BookingBean();
                bb.setId(rs.getInt(1));
                bb.setUserId(rs.getInt(2));
                bb.setVenueId(rs.getInt(3));
                bb.setDate(rs.getDate(4));
                bb.setStartTime(rs.getTime(5));
                bb.setEndTime(rs.getTime(6));
                bb.setBookingStatus(rs.getString(7));
                bb.setPaymentStatus(rs.getString(8));
                bb.setCheckInTime(rs.getTimestamp(9));
                bb.setCheckOutTime(rs.getTimestamp(10));
                bb.setMemberRemarks(rs.getString(11));
                bb.setStaffRemarks(rs.getString(12));
                bb.setCreatedAt(rs.getTimestamp(13));
                bb.setUpdatedAt(rs.getTimestamp(14));
                bb.setVenueComment(rs.getString(15));
                bb.setAmount(rs.getInt(16));
                obb.addBooking(bb);
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

        return obb;
    }

    public ArrayList<BookingBean> queryCustByUserIDv2(String UserId) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        BookingBean bb = null;

        ArrayList<BookingBean> bbList = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT id, user_id, venue_id, date, start_time, end_time, booking_status, payment_status, check_in_time, check_out_time, member_remarks, staff_remarks, created_at, updated_at, venue_comment, Amount, COUNT(`id`) AS `total_item`, SUM(`Amount`) AS Total_Amount FROM bookings WHERE `user_id`=? GROUP BY `id`";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, UserId);

            ResultSet rs = pStmnt.executeQuery();
            bbList = new ArrayList();

            while (rs.next()) {
                bb = new BookingBean();
                bb.setId(rs.getInt(1));
                bb.setUserId(rs.getInt(2));
                bb.setVenueId(rs.getInt(3));
                bb.setDate(rs.getDate(4));
                bb.setStartTime(rs.getTime(5));
                bb.setEndTime(rs.getTime(6));
                bb.setBookingStatus(rs.getString(7));
                bb.setPaymentStatus(rs.getString(8));
                bb.setCheckInTime(rs.getTimestamp(9));
                bb.setCheckOutTime(rs.getTimestamp(10));
                bb.setMemberRemarks(rs.getString(11));
                bb.setStaffRemarks(rs.getString(12));
                bb.setCreatedAt(rs.getTimestamp(13));
                bb.setUpdatedAt(rs.getTimestamp(14));
                bb.setVenueComment(rs.getString(15));
                bb.setAmount(rs.getInt(16));
                bb.setTotal_item(rs.getInt(17));
                bb.setTotalAmount(rs.getInt(18));
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

    public boolean updateBookingStatusById(int id, String newStatus) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isUpdated = false;

        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE bookings SET booking_status=? WHERE id=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, newStatus);
            pStmnt.setInt(2, id);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount > 0) {
                isUpdated = true;
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

        return isUpdated;
    }
}
