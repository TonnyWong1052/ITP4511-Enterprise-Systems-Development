<%-- 
    Document   : UpdatePersonalRD
    Created on : 2023年4月22日, 上午02:16:04
    Author     : qwer1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <head>
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js'></script>
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
    <div class="text-center mb-4">
        <h4>Update Booking</h4>
    </div>
        
 <div class="row">    
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
                      <th scope="col" class="text-center">fee</th>
                      <th scope="col">&nbsp;</th>
                    </tr>
                  </thead>
                
                  <tr>
                    <tr><td class='tm-product-name'>V001</td>
                        <td class='tm-product-name'>Tuen Mun</td>
                        <td class='tm-product-name'>4/4/2023</td>
                        <td class='tm-product-name'>12pm -15pm</td>
                        <td class='tm-product-name'>$300</td>
                        <td><button>select</button></td>
                  </tr>

                </table>
              </div>

            </div>
          </div>
        </div>
        
        <hr style="height:2px; color: #555">
         
        <h1><b> Detail: </b></h1>        
<div class="row">       
<div class="form-group col-lg-6 ">
    <label for="">ID</label>
    <div class="right-inner-addon input-container">
      <a><i class="fas fa-user"></i></a>
      <input name="" type="text" class="form-control validate">
    </div>
  </div>
<div class="form-group col-lg-6">
    <label for="">Name</label>
    <div class="right-inner-addon input-container">
      <a><i class="fas fa-id-card"></i></a>
      <input name="" type="text" class="form-control validate">
    </div>
</div>                        

<div class="form-group col-lg-6">
    <label for="">Date</label>
    <div class="right-inner-addon input-container">
      <a><i class="fas fa-id-card"></i></a>
      <input name="" type="text" class="form-control validate">
    </div>
</div>     
    
<div class="form-group col-lg-6">
    <label for="">Time</label>
    <div class="right-inner-addon input-container">
      <a><i class="fas fa-id-card"></i></a>
      <input name="" type="text" class="form-control validate">
    </div>
</div>   

<div class="form-group col-lg-6">
    <label for="">Capacity</label>
    <div class="right-inner-addon input-container">
      <a><i class="fas fa-id-card"></i></a>
      <input name="" type="text" class="form-control validate">
    </div>
</div>       

<div class="form-group col-lg-6">
    <label for="">Person-in-charge</label>
    <div class="right-inner-addon input-container">
      <a><i class="fas fa-id-card"></i></a>
      <input name="" type="text" class="form-control validate">
    </div>
</div>
    
<div class="form-group">
    <label for="exampleFormControlTextarea1">description</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
  </div>    

<div class="ml-3 mb-3">
    <h3> FEE: $300 </h2>
</div>    
    
</div>

<div class="row">
<div class="col-6 form-group tm-mt-small">
<input type="submit" class="btn btn-primary btn-block text-uppercase" value="Update Booking">
</div>

<div class="col-6 form-group tm-mt-small">
<input type="submit" class="btn btn-primary btn-block text-uppercase" style="background-color:red"  value="Cancel Booking">
</div>
</div>
                </div>
            </div>
        </div>
    </div>

    </body>
</html>
