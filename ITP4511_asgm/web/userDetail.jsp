<!-- <%-- 
    Document   : venueDetail
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
    <script>
        var loadFile = function(event) {
            var image = document.getElementById('image');
            image.src = URL.createObjectURL(event.target.files[0]);
        };
    </script>
</head>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
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
                    <a href="venueManagement.html" class="nav-item nav-link"><i class="bi bi-shop-window me-2"></i>Venue</a>
                    <a href="bookingManagement.html" class="nav-item nav-link"><i class="bi bi-bag me-2"></i>Booking</a>
                    <a href="userManagement.html" class="nav-item nav-link active"><i class="bi bi-people-fill me-2"></i>User</a>
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
                            <img class="rounded-circle me-lg-2" src="img/Sample_User_Icon.png" alt="" style="width: 40px; height: 40px;">
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
                            <h6 class="mb-4" style="font-size: 40px;">User Detail</h6>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                  <li class="breadcrumb-item"><a href="userManagement.html">User List</a></li>
                                  <li class="breadcrumb-item active" aria-current="page">User Detail</li>
                                </ol>
                            </nav>
                            <h4>Information</h4>

                            <form class="row g-3">
                                <div class="col-md-6">
                                  <label for="inputEmail4" class="form-label">User ID</label>
                                  <input type="email" class="form-control" id="inputEmail4" disabled>
                                </div>
                                <div class="col-md-6">
                                  <label for="inputPassword4" class="form-label">Name</label>
                                  <input type="text" class="form-control" id="inputPassword4">
                                </div>

                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">Phone</label>
                                    <input type="number" id="typeNumber" class="form-control" />
                                </div>

                                <div class="col-md-6">
                                    <label for="inputPassword4" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="inputPassword4">
                                  </div>
  
                                  <div class="col-md-6">
                                      <label for="inputEmail4" class="form-label">Password</label>
                                      <input type="text" id="typeNumber" class="form-control" />
                                  </div>
                                
                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">Role</label>
                                    <select class="form-select" aria-label="Default select example">
                                        <option value="Member" selected>Member</option>
                                        <option value="Staff">Staff</option>
                                        <option value="Senior Manager">Senior Manager</option>
                                    </select>
                                </div>

                                <div class="col-md-6">
                                    <button type="submit" class="btn btn-primary" style="max-width: 100px;">Edit</button>
                                </div>
                            </form>

                            <h4 style="margin-top: 20px;">Order History</h4>

                            <table class="table text-start align-middle table-bordered table-hover mb-0" style="margin-top: 20px;">
                                <thead>
                                    <tr class="text-dark">
                                        <th scope="col">ID</th>
                                        <th scope="col">Venue item</th>
                                        <th scope="col">Create at</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Tonny Chan</td>
                                        <td>3-4-2023</td>
                                        <td><span class="badge bg-secondary">Pending</span></td>
                                        <td><a href="BookingDetail.html"><button type="button" class="btn btn-sm btn-primary">Detail</button></a></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Otto</td>
                                        <td>mark@email.com</td>
                                        <td>jhon@email.com</td>
                                        <td><button type="button" class="btn btn-sm btn-primary">Detail</button></td>
                                    </tr>
                                </tbody>
                            </table>
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