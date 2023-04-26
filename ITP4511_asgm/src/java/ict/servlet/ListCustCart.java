/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.DB.CustomerDB;
import ict.bean.VenueBean;
import java.io.IOException;
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
@WebServlet(name = "ListCustCart", urlPatterns = {"/ListCustCart"})
public class ListCustCart extends HttpServlet {
    private CustomerDB db;
    
        public void init() throws ServletException {
        db = new CustomerDB();
    }     
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ArrayList<VenueBean> venues2 = db.queryCartVenue("2");
            request.setAttribute("venues2", venues2);
            
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/cart.jsp");
            rd.forward(request, response);
        
        
    }
    
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
