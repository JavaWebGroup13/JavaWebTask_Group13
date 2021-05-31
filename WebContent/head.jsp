<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
                                <a class="nav-link" href="?route=home">主页</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="?route=category">分类</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="?route=about">关于</a>
                            </li>
                            <!-- 未登录 -->
                            <li class="nav-item">
                                <a class="nav-link" href="?route=login">登录</a>
                            </li>
                            <!-- 已登录 -->
                            <li class="nav-item dropdown ml-auto">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">511098094@qq.com</a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="?route=center">个人中心</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="?route=logout">退出</a>
                                </div>
                            </li>
                        </ul>
                        <form class="form-inline my-2 my-lg-0" method="GET" action="index.html">
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
