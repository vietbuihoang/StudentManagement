<%-- 
    Document   : Khoa_form
    Created on : Mar 3, 2022, 1:00:33 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http–equiv=“Content-Type” content=“text/html; charset=UTF-8”>
              <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quản Lý tài khoản</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.4/dist/sweetalert2.min.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/PRJ_ASM_Project/assets/css/bootstrap.css">

        <link rel="stylesheet" href="/PRJ_ASM_Project/assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
        <link rel="stylesheet" href="/PRJ_ASM_Project/assets/vendors/bootstrap-icons/bootstrap-icons.css">
        <link rel="stylesheet" href="/PRJ_ASM_Project/assets/css/app.css">
        <link rel="shortcut icon" href="/PRJ_ASM_Project/assets/images/favicon.svg" type="image/x-icon">
    </head>

    <body>
        <div id="app">
            <div id="sidebar" class="active">
                <div class="sidebar-wrapper active">
                    <div class="sidebar-header">
                        <div class="d-flex justify-content-between">
                            <div class="logo">
                                <a href="#"><img src="/PRJ_ASM_Project/assets/images/logo/logo.png" alt="Logo" srcset=""></a>
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
                                <h3>Quản lý tài khoản</h3>
                                <p class="text-subtitle text-muted" style="margin-top:50px"></p>
                            </div>
                            <div class="col-12 col-md-6 order-md-2 order-first">
                                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Account</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <form action="account_update" method="post">
                        <section id="horizontal-input">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="card">
                                        <div class="card-header">
                                            <h4 class="card-title">Cập nhật thông tin tài khoản</h4>
                                        </div>

                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row align-items-center">
                                                        <div class="col-lg-2 col-3">
                                                            <label class="col-form-label">Tên tài khoản</label>
                                                        </div>
                                                        <div class="col-lg-10 col-9">
                                                            <input type="text" id="last-name" class="form-control" name="username"
                                                                   placeholder="Tên tài khoản" value="${acc.username}">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row align-items-center">
                                                        <div class="col-lg-2 col-3">
                                                            <label class="col-form-label">Mật khẩu</label>
                                                        </div>
                                                        <div class="col-lg-10 col-9">
                                                            <input type="text" id="helperText" class="form-control" name="password"
                                                                   placeholder="Mật khẩu" value="${acc.password}">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row align-items-center">
                                                        <div class="col-lg-2 col-3">
                                                            <label class="col-form-label">Display Name</label>
                                                        </div>
                                                        <div class="col-lg-10 col-9">
                                                            <input type="text" id="first-name" class="form-control" name="displayname"
                                                                   placeholder="Display Name" value="${acc.displayname}">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row align-items-center">
                                                        <div class="col-lg-2 col-3">
                                                            <label class="col-form-label">Email</label>
                                                        </div>
                                                        <div class="col-lg-10 col-9">
                                                            <input type="text" id="last-name" class="form-control" name="email"
                                                                   placeholder="Email" value="${acc.email}">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row align-items-center">
                                                        <div class="col-lg-2 col-3">
                                                            <label class="col-form-label">Phone</label>
                                                        </div>
                                                        <div class="col-lg-10 col-9">
                                                            <input type="text" id="first-name" class="form-control" name="phone"
                                                                   placeholder="Phone" value="${acc.phone}">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row align-items-center">
                                                        <div class="col-lg-2 col-3">
                                                            <label class="col-form-label">Role</label>
                                                        </div>
                                                        <div class="col-lg-10 col-9">
                                                            <input type="text" id="last-name" class="form-control" name="role"
                                                                   placeholder="Role" value="${acc.role}">
                                                            <p style="font-style: italic"><small class="text-muted">Viết hoa</small></p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row align-items-center">
                                                        <div class="col-lg-2 col-3">
                                                            <label class="col-form-label">ID</label>
                                                        </div>
                                                        <div class="col-lg-10 col-9">
                                                            <input type="text" id="last-name" class="form-control" name="id"
                                                                   placeholder="Role" value="${acc.id}" readonly="readonly">
                                                            
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
                    <div>
                        <a href="account?aindex=1"><button class="btn btn-outline-danger" style="padding-right: 20px;padding-left: 20px;padding-top: 10px; padding-bottom: 10px; margin-bottom: 20px;"><i
                                    style="margin-right: 5px;">
                                </i>Hủy bỏ</button>
                        </a>
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
