<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>
        <div class="details row">
            <!-- 左侧 -->
            <div class="col-md-9">
                <!-- 文章信息头 -->
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4">
                            ${ article.getTitle() }
                        </h1>
                        <p class="lead mt-4">
                        	${ article.getCreatedTime() }
                        </p>
                        <hr class="my-4">
						<p><em>${ article.getSummary() }</em></p>
						<!-- 已登录，并且是自己的文章 -->
                        <c:if test="${ user != null && article.getAuthorId() == user.getId() }">
                            <div class="row mt-4">
                                <div class="col-4">
                                    <a class="link" href="${pageContext.request.contextPath}/Write?id=${article.getId()}">编辑文章</a>
                                </div>
                                <div class="col-4">
                                    <a class="text-danger" href="#" data-toggle="modal" data-target="#exampleModal">删除文章</a>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
                <!-- 文章信息体 -->
                <p class="lead">
                	${ article.getContent() }
               	</p>
               	<!-- 评论框 -->
                <div class="card mt-4 mb-4">
                    <div class="card-body">
                        <h4 class="card-title">评论</h4>
                        <form action="${pageContext.request.contextPath}/Details" method="POST">
                        	<input name="id" type="hidden" value="${ article.getId() }">
                        	<!-- 没有登录 -->
                            <c:if test="${ user == null }">
	                            <div class="form-group">
	                                <textarea disabled class="form-control" placeholder="说点什么吧..." style="min-height: 120px;" name="content"></textarea>
	                            </div>
                            	<a href="${pageContext.request.contextPath}/Login" class="btn btn-primary">去登录</a>
                            </c:if>
                            <!-- 已登录 -->
                            <c:if test="${ user != null }">
                            	<div class="form-group">
	                                <textarea class="form-control" placeholder="说点什么吧..." style="min-height: 120px;" name="content"></textarea>
	                            </div>
                            	<button type="submit" class="btn btn-primary">提交</button>
                            </c:if>
                            
                        </form>
                    </div>
                </div>
                <!-- 评论列表 -->
                <h4 class="mb-4">评论列表</h4>
                <c:forEach var="comment" items="${ comments }" >
                <div class="media">
                    <img src="${ comment.getAvatar() }" class="mr-3" alt="..." style="width: 64px;height: 64px;">
                    <div class="media-body">
                        <h5 class="mt-0">${ comment.getNickName() }</h5>
                        <div class="row">
                            <p class="col-md-9">${ comment.getContent() }</p>
                            <p class="col-md-3">${ comment.getCreatedTime() }</p>
                        </div>
                    </div>
                </div>
                <hr/>
                </c:forEach>
            </div>
            <!-- 右侧 -->
            <div class="col-md-3">
                <div class="card">
	                <div class="card-body">
						<h4 class="card-title">最近更新</h4>
		                <!-- 推荐文章 -->
		                <div class="list-group list-group-flush mt-4">
		                <c:forEach var="article" items="${ articles_relevant }" >
		                     <a href="${pageContext.request.contextPath}/Details?id=${ article.getId() }" class="list-group-item list-group-item-action">${ article.getTitle() }</a>
		                </c:forEach>
		                </div>
		            </div>
                </div>
            </div>
        </div>

        <!-- 删除文章拟态框 -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">提示</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    </div>
                    <div class="modal-body">
                        确定删除文章吗？
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                        <a href="${pageContext.request.contextPath}/Delete?id=${article.getId()}" type="button" class="btn btn-danger">删除</a>
                    </div>
                </div>
            </div>
        </div>
<%@include file="foot.jsp" %>