/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.BookingBean;
import ict.db.BookingDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author qwer1
 */
@WebServlet(name = "exportCSV", urlPatterns = {"/exportCSV"})
public class exportCSV extends HttpServlet {
    private BookingDB db;
    
    @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new BookingDB(dbUrl, dbUser, dbPassword);
    } 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<BookingBean> booking = db.queryCust();

        // Set the response headers for CSV export
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=orders.csv");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Expires", "0");
        
        System.out.println("Number of bookings: " + booking.size());
        // Write the CSV header
        try (PrintWriter out = response.getWriter()) {
            // Write the CSV header
            out.print("Order ID, User ID, Venue ID, Date, Start Time, End Time, Booking Status, Payment Status, CheckIn Time, CheckOut Time, Created At, Update At, Amount \n");
            // Write the user data
            for (BookingBean b : booking) {
                out.printf("%d,%d,%d,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s \n",
                        b.getId(), b.getUserId(), b.getVenueId(), b.getDate(), b.getStartTime(), b.getEndTime(),
                        b.getBookingStatus(), b.getPaymentStatus(), b.getCheckInTime(), b.getCheckOutTime(),
                        b.getCreatedAt(), b.getUpdatedAt(), b.getAmount());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
