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
    <div class="container-fluid">
        <div class="row">

            <div class="col-12">
                <div class="row">
                    <div class="col-md-4">
                        <div class="row">
                        <div class="col-md-12">
                            <div class="card card-info">
                                <div class="card-header">
                                    <div class="card-title">
                                        Thông Tin Đơn Hàng:
                                    </div>
                                </div>
                                <div class="card-body">

                                    <table class="table table-striped">
                                        <tbody>
                                        <tr>
                                            <td>ID Order:</td>
                                            <td>${order.orderId}</td>
                                        </tr>
                                        <tr>
                                            <td>Name of consignee:</td>
                                            <td>${order.fullname}</td>
                                        </tr>
                                        <tr>
                                            <td>Created order:</td>
                                            <td>${order.created}</td>
                                        </tr>
                                        <tr>
                                            <td>Total price:</td>
                                            <td><fmt:formatNumber>${order.total_price}</fmt:formatNumber> đ</td>
                                        </tr>
                                        <tr>
                                            <td>Payments:</td>
                                            <td>${order.payment}</td>
                                        </tr>
                                        <tr>
                                            <td>Email:</td>
                                            <td>${order.order_email}</td>
                                        </tr>
                                        <tr>
                                            <td>Address:</td>
                                            <td>${order.order_address}</td>
                                        </tr>
                                        <tr>
                                            <td>Phone number:</td>
                                            <td>${order.phone_number}</td>
                                        </tr>
                                        <tr>
                                            <td>Status:</td>
                                            <td><a  class="btn ${btnbtn} btn-sm" style="color: white">${trangThai}</a></td>
                                        </tr>
                                        <tr>
                                            <td>Note:</td>
                                            <td>${order.order_note}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                            </div>
                        </div>
                        </div>

                        <div class="col-md-12">
                            <div class="card card-info">
                                <div class="card-header">
                                    <div class="card-title">
                                        Status Order:
                                    </div>
                                </div>
                                <%--@elvariable id="order" type=""--%>
                                <f:form  method="POST" action="${pageContext.request.contextPath}/admin/order/updateStatusOrder" modelAttribute="order">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <input type="hidden" name="orderId" value="${order.orderId}"/>
                                                <!-- select -->
                                                <div class="form-group">
                                                    <label>Cập Nhật Trạng Thái Đơn Hàng:</label>
                                                    <f:select class="form-control" name="status" path="status">
                                                        <c:if test="${order.status ==1}">
                                                            <f:option value="1">Đang Chờ</f:option>
                                                            <f:option value="2">Đã Xác Nhận</f:option>
                                                            <f:option value="3">Đang Vận Chuyển</f:option>
                                                            <f:option value="4">Đã Hoàn Thành</f:option>
                                                            <f:option value="5">Bị Hủy</f:option>
                                                        </c:if>
                                                        <c:if test="${order.status ==2}">
                                                            <f:option value="2">Đã Xác Nhận</f:option>
                                                            <f:option value="3">Đang Vận Chuyển</f:option>
                                                            <f:option value="4">Đã Hoàn Thành</f:option>
                                                            <f:option value="5">Bị Hủy</f:option>
                                                        </c:if>
                                                        <c:if test="${order.status ==3}">
                                                            <f:option value="3">Đang Vận Chuyển</f:option>
                                                            <f:option value="4">Đã Hoàn Thành</f:option>
                                                            <f:option value="5">Bị Hủy</f:option>
                                                        </c:if>
                                                        <c:if test="${order.status ==4}">

                                                            <f:option value="4">Đã Hoàn Thành</f:option>

                                                        </c:if>
                                                        <c:if test="${order.status ==5}">

                                                            <f:option value="5">Bị Hủy</f:option>
                                                        </c:if>

                                                    </f:select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
                                </f:form>
                            </div>

                        </div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="Row">
                            <div class="col-12">
                                <div class="card card-info ">
                                    <div class="card-header">
                                        <div class="card-title">
                                            Chi tiết Đơn Hàng
                                        </div>

                                    </div>
                                    <div class="card-body">
                                        <table class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th style="width: 10px">#</th>
                                                <th>Ảnh Sản Phẩm</th>
                                                <th>Tên Sản Phẩm</th>
                                                <th>Số Lượng</th>
                                                <th>Loại Sản Phẩm</th>
                                                <th>Giá Bán</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${listOrderDetail}" var="lsOdDetail" varStatus="itr">
                                                <tr>
                                                    <td>${offset+itr.index+1}.</td>
                                                    <td><img src="${lsOdDetail.product.image}" width="100"></td>
                                                    <td>${lsOdDetail.product.product_name}</td>
                                                    <td>${lsOdDetail.quantity}</td>
                                                    <td>${lsOdDetail.product.category_detail.cate_detail_name}</td>
                                                    <td><fmt:formatNumber>${lsOdDetail.price}</fmt:formatNumber>$</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="Row">



                </div>


            </div>

        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/layout/admin/footer.jsp" %>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<%@include file="/WEB-INF/views/layout/admin/infoActionc.jsp" %>

</body>
</html>



