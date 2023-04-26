/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.DB.CustomerDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author qwer1
 */
@WebServlet(name="CustomerAdd", urlPatterns={"/CustomerAdd"})

public class CustomerAdd extends HttpServlet {
     private CustomerDB db;

     
    @Override
    public void init() throws ServletException {
        db = new CustomerDB();
    }
    
        private void processRequest(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        int phone =  Integer.parseInt(request.getParameter("phone"));
        String password =request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        String custId = "";
        try
{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itp4511_asgm","root","");     
    Statement st=con.createStatement();
    String strQuery = "SELECT COUNT(custId) FROM customer";
    ResultSet rs = st.executeQuery(strQuery);

    String Countrow="";
      while(rs.next()){
      Countrow = rs.getString(1);
      System.out.println("Total Row :" +Countrow);
      int Count = Integer.parseInt(Countrow)+1;
      custId = String.valueOf(Count);
      System.out.println("Total Row :" +custId);       
       } 
    }
catch (Exception e){
    e.printStackTrace();
  }

        
        if (action.equals("add")) {
            db.addRecord(custId, email, username, phone, password, age);
         }
        }
      
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html> <head><title>觀看線上書籤</title></head> <body> <h1>Successful!</h1> </body></html>"); 
    }
    
}
