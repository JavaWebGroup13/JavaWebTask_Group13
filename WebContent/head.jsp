<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 设置项目基本路径 -->
<% request.setAttribute("basePath", "/JavaWebTask_Group13"); %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人博客</title>
	<style>
        /*
         * 设置鼠标指针
         */
		body{
		    cursor: url(static/img/cursor.png), default;
		}
		a,
		a:hover{
			cursor: url(static/img/cursor2.png), default;
		}
	</style>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/ckeditor.js"></script>
    <script src="static/js/jquery.slim.min.js"></script>
    <script src="static/js/bootstrap.bundle.min.js"></script>
</head> 
<body>
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
                            <li class="nav-item">
                                <a class="nav-link" href="${basePath}/Home">主页</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${basePath}/Category">分类</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${basePath}/About">关于</a>
                            </li>
                            <c:choose>
	                            <c:when test="${user != null}"  >
		                            <li class="nav-item dropdown ml-auto">
		                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
		                                	${ user.getUsername() }
		                                </a>
		                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		                                    <a class="dropdown-item" href="${basePath}/Center">个人中心</a>
		                                    <a class="dropdown-item" href="${basePath}/Write">写文章</a>
		                                    <div class="dropdown-divider"></div>
		                                    <a class="dropdown-item" href="${basePath}/Logout">退出</a>
		                                </div>
		                            </li>
	                            </c:when>
	                            <c:otherwise>
			                        <li class="nav-item">
			                            <a class="nav-link" href="${basePath}/Login">登录</a>
			                        </li>
	                            </c:otherwise>
                            </c:choose>
                        </ul>
                        <form class="form-inline my-2 my-lg-0" method="GET" action="${basePath}/Search">
                            <input name="keywords" class="form-control mr-sm-2" type="search" placeholder="文章/关键字" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
                        </form>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- body -->
    <div class="container body" style="margin-top: 80px;">