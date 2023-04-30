<!-- <%-- 
    Document   : venueDetail
    Created on : Apr 21, 2023, 3:34:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<%@page import="java.util.ArrayList" %>
<%@page import="ict.bean.UserBean" %>
<%@page import="ict.bean.BookingBean" %>
<%@ taglib  prefix="ict" uri="/WEB-INF/tlds/displayImage.tld" %>
<%
    UserBean userBean = (UserBean) request.getAttribute("u");
    ArrayList<BookingBean> bookingbean = (ArrayList<BookingBean>) request.getAttribute("b");
%>
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
            var loadFile = function (event) {
                var image = document.getElementById('image');
                image.src = URL.createObjectURL(event.target.files[0]);
            };
            <% 
                String message = (String) request.getAttribute("message");
                if (request.getAttribute("message") != null) {
            %>
//            System.out.println("message: " + request.getAttribute("message").toString());
            window.onload = function () {
            <%
                    out.println("document.getElementById(\"modal-message\").innerHTML = \"" + message + "\";");
            %>
                document.getElementById("model-btn").click();
            };
            <%
            }
            %>
            % >
        </script>
    </head>

    <body>
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
                    <div class="modal-body" id="modal-message"  >
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
            <jsp:include page="include/sidebar/sidebar-user.jsp" />
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
                            <div class="bg-light rounded h-100 p-4">
                                <h6 class="mb-4" style="font-size: 40px;">User Detail</h6>
                                <a href="handleUserDetail?action=delete&id=<%= userBean.getId() %>">
                                    <button type="button" class="btn btn-outline-success m-2" style="float: right;" >Delete User</button>
                                </a>
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="userManagement.html">User List</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">User Detail</li>
                                    </ol>
                                </nav>
                                <h4>Information</h4>
                                <form class="row g-3" action="handleUserDetail?action=<%= request.getParameter("action")%>&id=<%=userBean.getId()%> " method="POST"  >
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">User ID</label>
                                        <input type="text" class="form-control" id="inputEmail4" name="id" value="<% if (userBean.getId() == -1) {
                                                out.println("Not suitable");
                                            } else {
                                                out.println(userBean.getId());
                                            }%>" disabled>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputPassword4" class="form-label">Name</label>
                                        <input type="text" class="form-control" id="inputEmail4" name="name"  value="<%= userBean.getName()%>">
                                    </div>

                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Phone</label>
                                        <input type="number" id="typeNumber" class="form-control" name="phone" value="<%= userBean.getPhone()%>"  />
                                    </div>

                                    <div class="col-md-6">
                                        <label for="inputPassword4" class="form-label">Email</label>
                                        <input type="email" class="form-control" id="inputPassword4" name="email" value="<%= userBean.getEmail()%>" >
                                    </div>

                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Password</label>
                                        <input type="text" id="typeNumber" class="form-control" name="password" value="<%= userBean.getPassword()%>" />
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Role</label>
                                        <select class="form-select" aria-label="Default select example" name="role"  >
                                                <option value="Member" <% if (userBean.getRole().equals("Member")) {
                                                        out.print("selected");
                                                    } %> >Member</option>
                                                    <option value="Staff" <% if (userBean.getRole().equals("Staff")) {
                                                            out.print("selected");
                                                        } %> >Staff</option>
                                                    <option value="Senior Management" <% if (userBean.getRole().equals("Senior Management")) {
                                                            out.print("selected");
                                                        }%>  >Senior Management</option>
                                        </select>
                                    </div>

                                    <div class="col-md-6">
                                        <button type="submit" class="btn btn-primary" style="max-width: 100px;">Submit</button>
                                    </div>
                                </form>


                                <%
                                    if (bookingbean.size() != 0) {
                                %>
                                <h4 style="margin-top: 20px;display: inline-block;">Order History</h4>
                                <span style="float:right;" >Annual attendance this year/month: <%= userBean.getYearlyAttendance() %>%/ <%= userBean.getMonthlyAttendance() %>%  </span>
                                <table class="table text-start align-middle table-bordered table-hover mb-0" style="margin-top: 20px;">
                                    <thead>
                                        <tr class="text-dark">
                                            <th scope="col">Order ID</th>
                                            <th scope="col">Venue item</th>
                                            <th scope="col">Create at</th>
                                            <th scope="col">Status</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody> 
                                        <%
                                            for (int x = 0; x < bookingbean.size(); x++) {
                                                BookingBean bp = bookingbean.get(x);
                                                String bookingStatus = bp.getBookingStatus();
                                                String status = "";
                                                if (bookingStatus.equals("Confirmed")) {
                                                    status = "<span class='badge bg-success'>Confirmed</span>";
                                                }
                                                if (bookingStatus.equals("Pending")) {
                                                    status = "<span class='badge bg-primary'>Pending</span>";
                                                } else if (bookingStatus.equals("Waiting for Payment")) {
                                                    status = "<span class='badge bg-secondary'>Waiting for Payment</span>";
                                                } else if (bookingStatus.equals("Declined")) {
                                                    status = "<span class='badge bg-warning'>Declined</span>";
                                                }
                                                out.println("<tr>");
                                                out.println("<td>" + bp.getId() + "</td>");
                                                out.println("<td>" + bp.getTotalItem() + "</td>");
                                                out.println("<td>" + bp.getDate() + "</td>");
                                                out.println("<td>" + status + "</td>");
                                                out.println("<td><a href='handleBookingDetail?id=" + bp.getId() + "'><button type='button' class='btn btn-sm btn-primary'>Detail</button></a></td>");
                                                out.println("</tr>");
                                            }
                                        %>
                                    </tbody>
                                </table>
                                <%
                                    }
                                %>
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