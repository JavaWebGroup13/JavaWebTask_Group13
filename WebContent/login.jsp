<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>
        <!-- login -->
        <div class="login" action="?route=center" method="get">
            <form>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password">
                </div>
                <p>
                    没有账号？<a href="?route=register">去注册</a>
                </p>
                <button type="submit" class="btn btn-primary">登 录</button>
            </form>
        </div>
<%@include file="foot.jsp" %>