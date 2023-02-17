<%-- 
    Document   : test
    Created on : Mar 2, 2022, 11:56:50 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Khoa"%>
<%@page import="model.KhoaHoc"%>
<%@page import="model.HeDT"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${requestScope.listSinhVien.maLop}
        ${requestScope.listSinhVien.tenLop}
        ${requestScope.listSinhVien.khoa.maKhoa}
        ${requestScope.listSinhVien.heDT.maHDT}
        ${requestScope.listSinhVien.khoahoc.maKH}
</body>
</html>
