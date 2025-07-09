<%-- 
    Document   : PostDetail
    Created on : Oct 17, 2023, 10:58:05 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./Tool/css_bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="./Tool/js_bootstrap.bundle.min.js" type="text/javascript"></script>
        <link href="css/post.css" rel="stylesheet" type="text/css"/>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5J-vhaNcmiDOIK-YwPm1fSfQha-4fZ2M"></script>


    </head>
    <body>
        <%@include file="Header and Footer/PageHeader.jsp" %>
        <c:set var="p" value="${requestScope.post}" />
        <c:set var="e" value="${requestScope.employer}" />
        <c:set var="com" value="${requestScope.company}" />
        <div class="container-fluid body col-sm-8 p-5">          
            <div class="row">
                <div class="time">
                    <p>${p.getDate_start()}</p>
                </div>
                <div class="container-fluid job_detail p-5">
                    <div class="row job_info">              
                        <div class="col-sm-8 job_info_name">
                            <div class="job_name">                              
                                <h2>${p.postDetail.getJob_name()}</h2>
                            </div>
                            <div class="job_comp-name">                             
                                <h4>${e.getE_name()}${com.getCom_name()}</h4>
                            </div>
                        </div>
                        <div class="job_brand-logo col-sm-4">
                            <img src="${e.getAccount().getAccImg()}${com.getAccount().getAccImg()}" alt="">
                        </div>        
                    </div>

                    <div class="line"></div>

                    <div class="container job_info p-0">

                        <div class="row d-flex">
                            <div style="width: fit-content;" class="job_salary">
                                <i class='bx bx-wallet'></i>
                                <div class="job_salary-info">
                                    <p>Salary</p>
                                    <p>${p.postDetail.getSalary()}</p>
                                </div>
                            </div>
                            <div style="width: fit-content;" class="job_salary">
                                <i class='bx bx-category' ></i>
                                <div class="job_salary-info">
                                    <p>Sector</p>
                                    <p>${p.postDetail.getSector()}</p>
                                </div>
                            </div>
                            <div style="width: fit-content;" class="job_salary">
                                <i class='bx bx-time-five' ></i>
                                <div class="job_salary-info">
                                    <p>Working hours</p>
                                    <p>${p.postDetail.getWorkingHours()}</p>
                                </div>
                            </div>
                            <div style="width: fit-content;" class="job_salary">
                                <i class='bx bx-info-circle'></i>
                                <div class="job_salary-info">
                                    <p>Number of recruit</p>
                                    <p>${p.postDetail.getNumberOfRecure()}</p>
                                </div>
                            </div>
                        </div>
                        <div class="job_apply">
                            <c:set var="a_id" value="${requestScope.a_id}"/>
                            <c:set var="p_id" value="${requestScope.post_id}"/>
                            <c:set var="pD_id" value="${requestScope.postD_id}"/>
                            <form action="Apply" method="get">
                                <input type="hidden" name="p_id" value="${p_id}"/>
                                <input type="hidden" name="pD_id" value="${pD_id}"/>
                                <input type="hidden" name="a_id" value="${a_id}"/>
                                <div class="job_apply-icon">
<!--                                    <div class="apply">
                                        <i class='bx bx-file'></i>
                                    </div>-->
                                    <div style="color: greenyellow;" class="check">
                                        <button style="background-color: transparent; color: white;
                                                border: none; outline: none;" type="submit">
                                            <!--<i class='bx bx-check-circle'></i>-->
                                            <i class='bx bx-file'></i>
                                        </button>
                                    </div>
                                </div>
                                <p>Apply</p>
                            </form>
                        </div>
                    </div>
                </div>       
            </div>


            <div class="row my-5">
                <div class="desciprion">
                    <p>Description</p>
                </div>
                <div class="container-fluid job_detail job_desciprion p-5">
                    <p>${p.postDetail.getDesciption()}</p>
                </div>       
            </div>

            <div class="row">
                <div class="container-fluid desciprion p-0">
                    <c:set var="a_id" value="${requestScope.a_id}"/>
                    <c:set var="p_id" value="${requestScope.post_id}"/>
                    <c:set var="pD_id" value="${requestScope.postD_id}"/>
                    <c:choose>
                        <c:when test="${not empty a_id}">
                            <form action="AddFeedbackController" method="post">
                                <input style="display: none;" name="a_id" value="${a_id}"/>
                                <input style="display: none;" name="p_id" value="${p_id}"/>
                                <input style="display: none;" name="pD_id" value="${pD_id}"/>
                                <p class="ps-3">Feedback</p>
                                <div class="feedback_input col-sm-8">
                                    <input 
                                        name="feedback_detail" 
                                        class="feedback_input-field" 
                                        type="text" placeholder="Write out your thought...">
                                    <i class='bx bx-message-rounded-dots'></i>
                                </div>
                                <button style="display: none;" type="submit">Enter</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <p class="ps-3">Feedback</p>
                        </c:otherwise>
                    </c:choose>

                </div>

                <div class="feedback_list">
                    <c:forEach var="fb" items="${p.listFBdata}" >
                        <div class="row feedback_content my-5">         
                            <div class="container-fluid job_detail job_desciprion feedback p-0 pb-3">
                                <div class="user_avatar me-3">
                                    <img src="images/user1.png" alt="">
                                </div>
                                <div class="user_info">                    
                                    <p>
                                        ${fb.getCandidate().getC_name()}
                                    </p>
                                    <p>${fb.feedBack.getFb_detail()}</p>
                                    <p>${fb.feedBack.getFb_date()}</p>
                                </div>                      
                            </div>       
                        </div>    
                    </c:forEach>      
                </div>
            </div>


        </div>

        <c:set var="candidate" value="${requestScope.candidate}"/>
        <c:choose>
            <c:when test="${not empty candidate}">                                      
                <div class="contact" >
                    <button data-bs-toggle="modal" class="find-cmp-loca" data-bs-target="#staticBackdrop">Contact Information</button>
                </div>

                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" 
                     tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div style="border: none;" class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel"></h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="container modal-body p-5 pt-0">
                                <div class="row col-sm-10 w-100">
                                    <div class="modal_body-content w-100">
                                        <h5>Phone number</h5>
                                        <div class="content">
                                            <p>${p.postDetail.getContact_phone()}</p>
                                        </div>
                                    </div>
                                    <div class="modal_body-content w-100">
                                        <h5>Email address</h5>
                                        <div class="content">
                                            <p>${p.postDetail.getContact_email()}</p>
                                        </div>
                                    </div>
                                    <div class="modal_body-content w-100">
                                        <h5>Address</h5>
                                        <div class="content" >
                                            <p id="cmp_addr">${p.postDetail.getContact_address()}, ${p.postDetail.getCity()}</p>
                                        </div>
                                    </div>             
                                    <div class="modal-body  pt-0 d-flex justify-content-center">
                                        <div class="row col-sm-12 w-100 h-100">                        

                                            <div id="map" style="width: 100%; height: 150px;">
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="contact" >
                    <button data-bs-toggle="modal" class="find-cmp-loca" data-bs-target="#staticBackdrop"><a style="text-decoration: none; color: white;" href="/projob/login">Contact Information</a></button>
                </div>
            </c:otherwise>
        </c:choose>

        <%@include file="Header and Footer/PageFooter.jsp" %> 
    </body>
    <script src="js/post.js"></script>
    <script src="js/map.js"></script>

</html>
