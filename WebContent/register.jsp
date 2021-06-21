<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
        <!-- register -->
        <!-- 用户点击过注册了，显示注册结果 -->
        <c:if test="${ code != null }">
        	<c:if test="${ code == 0 }">
        		<% response.setHeader("Refresh", "3;URL=/JavaWebTask_Group13/Login"); %>
        	</c:if>
	        <div class="alert alert-${ code == 0 ? 'success' : 'danger' }" role="alert">
				${ msg }
			</div>
		</c:if>
         <div class="register">
            <form action="${basePath}/Register" method="POST">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input name="username" type="text" class="form-control" id="username">
                </div>
                <div class="form-group">
                    <label for="password1">密码</label>
                    <input name="password1" type="password" class="form-control" id="password1">
                </div>
                <div class="form-group">
                    <label for="password2">确认密码</label>
                    <input name="password2" type="password" class="form-control" id="password2">
                </div>
                <p>
                    已有账号？<a href="${basePath}/Login">去登录</a>
                </p>
                <button type="submit" class="btn btn-primary">注 册</button>
            </form>
        </div>
<%@include file="foot.jsp" %>