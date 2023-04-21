///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ict.servlet;
//
//import ict.bean.CustomerBean;
//import ict.db.CustomerDB;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author user
// */
//@WebServlet(name = "handleCustomer", urlPatterns = {"/handleCustomer"})
//public class HandleCustomer extends HttpServlet {
//    private CustomerDB db;
//    public void init() {
//        String dbUser = this.getServletContext().getInitParameter("dbUser");
//        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
//        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
//        db = new CustomerDB(dbUrl, dbUser, dbPassword);
//    } 
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        
//        if ("delete".equalsIgnoreCase(action)) {
//            String id = request.getParameter("id");
//            if (id != null) {
//                // call delete record method in the database
//                // redirect the result to list action
//                db.delRecord(id);
//                response.sendRedirect("handleCustomer?action=list");
//            }
//        }else if ("getEditCustomer".equalsIgnoreCase(action)) {
//            // obtain the parameter id;
//            String id = request.getParameter("id");
//            if (id != null) {
//                // call query db to get retrieve for a customer with the given id
//                CustomerBean customer = db.queryCustByID(id);
//                // set the customer as attribute in request scope
//                request.setAttribute("c", customer);
//                RequestDispatcher rd;
//                rd = getServletContext().getRequestDispatcher("/editCustomer.jsp");
//                rd.forward(request, response);
//            }
//        }else if ("list".equalsIgnoreCase(action)) {
//            // call the query db to get retrieve for all customer
//            ArrayList<CustomerBean> customers = db.queryCust();
//            // set the result into the attribute
//            request.setAttribute("customers", customers);
//            // redirect the result to the listCustomers.jsp
//            RequestDispatcher rd;
//            rd = getServletContext().getRequestDispatcher("/listCustomers.jsp");
//            rd.forward(request, response);
//        }else if ("search".equalsIgnoreCase(action)) {
//            // obtain the parameter name;
//            if (name != null) {
//                ArrayList<CustomerBean> customers;
//                // call queryByName from db
//                // to retrieve for customers with the given name
//                // set the result into the attribute in request
//                // forward the result to the listCustoemrs.jsp
//            }
//        } else {
//            PrintWriter out = response.getWriter();
//            out.println("No such action!!!");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
