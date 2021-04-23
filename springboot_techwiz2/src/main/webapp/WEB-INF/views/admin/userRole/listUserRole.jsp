<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="pageTitle" scope="request" value="User Role Manager"/>
<%@include file="../../layout/admin/header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Quản Lý Phân Quyền Account</h1>
                    <c:if test="${param.success != null}">
                        <div class="alert alert-success" role="alert">
                            thanh cong
                        </div>
                    </c:if>
                    <c:if test="${param.error!=null}">
                        <div class="alert alert-danger" role="alert">
                            that bai
                        </div>
                    </c:if>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a >Trang Chủ</a></li>
                        <li class="breadcrumb-item active">Quản Lý Phân Quyền Account</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-7">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Danh Sách Phân Quyền</h3>

                    </div>
                    <!-- /.card-header -->
                    <div class="card-body">
                        <table class="table table-striped projects">
                            <thead>
                            <tr>
                                <th style="width: 10px">STT</th>
                                <th>Tên Email</th>
                                <th>Tên Quyền</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="userRole" varStatus="itr">
                                <tr>
                                    <td>${offset+itr.index+1}</td>
                                    <td>${userRole.userId.email }</td>
                                    <td>${userRole.roleId.name}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/admin/roleUser/editRoleUser?id=${userRole.id}" class="btn  btn-info btn-sm"><i class="fas fa-pencil-alt"> </i> Cập Nhật</a>
                                        <a href="${pageContext.request.contextPath}/admin/roleUser/deleteRoleUser?id=${userRole.id}" class="btn  btn-danger btn-sm"><i class="fas fa-trash"> </i> Xóa</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <%-- <mytag:PaginatiomnTaglib steps="10" offset="${offset}" count="${count}" uri="/cateController/getAll.htm" next="&raquo;" previous="&laquo;"/> --%>
                    </div>
                    <!-- /.card-body -->
<%--                    <div class="card-footer clearfix">--%>
<%--                        <ul class="pagination pagination-sm m-0 float-right">--%>
<%--                            <c:if test="${totalPages > 1}">--%>
<%--                                <c:if test="${currentPage>1}">--%>
<%--                                    <li class="page-item"><a class="page-link" href="/admin/category/page/${currentPage-1}">«</a></li>--%>
<%--                                </c:if>--%>
<%--                                <c:forEach  end="${totalPages}" begin="1" varStatus="loop">--%>
<%--                                    <c:if test="${currentPage != loop.index}">--%>
<%--                                        <li class="page-item "><a class="page-link" href="/admin/category/page/${loop.index}">${loop.index}</a></li>--%>
<%--                                    </c:if>--%>
<%--                                    <c:if test="${currentPage == loop.index}">--%>
<%--                                        <li class="page-item active"><a class="page-link" href="/admin/category/page/${loop.index}">${loop.index}</a></li>--%>
<%--                                    </c:if>--%>
<%--                                </c:forEach>--%>
<%--                                <c:if test="${currentPage<totalPages}">--%>
<%--                                    <li class="page-item"><a class="page-link" href="/admin/category/page/${currentPage+1}">»</a></li>--%>
<%--                                </c:if>--%>
<%--                            </c:if>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
                </div>
                <!-- /.card -->
            </div>
            <div class="col-md-5">
                <!-- general form elements -->
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Thêm Quyền Mới Cho Account!</h3>
                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                                <i class="fas fa-minus"></i></button>
                        </div>
                    </div>
                    <div class="card-body" style="display: block;">
                        <!-- /.card-header -->
                        <!-- form start -->
                        <f:form action="${pageContext.request.contextPath}/admin/roleUser/saveRoleUser" method="POST" modelAttribute="userRoleNew">
                        <div class="form-group">
                            <label>Account:</label>
                            <f:select class="custom-select" path="userId.id">
                                <f:options items="${listUser}"  itemLabel="email" itemValue="id" />
                            </f:select>
                        </div>
                        <div class="form-group">
                            <label>Role:</label>
                            <f:select class="custom-select" path="roleId.id">
                                <f:options items="${listRole}"  itemLabel="name" itemValue="id" />
                            </f:select>
                        </div>
                        <div class="form-group">
                            <div class="form-group">

                            </div>
                            <!-- /.card-body -->
                            <div class="card-footer">
                                <button type="submit" class="btn btn-info">Thêm Mới</button>
                            </div>
                            </f:form>
                        </div>
                    </div>
                    <!-- /.card -->
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../../layout/admin/footer.jsp"/>