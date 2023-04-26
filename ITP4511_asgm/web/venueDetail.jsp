<%-- 
    Document   : venueDetail
    Created on : Apr 21, 2023, 3:34:34 PM
    Author     : user
--%>

<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<%@page import="java.util.ArrayList" %>
<%@page import="ict.bean.venuesBean" %>
<%@ taglib  prefix="ict" uri="/WEB-INF/tlds/displayImage.tld" %>
<%
    if (session.getAttribute("Role") != null && !session.getAttribute("Role").equals("Staff") && !session.getAttribute("Role").equals("Senior Management")) {
        response.sendRedirect("errorPage/notEnoughPermission.html");
    }
%>
<%
    venuesBean venue = (venuesBean) request.getAttribute("v");
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
                var image = document.getElementById('picture');
                image.src = URL.createObjectURL(event.target.files[0]);
            };
            //        if user click edit button, then display message
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
        </script>
    </head>

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
            <jsp:include page="include/sidebar/sidebar-venue.jsp" />
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
                                <h6 class="mb-4" style="font-size: 40px;display: inline-block ">Venue Detail</h6>
                                <%
                                    if (request.getParameter("action") != null && request.getParameter("action").equals("edit")) {
                                %>
                                <form action="handleVenueDetail?action=delete&id=<%= venue.getId()%>" method="POST"  >
                                    <button type="submit" class="btn btn-outline-danger m-2" style="float: right;"  >Delete Venue</button>
                                </form>
                                <%
                                    }
                                %>
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="handleVenueManagement">Venue List</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Venue Detail</li>
                                    </ol>
                                </nav>
                                <!--enctype="multipart/form-data"-->
                                <!--<form class="row g-3" action="handleVenueDetail?id=<%= venue.getId()%>" method="POST"  >-->
                                <form class="row g-3" action="handleVenueDetail?action=edit&id=<%= venue.getId()%>" method="post"  >
                                    <input type="hidden" name="processData" value="<%= request.getParameter("action")%>" />
                                    <%
                                        String base64Image = Base64.getEncoder().encodeToString(venue.getImage());
                                        String imageSrc = "";
                                        if (base64Image != null && !base64Image.isEmpty()) {
                                            imageSrc = "data:image/jpeg;base64," + base64Image;
                                        } else {
                                            imageSrc = "./img/no-available.jpg";
                                        }
                                    %>
                                    <ict:displayImage imageBytes="${requestScope.imageBytes}" />

                                    <%
                                        if (request.getParameter("action") != null && request.getParameter("action").equals("edit")) {
                                    %>
                                    <img src="img/partyRoom.jpg" alt="" name="picture" id="picture" style="margin-left: auto; margin-right: auto;display: block;max-height: 250px;max-width: 400px; cursor: pointer;" onclick="document.getElementById('file').click();">
                                    <%
                                        }else {  
                                    %>
                                    <img src="<%= imageSrc%>" alt="" name="picture" id="picture" style="margin-left: auto; margin-right: auto;display: block;max-height: 250px;max-width: 400px; cursor: pointer;" onclick="document.getElementById('file').click();">
                                    <%
                                        }
                                    %>
                                    <input type="file" id="file" name="image" onchange="loadFile(event)" accept="image/*" style="display: none;">
                                    <!-- <input type="button" value="Browse..." onclick="document.getElementById('file').click();" style="margin-left: auto; margin-right: auto;display: block;" /> -->
                                    <!-- <input class="form-control border-0" type="search" placeholder="Search" style="width:300px;display: inline;">
                                    <i class="bi bi-search fa-1x" style="margin-left: 10px;" ></i> -->

                                    <%
                                        String id;
                                        if (venue.getId() != 0) {
                                            id = Integer.toString(venue.getId());
                                        } else {
                                            id = "Not Suitable";
                                        }
                                    %>
                                    <p style="font-size: 25px;">Information</p>
                                    <input type="hidden" name="id" value="<%= venue.getId()%>"  >
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Venue ID</label>
                                        <input type="text" class="form-control" id="venueId" name="venueId"  value="<%= id%>" disabled="disabled"  >
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputPassword4" class="form-label">Name</label>
                                        <input type="text" class="form-control" id="name" name="name" value="<%= venue.getName()%>" >
                                    </div>

                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Capacity</label>
                                        <input type="number" id="typeNumber" class="form-control" name="capacity" value="<%= venue.getCapacity()%>" />
                                    </div>

                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Type</label>
                                        <select class="form-select" aria-label="Default select example" name="type" >
                                                <option value="Banquet Hall" <% if (venue.getType().equals("Banquet Hall")) {
                                                        out.println("selected");
                                                    } %>  >Banquet Hall</option>
                                                    <option value="Conference Room"  <% if (venue.getType().equals("Conference Room")) {
                                                            out.println("selected");
                                                        } %> >Conference Room</option>
                                                    <option value="Party Room" <% if (venue.getType().equals("Party Room")) {
                                                            out.println("selected");
                                                        } %> >Party Room</option>
                                                    <option value="Art Studio" <% if (venue.getType().equals("Art Studio")) {
                                                            out.println("selected");
                                                        } %> >Art Studio</option>
                                                    <option value="Co-working Space" <% if (venue.getType().equals("Co-working Space")) {
                                                            out.println("selected");
                                                        } %> >Co-working Space</option>
                                        </select>
                                    </div>

                                    <div class="col-md-6">
                                        <label for="inputPassword4" class="form-label">Location</label>
                                        <select class="form-select" aria-label="Default select example" name="location" name="location"  >
                                                <option value="Tuen Mun" <% if (venue.getLocation().equals("Tuen Mun")) {
                                                        out.println("selected");
                                                    } %> >Tuen Mun</option>
                                                    <option value="Sha Tin" <% if (venue.getLocation().equals("Sha Tin")) {
                                                            out.println("selected");
                                                        } %> >Sha Tin</option>
                                                    <option value="Tsing Yi" <% if (venue.getLocation().equals("Tsing Yi")) {
                                                            out.println("selected");
                                                        } %> >Tsing Yi</option>
                                                    <option value="Lee Wai Lee" <% if (venue.getLocation().equals("Lee Wai Lee")) {
                                                            out.println("selected");
                                                        } %> >Lee Wai Lee</option>
                                                    <option value="Chai Wan" <% if (venue.getLocation().equals("Chai Wan")) {
                                                            out.println("selected");
                                                        }%> >Chai Wan</option>
                                        </select>
                                    </div>

                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Venue manager name</label>
                                        <input type="text" class="form-control" id="inputEmail4" name="person_in_charge" value="<%= venue.getPersonInCharge()%>" >
                                    </div>

                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Booking fee</label>
                                        <input type="number" id="typeNumber" class="form-control" name="hourly_rate" value="<%= venue.getHourlyRate()%>" />
                                    </div>

                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Is active</label>
                                        <!-- <input class="form-control" type="text" placeholder="Empty" aria-label="Disabled input example"> -->
                                        <select class="form-select" aria-label="Default select example" name="active" >
                                                <option value="1" <% if (venue.getIsActive().equals("1")) {
                                                        out.println("selected");
                                                    } %> >Avabiliable</option>
                                                    <option value="0" <% if (venue.getIsActive().equals("0")) {
                                                            out.println("selected");
                                                        }%> >Unavabiliable</option>
                                        </select>
                                    </div>

                                    <div class="mb-3">
                                        <label for="exampleFormControlTextarea1" class="form-label">Description</label>
                                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description" ><%= venue.getDescription()%></textarea>
                                    </div>

                                    <div class="col-md-6">
                                        <button type="submit" class="btn btn-primary" style="max-width: 100px;">Submit</button>
                                    </div>
                                </form>
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