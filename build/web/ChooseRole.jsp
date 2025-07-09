<%-- 
    Document   : Login
    Created on : Oct 29, 2023, 3:32:03 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

    <link rel="stylesheet" href="./css/login.css">
    <link rel="stylesheet" href="./css/chooseRole.css">
    <link rel="stylesheet" href="./css/Style.css">
    
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet"/>
</head>

<body>
    
    <div class="container col-lg-4">
        <form>
            
            <h1 class="brand">Jobs Provider</h1>
            <h2 class="form-name">WHO ARE YOU?</h2>
            <p>Choose your role.</p>
           
            <div class="d-flex justify-content-between my-5">
                <div class="role text-center">
                    <a href="Register.jsp">
                        <i class="fa-solid fa-user-tie"></i>
                        <h4>Candidate</h4>
                    </a>                 
                </div>
                <div class="role text-center">
                    <a href="RegisterEmp.jsp">
                        <i class="fa-solid fa-house-chimney-user"></i>
                        <h4>Employer</h4>
                    </a>
                </div>
                <div class="role text-center">
                    <a href="RegisterCom.jsp">
                        <i class="fa-solid fa-building"></i>
                        <h4>Company</h4>
                    </a>
                </div>
            </div>
            
                    
        </form>
       
    </div>
    
</body>
<!--<script src="./js/login.js"></script>-->

</html>