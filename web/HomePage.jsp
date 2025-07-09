<%-- 
    Document   : HomePage.jsp
    Created on : Oct 23, 2023, 2:12:09 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Account" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Provider Job</title>
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="./Tool/css_bootstrap.min.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD9xvswUG16cb1cJtMkUSDEU720BkhRPMM"></script>
        <style>
            .imageWrapper{
                width: 58px;
                height: 53.86px;
                border-radius: 50%;
                margin-right: 10px;
            }
            footer a{
                margin-bottom: 5px;
            }
        </style>
    </head>
    <body>
        <div style="display: none;">
            <c:set var="account" value="${requestScope.account}"/>
            <div class="account">
                <p class="account_id">${account.getA_id()}</p>                
            </div>
            <c:forEach var="data" items="${requestScope.listPost}" >
                <div class="data">
                    <p class="job_name">${data.postDetail.getJob_name()}</p>
                    <p class="emp_id">${data.postDetail.getEmp_id()}${data.postDetail.getCom_id()}</p>
                    <p class="city">${data.postDetail.getCity()}</p>
                    <p class="salary">${data.postDetail.getSalary()}</p>
                    <p class="postD_id">${data.postDetail.getPostD_id()}</p>
                    <p class="post_id">${data.getPost_id()}</p>
                    <p class="job_addr">${data.postDetail.getContact_address()}</p>
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
            <c:forEach var="sector" items="${requestScope.listSector}" >
                <div class="sector">
                    <p class="sector_name">${sector.getSector()}</p>                              
                </div>           
            </c:forEach>
            <c:forEach var="city" items="${requestScope.listCity}" >
                <div class="cityObj">
                    <p class="cityObj_name">${city}</p>                              
                </div>           
            </c:forEach>
            <c:forEach var="workingHours" items="${requestScope.listWorkingHours}" >
                <div class="workingHours">
                    <p class="workingHours_name">${workingHours}</p>                              
                </div>           
            </c:forEach>
            <c:forEach var="salary" items="${requestScope.listSalary}" >
                <div class="salaryObj">
                    <p class="salaryObj_name">${salary}</p>                              
                </div>           
            </c:forEach>
        </div>
        <!--header-->
        <div class="overlay hide"></div>
        <header>
            <nav class="navbar navbar-expand-md bg-secondary">
                <div class="container-fluid navbar-header" style="padding: 0 50px;">
                    <h2 class="col-sm-1 "><a class="navbar-brand" href="/projob/viewpostcontroller">ProJob</a></h2>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="col-md-11 collapse navbar-collapse" id="mynavbar">

                        <form
                            action="SearchPostController"
                            method="post"
                            class="col-md-8 ms-4 ms-xl-1 justify-content-start d-flex navbar-form">

                            <c:set var="account" value="${requestScope.account}"/>
                            <input style="display: none;" name="account" value=${account.getA_id()}/>

                            <div class="formInputWrapper">
                                <input class="form-control" type="text" placeholder="Looking for Jobs...">
                                <i role="button" class='bx bx-search'></i>
                                <ul class="listSearch hide">

                                </ul>
                            </div>
                            <!--rightinput 1-->
                            <div class="formFilterInputRight1">
                                <div class="formFilterInput1">
                                    <i class='bx bxs-map'></i>
                                    <p style="width: 160px;">All of the city</p>
                                    <i class='bx bx-chevron-down' ></i>        
                                </div> 
                                <ul class="formFilterInputList1 hide col-11 ">
                                    <c:forEach var="city" items="${requestScope.listCity}" >
                                        <li class="formFilterInputItem1">
                                            <input                                                 
                                                style="
                                                border: none;
                                                outline: none;
                                                cursor: pointer;"
                                                name="city" value="${city}" readonly/>
                                        </li>
                                    </c:forEach>                                         
                                </ul>               
                            </div>
                            <!--formFilterInputRight2-->
                            <div class="formFilterInputRight2">
                                <div class="formFilterInput2">
                                    <i class='bx bxs-map'></i>
                                    <p style="width: 160px; text-align: start;">Salary</p>
                                    <i class='bx bx-chevron-down' ></i>        
                                </div> 
                                <ul class="formFilterInputList2 col-11 hide">
                                    <c:forEach var="salary" items="${requestScope.listSalary}" >
                                        <li class="formFilterInputItem2">
                                            <input 
                                                style="
                                                border: none;
                                                outline: none;
                                                cursor: pointer;
                                                "
                                                name="salary" value="${salary}" readonly/>
                                        </li>
                                    </c:forEach>                    
                                </ul>               
                            </div>
                            <!--formFilterInputRight3-->
                            <div class="formFilterInputRight3">
                                <div class="formFilterInput3">
                                    <i class='bx bxs-map'></i>
                                    <p selected>Working Hour</p>
                                    <i class='bx bx-chevron-down' ></i>        
                                </div> 
                                <ul class="formFilterInputList3 col-11 hide">
                                    <!--<select style="height: 32px; width: 100%;" name="workingHours" required="">-->
                                    <c:forEach var="workingHours" items="${requestScope.listWorkingHours}" >
                                        <li class="formFilterInputItem3">
                                            <input 
                                                style="
                                                border: none;
                                                outline: none;
                                                cursor: pointer;"
                                                name="workingHours" value="${workingHours}" readonly/>
                                        </li>
                                    </c:forEach>
                                    <!--</select>-->
                                </ul>               
                            </div>
                            <button type="submit" class="formSearchButton ms-1 "
                                    style="
                                    border: none;
                                    outline: none;
                                    border-radius: 5px;
                                    padding: 0 5px;
                                    font-size: 16px;
                                    width: 10%;
                                    font-weight: 600;
                                    background-color: rgb(39, 10, 64);
                                    color: pink;"
                                    >SEARCH</button>
                        </form>
                        <c:set var="account" value="${requestScope.account}"/>
                        <ul class="col-md-4 d-flex justify-content-end navbar-nav ">
                            <li class="nav-item">
                                <a class="nav-link" href="/projob/viewpostcontroller?a_id=${account.getA_id()}">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">About</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Contact</a>
                            </li>

                            <!-- <div style="width: 50px; height: 50px;">
                                <img style="width: 100%; height: 100%; object-fit: contain; object-position: center;" class="rounded-circle me-2" src="${itemBlog[index].emp_img}" alt="">
                            </div> -->

                            <li class="nav-item ms-5">
                                <c:set var="account" value="${requestScope.account}"/>
                                <%
                                    Account a = (Account) request.getAttribute("account");                             
                                    if (a.getUsername() == null){
                                %>
                                <a href="/projob/login" class="nav-link">Login<i class='bx bxs-user'></i></a> 
                                    <%
                                        } else {
                                    %>
                                <a href="#" class="nav-link"><%= a.getUsername() %> <img width="30px" src="images/user1.png" alt=""> </a>
                                    <%
                                            if (a.getRole().equals("1")) {
                                    %>                                             
                                <ul class="profileList">
                                    <li class="profileItem"><a href="ChangeUserProfile?a_id=${account.getA_id()}">Profile</a></li>
                                    <li class="profileItem"><button><a href="/projob/UploadJobController?id=${account.getA_id()}">POST JOB</a></button></li>
                                    <li class="profileItem"><a href="viewpostcontroller?logout=on">Change password</a></li>
                                    <li class="profileItem"><a href="viewpostcontroller?logout=on">Log out <i class='bx bx-log-in-circle'></i></a></li>
                                </ul>
                                <% } else if (a.getRole().equals("2")) { %>
                                <ul class="profileList hide">
                                    <li class="profileItem"><a href="ChangeUserProfile?a_id=${account.getA_id()}">Profile</a></li>
                                    <li class="profileItem"><a href="viewpostcontroller?logout=on">Change password</a></li>
                                    <li class="profileItem"><a href="viewpostcontroller?logout=on">Log out <i class='bx bx-log-in-circle'></i></a></li>
                                </ul>
                                <% }} %>
                            </li>
                        </ul>

                    </div>
                </div>
            </nav>
        </header>

        <!-- Carousel -->
        <div id="demo" class="carousel slide" data-bs-ride="carousel">

            <!-- Indicators/dots -->
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
            </div>

            <!-- The slideshow/carousel -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="images/carousel1.png" height="400px" class="d-block" style="width:100%">
                </div>
                <div class="carousel-item">
                    <img src="images/the bee.png" height="400px" class="d-block" style="width:100%">
                </div>
                <div class="carousel-item">
                    <img src="images/carousel3.png" height="400px" class="d-block" style="width:100%">
                </div>
            </div>

            <!-- Left and right controls/icons -->
            <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                <span class="carousel-control-next-icon"></span>
            </button>
        </div>

        <!--section slogen-->
        <section  
            style="
            display: flex;
            gap: 2em;"   
            class="slogen">
            <div class="slogen_swrapper">
                <i class='bx bx-pulse'></i>
                <div class="slogen_swrapper-content">
                    <h3>PROVIDE THE BEST JOB</h3>
                    <span>ProJob</span>
                </div>
            </div>
            <c:set var="account" value="${requestScope.account}"/>
            <c:choose>
                <c:when test="${not empty account}">
                    <div>
                        <div class="contact" >
                            <button              
                                style="
                                padding: .4em 1.2em;
                                border: 3px solid rgb(224, 219, 219);
                                border-radius: .3em;
                                outline: none;
                                font-weight: 700;"               
                                class="find-loca" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Find Nearest Jobs</button>
                        </div>
                        <div style="--bs-modal-width: 1000px;" class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" 
                             tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                            <div style="height: 500px;" class="modal-dialog">
                                <div class="modal-content w-100 h-100">
                                    <div style="border: none;" class="modal-header">
                                        <h5 class="modal-title" id="staticBackdropLabel"></h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="container modal-body p-5 pt-0 d-flex justify-content-center">
                                        <div class="row col-sm-10 w-100 h-100">                        
                                            <div id="map" class="modal_body-content w-100">
                                                <img 
                                                    id="brandImage" 
                                                    class="test_1 test_2" 
                                                    alt="Brand Logo" 
                                                    style="
                                                    width: 100px;
                                                    height: 100px;
                                                    display: none;
                                                    position: absolute;">
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
                        <button              
                            style="
                            padding: .4em 1.2em;
                            border: 3px solid rgb(224, 219, 219);
                            border-radius: .3em;
                            outline: none;
                            font-weight: 700;"               
                            class="find-loca">
                            <a 
                                style="text-decoration: none;"
                                href="/projob/login"
                                >Find Nearest Jobs</a></button>
                    </div>
                </c:otherwise>
            </c:choose>


        </section>

        <!--filter-->
        <section class="row filter mb-3">
            <div class="container-custom d-flex flex-wrap">
                <div class="col-12 col-md-4 d-flex align-items-center mt-4 mt-md-0 justify-content-start filter-category-left">
                    <i class='bx bx-menu-alt-left'></i>
                    <select name="category" id="category">
                        <option value="area">Area</option>
                        <option value="sector"">Sector</option>
                        <option value="time">Working hours</option>
                        <option value="salary">Salary</option>
                    </select>
                </div>
                <div class="col-12 col-md-8 filter-category-wrapper d-none d-md-flex align-items-center ">
                    <!--control-->      
                    <button id="leftBtnFilter"><i class='bx bx-chevron-left'></i></button>
                    <!--end control-->
                    <ul class="filter-category d-flex list-unstyled">      

                    </ul>

                    <button id="rightBtnFilter"><i class='bx bx-chevron-right' ></i></button>
                </div>    
            </div>
        </section>

        <!--blog-->
        <section class="blog">
            <div class="container-custom">
                <div class="row blog_list post_list mb-3">           

                </div>


            </div>

            <!--pagination-->
            <div id="comp-control" class="d-flex pagi-control justify-content-center align-items-center mt-1">
                <button id="btnLeftPagination"><i class='bx bx-chevron-left'></i></button>
                <p class="mb-0 ms-1 me-1"><span id="currentPageTag"></span> / <span id="totalPage">1</span> pages</p>
                <button id="btnRightPagination"><i class='bx bx-chevron-right'></i></button>
            </div>

        </section>

        <!--top company-->
        <section>

            <div class="container-custom comp">
                <div class="row align-items-center comp-content mb-3">
                    <h3 class="col-sm-6 comp-title">
                        Top of the Company
                    </h3>
                    <!--control-->
                    <div id="comp-control" class="col-sm-6 comp-btn d-flex justify-content-end">
                        <button id="leftBtnComp"><i class='bx bx-chevron-left'></i></button>
                        <button id="rightBtnComp"><i class='bx bx-chevron-right' ></i></button>
                    </div>
                </div>

                <div class="comp-list_card">
                    <div class="d-flex flex-nowrap blog_list mb-3">
                        <c:forEach var="company" items="${requestScope.listCom}">
                            <div class="col-12 col-sm-3 blog-wrap_item company">
                                <div class="blog_item card">
                                    <div class="card-body">
                                        <div class="card-body-img">
                                            <img class="rounded me-2 card-img" src="${company.getAccount().getAccImg()}" alt="">
                                        </div>

                                        <div class="bog_item-content text-center">
                                            <p class="card-title ">${company.getCom_name()}</p>                           
                                        </div>
                                    </div>
                                </div>
                            </div>         
                        </c:forEach>                
                    </div>
                </div>
            </div>
        </section>

        <!--banner ad-->
        <section class="ads">
            <img src="images/carousel3.png" alt="banner ads">
        </section>

        <!--top outstanding-->
        <section class="outstading container-custom">
            <div class="outstading-wrapper">
                <h3>Top Outstanding Profession</h3>
                <div class="outstading-wrapper_list">
                    <div class="row">               
                        <c:forEach var="sector" items="${requestScope.listSector}" >
                            <div class="col-sm-6 col-md-3 card-wrapper mb-3">
                                <div class="card outstading-wrapper_list_item">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-center">
                                            <img width="70px" src="images/kinh-doanh-ban-hang.webp" alt="bussiness">
                                        </div>
                                        <div class="outstading-wrapper_list_item_content text-center">
                                            <p class="card-title ">${sector.getSector()}</p>
                                            <span class="card-text ">Number of jobs: ${sector.getQuantity()}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>                                 
                        </c:forEach>
                    </div>              
                </div>        
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
        const listProfile = document.querySelector('.profileList')
        const iconProfile = document.querySelector('.navbar-nav li:last-child a')

        iconProfile.addEventListener('click', () => {
            listProfile.classList.toggle('hide')
        })
        // category list
const listCategory = document.querySelector('#category')
const filterCategory = document.querySelector('.filter-category-wrapper')
const ul = document.querySelector('.filter-category')


const sectorList = document.querySelectorAll('.sector');
let sectorArr = [];
sectorList.forEach(sector => {
    let OjbAdd = {};
    let childE = sector.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    sectorArr.push(OjbAdd);
})


const cityList = document.querySelectorAll('.cityObj');
let cityArr = [];
cityList.forEach(city => {
    let OjbAdd = {};
    let childE = city.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    cityArr.push(OjbAdd);
})


const timeList = document.querySelectorAll('.workingHours');
let timeArr = [];
timeList.forEach(time => {
    let OjbAdd = {};
    let childE = time.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    timeArr.push(OjbAdd);
})

let salaryArr = ["Ít hơn 5tr", "5tr-10tr", "10tr-20tr", "20tr-30tr", "Lớn hơn 30tr"];

let accountBlog = [];
const account = document.querySelectorAll('.account');
account.forEach(account => {
    let ObjAdd = {}
    let childE = account.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        ObjAdd[className] = content;
    }
    accountBlog.push(ObjAdd);
}
)

function innitListCategoryRight() {
//    cityArr.map(city => {
//        ul.innerHTML += `<li class="filter-category_item"><a style="text-decoration: none;" href="viewpostcontroller?key=${city.cityObj_name}&a_id=${accountBlog[0].account_id}&code=city">${city.cityObj_name}</a></li>`
//    })

    /***************************************************************************/
    const tabBox = document.querySelector('.filter-category')
    const allTabs = document.querySelectorAll('.filter-category_item')
    const arrowIcon = document.querySelectorAll('.filter-category-wrapper button')
    const idBtn = 'leftBtnFilter'
    const activeClass = '.filter-category_item.active'
    // handle scroll x
    scrollX(arrowIcon, tabBox, idBtn)
    // handle choose item
    activeElement(allTabs, activeClass)
}

innitListCategoryRight()

listCategory.addEventListener('change', () => {
    ul.innerHTML = ""
    switch (listCategory.value) {
        case "sector":
            sectorArr.map(sector => {
ul.innerHTML += `<li class="filter-category_item"><a style="text-decoration: none;" href="viewpostcontroller?key=${sector.sector_name}&a_id=${accountBlog[0].account_id}&code=sector">${sector.sector_name}</a></li>`
            })
            break;
        case "area":
            cityArr.map(city => {
                ul.innerHTML += `<li class="filter-category_item"><a style="text-decoration: none;" href="viewpostcontroller?key=${city.cityObj_name}&a_id=${accountBlog[0].account_id}&code=city">${city.cityObj_name}</a></li>`
            })
            break;
        case "time":
            timeArr.map(time => {
                ul.innerHTML += `<li class="filter-category_item"><a style="text-decoration: none;" href="viewpostcontroller?key=${time.workingHours_name}&a_id=${accountBlog[0].account_id}&code=wh">${time.workingHours_name}</a></li>`
            })
            break;
        case "salary":
            salaryArr.map(salary => {
                ul.innerHTML += `<li class="filter-category_item"><a style="text-decoration: none;" href="viewpostcontroller?key=${salary}&a_id=${accountBlog[0].account_id}&code=salary">${salary}</a></li>`
            })
            break;
    }

    /***************************************************************************/
    const tabBox = document.querySelector('.filter-category')
    const allTabs = document.querySelectorAll('.filter-category_item')
    const arrowIcon = document.querySelectorAll('.filter-category-wrapper button')
    const idBtn = 'leftBtnFilter'
    const activeClass = '.filter-category_item.active'
    // handle scroll x
    scrollX(arrowIcon, tabBox, idBtn)
    // handle choose item
    activeElement(allTabs, activeClass)
})


// top of the company scroll
const blog_list = document.querySelector('.comp-list_card')
const BtnComp = document.querySelectorAll('.comp-btn button')
const idBtn = 'leftBtnComp'

scrollX(BtnComp, blog_list, idBtn)

//const itemBlog = [];

export var itemBlog = [];
const data = document.querySelectorAll('.data');
data.forEach(dataE => {
    let OjbAdd = {};
    let childE = dataE.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    itemBlog.push(OjbAdd);
})
//console.log(itemBlog)

let empBlog = [];
const empDatas = document.querySelectorAll('.emp');
empDatas.forEach(empData => {
    let ObjAdd = {}
    let childE = empData.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        ObjAdd[className] = content;
    }
    empBlog.push(ObjAdd);
}
)



let comBlog = [];
const comDatas = document.querySelectorAll('.com');
comDatas.forEach(comData => {
    let ObjAdd = {}
    let childE = comData.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
let content = childE[i].textContent;
        ObjAdd[className] = content;
    }
    comBlog.push(ObjAdd);
}
)

console.log(comBlog);

//console.log(comBlog[0].com_img)

for (let i = 0; i < itemBlog.length; i++) {
    for (let j = 0; j < empBlog.length; j++) {
        if (empBlog[j].emp_id === itemBlog[i].emp_id) {
            itemBlog[i].emp_id = empBlog[j].emp_name;
            itemBlog[i].emp_img = empBlog[j].emp_img;
        }
    }
}

for (let i = 0; i < itemBlog.length; i++) {
    for (let j = 0; j < comBlog.length; j++) {
        if (comBlog[j].com_id === itemBlog[i].emp_id) {
            itemBlog[i].emp_id = comBlog[j].com_name;
            itemBlog[i].emp_img = comBlog[j].com_img;
        }
    }
}

const pagiControl = document.querySelectorAll('.pagi-control button')
const postList = document.querySelector('.post_list')
const btnLeftPagination = document.querySelector('#btnLeftPagination')
const btnRightPagination = document.querySelector('#btnRightPagination')
const currentPageTag = document.querySelector('#currentPageTag')
const totalPageTag = document.querySelector('#totalPage')

let curentPage = 1;
let itemPerPage = 6;
let totalPage = parseInt(itemBlog.length / itemPerPage);
if ((itemBlog.length % itemPerPage) > 0) {
    totalPage++;
}
let start = 0;
let end = 0;

currentPageTag.innerText = curentPage

pagination(0, 6)
totalPageTag.innerText = totalPage

//console.log(totalPage)

if (curentPage == 1) {
    btnLeftPagination.classList.add('disabled');
}

pagiControl.forEach((btn) => {
    const btnPagination = btn.addEventListener('click', () => {
        switch (btn.id) {
            case 'btnLeftPagination':
                if (curentPage <= totalPage && curentPage > 1) {
                    curentPage--
                    console.log(curentPage)
                    start = (curentPage - 1) * itemPerPage;
                    end = curentPage * itemPerPage;
                    pagination(start, end)
                    btnRightPagination.classList.remove('disabled');
                }
                currentPageTag.innerText = curentPage
                break;
            case 'btnRightPagination':
                if (curentPage > 0 && curentPage < totalPage) {
                    btnLeftPagination.classList.remove('disabled');
                    currentPageTag.innerText = ++curentPage
                    start = (curentPage - 1) * itemPerPage;
                    end = curentPage * itemPerPage;
                    pagination(start, end)
                }
                break;
        }
        if (curentPage == 1) {
            btnLeftPagination.classList.add('disabled');
        }
        if (curentPage == totalPage) {
            btnRightPagination.classList.add('disabled');
        }
        currentPageTag.innerText = curentPage
    })




})

function pagination(start, end) {
    postList.innerHTML = ""
    for (let index = start; index < end; index++) {
        let arr1 = itemBlog[index];
postList.innerHTML += `                                
                                <div class="col-12 col-sm-6 mb-3 col-md-4 blog-wrap_item blog-wrap_item-hover">
                                    <div class="blog_item card">
                                        <a style="text-decoration: none;" 
                                            href="ViewPostDetailController?postD_id=${itemBlog[index].postD_id}&post_id=${itemBlog[index].post_id}&a_id=${accountBlog[0].account_id}">
                                            <div class="card-body d-flex">
                                                <div class="imageWrapper">
                                                    <img style="width: 100%; height: 100%; object-fit: contain; object-position: center;" class="rounded-circle me-2" src="${itemBlog[index].emp_img}" alt="">
                                                </div>
                                                <div class="bog_item-content">
                                                    <p style="color: black;" class="card-title">${itemBlog[index].job_name}</p>
                                                    <p style="color: black;" class="card-text">${itemBlog[index].emp_id}</p>          
                                                </div>
                                            </div>        
                                            <div class="cardFooter">
                                                <span class="cardCity">${itemBlog[index].city}</span>
                                                <span class="cardSalary">${itemBlog[index].salary}</span>
                                            </div>
                                        </a>                                                                                                          
                                </div>
                                `
    }
}

/** search filter____________________________________________________________________________________________________________________________ */
/**form input 1*/
const formFilterInputRight1 = document.querySelector('.formFilterInputRight1')
const formFilterInputList1 = document.querySelector('.formFilterInputList1')
const formFilterInputIcon1 = document.querySelector('.formFilterInput1 i:last-child')
const formFilterContent1 = document.querySelector('.formFilterInput1 p')
const formFilterInputItem1 = document.querySelectorAll('.formFilterInputItem1')
/**form input 2*/
const formFilterInputRight2 = document.querySelector('.formFilterInputRight2')
const formFilterInputList2 = document.querySelector('.formFilterInputList2')
const formFilterInputIcon2 = document.querySelector('.formFilterInput2 i:last-child')
const formFilterContent2 = document.querySelector('.formFilterInput2 p')
const formFilterInputItem2 = document.querySelectorAll('.formFilterInputItem2')
/**form input 3*/
const formFilterInputRight3 = document.querySelector('.formFilterInputRight3')
const formFilterInputList3 = document.querySelector('.formFilterInputList3')
const formFilterInputIcon3 = document.querySelector('.formFilterInput3 i:last-child')
const formFilterContent3 = document.querySelector('.formFilterInput3 p')
const formFilterInputItem3 = document.querySelectorAll('.formFilterInputItem3')

const overlay = document.querySelector('.overlay')
let beforeId = 0

formFilterInputRight1.addEventListener('click', () => {
    formFilterInputList1.classList.toggle('hide')
    toggleDownUpIcon(formFilterInputIcon1)
    addDownIcon(formFilterInputIcon2)
    addDownIcon(formFilterInputIcon3)
    // id trc do??
    switch (beforeId) {
        case 2:
            formFilterInputList2.classList.add('hide')
            addDownIcon(formFilterInputIcon2)
            break;
        case 3:
            formFilterInputList3.classList.add('hide')
            addDownIcon(formFilterInputIcon3)
            break;
    }
    // comment
    // overlay beforeid == currentid
    beforeId === 1 ? overlay.classList.toggle('hide') : overlay.classList.remove('hide');
    beforeId = 1
})
formFilterInputRight2.addEventListener('click', () => {
    formFilterInputList2.classList.toggle('hide')
    toggleDownUpIcon(formFilterInputIcon2)
    addDownIcon(formFilterInputIcon1)
    addDownIcon(formFilterInputIcon3)
    // id trc do??
    switch (beforeId) {
        case 1:
            formFilterInputList1.classList.add('hide')
            addDownIcon(formFilterInputIcon1)
            break;
        case 3:
            formFilterInputList3.classList.add('hide')
            addDownIcon(formFilterInputIcon3)
            break;
    }
    // overlay beforeid == currentid
    beforeId === 2 ? overlay.classList.toggle('hide') : overlay.classList.remove('hide');
    beforeId = 2
})
formFilterInputRight3.addEventListener('click', () => {
    formFilterInputList3.classList.toggle('hide')
    toggleDownUpIcon(formFilterInputIcon3)
    addDownIcon(formFilterInputIcon1)
    addDownIcon(formFilterInputIcon2)
    // id trc do??
    switch (beforeId) {
        case 1:
            formFilterInputList1.classList.add('hide')
            addDownIcon(formFilterInputIcon1)
            break;
        case 2:
            formFilterInputList2.classList.add('hide')
            addDownIcon(formFilterInputIcon2)
            break;
    }
    // overlay beforeid == currentid
    beforeId === 3 ? overlay.classList.toggle('hide') : overlay.classList.remove('hide');
    beforeId = 3
})

// Overlay ..............
overlay.addEventListener('click', () => {
    switch (beforeId) {
        case 1:
            formFilterInputList1.classList.add('hide')
            addDownIcon(formFilterInputIcon1)
            break;
        case 2:
            formFilterInputList2.classList.add('hide')
            addDownIcon(formFilterInputIcon2)
            break;
        case 3:
            formFilterInputList3.classList.add('hide')
            addDownIcon(formFilterInputIcon3)
            break;
    }
overlay.classList.add('hide')
})

// Overlay end ..........

formFilterInputItem1.forEach(item => {
    item.addEventListener('click', () => {
        formFilterContent1.innerHTML = item.innerHTML
    })
})
formFilterInputItem2.forEach(item => {
    item.addEventListener('click', () => {
        formFilterContent2.innerHTML = item.innerHTML
    })
})
formFilterInputItem3.forEach(item => {
    item.addEventListener('click', () => {
        formFilterContent3.innerHTML = item.innerHTML
    })
})


function addDownIcon(formFilterInputIcon) {
    formFilterInputIcon.classList.forEach(item => {
        if (item === 'bx-chevron-up') {
            formFilterInputIcon.classList.remove('bx-chevron-up')
            formFilterInputIcon.classList.add('bx-chevron-down')
        }
    })
}
function toggleDownUpIcon(formFilterInputIcon) {
    formFilterInputIcon.classList.forEach(item => {
        if (item === 'bx-chevron-down') {
            formFilterInputIcon.classList.remove('bx-chevron-down')
            formFilterInputIcon.classList.add('bx-chevron-up')
        } else if (item === 'bx-chevron-up') {
            formFilterInputIcon.classList.remove('bx-chevron-up')
            formFilterInputIcon.classList.add('bx-chevron-down')
        }
    })
}

//the common function
function scrollX(arrowIcon, tabBox, idBtn) {
    arrowIcon.forEach(btnIcon => {
        btnIcon.addEventListener('click', () => {
            tabBox.scrollLeft += btnIcon.id === idBtn ?
                    -232.8 : 232.8;
        })
    })
}

function activeElement(allTabs, activeClass) {
    allTabs.forEach(item => {
        item.addEventListener('click', (e) => {
            let itemActive = document.querySelector(activeClass)
            itemActive !== null ? itemActive.classList.remove('active') :
                    itemActive
            e.target.classList.add('active')
        });
    })
}
    </script>

    <script type="module" src="js/map2.js"></script>
    <script type="text/javascript" src="js/Search.js"></script>
    <script src="./Tool/js_bootstrap.bundle.min.js"></script>
</html>
