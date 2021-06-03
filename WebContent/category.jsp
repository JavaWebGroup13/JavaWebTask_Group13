<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>
        <!-- category类别 -->
        <div class="category">
        	<!-- 查询类别结果提示 -->
        	<c:if test="${ code1 != null && code1 != 0 }" >
	            <div class="alert alert-warning" role="alert">
	                ${ msg1 }
	            </div>
            </c:if>
            <!-- 展示所有类别 -->
            <ul class="nav nav-pills mb-3 mb-2">
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
                    	${ article.getContent() }
                    </p>
                    <p class="card-text"><small class="text-muted">
                    	${ article.getUpdateTime() }
                    </small></p>
                </div>
            </div>
            </c:forEach>
            <!-- 分页 -->
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
<%@include file="foot.jsp" %>