<%-- 
    Document   : Footer
    Created on : Jul 1, 2021, 11:22:40 AM
    Author     : Vu X Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- FOOTER -->
<footer id="footer">
    <!-- top footer -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-4 col-xs-12">
                    <div class="footer">
                        <h3 class="footer-title">About Us</h3>
                        <p>Provide users with the best quality made in China products</p>
                        <ul class="footer-links">
                            <li><a href="#"><i class="fa fa-map-marker"></i>146 Trần Duy Hưng</a></li>
                            <li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
                            <li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>
                        </ul>
                    </div>
                </div>


                <div class="clearfix visible-xs"></div>

                <div class="col-md-4 col-xs-12">
                    <div class="footer">
                        <h3 class="footer-title">Information</h3>
                        <ul class="footer-links">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Orders and Returns</a></li>
                            <li><a href="#">Terms & Conditions</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-4 col-xs-12">
                    <div class="footer">
                        <h3 class="footer-title">Service</h3>
                        <ul class="footer-links">
                            <c:if test="${sessionScope.acc.getCid() > 0}">  
                                <li><a href="manageProduct">Manager Product</a></li>
                                <li><a href="Customer">My Account</a></li>
                                <li><a href="logout">Logout</a></li>
                                </c:if>
                                <c:if test="${sessionScope.acc.getCid() == 0}">  
                                <li><a href="manageCustomer">Manager Account</a></li>
                                <li><a href="InvoicesAndProfits">Invoices and Profits</a></li>
                                <li><a href="logout">Logout</a></li>
                                </c:if>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /top footer -->

    <!-- bottom footer -->
    <div id="bottom-footer" class="section">
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-12 text-center">
                    <ul class="footer-payments">
                        <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                        <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                    </ul>
                    <span class="copyright">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        &copy; <script>document.write(new Date().getFullYear());</script> This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a style="color: #269abc" href="https://www.facebook.com/xuanphuc.vu.0312/" target="_blank">Vũ X Phúc</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </span>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /bottom footer -->
</footer>
<!-- /FOOTER -->
