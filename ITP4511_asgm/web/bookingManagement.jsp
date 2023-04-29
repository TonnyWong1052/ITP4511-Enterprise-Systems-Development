<!-- <%-- 
    Document   : BookingManagement
    Created on : Apr 21, 2023, 3:34:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="ict.bean.BookingBean" %>
<!DOCTYPE html>
<html lang="en">
<%
    ArrayList<BookingBean> bookingbean = (ArrayList<BookingBean>)request.getAttribute("b");
%>
<head>
    <meta charset="utf-8">
    <title>Booking Management</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-pzjw8f+ua7Kw1TIq0v8FqFjcJ6pajs/rfdfs3SO+kD4Ck5BdPtF+to8xMp9MvcqM" crossorigin="anonymous">
    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var textBox = document.getElementById('search');
            
            textBox.addEventListener('keydown', function(event) {
                if (event.key === 'Enter' || event.keyCode === 13) {
                    window.location.href = 'test.html';
                }
            });
        });
    </script>
</head>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <jsp:include page="include/spinner.jsp" />

        <!-- Sidebar Start -->
        <jsp:include page="include/sidebar/sidebar-booking.jsp" />


        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
                <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
                    <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
                </a>
                <a href="#" class="sidebar-toggler flex-shrink-0">
                    <i class="fa fa-bars"></i>
                </a>
                <div class="navbar-nav align-items-center ms-auto">
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <img class="rounded-circle me-lg-2" src="img/Sample_User_Icon.png" alt="" style="width: 40px; height: 40px;">
                            <span class="d-none d-lg-inline-flex">Tonny Wong</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                            <a href="#" class="dropdown-item">My Profile</a>
                            <a href="#" class="dropdown-item">Settings</a>
                            <a href="#" class="dropdown-item">Log Out</a>
                        </div>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->


            <!-- Table Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-12 col-xl-12">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4" style="font-size: 30px;">
                                <p style="display: inline-block;">Order Management</p>
                                <a href="exportCSV">
                                    <button type="button" class="btn btn-outline-success m-2" style="float: right;" >Export CSV</button>
                                </a>
                            </h6>
                            
                            <form action="handleBookingManagement" >
                                <input class="form-control border-0" id="search" name="search" type="search" placeholder="Search" style="width:300px;display: inline;">
                            </form>

                            <!-- <i class="bi bi-search fa-1x" style="margin-left: 10px;" ></i> -->
                            <span style="margin-left: 20px;">Filter: </span>
                            <div class="form-check" style="display: inline-block;margin-right: 10px;">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" checked>
                                <label class="form-check-label" for="flexCheckDefault">
                                  Pending
                                </label>
                            </div>

                            <div class="form-check" style="display: inline-block;margin-right: 10px;">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                <label class="form-check-label" for="flexCheckDefault">
                                  Waiting for Payment
                                </label>
                            </div>

                            <div class="form-check" style="display: inline-block;margin-right: 10px;">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                <label class="form-check-label" for="flexCheckDefault">
                                    Confirmed
                                </label>
                            </div>

                            <div class="form-check" style="display: inline-block;margin-right: 10px;">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                <label class="form-check-label" for="flexCheckDefault">
                                    Declined
                                </label>
                            </div>
                        
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">Order ID</th>
                                        <th scope="col">User ID</th>
                                        <th scope="col">Venue item</th>
                                        <th scope="col">Create at</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Amount</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for(int x=0;x<bookingbean.size();x++){
                                            BookingBean venue = bookingbean.get(x);
                                            String bookingStatus = venue.getBookingStatus();
                                            String status = "";
                                            if(bookingStatus.equals("Confirmed")){
                                                status = "<span class='badge bg-success'>Confirmed</span>";
                                            }if(bookingStatus.equals("Pending")){
                                                status = "<span class='badge bg-primary'>Pending</span>";
                                            }else if(bookingStatus.equals("Waiting for Payment")){
                                                status = "<span class='badge bg-secondary'>Waiting for Payment</span>";
                                            }else if(bookingStatus.equals("Declined")){
                                                status = "<span class='badge bg-warning'>Declined</span>";
                                            }
                                            
                                            out.println("<tr>");
                                            out.println("<td>" + venue.getId() + "</td>");
                                            out.println("<td>" + venue.getUserId() + "</td>");
                                            out.println("<td>" + venue.getTotalItem() + "</td>");
                                            out.println("<td>" + venue.getCreatedAt() + "</td>");
                                            out.println("<td>" + status + "</td>");
                                            out.println("<td>$" + venue.getTotalAmount() + "</td>");
                                            out.println("<td><a href='handleBookingDetail?id=" + venue.getId() + "'><button type='button' class='btn btn-sm btn-primary'>Detail</button></a></td>");
                                            out.println("</tr>");
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Table End -->


            <!-- Footer Start -->
            <jsp:include page="include/footer.jsp" />
            <!-- Footer End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/chart/chart.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>