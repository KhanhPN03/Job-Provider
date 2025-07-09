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
    <link href="css/Style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <%--<%@include file="Header and Footer/PageHeader.jsp" %>--%>
    <div class="container col-lg-4">
        <form action="Apply" method="post">
            <h1 class="brand">Jobs Provider</h1>
            <h2 class="form-name">Apply</h2>
            <p>Please complete all fields to apply for this job.</p>
            
            <c:set var="a_id" value="${requestScope.a_id}"/>
            <c:set var="p_id" value="${requestScope.p_id}"/>
            <c:set var="pD_id" value="${requestScope.pD_id}"/>
            <input type="hidden" name="a_id" value="${a_id}"/>
            <input type="hidden" name="p_id" value="${p_id}"/>
            <input type="hidden" name="pD_id" value="${pD_id}"/>

            
            <div class="form-control">
                <input id="password" name="name" type="text" placeholder=""/>
                <label for="input">Full name</label>
                <small></small>
                <span></span>
            </div>
            <div class="form-control">
                <input id="password" name="dob" type="date" placeholder=""/>
                <label for="input">DATE OF BIRTH</label>
                <small></small>
                <span></span>
            </div>
            <div class="form-control">
                <input id="username" name="gender" type="text" placeholder=""/>
                <label for="username">Gender</label>
                <small></small>
                <span></span>
            </div>
            <div class="form-control">
                <input id="username" type="email" name="email" placeholder=""/>
                <label for="username">Email address</label>
                <small></small>
                <span></span>
            </div>
            <div class="form-control">
                <input id="username" name="phone" type="text" placeholder=""/>
                <label for="input">Phone number</label>
                <small></small>
                <span></span>
            </div>
            <div class="form-control">
                <input id="username" name="link" type="url" placeholder=""/>
                <label for="username">CV link</label>
                <small></small>
                <span></span>
            </div>           
            

            <button type="submit" class="btn-submit">APPLY</button>
           
        </form>
       
    </div>
    <%--<%@include file="Header and Footer/PageFooter.jsp" %>--%> 
</body>
<!--<script src="./js/login.js"></script>-->

</html>