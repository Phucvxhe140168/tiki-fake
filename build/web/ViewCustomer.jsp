<%-- 
    Document   : ViewCustomer
    Created on : Jul 6, 2021, 12:20:17 AM
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
        <style>
            body{
                margin-top:20px;
                color: #1a202c;
                text-align: left;
                background-color: #e2e8f0;    
            }
            .main-body {
                padding: 15px;
            }
            .card {
                box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
            }

            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid rgba(0,0,0,.125);
                border-radius: .25rem;
            }

            .card-body {
                flex: 1 1 auto;
                min-height: 1px;
                padding: 1rem;
            }

            .gutters-sm {
                margin-right: -8px;
                margin-left: -8px;
            }

            .gutters-sm>.col, .gutters-sm>[class*=col-] {
                padding-right: 8px;
                padding-left: 8px;
            }
            .mb-3, .my-3 {
                margin-bottom: 1rem!important;
            }

            .bg-gray-300 {
                background-color: #e2e8f0;
            }
            .h-100 {
                height: 100%!important;
            }
            .shadow-none {
                box-shadow: none!important;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        ${mess}
            <div class="container">
                <a href="homeControl" ${action}  style=" margin-top: 2px;margin-left: 18px" class="btn btn-info" <span>Back To Home</span></a>
                <div class="main-body">
                    <div class="row gutters-sm">
                        <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex flex-column align-items-center text-center">
                                        <div class="mt-3">
                                            <h4>${name}</h4>
                                        <p class="text-secondary mb-1">Salesman</p>
                                        <form action="forgot?user=${name}" method="post">
                                            <button ${action} class="btn btn-outline-primary">Change your PassWord</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-column align-items-center text-center">
                            <div class="card mt-3">
                                <div class="row">
                                    <br> <br>
                                    <div class="col-sm-6">
                                        <h6 class="mb-0">Amount on the system:</h6>
                                    </div>
                                    <div class="col-sm-6 text-secondary">
                                        $ ${money}
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 ">
                                        <a href="#TakeMoney" ${action} class="btn btn-info" data-toggle="modal"><i class="material-icons"> </i> <span>Withdrawal in the system</span></a>
                                    </div>
                                </div>
                                    <div class="row">
                                    <div class="col-sm-6 " style="margin-left: 200px">
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="card mb-3">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Full Name</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${fullName}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Phone</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${phone}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Address</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${addre}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <a href="#addEmployeeModal" ${action} class="btn btn-info" data-toggle="modal"><i class="material-icons"> </i> <span>Edit</span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row gutters-sm">
                            <div class="col-sm-12 mb-3">
                                <table class="table table-striped table-hover">
                                    <tr>
                                        <th>Name Product</th>
                                        <th>Products sold</th>
                                        <th>Remaining products</th>
                                    </tr>
                                    <c:forEach items="${listP}" var="o">
                                        <tr>
                                            <td>${o.getUsername()}</td>
                                            <td>${o.getQuantitySale()}</td>
                                            <td>${o.getQuantity()}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="ChangeInformation" method="post">
                        <div class="row"
                             style="border: 1px solid #33ccff; border-radius: 10px; width: 100%; margin: 0 auto; padding: 20px;">
                            <div class="col-sm-12">

                                <h2 class="myclass">Edit information</h2>
                                <div class="form-group">
                                    <label>Full Name</label> 
                                    <input type="text" class="form-control" name="fname" value="${fullName}" >
                                </div>
                                <div class="form-group">
                                    <label>Phone</label> 
                                    <input type="tel" class="form-control" name="phone" placeholder="Enter Price" value="${phone}">
                                </div>
                                <div class="form-group">
                                    <label>Address</label> 
                                    <input type="text" class="form-control" name="address" placeholder="Enter Quantity" value="${addre}">
                                </div>
                                <input type="submit" style=" margin-top: 2px" class="btn btn-info" value="Save" />
                                <a href="Customer"  style=" margin-top: 2px" class="btn btn-info" <span>Cancel</span></a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="TakeMoney" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="Withdrawal" method="post">
                        <div class="row"
                             style="border: 1px solid #33ccff; border-radius: 10px; width: 100%; margin: 0 auto; padding: 20px;">
                            <div class="col-sm-12">

                                <h2 class="myclass">Withdrawal</h2>
                                <div class="form-group">
                                    <label>Amount to withdraw</label> 
                                    <input type="num" class="form-control" name="money" placeholder="Enter Number to withdraw">
                                </div>
                                <div class="form-group">
                                    <label>Your bank name</label> 
                                    <input type="num" class="form-control" name="bank" placeholder="Enter Bank name" >
                                </div>
                                <div class="form-group">
                                    <label>Your bank account number</label> 
                                    <input type="num" class="form-control" name="bankNum" placeholder="Enter ank account number" >
                                </div>
                                <input type="submit" style=" margin-top: 2px" class="btn btn-info" value="Save" />
                                <a href="Customer"  style=" margin-top: 2px" class="btn btn-info" <span>Cancel</span></a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
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