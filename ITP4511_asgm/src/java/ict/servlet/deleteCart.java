/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.DB.CustomerDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author qwer1
 */
@WebServlet(name="deleteCart", urlPatterns={"/deleteCart"})

public class deleteCart  extends HttpServlet {
     private CustomerDB db;
     
      public void init() throws ServletException {
        db = new CustomerDB();
    }     
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String venueid = request.getParameter("id");
    CustomerDB custDB = new CustomerDB();
    boolean deleteSuccess = custDB.delcart("2", venueid);
       if(deleteSuccess){
           System.out.println("Reocrd has been deleted successfully");
        }else{
            System.out.println("Record not found");
}
    
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
