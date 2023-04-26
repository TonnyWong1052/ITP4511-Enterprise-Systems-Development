<%-- 
    Document   : showValidBooking
    Created on : 2023年4月21日, 下午05:56:15
    Author     : qwer1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<div id="">
<jsp:include page="heading.jsp" />
</div>

<div class="row d-flex justify-content-center" style="margin-top:200px; font-family: Arial" >
    <div class="col-md-10">
    <div class="card px-5 py-4" id="form1">
    <div class="form-data">
    <div class="text-left mb-4">
        <h2>Check Booking</h2>
    </div>
        
        <div class="row">
          <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mx-auto">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
              <div class="tm-product-table-container">
                <table class="table table-hover tm-table-small tm-product-table text-center ">
                  <thead>
                    <tr style=" font-size: medium; color: #555;">
                      <th scope="col" class="text-center">ID</th>
                      <th scope="col" class="text-center">Venue</th>
                       <th scope="col" class="text-center">Date</th>
                        <th scope="col" class="text-center">Time</th>
                      <th scope="col">&nbsp;</th>
                    </tr>
                  </thead>
                
                  <tr>
                    <tr><td class='tm-product-name'>V001</td>
                        <td class='tm-product-name'>Tuen Mun</td>
                        <td class='tm-product-name'>4/4/2023</td>
                        <td class='tm-product-name'>12pm -15pm</td>
                        <td><button>Update</button></td>
                  </tr>

                </table>
              </div>

            </div>
          </div>
        </div>
</div>
</div>
</div>
</div>
    </body>
</html>
