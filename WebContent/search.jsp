<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>
        <!-- search -->
        <%
        // 获取搜索结果
        int code = (Integer)request.getAttribute("code");
        String msg = (String)request.getAttribute("msg");
        %>
        <div class="search">
        	<!-- 搜索结果提示 -->
            <div class="alert alert-${ code == 0 ? 'success' : 'warning'}" role="alert">
                <%= msg %>
            </div>
            
            <!-- 搜索结果 -->
            <c:forEach var="article" items="${ articles }">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="${pageContext.request.contextPath}/Details?id=${article.getId()}">
                        	${ article.getTitle() }
                        </a>
                    </h5>
                    <p class="card-text">
							${ article.getContent() }
					</p>
                    <p class="card-text">
                        <small class="text-muted">
							${ article.getCreatedTime() }
						</small>
                    </p>
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