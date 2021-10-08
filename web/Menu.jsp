<%-- 
    Document   : Menu
    Created on : Jul 1, 2021, 11:17:12 AM
    Author     : Vu X Phuc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <!-- HEADER -->
        <header>
            <!-- TOP HEADER -->
            <div id="top-header">
                <div class="container">
                    <ul class="header-links pull-left">
                        <li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
                        <li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
                        <li><a href="#"><i class="fa fa-map-marker"></i> 146 Trần Duy Hưng</a></li>
                    </ul>
                    <ul class="header-links pull-right">
                        <c:if test="${sessionScope.acc == null}">
                        <li><a href="Login.jsp"><i class="fa fa-user-o"></i> Login</a></li>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                        <li><a href="homeControl"><i class="fa fa-user-o"></i>${sessionScope.acc.cUserName}</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
            <!-- /TOP HEADER -->

            <!-- MAIN HEADER -->
            <div id="header">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- LOGO -->
                        <div class="col-md-3">
                            <div class="header-logo">
                                <a href="homeControl" class="logo">
                                    <img src="./img/logo.png" alt="" width="100">
                                </a>
                            </div>
                        </div>
                        <!-- /LOGO -->

                        <!-- SEARCH BAR -->
                        <div class="col-md-6">
                            <div class="header-search">
                                <form action="search" method="post">
                                    <input class="input" type="txt" placeholder="Search here" name="txtSearch" value="${txtSea}">
                                    <button type="submit" class="search-btn">Search</button>
                                </form>
                            </div>
                        </div>
                        <!-- /SEARCH BAR -->

                        <!-- ACCOUNT -->
                        <div class="col-md-3 clearfix">
                            <div class="header-ctn">

                                <!-- Cart -->
                                <div class="dropdown">
                                    <a  class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                        <a href="ShowCart">
                                        <i class="fa fa-shopping-cart"></i>
                                        <span>Your Cart</span>
                                        <div class="qty">3</div>
                                        </a>
                                    </a>
                                    
                                </div>
                                <!-- /Cart -->

                                <!-- Menu Toogle -->
                                <div class="menu-toggle">
                                    <a href="#">
                                        <i class="fa fa-bars"></i>
                                        <span>Menu</span>
                                    </a>
                                </div>
                                <!-- /Menu Toogle -->
                            </div>
                        </div>
                        <!-- /ACCOUNT -->
                    </div>
                    <!-- row -->
                </div>
                <!-- container -->
            </div>
            <!-- /MAIN HEADER -->
        </header>
        <!-- /HEADER -->
