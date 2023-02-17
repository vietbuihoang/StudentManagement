<%-- 
    Document   : error
    Created on : Mar 14, 2022, 4:01:57 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quản lý sinh viên</title>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/bootstrap.css">
        <link rel="stylesheet" href="assets/vendors/bootstrap-icons/bootstrap-icons.css">
        <link rel="stylesheet" href="assets/css/app.css">
        <link rel="stylesheet" href="assets/css/pages/error.css">
    </head>

    <body>
        <div id="error">


            <div class="error-page container">
                <div class="col-md-8 col-12 offset-md-2">
                    <!-- <img class="img-error" src="assets/images/samples/error-404.png" alt="Not Found"> -->
                    <div class="text-center">
                        <h1 class="error-title text-danger">Warning</h1>
                        <p style="font-size: 30px" role="alert">${error2}</p>
                        <a href="home" class="btn btn-lg btn-outline-primary mt-3">Quay về trang chủ</a>
                    </div>
                </div>
            </div>


        </div>
    </body>

</html>

