<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
        <!-- search -->
        <div class="search">
        	<!-- 搜索结果提示 -->
            <div class="alert alert-${ code == 0 ? 'success' : 'warning'}" role="alert">
                ${ msg }
            </div>
            <!-- 搜索结果 -->
            <c:forEach var="article" items="${ articles }">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="${basePath}/Details?id=${article.getId()}">
                        	${ article.getTitle() }
                        </a>
                    </h5>
                    <p class="card-text">
							${ article.getSummary() }
					</p>
                    <p class="card-text">
                        <small class="text-muted">
							${ article.getCreatedTime() }
						</small>
                    </p>
                </div>
            </div>
            </c:forEach>
        </div>
<%@include file="foot.jsp" %>