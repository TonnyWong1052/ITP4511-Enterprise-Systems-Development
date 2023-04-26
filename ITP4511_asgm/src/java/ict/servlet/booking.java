/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.DB.CustomerDB;
import ict.bean.VenueBean;
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
@WebServlet(name="booking", urlPatterns={"/booking"})
public class booking extends HttpServlet {
      private int textid =1;
      private CustomerDB db;
      private String x2;
      private String x ="";
      public void init() throws ServletException {
        db = new CustomerDB();
    }  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html");
   response.setContentType("text/html");
    PrintWriter out =response.getWriter();
    String[] venueid = request.getParameterValues("ide");
    ArrayList<VenueBean> allVenues = new ArrayList<>();
   ArrayList<VenueBean> venues= new ArrayList<>();
    if (venueid!=null){
        for (int i=0; i<venueid.length; i++){
             x  = x+ venueid[i];
    venues = db.queryVenueWhere(venueid[i]);
    allVenues.addAll(venues);
        }
     out.println(allVenues);
       request.setAttribute("venues", allVenues);
       RequestDispatcher rd;
       rd = getServletContext().getRequestDispatcher("/CreateBooking.jsp");
       rd.forward(request, response);
       out.println("successful!!");
       
        }else{
        out.println("error");
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
