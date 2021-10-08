<%-- 
    Document   : RegisterProduct
    Created on : Jul 2, 2021, 3:06:53 PM
    Author     : Vu X Phuc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TIKI</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
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
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="registerProduct" method="post" enctype="multipart/form-data">
                        <div class="row"
                             style=" margin: 0 auto; padding: 20px;">
                            <div class="col-sm-12">

                                <h2 class="myclass">Register Product</h2>
                            <div class="form-group">
                                <label>Product ID</label> 
                                <input type="text" class="form-control" name="pid" placeholder="Enter Name" readonly value="${productbyID.getId()}">
                            </div>
                            <div class="form-group">
                                <label>Product Name</label> 
                                <input type="text" class="form-control" name="pname" placeholder="Enter Name" value="${productbyID.getName()}">
                            </div>
                            <div class="form-group">
                                <label>Price</label> 
                                <input type="text" class="form-control" name="price" placeholder="Enter Price" value="${productbyID.getPrice()}">
                            </div>
                            <div class="form-group">
                                <label>Quantity</label> 
                                <input type="text" class="form-control" name="quantity" placeholder="Enter Quantity" value="${productbyID.getQuantity()}">
                            </div>
                            <div class="form-group">
                                <label>Description</label> 
                                <textarea class="form-control" rows="4" name="description" placeholder="Enter Description">${productbyID.decription}</textarea>
                            </div> 
                            <div class="form-group">
                                <label>Photo</label> 
                                <img style="width: 100%" src="./img/${productbyID.image}">
                                <input type="file" class="form-control" name="image">
                            </div>
                            <div class="form-group">
                                <label>Category</label> 
                                <select name="category" class="form-select" >
                                    <c:forEach items="${listC}" var="o">
                                        <option ${(o.getCaid() == productbyID.getCaID())?"selected":""} value="${o.caid}">${o.cname}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <input type="submit" style=" margin-top: 2px" class="btn btn-info" value="Save" />
                            <a href="manageProduct"  style=" margin-top: 2px" class="btn btn-info" <span>Cancel</span></a>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <jsp:include page="Footer.jsp"></jsp:include>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </body>
</html>
