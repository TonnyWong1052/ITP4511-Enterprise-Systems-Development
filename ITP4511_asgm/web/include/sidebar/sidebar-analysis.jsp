<%-- 
    Document   : sidebar-analysis
    Created on : 2023年4月24日, 下午3:03:42
    Author     : tomleung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-light navbar-light">
                <a href="index.html" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary">EPL Admin</h3>
                </a>
                <div class="navbar-nav w-100">
                    <a href="handleVenueManagement" class="nav-item nav-link"><i class="bi bi-shop-window me-2"></i>Venue</a>
                    <a href="handleBookingManagement" class="nav-item nav-link"><i class="bi bi-bag me-2"></i>Order</a>
                    <a href="userManagement.html" class="nav-item nav-link"><i class="bi bi-people-fill me-2"></i>User</a>
                    <a href="analysis.html" class="nav-item nav-link active"><i class="bi bi-graph-up me-2"></i>Analysis</a>
                </div>
            </nav>
        </div>
    </body>
</html>
