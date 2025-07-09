<%-- 
    Document   : UserProfile
    Created on : Oct 31, 2023, 12:24:55 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/userProfile.css" />
        <link rel="stylesheet" href="./css/admindb.css">
        <link rel="stylesheet" href="./css/postManage.css">
        <link rel="stylesheet" href="./css/login.css"
              <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet"/>
        <link rel="stylesheet" href="./Tool/css_bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <script async src="main.js"></script>

        <style>
            body {
                gap: 30px;
            }
            .hide {
                display: none;
            }
            .activate {
                font-size: 1rem;
                padding-top: 10px;
            }
        </style>
        <title>Candidate</title>
    </head>

    <body style="">

        <div id="wrapper" class="col-3">

            <div id="container col-5">

                <div id="avatar">
                    <img id="avatar-d" src="./images/z4788234829984_8a40558b64f1db05c8a9ed421a0f3067.jpg" alt="" /><input
                        type="file" id="imageInput" style="display: none" />
                </div>
                <div id="content">
                    <form action="ChangeUserProfile" method="post">
                        <c:set var="accountInfo" value="${requestScope.accountInfo}"/>
                        <c:set var="code" value="${requestScope.code}"/>
                        <c:set var="a_id" value="${requestScope.a_id}"/>
                        <input style="display: none;" name="code" value="${code}"/>
                        <input style="display: none;" name="a_id" value="${a_id}"/>
                        <div class="activate">
                            <label for="fullname">Full Name:</label>
                            <span id="fullname-span">
                                <c:choose>
                                    <c:when test="${code eq 'E'}">                                      
                                        <input 
                                            style="
                                            background-color: transparent;
                                            padding: 5px;
                                            border-radius: 7px;" 
                                            id="fullname-input" 
                                            type="text" class=""
                                            name="name"
                                            value="${accountInfo.getE_name()}" />
                                    </c:when>
                                    <c:when test="${code eq 'Com'}">
                                        <input style="
                                               background-color: transparent;
                                               padding: 5px;
                                               border-radius: 7px;" 
                                               id="fullname-input" 
                                               type="text" class=""
                                               name="name"
                                               value="${accountInfo.getCom_name()}" />
                                    </c:when>
                                    <c:when test="${code eq 'C'}">                                       
                                        <input style="
                                               background-color: transparent;
                                               padding: 5px;
                                               border-radius: 7px;" 
                                               id="fullname-input" 
                                               type="text" class=""
                                               name="name"
                                               value="${accountInfo.getC_name()}" />
                                    </c:when>
                                    <c:otherwise>
                                        Unknown code: ${code}
                                    </c:otherwise>
                                </c:choose>
                            </span>
                        </div>
                        <hr />
                        <div class="activate">
                            <label for="email">Email:</label>
                            <span id="email-span">                              
                                <input style="
                                       background-color: transparent;
                                       padding: 5px;
                                       border-radius: 7px;" 
                                       id="fullname-input" 
                                       type="text" class=""
                                       name="email"
                                       value="${accountInfo.getAccount().getEmail()}" />
                            </span>
                            <input id="email-input" type="text" class="hide" />
                        </div>
                        <hr />
                        <div class="activate">
                            <label for="phone">Phone Number:</label>
                            <span id="phone-span">
                                <c:choose>
                                    <c:when test="${code eq 'E'}">
                                        <input 
                                            style="
                                            background-color: transparent;
                                            padding: 5px;
                                            border-radius: 7px;" 
                                            id="fullname-input" 
                                            type="text" class=""
                                            name="phone"
                                            value="${accountInfo.getE_phone()}" />
                                    </c:when>
                                    <c:when test="${code eq 'Com'}">
                                        <input 
                                            style="
                                            background-color: transparent;
                                            padding: 5px;
                                            border-radius: 7px;" 
                                            id="fullname-input" 
                                            type="text" class=""
                                            name="phone"
                                            value="${accountInfo.getCom_phone()}" />
                                    </c:when>
                                    <c:when test="${code eq 'C'}">
                                        <input 
                                            style="
                                            background-color: transparent;
                                            padding: 5px;
                                            border-radius: 7px;" 
                                            id="fullname-input" 
                                            type="text" class=""
                                            name="phone"
                                            value="${accountInfo.getC_phone()}" />
                                    </c:when>
                                    <c:otherwise>
                                        Unknown code: ${code}
                                    </c:otherwise>
                                </c:choose>                
                            </span>
                            <input id="phone-input" type="text" class="hide" />
                        </div>
                        <hr />
                        <div class="activate">
                            <label for="address">Address:</label>
                            <span id="address-span">
                                <c:choose>
                                    <c:when test="${code eq 'E'}">
                                        <input 
                                            style="
                                            background-color: transparent;
                                            padding: 5px;
                                            border-radius: 7px;" 
                                            id="fullname-input" 
                                            type="text" class=""
                                            name="address"
                                            value="${accountInfo.getE_address()}" />
                                    </c:when>
                                    <c:when test="${code eq 'Com'}">
                                        <input 
                                            style="
                                            background-color: transparent;
                                            padding: 5px;
                                            border-radius: 7px;" 
                                            id="fullname-input" 
                                            type="text" class=""
                                            name="address"
                                            value="${accountInfo.getCom_address()}" />
                                    </c:when>
                                    <c:when test="${code eq 'C'}">
                                        <input 
                                            style="
                                            background-color: transparent;
                                            padding: 5px;
                                            border-radius: 7px;" 
                                            id="fullname-input" 
                                            type="text" class="" 
                                            name="address"
                                            value="${accountInfo.getC_address()}" />
                                    </c:when>
                                    <c:otherwise>
                                        Unknown code: ${code}
                                    </c:otherwise>
                                </c:choose> 
                            </span>
                            <input id="address-input" type="text" class="hide" />

                        </div>
                        <hr />
                        <div class="activate">
                            <div class="button">
                                <button type="submit">Update</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>



        </div>
        <c:choose>
            <c:when test="${code eq 'E'}">
                <div id="wrapper" class="col-7">

                    <div id="container"
                         class="col-12"
                         style="
                         height: 400px;
                         overflow-y: scroll;
                         ">
                        <div>
                            <h4>Uploaded Jobs</h4>
                        </div>
                        <div id="content" >
                            <form action="ChangeUserProfile" method="post">                                              
                                <c:forEach var="post" items="${requestScope.postList}">
                                    <div class="content__body__post flex-row">                          
                                        <div class="content__body__comp  col-9 col-md-9 d-flex align-items-center gap-3" style="vertical-align: text-bottom;">  
                                            <p 
                                                class="col-6" 
                                                style="
                                                margin: 0;
                                                word-break: break-word;
                                                font-weight: 500;
                                                ">
                                                ${post.getPostDetail().getJob_name()}
                                            </p>  
                                            <p 
                                                class="col-5 d-none d-sm-block" 
                                                style="
                                                margin: 0;
                                                ">
                                                ${post.getDate_start()} - ${post.getDate_end()}
                                            </p>
                                            <p class="col-1 d-none d-sm-block" style="margin: 0; text-align: center;">
                                                <c:choose>
                                                    <c:when test="${post.getPostDetail().getPost_status() == 0}">
                                                        Pending
                                                    </c:when>
                                                    <c:when test="${post.getPostDetail().getPost_status() == 1}">
                                                        Approved
                                                    </c:when>
                                                    <c:otherwise>
                                                        Deny
                                                    </c:otherwise>
                                                </c:choose>
                                            </p>
                                        </div>  
                                        <div class="content__body__action col-3 col-md-3">  
                                            <div class="nav_swift">  
                                                <div class="subnav f-right">  
                                                    <div class="item ">  
                                                        <ul class="action-item d-sm-block d-lg-flex">   
                                                            <li class="my-2">  
                                                                <a>
                                                                    Delete
                                                                </a>  
                                                            </li>
                                                            <li class="my-2">  
                                                                <a href="ViewListCVs?post_id=${post.getPost_id()}">
                                                                    View CVs
                                                                </a>  
                                                            </li>
                                                            <li class="my-2">  
                                                                <a 
                                                                    href="ViewPostDetailController?postD_id=${post.getPostDetail().getPostD_id()}&post_id=${post.getPost_id()}">
                                                                    View
                                                                </a>  
                                                            </li>  
                                                        </ul>  
                                                    </div>  
                                                </div>  
                                            </div>  
                                        </div>  
                                    </div>
                                </c:forEach>
                            </form>
                        </div>
                    </div>

                </div>
            </c:when>
            <c:when test="${code eq 'Com'}">
                <div id="wrapper" class="col-7">

                    <div id="container"
                         class="col-12"
                         style="
                         height: 400px;
                         overflow-y: scroll;

                         ">

                        <div>
                            <h4>Uploaded Jobs</h4>
                        </div>
                        <div id="content" >
                            <form action="ChangeUserProfile" method="post">                                              
                                <c:forEach var="post" items="${requestScope.postList}">
                                    <div class="content__body__post flex-row">                          
                                        <div class="content__body__comp  col-9 col-md-9 d-flex align-items-center gap-3" style="vertical-align: text-bottom;">  
                                            <p 
                                                class="col-6" 
                                                style="
                                                margin: 0;
                                                word-break: break-word;
                                                font-weight: 500;
                                                ">
                                                ${post.getPostDetail().getJob_name()}
                                            </p>  
                                            <p 
                                                class="col-5 d-none d-sm-block" 
                                                style="
                                                margin: 0;
                                                ">
                                                ${post.getDate_start()} - ${post.getDate_end()}
                                            </p>
                                            <p class="col-1 d-none d-sm-block" style="margin: 0; text-align: center;">
                                                <c:choose>
                                                    <c:when test="${post.getPostDetail().getUpdate_status() == null}">
                                                        Deny
                                                    </c:when>
                                                    <c:when test="${post.getPostDetail().getPost_status() == 0}">
                                                        Pending
                                                    </c:when>
                                                    <c:when test="${post.getPostDetail().getPost_status() == 1}">
                                                        Approved
                                                    </c:when>

                                                </c:choose>
                                            </p>
                                        </div>  
                                        <div class="content__body__action col-3 col-md-3">  
                                            <div class="nav_swift">  
                                                <div class="subnav f-right">  
                                                    <div class="item ">  
                                                        <ul class="action-item d-sm-block d-lg-flex">   
                                                            <li class="my-2">  
                                                                <a>
                                                                    Delete
                                                                </a>  
                                                            </li>
                                                            <li class="my-2">  
                                                                <a href="ViewListCVs?post_id=${post.getPost_id()}">
                                                                    View CVs
                                                                </a>  
                                                            </li>
                                                            <li class="my-2">  
                                                                <a 
                                                                    href="ViewPostDetailController?postD_id=${post.getPostDetail().getPostD_id()}&post_id=${post.getPost_id()}">
                                                                    View
                                                                </a>  
                                                            </li>

                                                        </ul>  
                                                    </div>  
                                                </div>  
                                            </div>  
                                        </div>  
                                    </div>
                                </c:forEach>
                            </form>
                        </div>
                    </div>

                </div>
            </c:when>
            <c:when test="${code eq 'C'}">
                <div id="wrapper" class="col-7">

                    <div id="container"
                         class="col-12"
                         style="
                         height: 400px;
                         overflow-y: scroll;
                         ">

                        <div>
                            <h4>Applied Jobs</h4>
                        </div>
                        <div id="content" >
                            <form action="ChangeUserProfile" method="post">                                              
                                <c:forEach var="cv" items="${requestScope.cvList}">
                                    <div class="content__body__post flex-row">                          
                                        <div class="content__body__comp  col-9 col-md-9 d-flex align-items-center gap-3" style="vertical-align: text-bottom;">  
                                            <p 
                                                class="col-6" 
                                                style="
                                                margin: 0;
                                                word-break: break-word;
                                                font-weight: 500;
                                                ">
                                                ${cv.getName()}
                                            </p>  
                                            <p 
                                                class="col-6" 
                                                style="
                                                margin: 0;
                                                word-break: break-word;
                                                font-weight: 500;
                                                ">
                                                ${cv.getPhone()}
                                            </p>
                                        </div>  
                                        <div class="content__body__action col-3 col-md-3">  
                                            <div class="nav_swift">  
                                                <div class="subnav f-right">  
                                                    <div class="item ">  
                                                        <ul class="action-item d-sm-block d-lg-flex">   
                                                            <li class="my-2">  
                                                                <a                                                                 
                                                                    href="ViewCV?cv_id=${cv.getCv_id()}">                                                                   
                                                                    View CV
                                                                </a>  
                                                            </li>  
                                                            <li class="my-2">  
                                                                <a 
                                                                    href="ViewPostDetailForCV?post_id=${cv.getPost_id()}&a_id=${a_id}">
                                                                    View Job
                                                                </a>  
                                                            </li>  
                                                        </ul>  
                                                    </div>  
                                                </div>  
                                            </div>  
                                        </div>  
                                    </div>
                                </c:forEach>
                            </form>
                        </div>
                    </div>

                </div>
            </c:when>


        </c:choose>


    </body>
    <script src="./Tool/js_bootstrap.bundle.min.js"></script>
    <script src="./js/userProfile.js"></script>

</html>
