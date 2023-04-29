/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.BookingBean;
import ict.bean.OrderBookingBean;
import ict.bean.UserBean;
import ict.db.UserDB;
import ict.db.VenueDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author qwer1
 */
@WebServlet(name = "handleUserManagement", urlPatterns = {"/handleUserManagement"})
public class handleUserManagement extends HttpServlet {
    private UserDB db;
    
    @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB(dbUrl, dbUser, dbPassword);
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
        RequestDispatcher rd;
        String action = request.getParameter("search");
            if (!"".equals(action) && action != null) {
                ArrayList<UserBean> user = db.queryUserByID(action);
                request.setAttribute("u", user);

                rd = getServletContext().getRequestDispatcher("/userManagement.jsp");
                rd.forward(request, response);
            }
//else{
//            ArrayList<UserBean> user = db.queryUserByID(id);
//            request.setAttribute("u", user);
//            rd = getServletContext().getRequestDispatcher("/userManagement.jsp");
//            rd.forward(request, response);
//        }
        //OrderBookingBean obb = db.queryCustOrderBooking(id);
        //request.setAttribute("obb", obb);
//        RequestDispatcher rd;
        ArrayList<UserBean> user = db.queryUser();
        request.setAttribute("u", user);
        rd = getServletContext().getRequestDispatcher("/userManagement.jsp");
        rd.forward(request, response);
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
