<%-- 
    Document   : ManageCustomer
    Created on : Jul 3, 2021, 11:41:10 PM
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
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>

            <div class="container">
                <a href="homeControl"  style=" margin-top: 2px" class="btn btn-info" <span>Back To Home</span></a>
                <div class="table-wrapper" style="
                     margin-top: 2px;
                     padding: 20px;
                     border: 1px solid #33ccff;
                     border-radius: 10px;">

                    <div class="table-title">

                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage <b>Customer</b></h2>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>

                                </th>
                                <th>UserName</th>
                                <th>FullName</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Money</th>
                                <th>Delete Customer</th>
                                <th>View Customer</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ListC}" var="o">
                            <tr>
                                <td></td>
                                <td>${o.getcUserName()}</td>
                                <td>${o.getFullName()}</td>
                                <td>${o.getPhone()}</td>
                                <td>${o.getAddress()}</td>
                                <td>$ ${o.getMoney()}</td>
                                <td>
                                    <a href="DeleteCustomer?Cid=${o.getCid()}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                                <td>
                                    <a href="CustomerById?Cid=${o.getCid()}"  style=" margin-top: 2px" class="btn btn-info" <span>View</span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
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