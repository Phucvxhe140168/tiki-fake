<%-- 
    Document   : CheckOut
    Created on : Jun 30, 2021, 9:02:56 AM
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

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>

            <!-- SECTION -->
            <form action="DoneBill" method="post">
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-7">
                            <!-- Billing Details -->
                            <div class="billing-details">
                                <div class="section-title">
                                    
                                    <h3 class="title">Billing address</h3>
                                </div>
                                <div class="form-group">
                                    <h5 class="title">Number Bill:</h5>
                                </div>
                                <div class="form-group">
                                    <input class="input" type="text" name="billid" readonly value="${billid}">
                            </div>
                            <div class="form-group">
                                <h5 class="title">Full Name:</h5>
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="name" placeholder="Pleace Enter Your Full Name" value="${Name}">
                            </div>
                            <div class="form-group">
                                <h5 class="title">Address:</h5>
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="address" placeholder="Pleace Enter Your Address" value="${Add}">
                            </div>
                            <div class="form-group">
                                <h5 class="title">Phone Number:</h5>
                            </div>
                            <div class="form-group">
                                <input class="input" type="tel" name="phone" placeholder="Pleace Enter Your Phone Number" value="${Phone}">
                            </div>
                            <div class="form-group">
                                <h5 class="title">Date Create Bill:</h5>
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="date" readonly value="${date}">
                            </div>
                            ${mess}
                        </div>
                        <!-- /Billing Details -->
                    </div>

                    <!-- Order Details -->
                    <div class="col-md-5 order-details">
                        <div class="section-title text-center">
                            <h3 class="title">Your Order</h3>
                        </div>
                        <div class="order-summary">
                            <div class="order-col">
                                <div><strong>PRODUCT</strong></div>
                                <div><strong>TOTAL</strong></div>
                            </div>
                            <c:forEach items="${list}" var="o">
                                <div class="order-products">
                                    <div class="order-col">
                                        <div>${o.getWillsale()}x ${o.getName()}</div>
                                        <div>${o.getPrice()}</div>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="order-col">
                                <div>Shiping</div>
                                <div><strong>FREE</strong></div>
                            </div>
                            <div class="order-col">
                                <div>VAT</div>
                                <div><strong>${vat}</strong></div>
                            </div>
                            <div class="order-col">
                                <div><strong>TOTAL</strong></div>
                                <div><strong class="order-total">$${sum}</strong></div>
                            </div>
                        </div>
                        <div class="section-title ">
                            <p class="title">Please pay when you receive the goods from the delivery staff</p>
                        </div>
                        <button class="primary-btn order-submit rounded-pill py-3 btn-block">Place order</button>
                        <br> <br>
                    </div>
                    <!-- /Order Details -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
    </form>
        <!-- /SECTION -->

        <jsp:include page="Footer.jsp"></jsp:include>

        <!-- jQuery Plugins -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>

