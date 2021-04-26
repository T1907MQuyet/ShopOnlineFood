<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Order Manager"/>
<%@include file="/WEB-INF/views/layout/admin/header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Order Manager</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a >Home</a></li>
                        <li class="breadcrumb-item active">Order Manager</li>
                    </ol>
                </div>
            </div>

        </div><!-- /.container-fluid -->
    </section>
    <div class="col-md-12">
        <div class="card card-warning collapsed-card">
            <div class="card-header">
                <h3 class="card-title">Look Up Orders</h3>

                <div class="card-tools">

                    <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-plus"></i>
                    </button>

                    <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-times"></i>
                    </button>
                </div>
            </div>
            <!-- /.card-header -->
            <div class="card-body" style="display: none; color: #FFF">
                <div class="col-md-12" style="margin-top: 10px;margin-bottom: 10px;">
                    <div class="row">
                        <div class="col-md-3 col-sm-6 col-12">
                            <div class="info-box">
                                <span class="info-box-icon bg-primary"><i class="far fa-envelope"></i></span>

                                <div class="info-box-content">
                                    <a href="${pageContext.request.contextPath}/admin/order/page/1/1">
                                        <span class="info-box-text">Waiting</span>
                                        <span class="info-box-number">${coutWatting}</span>
                                    </a>
                                </div>
                                <!-- /.info-box-content -->
                            </div>
                            <!-- /.info-box -->
                        </div>
                        <!-- /.col -->
                        <div class="col-md-3 col-sm-6 col-12">
                            <div class="info-box">
                                <span class="info-box-icon bg-info"><i class="far fa-flag"></i></span>

                                <div class="info-box-content">
                                    <a class="text-info" href="${pageContext.request.contextPath}/admin/order/page/1/2">
                                        <span class="info-box-text">Confirmed</span>
                                        <span class="info-box-number">${coutConfirmed}</span>
                                    </a>
                                </div>
                                <!-- /.info-box-content -->
                            </div>
                            <!-- /.info-box -->
                        </div>
                        <!-- /.col -->
                        <div class="col-md-3 col-sm-6 col-12">
                            <div class="info-box">
                                <span class="info-box-icon bg-success"><i class="fas fa-shipping-fast"></i></span>

                                <div class="info-box-content">
                                    <a class="text-success" href="${pageContext.request.contextPath}/admin/order/page/1/3">
                                        <span class="info-box-text">Shipping</span>
                                        <span class="info-box-number">${coutShipping}</span>
                                    </a>
                                </div>
                                <!-- /.info-box-content -->
                            </div>
                            <!-- /.info-box -->
                        </div>
                        <div class="col-md-3 col-sm-6 col-12">
                            <div class="info-box">
                                <span class="info-box-icon bg-warning"><i class="fas fa-thumbs-up"></i></span>

                                <div class="info-box-content">
                                    <a class="text-warning" href="${pageContext.request.contextPath}/admin/order/page/1/4">
                                        <span class="info-box-text">Complete</span>
                                        <span class="info-box-number">${coutComplete}</span>
                                    </a>
                                </div>
                                <!-- /.info-box-content -->
                            </div>
                            <!-- /.info-box -->
                        </div>
                        <div class="col-md-3 col-sm-6 col-12">
                            <div class="info-box">
                                <span class="info-box-icon bg-danger"><i class="far fa-window-close"></i></span>

                                <div class="info-box-content">
                                    <a class="text-danger" href="${pageContext.request.contextPath}/admin/order/page/1/5">
                                        <span class="info-box-text">Cancelled</span>
                                        <span class="info-box-number">${coutCancelled}</span>
                                    </a>
                                </div>
                                <!-- /.info-box-content -->
                            </div>
                            <!-- /.info-box -->
                        </div>
                        <div class="col-md-3 col-sm-6 col-12">
                            <div class="info-box">
                                <span class="info-box-icon bg-fuchsia"><i class="fas fa-clipboard-list"></i></span>

                                <div class="info-box-content">
                                    <a class="text-fuchsia" href="${pageContext.request.contextPath}/admin/order">
                                        <span class="info-box-text">All Order</span>
                                        <span class="info-box-number"></span>
                                    </a>
                                </div>
                                <!-- /.info-box-content -->
                            </div>
                            <!-- /.info-box -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.card-body -->

            <!-- /.card-footer-->
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Order List</h3>
                    </div>
                    <div class="card-body p-0">
                        <table class="table table-striped projects">
                            <thead>
                            <tr>
                                <th style="width: 10px">#</th>
                                <th>Order</th>
                                <th>FullName</th>
                                <th>Address</th>
                                <th>Payment</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="order" varStatus="itr">
                                <tr>
                                    <td>${offset+itr.index+1}</td>
                                    <td><span class="text-bold">ID: </span> ${order.orderId}<br>
                                        <span class="text-bold">Email: </span> ${order.order_email}<br>
                                        <span class="text-bold">Created: </span> ${order.created}<br>
                                        <span class="text-bold">Total Price: </span>  <fmt:formatNumber>${order.total_price}</fmt:formatNumber>$<br>
                                        <span class="text-bold">Status:</span> <c:if test="${order.status ==1}">
                                            <p  class="badge badge-primary btn-sm">Waiting</p>
                                        </c:if>
                                        <c:if test="${order.status ==2}">
                                            <p  class="badge badge-info btn-sm">Confirmed</p>
                                        </c:if>
                                        <c:if test="${order.status ==3}">
                                            <p  class="badge badge-success btn-sm">Shipping</p>
                                        </c:if>
                                        <c:if test="${order.status ==4}">
                                            <p  class="badge badge-warning btn-sm">Complete</p>
                                        </c:if>
                                        <c:if test="${order.status ==5}">
                                            <p  class="badge badge-danger btn-sm">Cancelled</p>
                                        </c:if>
                                    </td>
                                    <td>${order.fullname}</td>
                                    <td>${order.order_address}</td>
                                    <td><p  class="badge badge-info">${order.payment}</p></td>
                                    <td class="project-actions ">
                                        <a href="${pageContext.request.contextPath}/admin/order/detailOrder?id=${order.orderId}" class="btn btn-primary btn-sm"><i class="fas fa-folder"> </i> Detail</a>
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
                                    <li class="page-item"><a class="page-link" href="/admin/order/page/${currentPage-1}/${status}">«</a></li>
                                </c:if>
                                <c:forEach  end="${totalPages}" begin="1" varStatus="loop">
                                    <c:if test="${currentPage != loop.index}">
                                        <li class="page-item "><a class="page-link" href="/admin/order/page/${loop.index}/${status}">${loop.index}</a></li>
                                    </c:if>
                                    <c:if test="${currentPage == loop.index}">
                                        <li class="page-item active"><a class="page-link" href="/admin/order/page/${loop.index}/${status}">${loop.index}</a></li>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${currentPage<totalPages}">
                                    <li class="page-item"><a class="page-link" href="/admin/order/page/${currentPage+1}/${status}">»</a></li>
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



