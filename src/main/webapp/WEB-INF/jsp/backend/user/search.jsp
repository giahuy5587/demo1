
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>

<div class =" row mt-2 mb-2">
    <div class="col">
        <form th:action="@{/backend/user/search}">
            <div class="form-check-inline floating">

                <label for= "name">Name:</label>
                <input type ="text" class="form-comtrol" name="name"
                id ="name" aria-describedly="helpId" placeholder="Name">
                <button class="btn btn-outline-primary"> tìm kiếm</button>
            </div>
        </form>
    </div>
</div>
<div class="col-sm-8 mx-auto">
    <h1>Danh sách tài khoản</h1>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Tên đăng nhập</th>
            <th scope="col">Họ và tên</th>
            <th scope="col">Giới tính</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Quyền</th>

        </tr>
        </thead>
        <tbody>

        <c:set var="stt" value="1"></c:set>
        <c:forEach items="${user}" var="user">
            <tr>
                <th scope="row">${stt}</th>
                <td>
                    <a href="/backend/user/edit/${user.id}">
                            ${user.userName}

                    </a>
                </td>
                <td>${user.fullName}</td>
                <td><c:if test="${user.gender == 1}">Nam</c:if>
                    <c:if test="${user.gender == 2}">Nữ</c:if></td>
                <td><c:if test="${user.status == 1}">Kích hoạt</c:if>
                    <c:if test="${user.status == 0}">Tạm dừng</c:if></td>
                <td>${user.role}</td>
                <c:set var="stt" value="${stt + 1}"></c:set>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
