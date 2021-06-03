<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 导入dao包下的所有类 -->
<%@ page import="dao.*" %>
<!-- 导入bean包下的所有类 -->
<%@ page import="bean.*" %>

<%@ page import="java.util.List" %>

<%@include file="head.jsp" %>
        <!-- home -->
        <div class="home row">
            <!-- 没有文章时 -->
            <c:if test="${ articles.size() == 0 }">
            <div class="col-md-12">
                <div class="alert alert-info" role="alert">
                    还没有文章，快去写一篇吧！<a href="${pageContext.request.contextPath}/Write">写文章</a>
                </div>
            </div>
            </c:if>
            <!-- 左侧 -->
            <div class="col-md-9">
                <!-- 第一篇文章 -->
                <c:if test="${ articles.size() > 0 }">
                <div class="card mb-3">
                    <img src="${ articles.get(0).getCover() }" style="max-height: 300px;" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">
                            <a href="${pageContext.request.contextPath}/Details?id=${articles.get(0).getId()}" role="button">
                            	${ articles.get(0).getTitle() }
                            </a>
                        </h5>
                        <p class="card-text">
                        	${ articles.get(0).getSummary() }
                        </p>
                        <p class="card-text"><small class="text-muted">
                        	${ articles.get(0).getUpdateTime() }
                        </small></p>
                    </div>
                </div>
                </c:if>
                <!-- 其他文章 -->
                <div class="row row-cols-1 row-cols-md-2">
                	<!-- 循环输出文章 begin="1" 表示从第二个元素开始循环-->
                	<c:forEach var="article" items="${ articles }" begin="1">
                    <div class="col mb-4">
                        <div class="card">
                            <img src="${ article.getCover() }" style="max-height: 300px;" class="card-img-top" alt="...">
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
                    </div>
                    </c:forEach>
                </div>
                <!-- 分页器 -->
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
            <!-- 右侧 -->
            <div class="col-md-3">
                <!-- 个人信息 -->
                <div class="card">
                	<img src="${ user != null ? user.getAvatar() : '' }" class="card-img-top" alt="...">
                    <div class="card-body">
	                    <h4 class="card-title">
	                    	${ user != null ? user.getNickname() : "未登录" }
	                    </h4>
	                    <p class="card-text">
	                        ${ user != null ? user.getProfile() : "登录后可进行更多操作" }
	                    </p>
	                    <a type="button" href='${pageContext.request.contextPath}/${user != null ? "Write" : "Login"}' class="btn btn-primary btn-block">
	                    	${ user != null ? "写文章" : "去登录" }
	                    </a>
                    </div>
                </div>

                <h4 class="title mt-4 ml-2">最近更新</h4>
                <!-- 推荐文章 -->
                <div class="list-group list-group-flush mt-4">
                    <a href="#" class="list-group-item list-group-item-action">A second link item</a>
                    <a href="#" class="list-group-item list-group-item-action">A third link item</a>
                    <a href="#" class="list-group-item list-group-item-action">A fourth link item</a>
                </div>
            </div>
        </div>
<%@include file="foot.jsp" %>