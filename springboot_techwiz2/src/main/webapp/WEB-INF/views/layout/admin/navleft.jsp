<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="../../index3.html" class="brand-link">
      <img src="<c:url value="/assets/dist/img/AdminLTELogo.png"/>"
           alt="AdminLTE Logo"
           class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">Admin</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="https://picsum.photos/160/160" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
          <a href="/logout" class="d-block">${pageContext.request.userPrincipal.name}</a>
        </c:if>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin" class="nav-link">
              <i class="nav-icon fas fa-tachometer-alt"></i><p>Dashboard</p>
            </a>
          </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link"><i class="nav-icon fas fa-th"></i><p>Category Website<i class="right fas fa-angle-left"></i></p></a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/category" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Category Manager</p></a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/categoryDetail" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Category Detail Manager</p></a>
              </li>
            </ul>
          </li>
          <li class="nav-item has-treeview">
          <a href="#" class="nav-link"><i class="nav-icon fas fa-copy"></i><p>Menu Website<i class="right fas fa-angle-left"></i></p></a>
          <ul class="nav nav-treeview">
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/admin/menu" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Menu Manager</p></a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/admin/menuDetail" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Menu Detail Manager</p></a>
            </li>
          </ul>
        </li>
          <li class="nav-item has-treeview">
          <a href="${pageContext.request.contextPath}/admin/product" class="nav-link">
            <i class="nav-icon fas fa-chart-pie"></i>
            <p>
              Product Manager
            </p>
          </a>
        </li>
          <li class="nav-item has-treeview">
            <a href="${pageContext.request.contextPath}/admin/customer" class="nav-link">
              <i class="nav-icon fas fa-chart-pie"></i>
              <p>
                Customer Manager
              </p>
            </a>
          </li>

        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
    