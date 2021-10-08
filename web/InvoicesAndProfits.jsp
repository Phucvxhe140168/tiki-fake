<%-- 
    Document   : InvoicesAndProfits
    Created on : Jul 7, 2021, 4:32:13 PM
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
            <a href="homeControl"  style=" margin-top: 2px;margin-left: 18px" class="btn btn-info" <span>Back To Home</span></a>
            <div class="main-body">
                <div class="row gutters-sm">
                    <div class="col-md-4 mb-3">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex flex-column align-items-center text-center">
                                    <div class="mt-3">
                                        <h4>ADMIN</h4>
                                        <br> <br>
                                        <form action="forgot?user=admin" method="post">
                                            <button class="btn btn-outline-primary">Change your PassWord</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-column align-items-center text-center">
                            <div class="card mt-3">
                                <div class="row">
                                    <br> 
                                    <div class="col-sm-6">
                                        <h6 class="mb-0">Total money in the system</h6>
                                    </div>
                                    <div class="col-sm-6 text-secondary">
                                        $ ${money}
                                    </div>
                                </div>
                                <div class="row">
                                    <br> 
                                    <div class="col-sm-6">
                                        <h6 class="mb-0">Total invoice amount: </h6>
                                    </div>
                                    <div class="col-sm-6 text-secondary">
                                        ${Bill}
                                    </div>
                                </div>
                                <div class="row">
                                    <br> 
                                    <div class="col-sm-6">
                                        <h6 class="mb-0">Tax to be paid: </h6>
                                    </div>
                                    <div class="col-sm-6 text-secondary">
                                        $ ${tax}
                                    </div>
                                </div>
                                <div class="row">
                                    <br> 
                                    <div class="col-sm-6">
                                        <h6 class="mb-0">total profit: </h6>
                                    </div>
                                    <div class="col-sm-6 text-secondary">
                                        $ ${profit}
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
                        <div class="row gutters-sm">
                            <div class="col-sm-12 mb-3">
                                <table class="table table-striped table-hover">
                                    <tr>
                                        <th>Date Create Bill</th>
                                        <th>Buyer Name</th>
                                        <th>Buyer Phone</th>
                                        <th>Buyer Address</th>
                                        <th>Total</th>
                                        <th></th>
                                    </tr>
                                    <c:forEach items="${listB}" var="o">
                                        <tr>
                                            <td>${o.getDatecreate()}</td>
                                            <td>${o.getBuyName()}</td>
                                            <td>${o.getBuyPhone()}</td>
                                            <td>${o.getBuyAdderss()}</td>
                                            <td>${o.getTotal()}</td>
                                            <td>
                                                <div class="col-sm-6 co">
                                                    <a id="${o.getBid()}" onclick="ViewBillDetail(this.id)" href="#addEmployeeModal" class="btn btn-info" data-toggle="modal"><i class="material-icons"></i> <span>View detail</span></a>					
                                                </div>
                                            </td>
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
                                <div id="upload"> </div>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <jsp:include page="Footer.jsp"></jsp:include>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
                                                        function ViewBillDetail(id) {
                                                            var BillDetailId = id;
                                                            $.ajax({
                                                                url: "/Tiki-fake/viewBillDetail",
                                                                type: "Post",
                                                                data: {
                                                                    bid: BillDetailId
                                                                },
                                                                success: function (data) {
                                                                    var row = document.getElementById("upload");
                                                                    row.innerHTML = data;
                                                                },
                                                                error: function (er) {

                                                                }});

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