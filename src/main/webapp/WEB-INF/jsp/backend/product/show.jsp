<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>
<jsp:include page="../common/head.jsp"></jsp:include>
<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
<div class="container">
    <div>
        <div class="bg-light p-5 rounded">
            <div class="col-sm-8 mx-auto">
                <h1>Show sản phẩm</h1>
                <p style="color: red">${message}</p>
                <form action="/backend/user/edit-form" method="post">
                    <div class="row">
                        <input name="id" value="${user.id}" hidden>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Tên sản phầm</label>
                                <input type="text" name="userName" value="${product.name}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label"></label>

                                <c:if  test="${product.image == null}"><img src="/image-product/${product.image}" /></c:if>
                                <c:if  test="${product.image != null}"><img src="/image-product/${product.image}" /></c:if>

                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Miêu tả</label>
                                <input type="email" name="email" value="${product.description}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Giá Thành</label>
                                <input type="email" name="email" value="${product.price}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
</body>
