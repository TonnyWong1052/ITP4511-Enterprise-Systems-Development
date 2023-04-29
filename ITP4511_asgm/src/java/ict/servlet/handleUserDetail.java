/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.BookingBean;
import ict.bean.UserBean;
import ict.db.BookingDB;
import ict.db.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "handleUserDetail", urlPatterns = {"/handleUserDetail"})
public class handleUserDetail extends HttpServlet {

    private UserDB db;
    private BookingDB bdb;

    @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB(dbUrl, dbUser, dbPassword);
        bdb = new BookingDB(dbUrl, dbUser, dbPassword);
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
            throws ServletException, IOException, SQLException {
        RequestDispatcher rd;
        String action = request.getParameter("action");
        UserBean u = new UserBean();

        if (action.equals("delete")) {
            String id = request.getParameter("id");
            db.deleteRecord(id);
            response.sendRedirect("handleUserManagement");
        } else if (action.equals("create")) {
//            check the user submit the form to create acccount  or not
            if (request.getParameter("name") != null) {
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String role = request.getParameter("role");
                u.setName(name);
                u.setPhone(Integer.valueOf(phone));
                u.setEmail(email);
                u.setPassword(password);
                u.setRole(role);
                db.createRecord(u);
                response.sendRedirect("handleUserManagement");
            } else {
                request.setAttribute("u", u);
                ArrayList<BookingBean> bb = new ArrayList<BookingBean>();
                request.setAttribute("b", bb);
                rd = getServletContext().getRequestDispatcher("/userDetail.jsp");
                rd.forward(request, response);
            }
        } else if (action.equals("edit")) {
//            check the user submit the form to edit acccount detail or not
            if (request.getParameter("name") != null) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String role = request.getParameter("role");
                u.setId(Integer.valueOf(id));
                u.setName(name);
                u.setPhone(Integer.valueOf(phone));
                u.setEmail(email);
                u.setPassword(password);
                u.setRole(role);
                db.editRecord(u);
                request.setAttribute("message", "Update data successfully");
            }
            String id = request.getParameter("id");
            ArrayList<UserBean> user = db.queryUserByID(id);
            UserBean ue = user.get(0);
            ArrayList<BookingBean> bb = bdb.queryCustByUserIDv2(id);
            request.setAttribute("u", ue);
            request.setAttribute("b", bb);
            rd = getServletContext().getRequestDispatcher("/userDetail.jsp");
            rd.forward(request, response);
        } else {
            rd = getServletContext().getRequestDispatcher("/errorPage/error.html");
            rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(handleUserDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(handleUserDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
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
