<%-- 
    Document   : ManageCustomer
    Created on : Jul 3, 2021, 5:19:02 PM
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
                                <h2>Manage <b>Product</b></h2>
                            </div>
                            <div class="col-sm-6 co">
                                <a href="#addEmployeeModal" style="margin-left: 380px" class="btn btn-info" data-toggle="modal"><i class="material-icons">&#xE147; </i> <span>Add New Product</span></a>					
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>

                                </th>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Image</th>
                                <th>Price</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listP}" var="o">
                            <tr>
                                <td>

                                </td>
                                <td>${o.id}</td>
                                <td>${o.name}</td>
                                <td>
                                    <img src="./img/${o.image}">
                                </td>
                                <td>${o.price} $</td>
                                <td>
                                    <a href="UploadregisterProduct?pid=${o.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="delete?pid=${o.id}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="add" method="post" enctype="multipart/form-data">
                        <div class="row"
                             style="border: 1px solid #33ccff; border-radius: 10px; width: 100%; margin: 0 auto; padding: 20px;">
                            <div class="col-sm-12">

                                <h2 class="myclass">Add New Product</h2>
                                <div class="form-group">
                                    <label>Product Name</label> 
                                    <input type="text" class="form-control" name="pname" placeholder="Enter Name" >
                                </div>
                                <div class="form-group">
                                    <label>Price</label> 
                                    <input type="text" class="form-control" name="price" placeholder="Enter Price" >
                                </div>
                                <div class="form-group">
                                    <label>Quantity</label> 
                                    <input type="text" class="form-control" name="quantity" placeholder="Enter Quantity" >
                                </div>
                                <div class="form-group">
                                    <label>Description</label> 
                                    <textarea class="form-control" rows="4" name="description" placeholder="Enter Description"></textarea>
                                </div> 
                                <div class="form-group">
                                    <label>Photo</label> 
                                    <input type="file" class="form-control" name="image">
                                </div>
                                <div class="form-group">
                                    <label>Category</label> 
                                    <select name="category" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${listC}" var="o">
                                            <option value="${o.caid}">${o.cname}</option>
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
        </div>
        <!-- Edit Modal HTML -->
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