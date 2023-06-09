/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.AnalysisBean;
import ict.bean.OrderBookingBean;
import ict.db.AnalysisDB;
import ict.db.BookingDB;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "handleAnalysisReport", urlPatterns = {"/handleAnalysisReport"})
public class handleAnalysisReport extends HttpServlet {
     private AnalysisDB db;
    
    @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new AnalysisDB(dbUrl, dbUser, dbPassword);
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
        String year = request.getParameter("year"); 
        String month = request.getParameter("month"); 
        String id = request.getParameter("id"); 
        
        //want jump
        AnalysisBean analysisBean = new AnalysisBean();
        
        int total = 0;
        double pectangle = 0;
        double income = 0;
        if(month==null){
            for(int x=1;x<12;x++){
                pectangle += db.queryVenueBookingRatePectangle(Integer.valueOf(id), Integer.valueOf(x));
                income += db.queryMonthlyIncomeByVenue("2", year, id);
            }
            total = db.queryVenueBookingRateTotal(Integer.valueOf(id));
        }else{
            total = db.queryVenueBookingRateTotal(Integer.valueOf(id));
            pectangle = db.queryVenueBookingRatePectangle(Integer.valueOf(id), Integer.valueOf(month));
            income = db.queryMonthlyIncomeByVenue(month, year, id);
        }
        
//        int total = db.queryVenueBookingRateTotal(Integer.valueOf(id));
//        double pectangle = db.queryVenueBookingRatePectangle(Integer.valueOf(id), Integer.valueOf(month));
//        double income = db.queryMonthlyIncomeByVenue(month, year, id);
        analysisBean.setBookingRatePercentage(pectangle);
        analysisBean.setMonthlyIncome(income);
        analysisBean.setTotalBookings(total);
        analysisBean.setVenueId(id);
        if(month == null){
            analysisBean.setDate(year);
        }else
            analysisBean.setDate(month + " - " + year);
        request.setAttribute("analy", analysisBean);
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/analysisReport.jsp");
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
