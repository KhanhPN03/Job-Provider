<%-- 
    Document   : Admindashboard
    Created on : Oct 27, 2023, 8:39:11 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%> 
<%@page import="Model.Post"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin DashBoard</title>
    <link rel="stylesheet" href="./css/admindb.css">
    <link rel="stylesheet" href="./Tool/css_bootstrap.min.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

</head>

<body>
    <div class="sidebar">
        <div class="logo">
        </div>
        <ul class="menu">
            <li class="active">
                <a href="/projob/PendingRequest">
                    <i class='bx bx-line-chart'></i>
                    <span>Dashboard</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <i class='bx bxs-user'></i>
                    <span>Account Management</span>
                </a>
            </li>
            <li >
                <a href="/projob/PostManagement">
                    <i class='bx bxs-window-alt'></i>
                    <span>Post Management
                    </span>

                </a>
            </li>
<!--            <li class="">
                <a href="/projob/AdsManagement">
                    <i class='bx bx-money-withdraw'></i>
                    <span>Ads Management
                    </span>
                </a>
            </li>-->
            <li>
                <a href="/projob/login">
                    <i class='bx bx-log-out-circle'></i>
                    <span>Log Out</span>
                </a>
            </li>
        </ul>
    </div>

    <div class="mainContent">
        <div class="mainContentTop ">
            <div class="contentTopLeft">
                <span>Admin</span>
                <p>Dashboard</p>
            </div>
            <div class="contentTopRight">
                <div class="contentRightInput">
                    <i class='bx bx-search'></i>
                    <input placeholder="Search..." type="text">
                </div>
                <img src="images/user3.png" alt="">
            </div>
        </div>
<!--        <div class="mainContentCenter">
            <div class="mainContentCenterWrapper">
                <p>Today's data</p>
                <div class="row">
                    <div class="card-wrapper p-1 col-sm-3">
                        <div class="card">
                            <div class="card-body">
                                <span>Payment amount</span>
                                <p>$500.00</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-wrapper p-1 col-sm-3">
                        <div class="card">
                            <div class="card-body">
                                <span>Payment amount</span>
                                <p>$500.00</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-wrapper p-1 col-sm-3">
                        <div class="card">
                            <div class="card-body">
                                <span>Payment amount</span>
                                <p>$500.00</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-wrapper p-1 col-sm-3">
                        <div class="card">
                            <div class="card-body">
                                <span>Payment amount</span>
                                <p>$500.00</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>-->
        <div class="mainContentBottom">
            <p>List Post Pending</p>
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Type</th>
                        <th>Description</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="pendingRequest" items="${requestScope.pendingList}">                      
                        <tr>
                            <td>${pendingRequest.date_start}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${pendingRequest.postDetail.update_status == 1
                                            && pendingRequest.postDetail.post_status == 1}">
                                        Update
                                    </c:when>
                                    <c:when test="${pendingRequest.postDetail.update_status == 1
                                            && pendingRequest.postDetail.post_status == 0}">
                                        Upload
                                    </c:when>
                                    
                                </c:choose>
                            </td>
                            <td>${pendingRequest.postDetail.job_name}</td>
                            <td>
                                <button 
                                    style="border: none; 
                                    outline: none; 
                                    background-color: transparent">
                                    <a style="text-decoration: none; color: black;" href="ApprovePost?id=${pendingRequest.getPostDetail().getPostD_id()}">Approve</a>
                                </button>&nbsp;
                                <button 
                                    style="border: none; 
                                    outline: none; 
                                    background-color: transparent">
                                    <a style="text-decoration: none; color: black;" href="DenyPost?id=${pendingRequest.getPostDetail().getPostD_id()}">Deny</a>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                                   
                </tbody>
            </table>
        </div>
    </div>
</body>
<script src="./js/admindb.js"></script>
<script src="./Tool/js_bootstrap.bundle.min.js"></script>

</html>
