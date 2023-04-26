/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.DB.CustomerDB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author qwer1
 */
@WebServlet(name="deletebooking", urlPatterns={"/deletebooking"})
public class deletebooking  extends HttpServlet {
     private CustomerDB db;
     
      public void init() throws ServletException {
        db = new CustomerDB();
    }
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String id = request.getParameter("id");
            int id2 =  Integer.parseInt(id);
            CustomerDB custDB = new CustomerDB();
            boolean deleteSuccess = custDB.delbooking(id2);
            if(deleteSuccess){
                 PrintWriter out = response.getWriter();
                out.println("Reocrd has been deleted successfully");
             }else{
                 PrintWriter out = response.getWriter();
                out.println("Record not found");
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
