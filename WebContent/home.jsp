<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
        <!-- home -->
        <div class="home row">
            <!-- 没有文章时 -->
            <c:if test="${ articles.size() == 0 }">
            <div class="col-md-12">
                <div class="alert alert-info" role="alert">
                    还没有文章，快去写一篇吧！<a href="${basePath}/Write">写文章</a>
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
                            <a href="${basePath}/Details?id=${articles.get(0).getId()}" role="button">
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
                                    <a href="${basePath}/Details?id=${article.getId()}" role="button">
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
                            <a class="page-link" href="${basePath}/Home?page=${page > 1 ? page - 1 : 1 }" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach var="i" begin="1" end="${ page_count }">
                            <li class="page-item">
	                            <a class="page-link" href="${basePath}/Home?page=${ i }">
	                                ${ i }
	                            </a>
                            </li>
                        </c:forEach>
                        <li class="page-item">
                            <a class="page-link" href="${basePath}/Home?page=${page < page_count ? page + 1 : page_count }" aria-label="Next">
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
                	<!-- 显示用户自己头像 -->
                	<c:if test="${user != null }">
                		<img src="${ user.getAvatar() }" class="card-img-top " alt="...">
                    </c:if>
                    <!-- 显示默认头像 -->
                    <c:if test="${ user == null }">
                		<img src="${basePath}/static/img/default-avatar.jpg" class="card-img-top" alt="...">
                    </c:if>
                    <div class="card-body">
	                    <h4 class="card-title">
	                    	${ user != null ? user.getNickname() : "未登录" }
	                    </h4>
	                    <p class="card-text">
	                        ${ user != null ? user.getProfile() : "登录后可进行更多操作" }
	                    </p>
	                    <a type="button" href='${basePath}/${user != null ? "Write" : "Login"}' class="btn btn-primary btn-block">
	                    	${ user != null ? "写文章" : "去登录" }
	                    </a>
                    </div>
                </div>

				<div class="card mt-4 ">
					<div class="card-body">
						<h4 class="card-title">最近更新</h4>
		                <!-- 推荐文章 -->
		                <div class="list-group list-group-flush mt-4">
		                <c:forEach var="article" items="${ articles_lately }" >
		                    <a href="${basePath}/Details?id=${ article.getId() }" class="list-group-item list-group-item-action">${ article.getTitle() }</a>
		                </c:forEach>
		                </div>
		            </div>
                </div>
            </div>
        </div>
<%@include file="foot.jsp" %>