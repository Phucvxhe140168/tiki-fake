<%-- 
    Document   : Product
    Created on : Jun 30, 2021, 9:04:36 AM
    Author     : Vu X Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TIKI</title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <!-- SECTION -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <div id="mess"> </div>
                    <!-- row -->
                    <h3 class="product-name"><a href="homeControl">Back To Home</a></h3>
                    <div class="row">
                        <!-- Product main img -->

                        <div class="col-md-5 col-md-push-2">

                            <div id="product-main-img">
                                <div class="product-preview">
                                    <img src="./img/${detail.image}" alt="">
                            </div>
                        </div>
                    </div>
                    <!-- /Product main img -->

                    <!-- Product thumb imgs -->
                    <div class="col-md-2  col-md-pull-5">
                        <div id="product-imgs">
                            <div class="product-preview">
                            </div>
                        </div>
                    </div>
                    <!-- /Product thumb imgs -->

                    <!-- Product details -->
                    <div class="col-md-5">
                        <div class="product-details">
                            <h2 class="product-name">${detail.name}</h2>

                            <div>
                                <h3 class="product-price">${detail.price} $</h3>
                            </div>
                            <div class="add-to-cart">
                                <br> <br>
                                <button id="${detail.getId()}" onclick="Addproduct(this.id)"  class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                            <ul class="product-links">
                                <li>Category:</li>
                                <li><a href="Category?Cid=${cate.caid}" >${cate.cname}</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- /Product details -->

                    <!-- Product tab -->
                    <div class="col-md-12">
                        <div id="product-tab">
                            <!-- product tab nav -->
                            <ul class="tab-nav">
                                <li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
                            </ul>
                            <!-- /product tab nav -->

                            <!-- product tab content -->
                            <div class="tab-content">
                                <!-- tab1  -->
                                <div id="tab1" class="tab-pane fade in active">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <p> ${detail.decription}</p>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <!-- /product tab content  -->
                        </div>
                    </div>
                    <!-- /product tab -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- Section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                    <div class="col-md-12">
                        <div class="section-title text-center">
                            <h3 class="title">TOP SELLING ON: ${cate.cname}</h3>
                        </div>
                    </div>

                    <!-- product -->
                    <c:forEach items="${listP}" var="o">
                        <!-- product -->
                        <div class="col-md-3 col-xs-6 ">
                            <div class="product">
                                <div class="product-img">
                                    <img src="./img/${o.image}" alt="" style="width:270px;height:380px;">
                                </div>
                                <div class="product-body">
                                    <h3 class="product-name"><a href="detail?pid=${o.getId()}&Category=${o.getCaID()}">${o.name} </a></h3>
                                    <h3 class="product-price">${o.price} $</h3>
                                </div>
                                <div class="add-to-cart">
                                    <button id="${o.getId()}" onclick="Addproduct(this.id)"  class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                </div>
                            </div>
                        </div>
                        <!-- /product -->
                    </c:forEach>
                    <!-- /product -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /Section -->

        <jsp:include page="Footer.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
                            
                            function Addproduct(id) {
                                var Productid = id;
                                $.ajax({
                                    url: "/Tiki-fake/AddbuyProductHome",
                                    type: "Post",
                                    data: {
                                        pid: Productid
                                    },
                                    success: function (data) {
                                        var row = document.getElementById("mess");
                                        row.innerHTML = data;
                                    },
                                    error: function (er) {

                                    }
                                });
                            }
        </script>
        <!-- jQuery Plugins -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>

