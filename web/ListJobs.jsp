<%-- 
    Document   : ListJobs
    Created on : Nov 1, 2023, 9:32:01 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="./css/listofjob.css">
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./Tool/css_bootstrap.min.css">
        <style>
           .imageWrapper{
                width: 58px;
                height: 53.86px;
                border-radius: 50%;
                margin-right: 10px;            
            }
            .bog_item-content{
             
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
            }
            .bog_item-content .card-title{
                margin: 0;
                font-size: 18px;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
            }
                footer {
                    margin-top: 30px;
                    background-color: #340303;
                    color: white;
                    padding: 30px 0;
                }
            .about p{
                font-weight: 500;
            }
            .link-wrapper a{
                text-decoration: none;
                color: var(--color-item);
            }
            .footer-leftContent{
                transform: translateX(43%)
            }
            .footer-leftContent p{
                font-family: 'Sigmar One';
                margin-bottom: 10px;
            }
            .container-custom{
                padding: 0 15em;
            }  
            footer a{
                margin-bottom: 5px;
            }
        </style>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <%@include file="Header and Footer/PageHeader.jsp" %>

        <c:set var="city" value="${requestScope.firstCity}"/>
        <c:set var="salary" value="${requestScope.firstSalary}"/>
        <c:set var="wh" value="${requestScope.firstWorkingHours}"/>
        <c:set var="a_id" value="${requestScope.a_id}"/>
        <div style="display: none;" class="account">
            <p class="account_id">${a_id}</p>                
        </div>


        <div style="display: none">
            <c:forEach var="data" items="${requestScope.listPost}" >
                <div class="data">
                    <p class="job_name">${data.postDetail.getJob_name()}</p>
                    <p class="emp_id">${data.postDetail.getEmp_id()}${data.postDetail.getCom_id()}</p>
                    <p class="city">${data.postDetail.getCity()}</p>
                    <p class="salary">${data.postDetail.getSalary()}</p>
                    <p class="postD_id">${data.postDetail.getPostD_id()}</p>
                    <p class="post_id">${data.getPost_id()}</p>
                    <p class="job_addr">${data.postDetail.getContact_address()}</p>
                    <p class="sectors">${data.postDetail.getSector()}</p>
                    <p class="emp_img">img</p>
                </div>           
            </c:forEach>
            <c:forEach var="com" items="${requestScope.listCom}" >
                <div class="com">
                    <p class="com_id">${com.getCom_id()}</p> 
                    <p class="com_name">${com.getCom_name()}</p>
                    <p class="com_img">${com.getAccount().getAccImg()}</p>
                </div>           
            </c:forEach>
            <c:forEach var="emp" items="${requestScope.listEmp}" >
                <div class="emp">
                    <p class="emp_id">${emp.getE_id()}</p>
                    <p class="emp_name">${emp.getE_name()}</p> 
                    <p class="emp_img">${emp.getAccount().getAccImg()}</p>
                </div>           
            </c:forEach>

        </div>
        <div class="slogen_swrapper">
            <i class='bx bx-pulse'></i>
            <div class="slogen_swrapper-content">
                <h3>PROVIDE THE BEST JOB</h3>
                <span>ProJob</span>
            </div>
        </div>
        <section class="listOfJob container" style="padding: 0;">
            <div class="listOfJobLeft">
                <div class="listOfJobLeftCategory">
                    <div class="d-flex flex-wrap justify-content-center">
                        <!--                        <div style="width: fit-content;"
                                                     class="mt-4 mt-md-0 justify-content-start filter-category-left">                 
                                                    <ul name="category" class="category">
                                                        <li>Category</li>
                                                        <li value="area"><i class='bx bx-map-alt'></i><span>Area</span></li>
                                                        <li value="sector""><i class='bx bxs-analyse'></i><span>Sector</span></li>
                                                        <li value="time"><i class='bx bxs-time' ></i><span>Working hours</span></li>
                                                        <li value="salary"><i class='bx bx-money' ></i><span>Salary</span></li>
                                                    </ul>
                                                </div>-->
                        <div class="col-md-10">
                            <div style="visibility: hidden; cursor: none;" class="filter-category-wrapper d-none d-md-flex align-items-center ">
                                <!--control-->      
                                <button id="leftBtnFilter"><i class='bx bx-chevron-left'></i></button>
                                <!--end control-->
                                <ul class="filter-category d-flex list-unstyled">      

                                </ul>

                                <button id="rightBtnFilter"><i class='bx bx-chevron-right' ></i></button>                                      
                            </div>
                            <div class="listOfJobLeftPostWrapper mt-4" style="padding: 10px;">
                                <div class="row listOfJobLeftPost">
                                    ...
                                </div>
                                <!--pagination-->
                                <div id="comp-control" class="d-flex pagi-control justify-content-center align-items-center mt-2">
                                    <button id="btnLeftPagination"><i class='bx bx-chevron-left'></i></button>
                                    <p class="mb-0 ms-1 me-1"><span id="currentPageTag"></span> / <span id="totalPage">1</span> pages</p>
                                    <button id="btnRightPagination"><i class='bx bx-chevron-right'></i></button>
                                </div>
                            </div>
                        </div>    
                    </div>               
                </div>
                <div class="listOfJobLeftPost"></div>
            </div>       
        </section>


        <!--footer-->
        <footer>
            <div class="container-custom">
                <div class="row">
                    <div class="col-12 col-md-7">
                        <div class="row">
                            <div class="col-6 col-sm-4 about">
                                <p>ABOUT US</p>
                                <div class="link-wrapper d-flex flex-column">
                                    <a href="https://www.topcv.vn/dieu-khoan-bao-mat">Privacy policy</a>
                                    <a href="https://static.topcv.vn/manual/Quy_che_san_TMDT_TopCV.pdf">Working process</a>
                                    <a href="https://www.topcv.vn/">Collaborators</a>
                                </div>
                            </div>
                            <div class="col-6 col-sm-4 term">
                                <p>TERM & CONDITION</p>
                                <div class="link-wrapper d-flex flex-column">
                                    <a href="#">Security regulations</a> 
                                    <a href="#">Operating regulations</a>
                                    <a href="#">Resolve complaints</a> 
                                    <a href="#">Usage Agreement </a>   
                                    <a href="#">Press Release</a>    
                                </div>
                            </div>
                            <div class="col-6 col-sm-4 service d-flex justify-content-sm-end">
                                <div>
                                    <p>SERVICES</p>
                                    <div class="link-wrapper d-flex flex-column">
                                        <a href="#">Services for advertising jobs</a>
                                        <a href="#">Services for finding jobs</a> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-5 footer-leftContent">
                        <p>WANT TO POST A JOB?</p>
                        <span>Contact us at: </span>
                        <ul class="nav mt-1">
                            <li class="nav-item"><a class="nav-link" href="https://www.facebook.com/profile.php?id=100006516376531"><i class='bx bxl-twitter fs-2'></i></a></li>
                            <li class="nav-item"><a class="nav-link" href="https://www.facebook.com/profile.php?id=100006516376531"><i class='bx bxl-facebook-circle fs-2'></i></a></li>
                            <li class="nav-item"><a class="nav-link" href="https://www.facebook.com/profile.php?id=100006516376531"><i class='bx bxl-instagram-alt fs-2' ></i></a></li>
                            <li class="nav-item"><a class="nav-link" href="https://www.facebook.com/profile.php?id=100006516376531"><i class='bx bxl-linkedin-square fs-2' ></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
        
    </body>
    <script>
        
    </script>
    <script src="./js/listofjob.js"></script>
    <script src="./Tool/js_bootstrap.bundle.min.js"></script>
</html>
