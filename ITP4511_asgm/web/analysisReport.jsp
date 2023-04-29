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
                          <li class="breadcrumb-item active" aria-current="page">Report</li>
                        </ol>
                    </nav>
                    
                    <div class="col-sm-6 col-xl-12">
                        <div class="bg-light d-flex justify-content-between p-4">
                            <h6>Select Date:</h6>
                            <span>February 2023</span><br>
                            <h6>Select Venue:</h6>
                            <span>XXX Venue</span>
                        </div>
                    </div>

                    <div class="col-sm-6 col-xl-4">
                        <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa bi-check2-square fa-4x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Total Booking Rate</p>
                                <h6 class="mb-0">$1234</h6>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-xl-4">
                        <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa bi-calendar-check fa-4x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Total Booking Count</p>
                                <h6 class="mb-0">$1234</h6>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-xl-4">
                        <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa bi-wallet-fill fa-4x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Total Income</p>
                                <h6 class="mb-0">$1234</h6>
                            </div>
                        </div>
                    </div>
                    
                    <!-- <div class="col-sm-6 col-xl-3">
                        <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-chart-pie fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Total Revenue</p>
                                <h6 class="mb-0">$1234</h6>
                            </div>
                        </div>
                    </div> -->

                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light text-center rounded p-4">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">Venue Booking Rate</h6>
                            </div>
                            <canvas id="bookingRate"></canvas>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light text-center rounded p-4">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">Salse & Revenue</h6>
                            </div>
                            <canvas id="totalIncome"></canvas>
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
    <script>
        var ctx4 = $("#bookingRate").get(0).getContext("2d");
        var myChart4 = new Chart(ctx4, {
            type: "bar",
            data: {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                datasets: [{
                    label: 'Venue Booking Rate',
                    data: [70, 80, 90, 85, 75, 65, 60, 70, 80, 90, 95, 90],
                    backgroundColor: '#009cff'
                }]
            },
            options: {
                responsive: true
            }
        });

        var ctx2 = $("#totalIncome").get(0).getContext("2d");
        var myChart2 = new Chart(ctx2, {
            type: "line",
            data: {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                datasets: [{
                        label: "Selected Venue Income",
                        data: [15232, 30323, 5512, 45323, 70123, 65444, 85333, 15000, 18000, 20000, 22000, 24000],
                        backgroundColor: "rgba(0, 156, 255, .5)",
                        fill: true
                    },
                    {
                        label: "Other Venue Average Income",
                        data: [15000, 18000, 20000, 22000, 24000, 26000, 28000, 30000, 32000, 35000, 38000, 40000],
                        backgroundColor: "rgba(0, 156, 255, .3)",
                        fill: true
                    }
                ]
                },
            options: {
                responsive: true
            }
        });
    </script>
</body>

</html>