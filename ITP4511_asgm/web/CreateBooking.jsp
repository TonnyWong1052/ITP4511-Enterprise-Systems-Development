<%-- 
    Document   : CreateBooking
    Created on : 2023年4月22日, 下午07:21:23
    Author     : qwer1
--%>

<%@page import="ict.bean.VenueBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <head>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js'></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div id="">
            <jsp:include page="heading.jsp" />
        </div>

        <form method='get' action='BookingAdd'>
            <div class="row d-flex justify-content-center" style="margin-top:200px; font-family: Arial" >
                <div class="col-md-10">
                    <div><h4> Create Booking</h4></div> <div class="card px-5 py-4" id="form1">

                        <%
                            ArrayList<VenueBean> venue = (ArrayList<VenueBean>) request.getAttribute("venues");
                            for (int i = 0; i < venue.size(); i++) {
                                System.out.println(venue);
                                VenueBean v = venue.get(i);

                                out.println(" <h1><b> Detail: </b></h1> <div class='row'><div class='form-group col-lg-6 '><label for=''>Venue ID</label><div class='right-inner-addon input-container'><a><i class='fas fa-user'></i></a><input name='venuId' type='text' class='form-control validate' value='" + v.getId() + "'></div></div>");
                                out.println("<div class='form-group col-lg-6'><label for=''>Venue</label><div class='right-inner-addon input-container'><a><i class='fas fa-id-card'></i></a><input name='' type='text' class='form-control validate'  value=" + v.getLocation() + "></div></div> ");
                                out.println("<div class='form-group col-lg-6'><label for=''>Venue Name</label><div class='right-inner-addon input-container'><a><i class='fas fa-id-card'></i></a><input name='' type='text' class='form-control validate'  value=" + v.getName() + "></div></div>");
                                out.println("<div class='form-group col-lg-6'><label for=''>Date</label><div class='right-inner-addon input-container'><a><i class='fas fa-id-card'></i></a><input name='data' type='Date' class='form-control validate'  value='" + v.getId() + "'></div></div>");
                                out.println("<div class='form-group col-lg-6'><label for=''>Start-Time</label><div class='right-inner-addon input-container'><a><i class='fas fa-id-card'></i></a><input name='STime' type='Time' class='form-control validate'></div></div> ");
                                out.println("<div class='form-group col-lg-6'><label for=''>End-Time</label><div class='right-inner-addon input-container'><a><i class='fas fa-id-card'></i></a><input name='ETime' type='Time' class='form-control validate'></div></div> </div>");
                                out.println("<input name='rate' type='hidden' class='form-control validate'  value='" + v.getHourlyRate() + "'><div><h4><label>Amount: HK  $ </label>" + v.getHourlyRate() + "</h4></div>");
                                out.println("<textarea name='area' rows='4' cols='50'>" + v.getHourlyRate() + " </textarea>");
                            }
                        %>

                    </div>     
                </div>


                <div class="row d-flex justify-content-center" style="margin-top:20px; font-family: Arial" >
                    <div class="col-md-10"> 
                        <div class="card px-5 py-4" id="form1">
                            <div class="form-data">

                                <div class="form-group col-lg-6">
                                    <label for="">Name</label>
                                    <div class="right-inner-addon input-container">
                                        <a><i class="fas fa-id-card"></i></a>
                                        <input name="Name" type="text" class="form-control validate"/>
                                    </div>
                                </div>

                                <div class="form-group col-lg-6">
                                    <label for="">Email</label>
                                    <div class="right-inner-addon input-container">
                                        <a><i class="fas fa-id-card"></i></a>
                                        <input name="Email" type="text" class="form-control validate"/>
                                    </div>
                                </div> 
                                <div id="adds">
                                </div>

                                <button2 id="add"> add guest+ </button2>

                            </div>
                        </div>
                    </div>
                </div>        

                <div class="row d-flex justify-content-center mt-4 ">
                    <div class="col-4 form-group tm-mt-small ">
                        <input  type="submit" class="btn btn-primary btn-block text-uppercase"  name="action" value="add"/>
                    </div>
                </div>
            </div>

            <script>
                $(document).ready(function () {
                    $("#add").click(function () {
                        $("#adds").append("<div class='form-group col-lg-6'> <label for=''>Name</label><div class='right-inner-addon input-container'><a><i class='fas fa-id-card'></i></a><input name='Name' type='text' class='form-control validate'></div></div>   <div class='form-group col-lg-6'> <label for=''>Email</label><div class='right-inner-addon input-container'><a><i class='fas fa-id-card'></i></a><input name='Email' type='text' class='form-control validate'></div></div>");
                    });
                });
            </script>
        </form>
    </body>
</html>
