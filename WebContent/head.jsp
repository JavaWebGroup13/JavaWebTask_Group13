<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!-- 导入dao包下的所有类 -->
<%@ page import="dao.*" %>
<!-- 导入bean包下的所有类 -->
<%@ page import="bean.*" %>

<%
	boolean isLogin = false;
	User user = null;
	
	try{
		isLogin = (Boolean)session.getAttribute("isLogin");
		user = (User)session.getAttribute("user");
	}catch(Exception e){
		System.out.println("获取session参数错误");
		e.printStackTrace();
	}
	
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人博客</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

</head> 
<body>
    <script src="https://cdn.ckeditor.com/ckeditor5/12.0.0/classic/ckeditor.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- head -->
    <div class="container">
        <div class="head">
            <!-- 头部导航 -->
            <div class="container fixed-top">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <a class="navbar-brand" href="#">个人博客</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="${pageContext.request.contextPath}/home.jsp">主页</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/category.jsp">分类</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">关于</a>
                            </li>
                            <c:choose>
	                            <c:when test="${isLogin}"  >
		                            <li class="nav-item dropdown ml-auto">
		                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
		                                	<%=  user.getUsername() %>
		                                </a>
		                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/center.jsp">个人中心</a>
		                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/write.jsp">写文章</a>
		                                    <div class="dropdown-divider"></div>
		                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/Logout">退出</a>
		                                </div>
		                            </li>
	                            </c:when>
	                            <c:otherwise>
			                        <li class="nav-item">
			                            <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">登录</a>
			                        </li>
	                            </c:otherwise>
                            </c:choose>
                        </ul>
                        <form class="form-inline my-2 my-lg-0" method="GET" action="${pageContext.request.contextPath}/search.jsp">
                            <input type="hidden" name="route" value="search">
                            <input class="form-control mr-sm-2" type="search" placeholder="文章/关键字" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
                        </form>
                    </div>
                </nav>
            </div>

            <!-- 面包屑导航 -->
            <nav aria-label="breadcrumb" style="margin-top: 66px;">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="?route=home">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">login</li>
                </ol>
            </nav>
        </div>
    </div>

    <!-- body -->
    <div class="container body">
