<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/jsp/backend/common/head.jsp"></jsp:include>
<body>
<jsp:include page="/WEB-INF/jsp/backend/common/nav.jsp"></jsp:include>
<div class="container">
    <div>
        <div class="bg-light p-5 rounded">
            <div class="col-sm-8 mx-auto">
                <h1>Tạo mới sản phẩm</h1>
                <p style="color: red">${message}</p>
                <form:form action="/backend/category/create-form" method="post" id="product-form" modelAttribute="category">
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Tên thể loại</label>
                                <form:input type="text" path="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
                                <form:errors path="name" cssClass="error"></form:errors>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">Mô tả</label>
                                <form:input type="number" path="description" class="form-control" id="exampleInputPassword1"/>
                                <form:errors path="description" cssClass="error"></form:errors>
                            </div>
                        </div>

                    </div>
                    <button type="submit" class="btn btn-primary">Tạo mới</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>


