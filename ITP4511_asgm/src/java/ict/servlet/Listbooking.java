/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.DB.CustomerDB;
import ict.bean.BookingBean;
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
@WebServlet(name = "Listbooking", urlPatterns = {"/Listbooking"})
public class Listbooking extends HttpServlet {
        private CustomerDB db;
     
    public void init() throws ServletException {
        db = new CustomerDB();
    }     
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        
//        if("list".equalsIgnoreCase(action)){
            ArrayList<BookingBean> booking = db.querybooking("2");
            request.setAttribute("booking", booking);
            
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/CheckBooking.jsp");
            rd.forward(request, response);
//         }else{
//            PrintWriter out = response.getWriter();
//            out.println("No such action!!");
//        }
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
