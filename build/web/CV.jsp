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
                    <c:set var="cv" value="${requestScope.cv}"/>                  
                    <div class="activate">
                        <label for="fullname">Full Name:</label>
                        <span id="fullname-span">                                                                    
                            <span 
                                style="
                                background-color: transparent;
                                padding: 5px;
                                border-radius: 7px;" />
                            ${cv.getName()}
                        </span>
                        </span>
                    </div>
                    <hr />
                    <div class="activate">
                        <label for="fullname">Date of birth:</label>
                        <span id="fullname-span">                                                                    
                            <span 
                                style="
                                background-color: transparent;
                                padding: 5px;
                                border-radius: 7px;" />
                            ${cv.getDob()}
                        </span>
                        </span>
                    </div>
                    <hr /><div class="activate">
                        <label for="fullname">Email address:</label>
                        <span id="fullname-span">                                                                    
                            <span 
                                style="
                                background-color: transparent;
                                padding: 5px;
                                border-radius: 7px;" />
                            ${cv.getEmail()}
                        </span>
                        </span>
                    </div>
                    <hr />
                    <div class="activate">
                        <label for="fullname">Phone number:</label>
                        <span id="fullname-span">                                                                    
                            <span 
                                style="
                                background-color: transparent;
                                padding: 5px;
                                border-radius: 7px;" />
                            ${cv.getPhone()}
                        </span>
                        </span>
                    </div>
                    <hr />
                    <div class="activate">
                        <label for="fullname">CV link:</label>
                        <span id="fullname-span">                                                                    
                            <span 
                                style="
                                background-color: transparent;
                                padding: 5px;
                                border-radius: 7px;" />
                            ${cv.getCv_link()}
                        </span>
                        </span>
                    </div>
                    <hr />

                </div>
            </div>



        </div>



    </body>
    <script src="./Tool/js_bootstrap.bundle.min.js"></script>
    <script src="./js/userProfile.js"></script>

</html>
