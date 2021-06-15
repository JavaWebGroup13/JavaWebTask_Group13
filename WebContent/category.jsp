<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>
        <!-- category类别 -->
        <div class="category">
        	<!-- 查询类别结果提示 -->
        	<c:if test="${ code1 != null }" >
	            <div class="alert alert-${ code1 == 0 ? 'success' : 'warning' }" role="alert">
	                ${ msg1 }
	            </div>
            </c:if>
            <button type="button" class="btn btn-primary mb-4" data-toggle="modal" data-target="#exampleModal">增加类别</button>
            <!-- 展示所有类别 -->
            <ul class="nav nav-tabs">
            	<c:forEach var="category" items="${ categorys }">
                <li class="nav-item">
                    <a class="nav-link ${ category.getId() == which ? 'active' : '' }" href="${pageContext.request.contextPath}/Category?id=${ category.getId() }">
                    	${ category.getTitle() }
                    </a>
                </li>
                </c:forEach>
            </ul>
            <!-- 查询文章结果提示 -->
        	<c:if test="${ code2 != null && code2 != 0 }" >
	            <div class="alert alert-warning" role="alert">
	                ${ msg2 }
	            </div>
            </c:if>
            <!-- 展示文章列表 -->
            <c:forEach var="article" items="${ category_articles }">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">
                    	<a href="${pageContext.request.contextPath}/Details?id=${article.getId()}" role="button">
                            ${ article.getTitle() }
                        </a>
                    </h5>
                    <p class="card-text">
                    	${ article.getSummary() }
                    </p>
                    <p class="card-text"><small class="text-muted">
                    	${ article.getUpdateTime() }
                    </small></p>
                </div>
            </div>
            </c:forEach>
        </div>
        <!-- 增加类别的弹出框 -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">增加类别</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="postCategory" action="${pageContext.request.contextPath}/Category" method="POST">
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">标题</label>
                                <input name="title" type="text" class="form-control" id="recipient-name">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                        <button onclick="postCategory.submit()" type="submit" class="btn btn-primary">添 加</button>
                    </div>
                </div>
            </div>
        </div>
<%@include file="foot.jsp" %>