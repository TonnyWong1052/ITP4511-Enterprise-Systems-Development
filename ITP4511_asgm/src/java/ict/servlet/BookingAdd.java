package ict.servlet;

import ict.DB.CustomerDB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author qwer1
 */
@WebServlet(name = "BookingAdd", urlPatterns = {"/BookingAdd"})
public class BookingAdd extends HttpServlet {
     private CustomerDB db;
    
    public void init() throws ServletException {
        db = new CustomerDB();
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
        String action = request.getParameter("action");
        String[] venuId = request.getParameterValues("venuId");
        String[] data = request.getParameterValues("data");
        String[] STime = request.getParameterValues("STime");
        String[] ETime = request.getParameterValues("ETime");
        String[] Amount = request.getParameterValues("rate");
        String[] Name = request.getParameterValues("Name");
        String[] Email = request.getParameterValues("Email");
        int Count = 0;
        int Count2 = 0;
        String id = "2";
        
        try{   
    Class.forName("com.mysql.jdbc.Driver").newInstance();
        
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itp4511_asgm","root","");     
    Statement st=con.createStatement();
    String strQuery = "SELECT MAX(id) FROM bookings";
    ResultSet rs = st.executeQuery(strQuery);

    String Countrow="";
      while(rs.next()){
      Countrow = rs.getString(1);
      System.out.println("Total Row :" +Countrow);
      Count = Integer.parseInt(Countrow);
      System.out.println("Total Row :" +Count);       
       }  
    }
catch (Exception e){
    e.printStackTrace();
  }

 try{   
    Class.forName("com.mysql.jdbc.Driver").newInstance();
        
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itp4511_asgm","root","");     
    Statement st=con.createStatement();
    String strQuery = "SELECT MAX(id) FROM guests";
    ResultSet rs = st.executeQuery(strQuery);

    String Countrow="";
      while(rs.next()){
      Countrow = rs.getString(1);
      System.out.println(" Row :" +Countrow);
      Count2 = Integer.parseInt(Countrow);
      System.out.println(" Row :" +Count2);       
       }  
    }
catch (Exception e){
    e.printStackTrace();
  }        
        
        
        if (action.equals("add")) {
         
            for (int i=0; i<venuId.length; i++){ 
                String dateString = data[i];
                Count= Count +1;
                 System.out.println("Total Row :" +Count);
                 System.out.println("venuId :" +venuId[i]);
            db.createbooking( Count, id, venuId[i], dateString, STime[i], ETime[i], Amount[i]);
            for (int x=0; x<Name.length; x++){ 
                 Count2= Count2 +1;
                 db.createguest( Count2, Name[x], Email[x], Count);
                }
            }
              PrintWriter out = response.getWriter();
        out.println("<html> <head><title></title></head> <body> <h1>Successful Create booking!</h1> </body></html>");
        }
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
