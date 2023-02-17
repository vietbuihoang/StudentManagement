<%-- 
    Document   : table_fixed1
    Created on : Mar 1, 2022, 11:26:06 PM
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
        <title>Danh sách Sinh viên</title>

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
                                <h3>Danh sách sinh viên</h3>
                                <p class="text-subtitle text-muted" style="margin-top:50px"></p>
                                <c:choose>
                                    <c:when test="${sessionScope.acc.role eq 'USER'}">
                                        <a href="sinhvien_create" style="display: none;">
                                            <button class="btn btn-info" style="padding-top: 10px; padding-bottom: 10px; margin-bottom: 20px;"><i class="bi-plus-circle" style="margin-right: 5px;">
                                                </i>Thêm mới </button>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="sinhvien_create">
                                            <button class="btn btn-info" style="padding-top: 10px; padding-bottom: 10px; margin-bottom: 20px;"><i class="bi-plus-circle" style="margin-right: 5px;">
                                                </i>Thêm mới </button>
                                        </a>
                                    </c:otherwise>
                                </c:choose>

                                <form action="sinhvien?index=1" method="post">
                                    <div class="input-group mb-3" style="padding-top: 30px; padding-bottom: 10px;">
                                        <span class="input-group-text" id="basic-addon1"><i class="bi bi-search"></i></span>
                                        <input type="text" name="search" class="form-control" placeholder="Tìm sinh viên"
                                               aria-label="Recipient's username" value="<%=request.getParameter("search") != null ? request.getParameter("search") : ""%>">
                                        <button class="btn btn-outline-secondary" type="submit"
                                                id="button-addon2">Search</button>
                                    </div>
                                </form>
                                <p style="font-style: italic">${requestScope.mess}</p>
                            </div>
                            <div class="col-12 col-md-6 order-md-2 order-first">
                                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="home">Trang chủ</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Danh sách sinh viên</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>

                    <section class="section">
                        <div class="row" id="table-contexual">
                            <div class="col-12">
                                <div class="card">
                                    <!-- table contextual / colored -->
                                    <div class="table-responsive">
                                        <table class="table mb-0">
                                            <thead>
                                                <tr>
                                                    <th>Mã sinh viên</th>
                                                    <th>Tên sinh viên</th>
                                                    <th>Ngày sinh</th>
                                                    <th>Mã lớp</th>
                                                        <c:choose>
                                                            <c:when test="${sessionScope.acc.role eq 'USER'}">
                                                            <th> </th>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <th>ACTION</th>
                                                            </c:otherwise>
                                                        </c:choose>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:choose>
                                                    <c:when test="${sessionScope.acc.role eq 'USER'}">
                                                        <c:forEach items="${listSinhVienByUsername}" var="l">
                                                            <tr>
                                                                <td class="text-bold-500">${l.maSV}</td>
                                                                <td>${l.tenSV}</td>
                                                                <td class="text-bold-500">${l.ngaySinh}</td>
                                                                <td>${l.lop.maLop}</td>
                                                                <td><a href="#" onclick="openModel(`${l.maSV}`)" class="bi-eye" data-bs-toggle="modal"
                                                                       data-bs-target="#inlineForm"><i
                                                                            class="badge-circle badge-circle-light-secondary font-medium-1"
                                                                            data-feather="mail"></i></a></td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:forEach items="${listSV}" var="sv">
                                                            <tr class="table-success">
                                                                <td class="text-bold-500">${sv.maSV}</td>
                                                                <td>${sv.tenSV}</td>
                                                                <td class="text-bold-500">${sv.ngaySinh}</td>
                                                                <td>${sv.lop.maLop}</td>
                                                                <td><a href="#" onclick="openModel(`${sv.maSV}`)" class="bi-eye" data-bs-toggle="modal"
                                                                       data-bs-target="#inlineForm"><i
                                                                            class="badge-circle badge-circle-light-secondary font-medium-1"
                                                                            data-feather="mail"></i></a>
                                                                    <a href="sinhvien_update?sid=${sv.maSV}" class="bi-box-arrow-in-up-left"><i
                                                                            class="badge-circle badge-circle-light-secondary font-medium-1"
                                                                            data-feather="mail"></i></a>
                                                                    <a href="sinhvien_delete?svid=${sv.maSV}"
                                                                       onclick="if (!(confirm('Bạn có chắc chắc muốn xóa?')))
                                                                           return false" class="bi-trash-fill"><i
                                                                            class="badge-circle badge-circle-light-secondary font-medium-1"
                                                                            data-feather="mail"></i></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:otherwise>
                                                </c:choose>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <div class="modal fade text-left" id="inlineForm"  tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel33"
                         aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable"
                             role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="myModalLabel33">Thông
                                        tin sinh viên</h4>
                                    <button type="button" class="close"
                                            data-bs-dismiss="modal" aria-label="Close">
                                        <i data-feather="x"></i>
                                    </button>
                                </div>
                                <div class="modal-body" id="model">
                                    <label>Mã số sinh viên</label>
                                    <div class="form-group">
                                        <input type="text" class="form-control info" value="${s.maSV}" readonly="readonly">
                                    </div>
                                    <label>Họ và tên</label>
                                    <div class="form-group">
                                        <input type="text" class="form-control" value="${s.tenSV}" readonly="readonly">
                                    </div>
                                    <label>Giới tính</label>
                                    <div class="form-group"
                                         style="margin-top: 10px;">
                                        <c:choose>
                                            <c:when test="${s.gioiTinh==1}">
                                                <input type="radio" value="1" checked="checked">Nam
                                            </c:when>
                                            <c:when test="${s.gioiTinh==0}">
                                                <input type="radio" value="0" style="margin-left: 20px;" checked="checked">Nữ
                                            </c:when>
                                        </c:choose>

                                    </div>
                                    <label>Ngày sinh</label>
                                    <div class="form-group">
                                        <input type="text" class="form-control info" value="${s.ngaySinh}" readonly="readonly">
                                    </div>
                                    <label>Quê quán</label>
                                    <div class="form-group">
                                        <input type="text" class="form-control" value="${s.queQuan}" readonly="readonly">
                                    </div>
                                    <label>Số điện thoại</label>
                                    <div class="form-group">
                                        <input type="text" class="form-control" value="${s.sdt}" readonly="readonly">
                                    </div>
                                    <label>Email</label>
                                    <div class="form-group">
                                        <input type="text" class="form-control" value="${s.email}" readonly="readonly">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--                    paging part-->
                    <c:if test="${sessionScope.acc.role eq 'ADMIN'}">
                        <nav aria-label="Page navigation example">
                        <ul class="pagination pagination-primary  justify-content-center">
                            <c:if test="${index != 1}">
                                <li class="page-item">
                                    <a class="page-link" href="sinhvien?index=${index-1}&search=${search}" tabindex="-1" aria-disabled="true">Previous</a>
                                </li>
                            </c:if>
                            <c:forEach begin="1" end="${endPage}" var="i">
                                <c:choose>
                                    <c:when test="${index == i}">
                                        <li class="page-item active"><a class="page-link" href="sinhvien?index=${i}&search=${search}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="sinhvien?index=${i}&search=${search}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>

                            <c:if test="${index < endPage}">
                                <li class="page-item">
                                    <a class="page-link" href="sinhvien?index=${index+1}&search=${search}">Next</a>
                                </li>
                            </c:if>

                        </ul>
                    </nav>
                    </c:if>
                    

                </div>

                <footer>
                    <div class="footer clearfix mb-0 text-muted">
                        <div class="float-start">
                            <p>14/03/2022 &copy; Quản lý sinh viên</p>
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
        <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        <script>
                                                                   function openModel(maSv) {
                                                                       console.log(maSv);
                                                                       axios.get('get-student-by-maSv', {
                                                                           params: {
                                                                               maSv: maSv
                                                                           }
                                                                       }).then((response) => {
                                                                           const modelbody = document.getElementById('model');
                                                                           modelbody.innerHTML = response.data
                                                                       })
                                                                   }
        </script>
    </body>

</html>
