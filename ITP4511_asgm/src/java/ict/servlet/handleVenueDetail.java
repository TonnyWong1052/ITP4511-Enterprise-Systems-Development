/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.venuesBean;
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
 * @author User
 */
@WebServlet(name = "handleVenueDetail", urlPatterns = {"/handleVenueDetail"})
public class handleVenueDetail extends HttpServlet {
    private VenueDB db;
    
    @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new VenueDB(dbUrl, dbUser, dbPassword);
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
        String id = request.getParameter("id"); 
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String capacity = request.getParameter("capacity");
        String location = request.getParameter("location");
        String description = request.getParameter("description");
        String person_in_charge = request.getParameter("person_in_charge");
        String hourly_rate = request.getParameter("hourly_rate");
        String active = request.getParameter("active");
        String image = request.getParameter("image");
        
//      check if the name is exist, then update database
        if(name != null){
              venuesBean veunubean = new venuesBean();
              veunubean.setId(Integer.parseInt(id));
              veunubean.setName(name);
              veunubean.setType(type);
              veunubean.setCapacity(Integer.parseInt(capacity));
              veunubean.setLocation(location);
              veunubean.setDescription(description);
              veunubean.setPersonInCharge(person_in_charge);
              veunubean.setHourlyRate(Integer.parseInt(hourly_rate));
              veunubean.setActive(active);
              veunubean.setImage(image.getBytes());
            String message = "";
            if(db.editRecord(veunubean)){
                message = "Update data successfully";
            }else{
                message = "Update data unsuccessfully";
            }
            request.setAttribute("message", message);
        }
        
        if (id != null && !id.isEmpty() || id != null){        
            venuesBean venue = db.queryVenueByID(id);
            request.setAttribute("v", venue);
            rd = getServletContext().getRequestDispatcher("/venueDetail.jsp");
            rd.forward(request, response);
        }else{
//            data update
//            System.out.println("name: " + name);
//            System.out.println("id: " + id);
//            venuesBean venue = db.queryVenueByID(id);
//            request.setAttribute("v", venue);
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
