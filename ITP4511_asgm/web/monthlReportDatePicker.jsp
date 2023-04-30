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
                            <h6 style="font-size: 30px;">Select Date - Monthly Report</h6>
                        </div>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="analysis.html">Data Analysis</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Date Picker</li>
                            </ol>
                        </nav>
                        <div class="col-sm-12 col-xl-12">
                            <div class="bg-light rounded h-100 p-4">
                                <form class="row g-3"  action="handleAnalysisReport" action="POST" >
                                    <div class="col-md-12">
                                        <label for="inputEmail4" class="form-label">Venue Name</label>
                                        <select class="form-select" aria-label="Default select example"  name="id" >
                                            <option value="1" selected>Venaq Meeting Room</option>
                                            <option value="2">Modern Meeting Room</option>
                                            <option value="3">Cozy Corner</option>
                                        </select>
                                    </div>

                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Year</label>
                                        <select class="form-select" aria-label="Default select example"  name="year" >
                                            <option value="2023" selected>2023</option>
                                            <option value="2022">2022</option>
                                            <option value="2021">2021</option>
                                            <option value="2020">2020</option>
                                        </select>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputPassword4" class="form-label">Month</label>
                                        <select class="form-select" aria-label="Default select example"  name="month" >
                                            <option value="1" selected>1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="7">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                            <option value="1">11</option>
                                            <option value="12">12</option>
                                        </select>
                                    </div>
                                    <div class="col-md-6">
                                        <button type="submit" class="btn btn-primary" style="max-width: 100px;">Submit</button>
                                        <!-- <button type="submit" class="btn btn-primary" style="max-width: 100px;">Submit</button> -->
                                    </div>
                                </form>
                            </div>
                        </div>
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