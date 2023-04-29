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
        
        String processData = request.getParameter("processData");
//        if form has been submit, encapsulate the data to java bean
        venuesBean veunubean = new venuesBean();
        if(name != null){
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
        }
        
//      Update data model
//      check if the name is exist, then update database
        try{
            String action = request.getParameter("action");
            if(action.equals("edit")){
                String message = "";
                //  check if the user need to edit the record
                if(processData != null && processData.equals("create")){
    //                 create new record then return generated id
                    id = Integer.toString(db.createRecord(veunubean));
                    if(Integer.valueOf(id) > -1){
                         request.setAttribute("message", "Create data successfully");
                    }else{
                         request.setAttribute("message", "Create data unsuccessfully");
                    }
                }else if(processData != null && processData.equals("edit")){

                   if(db.editRecord(veunubean)){
                        request.setAttribute("message", "Update data successfully");
                   }else{
                       request.setAttribute("message", "Update data unsuccessfully");
                   }

               }

               venuesBean venue = db.queryVenueByID(id);
               if (!id.isEmpty() || id != null || venue == null){        
                   //System.out.println("venue: "  +venue.getName());
                    request.setAttribute("v", venue);
                    byte[] imageBytes = venue.getImage();
                    request.setAttribute("imageBytes", imageBytes);
                    rd = getServletContext().getRequestDispatcher("/venueDetail.jsp");
               }else{
                   rd = getServletContext().getRequestDispatcher("/errorPage/error.html");    
               }
           }else if(action.equals("create")){         
   //            check if the user click submit button to create record
               if(processData != null && processData.equals("create")){
                   db.createRecord(veunubean);
                   venuesBean venue = db.queryVenueByID(id);
                   request.setAttribute("v", venue);
               }else{
                   request.setAttribute("v", new venuesBean());
               }
               rd = getServletContext().getRequestDispatcher("/venueDetail.jsp");
           }else{
               rd = getServletContext().getRequestDispatcher("/errorPage/error.html");
           }        
        }catch(Exception ex){
            ex.printStackTrace();
            rd = getServletContext().getRequestDispatcher("/errorPage/error.html");
            rd.forward(request, response);
        }
        rd.forward(request, response);
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
