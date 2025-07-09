<%-- 
    Document   : PageHeader
    Created on : Oct 17, 2023, 11:01:41 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Provider Job</title>
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../Tool/css_bootstrap.min.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <header>
    <nav class="navbar navbar-expand-md bg-secondary">
        <div style="display: flex; justify-content: space-between; padding-left: 50px; padding-right: 50px;" class="container-fluid navbar-header" style="padding: 0 50px;">
            <div>
                <h2 class="col-sm-1 "><a class="navbar-brand" href="/projob/viewpostcontroller">ProJob</a></h2>
            </div>
        
            <div style="justify-content: flex-end;" class="col-md-11 collapse navbar-collapse" id="mynavbar">
              <ul class="col-md-4 d-flex justify-content-end navbar-nav ">
                <li class="nav-item">
                  <a class="nav-link" href="/projob/viewpostcontroller">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Contact</a>
                </li>
<!--                <li class="nav-item ms-5">                
                  <a href="" class="nav-link">Login<i class='bx bxs-user'></i></a>                
                </li>-->
              </ul>
            </div>
        </div>
      </nav>
    </header>
    </body>
<script src="../js/homePage.js"></script>
<script src="../Tool/js_bootstrap.bundle.min.js"></script>
</html>
