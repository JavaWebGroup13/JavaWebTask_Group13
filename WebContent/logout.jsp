<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>
        <!-- logout -->
        <div class="logout">
            <div class="alert alert-success" role="alert">
                您已成功退出，即将跳转到主页面！ 或：<a href="${pageContext.request.contextPath}/login.jsp">点此登录</a>
            </div>
        </div>
<%@include file="foot.jsp" %>