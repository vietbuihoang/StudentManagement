<%-- 
    Document   : modelInfo.jsp
    Created on : Mar 13, 2022, 10:57:28 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <input type="radio" value="1" readonly="readonly" ${s.gioiTinh == 1? "checked":""}>Nam
    <input type="radio" value="0" readonly="readonly" style="margin-left: 20px;" ${s.gioiTinh == 0? "checked":""}>Nữ
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
