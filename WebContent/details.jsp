<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>
        <!-- details -->
        <%
			Article article = (Article)session.getAttribute("article");
		%>
        <div class="details row">
            <!-- 左侧 -->
            <div class="col-md-9">
                <!-- 文章信息 -->
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4">
                        	<%= article.getTitle() %>
                        </h1>
                        <p class="lead">
                        	<%= article.getCreatedTime() %>
                        </p>
                        <hr class="my-4">
                        <p>
                        	<%= article.getContent() %>
                        </p>
                    </div>
                </div>
                <!-- 评论列表 -->
                <h4 class="mb-4">评论列表</h4>
                <div class="media">
                    <img src="img/image.png" class="mr-3" alt="..." style="width: 64px;height: 64px;">
                    <div class="media-body">
                        <h5 class="mt-0">王荆茜</h5>
                        <div class="row">
                            <p class="col-md-9">这篇文章写的真不错呀</p>
                            <p class="col-md-3">2020-12-12</p>
                        </div>
                    </div>
                </div>
                <div class="media">
                    <img src="img/image.png" class="mr-3" alt="..." style="width: 64px;height: 64px;">
                    <div class="media-body">
                        <h5 class="mt-0">王荆茜</h5>
                        <div class="row">
                            <p class="col-md-9">这篇文章写的真不错呀</p>
                            <p class="col-md-3">2020-12-12</p>
                            <div class="media mt-3">
                                <a class="mr-3" href="#">
                                    <img src="img/image.png" alt="..." style="width: 64px;height: 64px;">
                                </a>
                                <div class="media-body">
                                    <h5 class="mt-0">刘风暴</h5>
                                    <p>你眼光真好！</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 右侧 -->
            <div class="col-md-3">
                <h4 class="title mt-4 ml-2">相关推荐</h4>
                <!-- 推荐文章 -->
                <div class="list-group list-group-flush mt-4">
                    <a href="#" class="list-group-item list-group-item-action">A second link item</a>
                    <a href="#" class="list-group-item list-group-item-action">A third link item</a>
                    <a href="#" class="list-group-item list-group-item-action">A fourth link item</a>
                </div>
            </div>
        </div>
<%@include file="foot.jsp" %>