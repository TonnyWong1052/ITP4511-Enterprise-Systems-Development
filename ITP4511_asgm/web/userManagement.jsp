<%-- 
    Document   : venusManagement
    Created on : Apr 21, 2023, 3:34:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@page import="java.util.ArrayList" %>
    <%@page import="ict.bean.UserBean" %>
    <!DOCTYPE html>
    <html lang="en">
        <%
            ArrayList<UserBean> userBean = (ArrayList<UserBean>) request.getAttribute("u");
        %>

        <head>
            <meta charset="utf-8">
            <title>User Management</title>
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
                                    <h6 class="mb-4" style="font-size: 30px;">
                                        User Management
                                        <a href="handleUserDetail?action=create">
                                            <button type="button" class="btn btn-outline-success m-2" style="float: right;" >Add User</button>
                                        </a>
                                    </h6>

                                    <form action="handleUserManagement" >
                                        <input class="form-control border-0" id="search" name="search" type="search" placeholder="Search" style="width:300px;display: inline;">
                                    </form></br>

                                    <span style="margin-left: 20px;">Filter: </span>
                                    <div class="form-check" style="display: inline-block;margin-right: 10px;">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" checked>
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Member
                                        </label>
                                    </div>

                                    <div class="form-check" style="display: inline-block;margin-right: 10px;">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" checked>
                                        <label class="form-check-label" for="flexCheckDefault" >
                                            Staff
                                        </label>
                                    </div>

                                    <div class="form-check" style="display: inline-block;margin-right: 10px;">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" disabled>
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Senior Management
                                        </label>
                                    </div>

                                    <table class="table table-striped">
                                        <thead>
                                            <tr class="text-dark">
                                                <th scope="col">ID</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Phone</th>
                                                <th scope="col">Role</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (int x = 0; x < userBean.size(); x++) {
                                                    UserBean t = userBean.get(x);
                                                    out.println("<tr>");
                                                    out.println("<td>" + t.getId() + "</td>");
                                                    out.println("<td>" + t.getName() + "</td>");
                                                    out.println("<td>" + t.getEmail() + "</td>");
                                                    out.println("<td>" + t.getPhone() + "</td>");
                                                    out.println("<td>" + t.getRole() + "</td>");
                                                    out.println("<td><a class=\"btn btn-sm btn-primary\" href=\"handleUserDetail?action=edit&id=" + t.getId() + "\">Detail</a></td>");
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