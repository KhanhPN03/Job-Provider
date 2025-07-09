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
        <%--<%@include file="Header and Footer/PageHeader.jsp" %>--%>
        <div class="container col-lg-4">
            <form action="UploadJobController" method="post">
                <h1 class="brand">Jobs Provider</h1>
                <h2 class="form-name">Job Information</h2>
                <p>Complete all fields to upload your job.</p>

                <c:set var="a_id" value="${requestScope.a_id}"/>
                <input style="display: none;" name="a_id" value="${a_id}"/>      

                <div class="form-control">
                    <input id="password" name="job_name" type="text" placeholder=""/>
                    <label for="input">Job name</label>
                    <small></small>
                    <span></span>
                </div>
                <div class="form-control">
                    <!--<input id="password" name="Sector" type="text" placeholder=""/>-->
                    <select style="height: 32px; width: 100%;" name="Sector" required="">
                        <option value="">Sectors</option>
                        <option value="IT">IT</option>
                        <option value="Dich vu">Dich vu</option>
                        <option value="Logistics">Logistics</option>
                        <option value="Marketing">Marketing</option>
                        <option value="Quản lý chuỗi cung ứng">Quản lý chuỗi cung ứng</option>
                        <option value="Sức khỏe">Sức khỏe</option>
                        <option value="Giảng dạy">Giảng dạy</option>
                        <option value="Kế toán">Kế toán</option>
                    </select>
                    <input class="billing_address_1" type="hidden"/>
                    <span  class="move-label"></span>
                    <label for="input">Sector</label>
                    <small></small>
                    <span></span>
                </div>
                <div class="form-control">
                    <input id="username" name="Salary" type="text" placeholder=""/>
                    <label for="username">Salary</label>
                    <small></small>
                    <span></span>
                </div>
                <div class="form-control">

                    <select style="height: 32px; width: 100%;" name="workingHours" required="">
                        <option  value="">Full-time / Part-time</option>
                        <option  value="Full time">Full time</option>
                        <option  value="Part-time">Part-time</option>
                    </select>
                    <input class="billing_address_1" type="hidden"/>
                    <span  class="move-label"></span>

                    <label for="username">Working hours</label>
                    <small></small>
                    <span></span>
                </div>
                <div class="form-control">
                    <input id="username" name="date_end" type="date" placeholder=""/>
                    <label for="username">Date end</label>
                    <small></small>
                    <span></span>
                </div>
                <div class="form-control">
                    <input id="username" name="email" type="text" placeholder=""/>
                    <label for="username">Email address</label>
                    <small></small>
                    <span></span>
                </div>
                <div class="form-control">
                    <input id="username" name="phone" type="text" placeholder=""/>
                    <label for="username">Phone number</label>
                    <small></small>
                    <span></span>
                </div>
                <div class="form-control">
                    <input id="username" name="address" type="text" placeholder=""/>
                    <label for="username">Address</label>

                    <small></small>
                    <span></span>
                    <span class="move-label"></span>
                </div>
                <div class="form-control">
                    <select style="height: 32px; width: 100%;" name="calc_shipping_provinces" required="">
                        <option style="background-color: transparent;" value="">Tỉnh / Thành phố</option>
                    </select>
                    <input class="billing_address_1" type="hidden"/>
                    <span  class="move-label"></span>
                    <label for="">City</label>
                    <small></small>
                    <span></span>
                </div>
                <div class="form-control">
                    <input id="username" name="number" type="text" placeholder=""/>
                    <label for="username">Number of recruit</label>
                    <small></small>
                    <span></span>
                </div>
                <div class="form-control">
                    <input id="username" name="description" type="text" placeholder=""/>
                    <label for="username">Job Description</label>
                    <small></small>
                    <span></span>
                </div>           


                <div class="form-desciprion my-4">
                    <p class="m-0">Your upload request will be sent to the manager after you submit. The manager can either approve or deny your request.</p>
                </div>

                <button type="submit" class="btn-submit m-0">SUBMIT</button>



            </form>

        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <script src='https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js'></script>

        <script>//<![CDATA[
            if (address_2 = localStorage.getItem('address_2_saved')) {
                $('select[name="calc_shipping_district"] option').each(function () {
                    if ($(this).text() == address_2) {
                        $(this).attr('selected', '')
                    }
                })
                $('input required.billing_address_2').attr('value', address_2)
            }
            if (district = localStorage.getItem('district')) {
                $('select[name="calc_shipping_district"]').html(district)
                $('select[name="calc_shipping_district"]').on('change', function () {
                    var target = $(this).children('option:selected')
                    target.attr('selected', '')
                    $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
                    address_2 = target.text()
                    $('input required.billing_address_2').attr('value', address_2)
                    district = $('select[name="calc_shipping_district"]').html()
                    localStorage.setItem('district', district)
                    localStorage.setItem('address_2_saved', address_2)
                })
            }
            $('select[name="calc_shipping_provinces"]').each(function () {
                var $this = $(this),
                        stc = ''
                c.forEach(function (i, e) {
                    e += 1
                    stc += '<option value="' + (i === "Thành phố Hồ Chí Minh" ? "Hồ Chí Minh" : i) + '">' + i + '</option>'
                    $this.html('<option value="">Tỉnh / Thành phố</option>' + stc)
                    if (address_1 = localStorage.getItem('address_1_saved')) {
                        $('select[name="calc_shipping_provinces"] option').each(function () {
                            if ($(this).text() == address_1) {
                                $(this).attr('selected', '')
                            }
                        })
                        $('input required.billing_address_1').attr('value', address_1)
                    }
                    $this.on('change', function (i) {
                        i = $this.children('option:selected').index() - 1
                        var str = '',
                                r = $this.val()
                        if (r != '') {
                            arr[i].forEach(function (el) {
                                str += '<option value="' + el + '">' + el + '</option>'
                                $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>' + str)
                            })
                            var address_1 = $this.children('option:selected').text()
                            var district = $('select[name="calc_shipping_district"]').html()
                            localStorage.setItem('address_1_saved', address_1)
                            localStorage.setItem('district', district)
                            $('select[name="calc_shipping_district"]').on('change', function () {
                                var target = $(this).children('option:selected')
                                target.attr('selected', '')
                                $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
                                var address_2 = target.text()
                                $('input required.billing_address_2').attr('value', address_2)
                                district = $('select[name="calc_shipping_district"]').html()
                                localStorage.setItem('district', district)
                                localStorage.setItem('address_2_saved', address_2)
                            })
                        } else {
                            $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>')
                            district = $('select[name="calc_shipping_district"]').html()
                            localStorage.setItem('district', district)
                            localStorage.removeItem('address_1_saved', address_1)
                        }
                    })
                })
            })
//]]></script>
            <%--<%@include file="Header and Footer/PageFooter.jsp" %>--%> 
    </body>
    <!--<script src="./js/login.js"></script>-->

</html>