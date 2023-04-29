<!-- <%-- 
    Document   : BookginDetail
    Created on : Apr 21, 2023, 3:34:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="ict.bean.BookingBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="ict.bean.OrderBookingBean" %>

<%
    OrderBookingBean obb = (OrderBookingBean) request.getAttribute("obb");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Venue Detail</title>
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

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">

<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"> -->
</head>
<script>
    window.onload = function () {
        document.getElementById("model-btn").click();
    };
</script>
<body>
    <!-- Modal setting -->
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" style="display:none;" id="model-btn">
        button
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">System Message</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    The order has been approved successfully
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">OK</button>
                </div>
            </div>
        </div>
    </div>

    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <jsp:include page="include/spinner.jsp" />

        <!-- Sidebar Start -->
        <jsp:include page="include/sidebar/sidebar-booking.jsp" />


        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <jsp:include page="include/navbar.jsp" />
            <!-- Navbar End -->


            <!-- Table Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-12 col-xl-12">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4" style="font-size: 40px;">
                                <p style="display: inline-block;">Booking Detail</p>
                                <button type="button" class="btn btn-outline-warning m-2"
                                        style="float: right;width: 85px;">Decline</button>
                                <button type="button" class="btn btn-outline-success m-2"
                                        style="float: right;width: 85px;">Approve</button>
                            </h6>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="bookingManagement.html">Booking List</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Venue Detail</li>
                                </ol>
                            </nav>

                            <form class="row g-3">

                                <h5>
                                    User Information
                                    <button type="button" class="btn btn-outline-primary m-1">Read More</button>
                                </h5>
                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">User ID</label>
                                    <input type="text" class="form-control" id="inputEmail4" value="<%= obb.getUserID()%>"  disabled>
                                </div>

                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">User Name</label>
                                    <input type="text" class="form-control" id="inputEmail4" value="Chan Xiu Ming" disabled>
                                </div> <br>
                            </form>

                            <%
                                for (int x = 0; x < obb.getBookingList().size(); x++) {
                                    BookingBean tempbb = obb.getBookingList().get(x);
                            %>
                            <hr style="border-top: 2px solid black; width: 100%;">

                            <form class="row g-3" action="handleBookingDeetail?id" method="POST">

                                <h5>
                                    Venue #<%= x + 1%>
                                    <button type="button" class="btn btn-outline-info m-1">Detail</button>
                                </h5>

                                <div class="col-md-6">
                                    <label for="venueId<%= x%>" class="form-label">Venue ID</label>
                                    <input type="text" class="form-control" id="venueId<%= x%>" value="<%= tempbb.getVenueId()%>" disabled>
                                </div>

                                <div class="col-md-6">
                                    <label for="venueName<%= x%>" class="form-label">Venue Name</label>
                                    <input type="text" class="form-control" id="venueName<%= x%>" value="TinShuiWai" disabled>
                                </div>

                                <div class="col-md-6">
                                    <label for="createDate<%= x%>" class="form-label">Create Date</label>
                                    <input type="date" class="form-control" id="createDate<%= x%>" value="<%= tempbb.getCreatedAt() %>" />
                                </div>

                                <div class="col-md-6">
                                    <label for="startTime<%= x%>" class="form-label">Start Time</label>
                                    <input type="time" class="form-control" id="startTime<%= x%>" value="<%= tempbb.getStartTime()%>" />
                                </div>

                                <div class="col-md-6">
                                    <label for="endTime<%= x%>" class="form-label">End Time</label>
                                    <input type="time" class="form-control" id="endTime<%= x%>" value="<%= tempbb.getEndTime()%>" />
                                </div>

                                <div class="col-md-6">
                                    <label for="bookingStatus<%= x%>" class="form-label">Booking Status</label>
                                    <input type="text" class="form-control" id="bookingStatus<%= x%>" value="<%= tempbb.getBookingStatus()%>" disabled>
                                </div>

                                <div class="col-md-6">
                                    <label for="paymentStatus<%= x%>" class="form-label">Payment Status</label>
                                    <input type="text" class="form-control" id="paymentStatus<%= x%>" value="<%= tempbb.getPaymentStatus()%>" disabled>
                                </div>

                                <div class="col-md-6">
                                    <label for="amount<%= x%>" class="form-label">Amount</label>
                                    <input type="number" id="amount<%= x%>" class="form-control" value="<%= tempbb.getAmount()%>" />
                                </div>

                                <div class="mb-3">
                                    <label for="memberRemark<%= x%>" class="form-label">Member Remark</label>
                                    <textarea class="form-control" id="memberRemark<%= x%>" rows="3"><%= tempbb.getMemberRemarks() %></textarea>
                                </div>

                                <div class="mb-3">
                                    <label for="staffRemark<%= x%>" class="form-label">Staff Remark</label>
                                    <textarea class="form-control" id="staffRemark<%= x%>" rows="3"><%= tempbb.getStaffRemarks() %></textarea>
                                </div>

                                <div class="col-md-6">
                                    <button type="submit" class="btn btn-primary" style="max-width: 100px;">Edit</button>
                                </div>
                            </form>
                            <%
                                } // Closing the for loop
                            %>
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