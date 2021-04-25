<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Category Manager"/>
<%@include file="/WEB-INF/views/layout/admin/header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Product Manager</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a >Home</a></li>
                        <li class="breadcrumb-item active">Product Manager</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Product List</h3>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body p-0">
                        <table class="table table-striped projects">
                            <thead>
                            <tr>
                                <th style="width: 10px">STT</th>
                                <th>Product Name</th>
                                <th>Category Detail</th>
                                <th>Price</th>
                                <th>Image</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="pro" varStatus="itr">
                                <tr>
                                    <td>${offset+itr.index+1}
                                    </td>
                                    <td>${pro.product_name
                                    }</td>
                                    <td>${pro.category_detail.cate_detail_name}</td>
                                    <td><fmt:formatNumber>${pro.price}</fmt:formatNumber> đ</td>
                                    <td><img src="${pro.image}" width="100"></td>
                                    <td>
                                        <c:if test="${pro.status ==1}">
                                            <span class="badge badge-success">Show</span>
                                        </c:if>
                                        <c:if test="${pro.status !=1}">
                                            <span class="badge badge-danger">Hidden</span>
                                        </c:if>
                                    </td>
                                    <td class="project-actions ">
                                        <a href="${pageContext.request.contextPath}/admin/product/detailPro?id=${pro.product_id}" class="btn btn-primary btn-sm"><i class="fas fa-folder"> </i>Detail</a>
                                        <a href="${pageContext.request.contextPath}/admin/product/deleteProducts?id=${pro.product_id}" class="btn btn-danger btn-sm"><i class="fas fa-trash"></i> Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.card-body -->
                    <div class="card-footer clearfix">
                        <ul class="pagination pagination-sm m-0 float-right">
                            <c:if test="${totalPages > 1}">
                                <c:if test="${currentPage>1}">
                                    <li class="page-item"><a class="page-link" href="/admin/product/page/${currentPage-1}">«</a></li>
                                </c:if>
                                <c:forEach  end="${totalPages}" begin="1" varStatus="loop">
                                    <c:if test="${currentPage != loop.index}">
                                        <li class="page-item "><a class="page-link" href="/admin/product/page/${loop.index}">${loop.index}</a></li>
                                    </c:if>
                                    <c:if test="${currentPage == loop.index}">
                                        <li class="page-item active"><a class="page-link" href="/admin/product/page/${loop.index}">${loop.index}</a></li>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${currentPage<totalPages}">
                                    <li class="page-item"><a class="page-link" href="/admin/product/page/${currentPage+1}">»</a></li>
                                </c:if>
                            </c:if>
                        </ul>
                    </div>
                </div>
                <!-- /.card -->
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/layout/admin/footer.jsp" %>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<%@include file="/WEB-INF/views/layout/admin/infoActionc.jsp" %>

</body>
</html>



