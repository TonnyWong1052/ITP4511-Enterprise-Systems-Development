/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.DB.CustomerDB;
import ict.bean.BookingBean;
import ict.bean.GuestBean;
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
@WebServlet(name = "ListBookingDetail", urlPatterns = {"/ListBookingDetail"})
public class ListBookingDetail extends HttpServlet {
private CustomerDB db;
     
    public void init() throws ServletException {
        db = new CustomerDB();
    }     
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{   
            String id = request.getParameter("vid");           
            ArrayList<VenueBean> venuesk = db.queryVenueWhere(id);
            request.setAttribute("venuesk", venuesk);
            
            
            
//            request.setAttribute("venues", allVenues);
//            RequestDispatcher rd;
//            rd = getServletContext().getRequestDispatcher("/CreateBooking.jsp");
//            rd.forward(request, response);
           
            String id2 = request.getParameter("id");           
            ArrayList<GuestBean> aguests = db.queryguest(id2);
            request.setAttribute("guests", aguests);
            
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/UpdatePersonalRD.jsp");
            rd.forward(request, response);
            
           }catch (Exception e){
               PrintWriter out = response.getWriter();
            out.println("No such action!!" + e);
           }
            
            
            
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


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
