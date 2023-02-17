<%-- 
    Document   : Diem_form
    Created on : Mar 3, 2022, 6:26:20 PM
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
        <title>Quản lý điểm</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.4/dist/sweetalert2.min.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/bootstrap.css">

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
                                <a href="#"><img src="assets/images/logo/logo.png" alt="Logo" srcset=""></a>
                            </div>
                            <div class="toggler">
                                <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="sidebar-menu">
                        <ul class="menu">
                            <li class="sidebar-item">
                                <a href="#" class='sidebar-link'>
                                    <i class="bi bi-grid-fill"></i>
                                    <span>Trang chủ</span>
                                </a>
                            </li>

                            <li class="sidebar-item">
                                <a href="#" class='sidebar-link'>
                                    <i class="bi bi-stack"></i>
                                    <span>Khoa</span>
                                </a>

                            </li>

                            <li class="sidebar-item">
                                <a href="#" class='sidebar-link'>
                                    <i class="bi bi-collection-fill"></i>
                                    <span>Môn học</span>
                                </a>
                            </li>

                            <li class="sidebar-item">
                                <a href="#" class='sidebar-link'>
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
                                        <a href="#">Danh sách sinh viên</a>
                                    </li>
                                    <li class="submenu-item ">
                                        <a href="#">Điểm</a>
                                    </li>
                                </ul>
                            </li>

                            <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
                    </div>
                </div>
            </div>
            <div id="main">
                <header class="mb-3">
                    <a href="#" class="burger-btn d-block d-xl-none">
                        <i class="bi bi-justify fs-3"></i>
                    </a>
                </header>

                <div class="page-heading">
                    <div class="page-title">
                        <div class="row">
                            <div class="col-12 col-md-6 order-md-1 order-last">
                                <h3>Quản lý điểm</h3>
                                <p class="text-subtitle text-muted" style="margin-top:50px"></p>
                            </div>
                            <div class="col-12 col-md-6 order-md-2 order-first">
                                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Điểm</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <form action="diem_update" method="post">
                        <section id="multiple-column-form">
                            <div class="row match-height">
                                <div class="col-12">
                                    <div class="card">
                                        <div class="card-header">
                                            <h4 class="card-title">Cập nhật điểm điểm</h4>
                                        </div>
                                        <div class="card-content">
                                            <div class="card-body">
                                                <form class="form">
                                                    <div class="row">
                                                        <div class="col-md-6 col-12">
                                                            <div class="form-group">
                                                                <label for="first-name-column">Mã sinh viên</label>
                                                                <input type="text" id="city-column" class="form-control" placeholder="Mã sinh viên"
                                                                       name="maSV" value="${d.sinhvien.maSV}" readonly="readonly">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6 col-12">
                                                            <div class="form-group">
                                                                <label for="first-name-column">Mã môn học</label>
                                                                <input type="text" id="city-column" class="form-control" placeholder="Mã môn học"
                                                                       name="maMH" value="${d.monhoc.maMH}" readonly="readonly">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6 col-12">
                                                            <div class="form-group">
                                                                <label for="city-column">Học kỳ</label>
                                                                <input type="text" id="city-column" class="form-control" placeholder="Học kỳ"
                                                                       name="hocky" value="${d.hocKy}">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6 col-12">
                                                            <div class="form-group">
                                                                <label for="country-floating">Điểm lần 1</label>
                                                                <input type="text" id="country-floating" class="form-control"
                                                                       name="diem1" placeholder="Điểm lần 1" value="${d.diem1}">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6 col-12">
                                                            <div class="form-group">
                                                                <label for="company-column">Điểm lần 2</label>
                                                                <input type="text" id="company-column" class="form-control"
                                                                       name="diem2" placeholder="Điểm lần 2" value="${d.diem2}">
                                                            </div>
                                                        </div>
                                                    </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <button type="submit" id="sweet" class="btn btn-primary" style="padding-top: 10px; padding-bottom: 10px; margin-bottom: 20px;"><i
                                style="margin-right: 5px;">
                            </i>Xác nhận</button>
                    </form>
                    <a href="diem?dindex=1"><button class="btn btn-outline-danger" style="padding-right: 20px;padding-left: 20px;padding-top: 10px; padding-bottom: 10px; margin-bottom: 20px;"><i
                                style="margin-right: 5px;">
                            </i>Hủy bỏ</button>
                    </a>
                    <footer>
                        <div class="footer clearfix mb-0 text-muted">
                            <div class="float-start">
                                <p>14/3/2022 &copy; Quản lý sinh viên<</p>
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

            <script src="assets/js/mazer.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.4/dist/sweetalert2.min.js"></script>
            <script>
                document.getElementById("sweet").addEventListener('click', (event) => {
                    event.preventDefault();
                    Swal.fire({
                        position: 'top-middle',
                        icon: 'success',
                        title: 'Lưu thành công',
                        showConfirmButton: false,
                        timer: 1500
                    }).then(function () {
                        document.querySelector('form').submit()
                    });
                });
            </script>
    </body>

</html>
