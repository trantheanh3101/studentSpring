
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 28/06/2024
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách học sinh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Trang chủ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="/student">Học sinh</a>
                <a class="nav-link" href="/teacher">Giáo viên</a>
                <a class="nav-link" href="/class">Lớp học</a>
            </div>
        </div>
        <form class="d-flex" action="student" method="post">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
            <input type="hidden" name="action" value="search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container">
    <p style="color: blue">${message}</p>
    <button class="btn btn-primary mt-4" onclick="window.location.href='/student/create'">Thêm</button>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Số thứ tự</th>
            <th>Mã</th>
            <th>Họ và tên</th>
            <th>Địa chỉ</th>
            <th>Điểm</th>
            <th>Học lực</th>
        </tr>
        </thead>
        <tbody>
        <%--        for(Student student : students)--%>
        <c:forEach var="student" items="${students}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.address}</td>
                <td>${student.score}</td>
                <td>
                    <c:choose>
                        <c:when test="${student.score >= 8}">Học sinh giỏi</c:when>
                        <c:when test="${student.score >= 6.5}">Học sinh khá</c:when>
                        <c:when test="${student.score >= 5}">Học sinh trung bình</c:when>
                        <c:when test="${student.score >= 3.5}">Học sinh yếu</c:when>
                        <c:otherwise>Cook</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <button class="btn btn-warning" onclick="window.location.href='/student/update/${student.id}'">Sửa</button>
                    <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal${student.id}">Xóa</button>
                    <div class="modal fade" id="deleteModal${student.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Xóa học sinh</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Bạn có muốn xóa học sinh có tên là ${student.name}?
                                    <p style="color: red">Hành động này không thể hoàn tác!!!!!</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                                    <form action="/student?action=delete" method="post">
                                        <button type="submit" class="btn btn-primary">Xác nhận</button>
                                        <input type="hidden" name="id" value="${student.id}">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>