<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
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
            <div class="col-md-5">
                <!-- general form elements -->
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Cập Nhật Quyền Cho Account!</h3>
                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                                <i class="fas fa-minus"></i></button>
                        </div>
                    </div>
                    <div class="card-body" style="display: block;">
                        <!-- /.card-header -->
                        <!-- form start -->
                        <f:form action="${pageContext.request.contextPath}/admin/roleUser/updateRoleUser" method="POST" modelAttribute="userRolesEdit">
                        <div class="form-group">
                            <f:input path="id" type="hidden"/>
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