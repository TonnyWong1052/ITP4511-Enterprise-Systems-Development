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
//@WebServlet(name = "handleEdit", urlPatterns = {"/handleEdit"})
//public class HandleEdit extends HttpServlet {
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
//        // 4. if action equals to “add”
//        if ("add".equals(action)) {
//            // Get the form parameters
//            String id = request.getParameter("id");
//            String name = request.getParameter("name");
//            String tel = request.getParameter("tel");
//            String age = request.getParameter("age");
//            db.addRecord(id, name, tel, Integer.valueOf(age));
//            response.sendRedirect("handleCustomer?action=list");
//        } else if ("edit".equalsIgnoreCase(action)) {
//            String id = request.getParameter("id");
//            String name = request.getParameter("name");
//            String tel = request.getParameter("tel");
//            String age = request.getParameter("age");
//            CustomerBean customer = new CustomerBean();
//            customer.setCustId(id);
//            customer.setName(name);
//            customer.setTel(tel);
//            customer.setAge(Integer.valueOf(age));
//            db.editRecord(customer);
//            response.sendRedirect("handleCustomer?action=list");
//        // obtain the parameters from request
//        // call editCustomer to update the database record
//        // redirect the result to “list” action again
//        }else {
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
