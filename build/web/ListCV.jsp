<%-- 
    Document   : ListCV
    Created on : Nov 3, 2023, 9:42:26 AM
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

    <body style="display: flex; flex-direction: column;">
        <div>
            <h4>CV List</h4>
        </div>

        <div id="wrapper" class="col-7">

            <div id="container"
                 class="col-12"
                 style="
                 height: 400px;
                 overflow-y: scroll;
                 ">


                <div id="content" >
                    <c:set var="listCV" value="${requestScope.listCV}"/>
                    <c:choose>
                        <c:when test="${not empty listCV}">
                            <c:forEach var="listCV" items="${requestScope.listCV}">
                                <div class="content__body__post flex-row">                          
                                    <div class="content__body__comp  col-9 col-md-9 d-flex align-items-center gap-3" style="vertical-align: text-bottom;">  
                                        <p 
                                            class="col-6" 
                                            style="
                                            margin: 0;
                                            word-break: break-word;
                                            font-weight: 500;
                                            ">
                                            ${listCV.getName()}
                                        </p>
                                        <p 
                                            class="col-3" 
                                            style="
                                            margin: 0;
                                            word-break: break-word;
                                            font-weight: 500;
                                            ">
                                            ${listCV.getEmail()}
                                        </p>
                                        <p 
                                            class="col-3" 
                                            style="
                                            margin: 0;
                                            word-break: break-word;
                                            font-weight: 500;
                                            ">
                                            ${listCV.getPhone()}
                                        </p>
                                    </div>  
                                    <div class="content__body__action col-3 col-md-3">  
                                        <div class="nav_swift">  
                                            <div class="subnav f-right">  
                                                <div class="item ">  
                                                    <ul class="action-item d-sm-block d-lg-flex">   
                                                        <li class="my-2">  
                                                            <a 
                                                                href="ViewCV?cv_id=${listCV.getCv_id()}">
                                                                View CV
                                                            </a>  
                                                        </li>  
                                                    </ul>  
                                                </div>  
                                            </div>  
                                        </div>  
                                    </div>  
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p                                  
                                style="
                                margin: 0;
                                word-break: break-word;
                                font-weight: bold;
                                font-size: 2rem;
                                text-align: center;
                                ">
                                No one applied yet...
                            </p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

        </div>



    </body>
    <script src="./Tool/js_bootstrap.bundle.min.js"></script>
    <script src="./js/userProfile.js"></script>

</html>
