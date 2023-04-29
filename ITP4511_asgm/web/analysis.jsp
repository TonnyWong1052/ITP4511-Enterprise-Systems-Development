<!-- <%-- 
    Document   : BookingManagement
    Created on : Apr 21, 2023, 3:34:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="en">

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

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var textBox = document.getElementById('search');

            textBox.addEventListener('keydown', function (event) {
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
        <jsp:include page="include/sidebar/sidebar-analysis.jsp" />
        <!-- Sidebar End -->


        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <jsp:include page="include/navbar.jsp" />
            <!-- Navbar End -->


            <!-- Table Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-12 col-xl-12">
                        <h6 style="font-size: 30px;">Data Analysis</h6>
                    </div>
                    <div class="col-sm-12 col-xl-6" style="cursor: pointer;">
                        <a href="monthlReportDatePicker.jsp">
                            <div class="bg-light rounded h-100 p-4">
                                <div class="testimonial-item text-center">
                                    <img class="img-fluid  mx-auto mb-4"
                                        src="img/streamline_interface-calendar-date-month-thirty-thirty-calendar-date-week-day-month.png"
                                        style="width: 100px; height: 100px;">
                                    <h5 class="mb-1">Monthly Report</h5>
                                </div>
                            </div>
                        </a>
                    </div>


                    <div class="col-sm-12 col-xl-6" style="cursor: pointer;">
                        <a href="yearlyReportDatePicker.jsp">
                            <div class="bg-light rounded h-100 p-4">
                                <div class="testimonial-item text-center">
                                    <img class="img-fluid mx-auto mb-4" src="img/iwwa_year.png"
                                        style="width: 100px; height: 100px;">
                                    <h5 class="mb-1">Yearly Report</h5>
                                </div>
                            </div>
                        </a>
                    </div>

                    <!-- <div class="col-sm-12 col-xl-6" style="cursor: pointer;">
                        <div class="bg-light rounded h-100 p-4">
                            <div class="testimonial-item text-center">
                                <img class="img-fluid rounded-circle mx-auto mb-4" src="img/mdi_clipboard-user.png" style="width: 100px; height: 100px;">
                                <h5 class="mb-1">User Analysis</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-12 col-xl-6" style="cursor: pointer;">
                        <div class="bg-light rounded h-100 p-4">
                            <div class="testimonial-item text-center">
                                <img class="img-fluid rounded-circle mx-auto mb-4" src="img/ep_place.png" style="width: 100px; height: 100px;">
                                <h5 class="mb-1">Venue Analysis</h5>
                            </div>
                        </div>
                    </div> -->
                </div>
            </div>
            <!-- Table End -->


            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; Event Point Limited, All Right Reserved.
                        </div>
                    </div>
                </div>
            </div>
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