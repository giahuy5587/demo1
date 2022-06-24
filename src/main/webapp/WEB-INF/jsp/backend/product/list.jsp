<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/head.jsp"></jsp:include>



<body>
<jsp:include page="../common/nav.jsp"></jsp:include>


<div class="container">
    <div>
        <div class="bg-light p-5 rounded">
            <div class="col-sm-8 mx-auto">
                <h1>Danh sách tài khoản</h1>
                <p style="color:red">${message}</p>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">name</th>
                        <th scope="col">BrandID</th>
                        <th scope="col">Giá</th>
                        <th scope="col">Miêu tả</th>
                        <th scope="col">CategoryID</th>
                        <th scope="col">image</th>


                    </tr>
                    </thead>
                    <tbody>

                    <c:set var="stt" value="1"></c:set>
                    <c:forEach items="${list.data}" var="product">
                        <tr>
                            <th scope="row">${stt}</th>
                            <td>
                                <a href="/backend/product/show/${product.name}">
                                        ${product.name}

                                </a>
                            </td>
                            <td>${product.brandId}</td>
                            <td>${product.price}</td>
                            <td>${product.description}</td>
                            <td>${product.categoryId}</td>
                            <td>${product.image}</td>



                            <c:set var="stt" value="${stt + 1}"></c:set>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>

            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item <c:if test="${list.page == 1}">disabled</c:if>"><a class="page-link" href="/backend/product/list?page=${list.page - 1}&perpage=${list.perpage}">Trước</a></li>
                    <c:forEach begin="1" step="1" end ="${list.numberPage}" var="num">
                        <li class="page-item " >
                            <a class="page-link"  href="/backend/prodct/list?page=${num}&perpage=${list.perpage}">${num}
                            </a>
                        </li>

                    </c:forEach>

                    <li class="page-item <c:if test="${list.page == list.numberPage}">disabled</c:if> "><a class="page-link" href="/backend/product/list?page=${list.page + 1}&perpage=${list.perpage}">Sau</a></li>
                </ul>
            </nav>


        </div>
    </div>
</div>
</body>

