<%-- 
    Document   : index
    Created on : Mar 1, 2022, 11:21:48 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http–equiv=“Content-Type” content=“text/html; charset=UTF-8”>
              <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trang chủ</title>

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/bootstrap.css">

        <link rel="stylesheet" href="assets/vendors/iconly/bold.css">

        <link rel="stylesheet" href="assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
        <link rel="stylesheet" href="assets/vendors/bootstrap-icons/bootstrap-icons.css">
        <link rel="stylesheet" href="assets/css/app.css">
        <link rel="shortcut icon" href="assets/images/favicon.svg" type="image/x-icon">
    </head>

    <body>
        <div id="app">
            <div id="sidebar" class="active">
                <div class="sidebar-wrapper active">
                    <div class="sidebar-header">
                        <div class="d-flex justify-content-between">
                            <div class="logo">
                                <a href="home"><img style="width: 210px;height: 175px" src="assets/images/logo/STUDENT.png" alt="Logo"></a>
                            </div>
                            <div class="toggler">
                                <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="sidebar-menu">
                        <ul class="menu">
                            <li class="sidebar-item">
                                <a href="home" class='sidebar-link'>
                                    <i class="bi bi-grid-fill"></i>
                                    <span>Trang chủ</span>
                                </a>
                            </li>

                            <li class="sidebar-item">
                                <a href="khoa?kindex=1" class='sidebar-link'>
                                    <i class="bi bi-stack"></i>
                                    <span>Khoa</span>
                                </a>

                            </li>

                            <li class="sidebar-item">
                                <a href="monhoc?mindex=1" class='sidebar-link'>
                                    <i class="bi bi-collection-fill"></i>
                                    <span>Môn học</span>
                                </a>
                            </li>

                            <li class="sidebar-item">
                                <a href="lop?lindex=1" class='sidebar-link'>
                                    <i class="bi bi-grid-1x2-fill"></i>
                                    <span>Lớp</span>
                                </a>
                            </li>

                            <li class="sidebar-item  has-sub">
                                <a href="#" class='sidebar-link'>
                                    <i class="bi bi-hexagon-fill"></i>
                                    <span>Sinh viên</span>
                                </a>
                                <ul class="submenu ">
                                    <li class="submenu-item ">
                                        <a href="sinhvien?index=1">Danh sách sinh viên</a>
                                    </li>
                                    <li class="submenu-item ">
                                        <a href="diem?dindex=1">Điểm</a>
                                    </li>
                                </ul>
                            </li>
                            <c:if test="${sessionScope.acc.role eq 'ADMIN' && sessionScope.acc != null}">
                                <li class="sidebar-item">
                                        <a href="account" class='sidebar-link'>
                                            <span>Account</span>
                                        </a>
                                    </li>
                            </c:if>

                            <c:choose>
                                <c:when test="${sessionScope.acc != null}">
                                    <li class="sidebar-item">
                                        <a href="logout" class='sidebar-link'>
                                            <span>Log out</span>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="sidebar-item">
                                        <a href="login" class='sidebar-link'>
                                            <span>Login</span>
                                        </a>
                                    </li>
                                    <li class="sidebar-item">
                                        <a href="logout" class='sidebar-link'>
                                            <span>Log out</span>
                                        </a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                            <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
                        </ul>
                    </div>
                </div>
                <div id="main">
                    <header class="mb-3">
                        <a href="#" class="burger-btn d-block d-xl-none">
                            <i class="bi bi-justify fs-3"></i>
                        </a>
                    </header>

                    <div class="page-heading">
                        <h3>QUẢN LÝ SINH VIÊN</h3>
                        <!--<p style="float:right;"><a style="font-size: 50px;font-weight: 20px">Login</a><a>Log out</a></p>-->
                    </div>
                    <div class="page-content">
                        <section class="row">
                            <div class="col-12 col-lg-9">
                                <div class="row">
                                    <div class="col-6 col-lg-3 col-md-6">
                                        <div class="card">
                                            <div class="card-body px-3 py-4-5">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="stats-icon purple">
                                                            <i class="iconly-boldShow"></i>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <h6 class="text-muted font-semibold">Khoa</h6>
                                                        <h6 class="font-extrabold mb-0">${countKhoa}.000</h6>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-6 col-lg-3 col-md-6">
                                        <div class="card">
                                            <div class="card-body px-3 py-4-5">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="stats-icon blue">
                                                            <i class="iconly-boldProfile"></i>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <h6 class="text-muted font-semibold">Môn học</h6>
                                                        <h6 class="font-extrabold mb-0">${countMonHoc}.000</h6>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-6 col-lg-3 col-md-6">
                                        <div class="card">
                                            <div class="card-body px-3 py-4-5">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="stats-icon green">
                                                            <i class="iconly-boldAdd-User"></i>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <h6 class="text-muted font-semibold">Sinh Viên</h6>
                                                        <h6 class="font-extrabold mb-0">${countSinhVien}.000</h6>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-6 col-lg-3 col-md-6">
                                        <div class="card">
                                            <div class="card-body px-3 py-4-5">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="stats-icon red">
                                                            <i class="iconly-boldBookmark"></i>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <h6 class="text-muted font-semibold">Lớp</h6>
                                                        <h6 class="font-extrabold mb-0">${countLop}.000</h6>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-12">
                                        <div class="card">
                                            <div class="card-header">
                                                <h4>Biểu đồ cột</h4>
                                            </div>
                                            <div class="card-body">
                                                <div id="chart-profile-visit"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3">
                                <div class="card">
                                    <div class="card-body py-4 px-5">
                                        <div class="d-flex align-items-center">
                                            <div class="avatar avatar-xl">
                                                <img src="assets/images/faces/3.jpg">
                                            </div>
                                            <div class="ms-3 name">
                                                <c:choose>
                                                    <c:when test="${sessionScope.acc != null}">
                                                        <h5 class="font-bold">${sessionScope.acc.displayname}</h5>
                                                    </c:when>
                                                    <c:otherwise>
                                                        Welcome
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="card-header">
                                        <h4>Other users</h4>
                                    </div>

                                    <div class="card-content pb-4">
                                        <c:forEach items="${listAcc}" var="i">
                                            <div class="recent-message d-flex px-4 py-3">
                                                <div class="avatar avatar-lg">
                                                    <img src="assets/images/faces/1.jpg">
                                                </div>
                                                <div class="name ms-4">
                                                    <h5 class="mb-1">${i.displayname}</h5>
                                                    <h6 class="text-muted mb-0">${i.email}</h6>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>

                    <footer>
                        <div class="footer clearfix mb-0 text-muted">
                            <div class="float-start">
                                <p>14/3/2022 &copy; Quản lý sinh viên</p>
                            </div>
                            <div class="float-end">
                                <p>Created with <span class="text-danger"><i class="bi bi-heart"></i></span> by <a
                                        href="http://ahmadsaugi.com">Duy Nguyễn</a></p>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>
            <script src="assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
            <script src="assets/js/bootstrap.bundle.min.js"></script>

            <script src="assets/vendors/apexcharts/apexcharts.js"></script>
            <script src="assets/js/pages/dashboard.js"></script>

            <script src="assets/js/mazer.js"></script>
    </body>

</html>
