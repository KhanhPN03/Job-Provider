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
    <div class="container col-lg-4">
        <form action="RecoverPassController" method="post">
            <h1 class="brand">Jobs Provider</h1>
            <h2 class="form-name">RECOVER PASSWORD</h2>
            <p>Create new password.</p>
            
            <c:set var="e" value="${requestScope.error}"/>
            <p style="text-align: center; color: #D62929; font-weight: 300; margin: 0;">${e}</p>
            
            <div class="form-control">
                <input id="username" name="new" type="text" placeholder=""/>
                <label for="username">New password</label>
                <small></small>
                <span></span>
            </div>
            <div class="form-control">
                <input id="username" name="confirmNew" type="text" placeholder=""/>
                <label for="username">Confirm password</label>
                <small></small>
                <span></span>
            </div>

            <button type="submit" class="btn-submit m-0">CONTINUE</button>
                               
        </form>
       
    </div>
</body>

</html>