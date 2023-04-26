<%-- 
    Document   : cart
    Created on : 2023年4月26日, 上午12:37:24
    Author     : qwer1
--%>

<%@page import="ict.bean.VenueBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
        <link href='css/kiratem2.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js'></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
<div id="">
    <jsp:include page="heading.jsp" />
</div>

<!--<form method="get" action="/ListVanue">
<input type="hidden" name="action" value="list"/>
</form>-->

<div class="row d-flex justify-content-center" style="margin-top:200px; font-family: Arial" >
    <div class="col-md-10">
    <div class="px-5 py-4" id="form1">
    <div class="form-data">
    <div class="text-center mb-4">
        <h4>Cart</h4>
        <div class="form-group col-lg-6">
<label for="">Select Venue</label>
<div class="right-inner-addon input-container">
  <a><i class="fas fa-id-card"></i></a>
<select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
<option selected>Open this select menu</option>
<option value="1">Tuen Mun</option>
<option value="2">Sha Tin</option>
<option value="4">Tsing Yi</option>
<option value="5">Lee Wai Lee</option>
<option value="6">Chai Wan</option>
</select>
</div>
</div>  
    </div>
        <form method="get" action="/assignment/booking">
        
    <%
        
    ArrayList<VenueBean> venue = (ArrayList<VenueBean>)request.getAttribute("venues2");
   for (int i=0; i< venue.size(); i++){
       System.out.println(venue);
       VenueBean v = venue.get(i);
        out.println("<div class='pro-container'> <div class='pro'>");
        out.println(" <img src='img/p1.jpg' class='img001' alt=''>");
        out.println(" <div class='des'>");
        out.println(" <h5>Name: "+ v.getName() +"</h5>");
        out.println("  <div class='fx'>");
        out.println("  <div style='padding-right: 10px;'><h5>Type : "+ v.getType()  +" </h5></div>");
        out.println("  <div class='arrow-1'></div><div><h5>Capacity: "+ v.getCapacity()  +"</h5></div> </div>");
        out.println("  <h5>Location: "+ v.getLocation()  +"</h5>");
        out.println("  <h5>Person-In-Charge: "+ v.getPersonInCharge()  +"</h5>");
        out.println("  <a style='font-size:20px;  font-weight:bold; color:#61acb3;'>Fee: "+ v.getHourlyRate()  +"</a>");
        //out.println("  <h6>Date: "+ v.getDate()  +"</h6></div>");
        out.println("  </div><div class='des2'><h5>Discription: "+ v.getDescription()  +" </h5></div>");
        out.println("  <div class='desbtn'><a href=deleteCart?action=1234&id="+ v.getId() +"><button2 class='button-5' role='button'>Delete</button2></a></div><input type='checkbox' name='ide' value="+ v.getId() + "> </div></div>");
        
   }
   
   %>
   <input type="submit" value="submit">
        </form>
</div>
</div>
</div>
</div>
</div>
                               
</html>
