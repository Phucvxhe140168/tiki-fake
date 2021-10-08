<%-- 
    Document   : CategoryProduct
    Created on : Jul 3, 2021, 11:08:46 PM
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
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>TIKI</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
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
                    <div class="row">
                        <!-- ASIDE -->
                        <div id="aside" class="col-md-3">
                            <!-- aside Widget -->
                            <div class="aside">
                                <h3 class="aside-title">Categories</h3>
                                <div class="checkbox-filter">
                                    <div class="input-checkbox">
                                        <label for="category-1">
                                            <span></span>
                                            <a href="homeControl">All Category${o.cname} ${tag == o.caid ? "&#10148;":""}</a>
                                    </label>
                                </div>
                                <c:forEach items="${listC}" var="o">
                                    <div class="input-checkbox">
                                        <label for="category-1">
                                            <span></span>
                                            <a href="Category?Cid=${o.caid}">${o.cname} ${tag == o.caid ? "&#10148;":""}</a>
                                        </label>
                                    </div>
                                </c:forEach>

                            </div>
                        </div>
                        <!-- /aside Widget -->

                        <!-- aside Widget -->
                        <div class="aside">
                            <h3 class="aside-title">Top selling</h3>
                            <c:forEach items="${TP}" var="o">
                                <div class="product-widget">
                                    <div class="product-img">
                                        <img src="./img/${o.image}" alt="">
                                    </div>
                                    <div class="product-body">
                                        <h3 class="product-name"><a href="detail?pid=${o.id}&Category=${o.getCaID()}">${o.name}</a></h3>
                                        <h4 class="product-price">${o.price} $</h4>
                                    </div>
                                </div>
                            </c:forEach>


                        </div>
                        <!-- /aside Widget -->
                    </div>
                    <!-- /ASIDE -->

                    <!-- STORE -->
                    <div id="store" class="col-md-9">


                        <!-- store products -->
                        <div id="tailen" class="row">
                            <c:forEach items="${listP}" var="o">
                                <!-- product -->
                                <div class=" col-md-4 col-xs-6 ">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="./img/${o.image}" alt="" style="width:270px;height:380px;">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-name"><a href="detail?pid=${o.getId()}&Category=${o.getCaID()}">${o.name} </a></h3>
                                            <h4 class="product-price">${o.price} $</h4>
                                        </div>
                                        <div class="add-to-cart">
                                                <button id="${o.getId()}" onclick="Addproduct(this.id)"  class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                            </div>
                                    </div>
                                </div>
                                <!-- /product -->
                            </c:forEach>

                        </div>
                        <!-- /store products -->
                    </div>
                    <!-- /STORE -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

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

