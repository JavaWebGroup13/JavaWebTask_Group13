<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>
        <!-- register -->
         <div class="register">
            <form>
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" id="username">
                </div>
                <div class="form-group">
                    <label for="password1">密码</label>
                    <input type="password" class="form-control" id="password1">
                </div>
                <div class="form-group">
                    <label for="password2">确认密码</label>
                    <input type="password" class="form-control" id="password2">
                </div>
                <p>
                    已有账号？<a href="?route=login">去登录</a>
                </p>
                <button type="submit" class="btn btn-primary">注 册</button>
            </form>
        </div>
<%@include file="foot.jsp" %>