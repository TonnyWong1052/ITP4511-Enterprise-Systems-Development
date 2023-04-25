<!-- <%-- 
    Document   : BookginDetail
    Created on : Apr 21, 2023, 3:34:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> -->
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
        window.onload = function() {
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
        <div id="spinner"
            class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-light navbar-light">
                <a href="index.html" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary">EPL Backend</h3>
                </a>
                <div class="navbar-nav w-100">
                    <a href="venueManagement.html" class="nav-item nav-link"><i
                            class="bi bi-shop-window me-2"></i>Venue</a>
                    <a href="bookingManagement.html" class="nav-item nav-link active"><i
                            class="bi bi-bag me-2"></i>Booking</a>
                    <a href="userManagement.html" class="nav-item nav-link"><i
                            class="bi bi-people-fill me-2"></i>User</a>
                    <a href="analysis.html" class="nav-item nav-link"><i class="bi bi-graph-up me-2"></i>Analysis</a>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->

        
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
                            <img class="rounded-circle me-lg-2" src="img/Sample_User_Icon.png" alt=""
                                style="width: 40px; height: 40px;">
                            <span class="d-none d-lg-inline-flex">John Doe</span>
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
                                    <input type="text" class="form-control" id="inputEmail4" disabled>
                                </div>

                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">User Name</label>
                                    <input type="text" class="form-control" id="inputEmail4" disabled>
                                </div> <br>

                                <hr style="border-top: 2px solid black; width: 100%;">

                                <h5>
                                    Venue #1
                                    <button type="button" class="btn btn-outline-info m-1">Detail</button>
                                </h5>

                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">Venue ID</label>
                                    <input type="email" class="form-control" id="inputEmail4" disabled>
                                </div>

                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">Venue Name</label>
                                    <input type="email" class="form-control" id="inputEmail4" disabled>
                                </div>

                                <div class="col-md-6">
                                    <label for="inputPassword4" class="form-label">Create Date</label>
                                    <input type="Date" class="form-control" value="23:05" />
                                </div>

                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">Start Time</label>
                                    <input type="time" class="form-control" value="23:05" />
                                </div>

                                <div class="col-md-6">
                                    <label for="inputPassword4" class="form-label">End Time</label>
                                    <input type="time" class="form-control" value="23:05" />
                                </div>

                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">Booking Status</label>
                                    <input type="text" class="form-control" id="inputEmail4" value="Pending" disabled>
                                </div>

                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">Payment Status</label>
                                    <input type="text" class="form-control" id="inputEmail4" value="Unpaid" disabled>
                                </div>

                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">Amount</label>
                                    <input type="number" id="typeNumber" class="form-control" />
                                </div>

                                <div class="mb-3">
                                    <label for="exampleFormControlTextarea1" class="form-label">Member Remark</label>
                                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                                </div>

                                <div class="mb-3">
                                    <label for="exampleFormControlTextarea1" class="form-label">Staff Remark</label>
                                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                                </div>

                                <div class="col-md-6">
                                    <button type="submit" class="btn btn-primary"
                                        style="max-width: 100px;">Edit</button>
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