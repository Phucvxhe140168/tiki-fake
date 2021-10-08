<%-- 
    Document   : CheckOut
    Created on : Jun 30, 2021, 9:02:56 AM
    Author     : Vu X Phuc
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TIKI</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
        <title>Forgot Password</title>
        <style>
            .forgot-form {            
                width: 340px;
                margin: 50px auto;
            }
            .forgot-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .forgot-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 15px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
            }
            body{
                background-color: black;
            }
        </style>
    </head>
    <body>
        <div class="forgot-form">
            <form action="forgot" method="post">
                <h2 class="text-center">Find your Account</h2>       
                <h2 style="color:red;text-align:center">${requestScope.error}</h2>
                ${mess}
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Username" required="required" name="user">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Find</button>
                </div>     
                <p class="text-center"><a href="Register.jsp">Create an Account</a></p>
                <p class="text-center"><a href="Login.jsp">Login</a></p>
            </form>
        </div>
    </body>
</html>
