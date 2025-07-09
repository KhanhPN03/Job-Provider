<%-- 
    Document   : postManage
    Created on : Oct 27, 2023, 8:40:39 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%> 
<%@page import="Model.Employer"%> 
<%@page import="Model.Company"%> 
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Post Management</title>
        <link rel="stylesheet" href="./css/admindb.css">
        <link rel="stylesheet" href="./css/postManage.css">
        <link rel="stylesheet" href="./Tool/css_bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    </head>

    <body>

        <div style="display: none">
            <c:forEach var="data" items="${requestScope.listPost}" >
                <div class="data">
                    <p class="acc_name">${data.postDetail.getJob_name()}</p> 
                    <p class="acc_id">${data.postDetail.getEmp_id()}${data.postDetail.getCom_id()}</p>
                    <p class="tax">${data.postDetail.getCity()}</p>

                </div>           
            </c:forEach>
        </div>


        <div class="sidebar">
            <div class="logo">
            </div>
            <ul class="menu">
                <li>
                    <a href="/projob/PendingRequest">
                        <i class='bx bx-line-chart'></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="active">
                    <a href="/projob/AccountPendingRequest">
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

                <li>
                    <a href="/projob/login">
                        <i class='bx bx-log-out-circle'></i>
                        <span>Log Out</span>
                    </a>
                </li>
            </ul>
        </div>

        <!-- Content -->
        <div class="mainContent">

            <div class="mainContentTop ">
                <div class="contentTopLeft">
                    <span>Admin</span>
                    <p>Account Management</p>
                </div>
                <div class="contentTopRight">
                    <div class="contentRightInput">
                        <i class='bx bx-search'></i>
                        <input placeholder="Search..." type="text">
                    </div>
                    <img src="../images/4.jpeg" alt="">
                </div>
            </div>

            <div class="mainContentBottom">
                <p>List Account Pending</p>
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Account ID</th>
                            <th>Tax</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="pendingRequest" items="${requestScope.EmpPendingList}">                      
                            <tr>

                                <td>
                                    ${pendingRequest.e_name}
                                </td>
                                <td>${pendingRequest.account.a_id}</td>
                                <td>${pendingRequest.tax}</td>
                                <td>
                                    <button 
                                        style="border: none;
                                        outline: none;
                                        background-color: transparent">
                                        <a style="text-decoration: none; color: black;" href="ApproveEmpAccount?id=${pendingRequest.e_id}">Approve</a>
                                    </button>&nbsp;
                                    <button 
                                        style="border: none;
                                        outline: none;
                                        background-color: transparent">
                                        <a style="text-decoration: none; color: black;" href="DenyEmpAccount?id=${pendingRequest.e_id}&a_id=${pendingRequest.account.a_id}">Deny</a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:forEach var="pendingRequest" items="${requestScope.ComPendingList}">                      
                            <tr>

                                <td>
                                    ${pendingRequest.com_name}
                                </td>
                                <td>${pendingRequest.account.a_id}</td>
                                <td>${pendingRequest.tax}</td>
                                <td>
                                    <button 
                                        style="border: none;
                                        outline: none;
                                        background-color: transparent">
                                        <a style="text-decoration: none; color: black;" href="ApproveComAccount?id=${pendingRequest.com_id}">Approve</a>
                                    </button>&nbsp;
                                    <button 
                                        style="border: none;
                                        outline: none;
                                        background-color: transparent">
                                        <a style="text-decoration: none; color: black;" href="DenyComAccount?id=${pendingRequest.com_id}&a_id=${pendingRequest.account.a_id}">Deny</a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>



            <div class="pagina">
                <span></span>
                <div class="index_btn">
                </div>
            </div>
        </div>
    </body>
    <!-- <script src="../js/pagina.js"></script> -->
    <script src="./js/admindb.js"></script>
    <script src="./js/AccManage.js"></script>
    <script src="./Tool/js_bootstrap.bundle.min.js"></script>

</html>
