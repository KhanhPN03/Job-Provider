<%-- 
    Document   : adsManage
    Created on : Oct 27, 2023, 8:40:07 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ads Management</title>
    <link rel="stylesheet" href="./css/admindb.css">
    <link rel="stylesheet" href="./css/adsManage.css">
    <link rel="stylesheet" href="./css/post.css">
    <link rel="stylesheet" href="./Tool/css_bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

</head>

<body>
    <div style="display: none">
        <c:forEach var="data" items="${requestScope.adsList}" >
            <div class="data">
                <p class="ads_id">${data.getAds_id()}</p>               
                <p class="ads_dateStart">${data.getDate_start()}</p>
                <p class="ads_dateEnd">${data.getDate_end()}</p>
                <p class="ads_statistic">${data.getAds_statistic()}</p>
                <p class="adsD_id">${data.getAdsDetail().getAdsD_id()}</p>
                <p class="adsD_des">${data.getAdsDetail().getAds_description()}</p>
                <p class="adsD_link">${data.getAdsDetail().getAdflick_link()}</p>
                <p class="adsD_status">${data.getAdsDetail().getAds_status()}</p>
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
            <li>
                <a href="#">
                    <i class='bx bxs-user'></i>
                    <span>Profile</span>
                </a>
            </li>
            <li class="">
                <a href="/projob/PostManagement">
                    <i class='bx bxs-window-alt'></i>
                    <span>Post Management
                    </span>

                </a>
            </li>
            <li class="active">
                <a href="/projob/AdsManagement">
                    <i class='bx bx-money-withdraw'></i>
                    <span>Ads Management
                    </span>
                </a>
            </li>
            <li>
                <a href="#">
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
                <p>Ads Management</p>
            </div>
            <div class="contentTopRight">
                <div class="contentRightInput">
                    <i class='bx bx-search'></i>
                    <input placeholder="Search..." type="text">
                </div>
                <img src="../images/4.jpeg" alt="">
            </div>
        </div>

        <div class="mainContentBody">
            <div class="row">
                <h2 class="col-12 m-1">Ads Management</h2>
                <!-- filter -->
                <div class="body_fil hide">
                    <div class="page_limit">
                        <span>Show</span>
                        <select id="table_size">
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                            <option value="50">50</option>
                        </select>
                        <span>Entries</span>
                    </div>
                    <div class="tab_filter_container">
                        <input type="text" id="tab_filter_text" />
                        <button id="tab_filter_btn" class="active">Filter</button>
                    </div>
                </div>
                <div class="col-12 content">
                </div>
            </div>

        </div>

        <div class="pagina">
            <span></span>
            <div class="index_btn">
            </div>
        </div>

    </div>
</body>
<script src="./Tool/js_bootstrap.bundle.min.js"></script>
<script src="./js/admindb.js"></script>
<script src="./js/AdsManage.js"></script>

</html>
